package com.example.leagues.mapper;

import com.example.leagues.dto.PlayerDTO;
import com.example.leagues.model.Country;
import com.example.leagues.model.Player;
import com.example.leagues.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerMapper {

    @Autowired
    private static CountryRepository countryRepository;

    public static PlayerDTO toDTO(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setName(player.getName());
        playerDTO.setSurname(player.getSurname());
        playerDTO.setDateOfBirth(player.getDateOfBirth());
        playerDTO.setGender(player.getGender());
        playerDTO.setCitizenship_id(player.getCitizenship().getId());
        playerDTO.setTeam_id(player.getTeam().getId());
        return playerDTO;
    }

    public static Player toEntity(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setId(playerDTO.getId());
        player.setName(playerDTO.getName());
        player.setSurname(playerDTO.getSurname());
        player.setDateOfBirth(playerDTO.getDateOfBirth());
        player.setGender(playerDTO.getGender());

        Country country = countryRepository.findById(playerDTO.getCitizenship_id())
                .orElseThrow(() -> new IllegalArgumentException("Invalid country Id:" + playerDTO.getCitizenship_id()));

        player.setCitizenship(country);
        return player;
    }
}
