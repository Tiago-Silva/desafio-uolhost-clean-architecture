package br.com.uolhost.infrastructure.controller;

import br.com.uolhost.application.dto.JogadoresRequestDTO;
import br.com.uolhost.application.dto.JogadoresResponseDTO;
import br.com.uolhost.application.usecases.CreatePlayInteractor;
import br.com.uolhost.domain.entity.Jogadores;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("play")
public class PlayController {

    private final CreatePlayInteractor createPlayInteractor;
    private final PlayDTOMapper playDTOMapper;
    public PlayController(CreatePlayInteractor createPlayInteractor, PlayDTOMapper playDTOMapper) {
        this.createPlayInteractor = createPlayInteractor;
        this.playDTOMapper = playDTOMapper;
    }

    @PostMapping
    public ResponseEntity<JogadoresResponseDTO> postProduct(@RequestBody JogadoresRequestDTO requestDTO){
        Jogadores play = this.playDTOMapper.toDomainObject(requestDTO);
        return ResponseEntity.ok(this.playDTOMapper.toDTO(this.createPlayInteractor.createPlay(play)));
    }

    @PutMapping
    public ResponseEntity<JogadoresResponseDTO> updatePlay(@RequestBody JogadoresResponseDTO responseDTO){
        Jogadores play = this.playDTOMapper.toDomainObject(responseDTO);
        return ResponseEntity.ok(this.playDTOMapper.toDTO(this.createPlayInteractor.updatePlay(play)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletePlay(@RequestBody JogadoresResponseDTO responseDTO){
        Jogadores play = this.playDTOMapper.toDomainObject(responseDTO);
        this.createPlayInteractor.deletePlay(play);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<JogadoresResponseDTO>> getFindAllPlayers(){
        return ResponseEntity.ok(this.createPlayInteractor.getPlay().stream().map(this.playDTOMapper::toDTO).toList());
    }

    @GetMapping("/{codinome}")
    public ResponseEntity<JogadoresResponseDTO> getFindPlayerByCodinome(@PathVariable("codinome") String codinome){
        return ResponseEntity.ok(this.playDTOMapper.toDTO(this.createPlayInteractor.getPlayByCodinome(codinome)));
    }

    @GetMapping("/grupo/{grupo}")
    public ResponseEntity<List<JogadoresResponseDTO>> getFindPlayersByGrupo(@PathVariable("grupo") String grupo){
        return ResponseEntity.ok(this.createPlayInteractor.getPlayersByGrupo(grupo).stream().map(this.playDTOMapper::toDTO).toList());
    }

}
