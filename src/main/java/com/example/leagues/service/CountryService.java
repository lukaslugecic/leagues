package com.example.leagues.service;

import com.example.leagues.dto.CountryDTO;
import com.example.leagues.mapper.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.leagues.repository.CountryRepository;
import com.example.leagues.model.Country;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryDTO> getCountries() {
        return countryRepository.findAll().stream()
                .map(CountryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CountryDTO getCountryById(Long id) {
        return CountryMapper.toDTO(Objects.requireNonNull(countryRepository.findById(id).orElse(null)));
    }

    public CountryDTO saveCountry(CountryDTO countryDTO) {
        Country country = CountryMapper.toEntity(countryDTO);
        return CountryMapper.toDTO(countryRepository.save(country));
    }

    public CountryDTO updateCountry(Long id, CountryDTO countryDTO) {
        Country country = CountryMapper.toEntity(countryDTO);
        country.setId(id);
        return CountryMapper.toDTO(countryRepository.save(country));
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }

}
