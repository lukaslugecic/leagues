package com.example.leagues.controller;

import com.example.leagues.dto.CountryDTO;
import com.example.leagues.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.leagues.service.CountryService;
import java.util.List;


@RestController
@RequestMapping("api/countries")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<CountryDTO> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/{id}")
    public CountryDTO getCountryById(@PathVariable Long id) {
        return countryService.getCountryById(id);
    }

    @PostMapping
    public CountryDTO saveCountry(@RequestBody CountryDTO countryDTO) {
        return countryService.saveCountry(countryDTO);
    }

    @PutMapping("/{id}")
    public CountryDTO updateCountry(@PathVariable Long id, @RequestBody CountryDTO countryDTO) {
        return countryService.updateCountry(id, countryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
