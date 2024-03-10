package br.com.uolhost.infrastructure.controller;

import br.com.uolhost.application.dto.JogadoresRequestDTO;
import br.com.uolhost.application.dto.JogadoresResponseDTO;
import br.com.uolhost.application.usecases.CreatePlayInteractor;
import br.com.uolhost.domain.entity.Jogadores;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
