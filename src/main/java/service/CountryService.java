package service;

import db.Country;
import db.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryById(Integer id) {
        return countryRepository.findById(id);
    }

    public Country getRandomCountry() {
        return countryRepository.findRandomCountry().orElse(null);
    }

    public Optional<String> getCapitalById(Integer id) {
        return countryRepository.findCapitalById(id);
    }
}
