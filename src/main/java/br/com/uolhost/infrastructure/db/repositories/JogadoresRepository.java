package br.com.uolhost.infrastructure.db.repositories;

import br.com.uolhost.domain.entity.Jogadores;
import br.com.uolhost.infrastructure.db.entityDB.JogadoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogadoresRepository extends JpaRepository<JogadoresEntity, String> {
    JogadoresEntity findByCodinome(String codinome);

    List<JogadoresEntity> findByGrupo(String grupo);
}
