package dave.dev.cryptoservice.service;

import dave.dev.cryptoservice.exception.CryptoCurrencyNotFoundException;
import dave.dev.cryptoservice.model.CryptoCurrency;
import dave.dev.cryptoservice.repository.CryptoCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoCurrencyServiceImpl implements CryptoCurrencyService {
    
    @Autowired
    private CryptoCurrencyRepository cryptoCurrencyRepository;

    @Override
    public List<CryptoCurrency> getAllCryptoCurrencies() {
        return cryptoCurrencyRepository.findAll();
    }

    @Override
    public CryptoCurrency getCryptoCurrencyById(Long id) {
        return cryptoCurrencyRepository.findById(id)
                .orElseThrow(() -> new CryptoCurrencyNotFoundException("CryptoCurrency with id " + id + " not found"));
    }

    @Override
    public CryptoCurrency getCryptoCurrencyBySymbol(String symbol) {
        return cryptoCurrencyRepository.findBySymbol(symbol);
    }

    @Override
    public CryptoCurrency saveCryptoCurrency(CryptoCurrency cryptoCurrency) {
        return cryptoCurrencyRepository.save(cryptoCurrency);
    }

    @Override
    public void updateCryptoCurrency(Long id, CryptoCurrency updatedCryptoCurrency) {
        if (!cryptoCurrencyRepository.existsById(id)) {
            throw new CryptoCurrencyNotFoundException("CryptoCurrency with id " + id + " not found");
        }
        updatedCryptoCurrency.setId(id);
        cryptoCurrencyRepository.save(updatedCryptoCurrency);
    }

    @Override
    public void deleteCryptoCurrency(Long id) {
        if (!cryptoCurrencyRepository.existsById(id)) {
            throw new CryptoCurrencyNotFoundException("CryptoCurrency with id " + id + " not found");
        }
        cryptoCurrencyRepository.deleteById(id);
    }
}
