package dave.dev.cryptoservice.service

import dave.dev.cryptoservice.model.CryptoCurrency;

import java.util.List;

public interface CryptoCurrencyService {
    
    List<CryptoCurrency> getAllCryptoCurrencies();
    
    CryptoCurrency getCryptoCurrencyById(Long id);
    
    CryptoCurrency getCryptoCurrencyBySymbol(String symbol);
    
    CryptoCurrency saveCryptoCurrency(CryptoCurrency cryptoCurrency);
    
    void updateCryptoCurrency(Long id, CryptoCurrency updatedCryptoCurrency);
    
    void deleteCryptoCurrency(Long id);
}
