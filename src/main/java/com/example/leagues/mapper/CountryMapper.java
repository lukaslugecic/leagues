package com.example.leagues.mapper;

import com.example.leagues.dto.CountryDTO;
import com.example.leagues.model.Country;

public class CountryMapper {

    public static CountryDTO toDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        return countryDTO;
    }

    public static Country toEntity(CountryDTO countryDTO) {
        Country country = new Country();
        country.setId(countryDTO.getId());
        country.setName(countryDTO.getName());
        return country;
    }
}
