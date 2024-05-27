package com.example.leagues.controller;

import com.example.leagues.dto.LeagueDTO;
import com.example.leagues.model.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.leagues.service.LeagueService;
import java.util.List;


@RestController
@RequestMapping("api/leagues")
public class LeagueController {

    private final LeagueService leagueService;

    @Autowired
    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @GetMapping
    public List<LeagueDTO> getCountries() {
        return leagueService.getCountries();
    }

    @GetMapping("/{id}")
    public LeagueDTO getLeagueById(@PathVariable Long id) {
        return leagueService.getLeagueById(id);
    }

    @PostMapping
    public LeagueDTO saveLeague(@RequestBody LeagueDTO leagueDTO) {
        return leagueService.saveLeague(leagueDTO);
    }

    @PutMapping("/{id}")
    public LeagueDTO updateLeague(@PathVariable Long id, @RequestBody LeagueDTO leagueDTO) {
        return leagueService.updateLeague(id, leagueDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLeague(@PathVariable Long id) {
        leagueService.deleteLeague(id);
    }
}
