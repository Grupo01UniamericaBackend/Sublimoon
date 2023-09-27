package br.com.Sublimoon.pi.repository;

import br.com.Sublimoon.pi.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
}
