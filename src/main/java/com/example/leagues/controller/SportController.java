package com.example.leagues.controller;

import com.example.leagues.dto.SportDTO;
import com.example.leagues.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.leagues.service.SportService;
import java.util.List;


@RestController
@RequestMapping("api/sports")
public class SportController {

    private final SportService sportService;

    @Autowired
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }

    @GetMapping
    public List<SportDTO> getCountries() {
        return sportService.getCountries();
    }

    @GetMapping("/{id}")
    public SportDTO getSportById(@PathVariable Long id) {
        return sportService.getSportById(id);
    }

    @PostMapping
    public SportDTO saveSport(@RequestBody SportDTO sportDTO) {
        return sportService.saveSport(sportDTO);
    }

    @PutMapping("/{id}")
    public SportDTO updateSport(@PathVariable Long id, @RequestBody SportDTO sportDTO) {
        return sportService.updateSport(id, sportDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSport(@PathVariable Long id) {
        sportService.deleteSport(id);
    }
}
