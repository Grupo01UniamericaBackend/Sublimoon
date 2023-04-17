package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Avaliacao;


import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
}
