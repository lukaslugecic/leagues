package com.example.leagues.service;

import com.example.leagues.dto.PlayerDTO;
import com.example.leagues.mapper.PlayerMapper;
import com.example.leagues.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerDTO> getPlayers() {
        return playerRepository.findAll().stream()
        .map(PlayerMapper::toDTO)
        .collect(Collectors.toList());
    }

    public PlayerDTO getPlayerById(Long id) {
        return PlayerMapper.toDTO(Objects.requireNonNull(playerRepository.findById(id).orElse(null)));
    }

    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        return PlayerMapper.toDTO(playerRepository.save(PlayerMapper.toEntity(playerDTO)));
    }

    public PlayerDTO updatePlayer(Long id, PlayerDTO playerDTO) {
        playerDTO.setId(id);
        return PlayerMapper.toDTO(playerRepository.save(PlayerMapper.toEntity(playerDTO)));
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

}
