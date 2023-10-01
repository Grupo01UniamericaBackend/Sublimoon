package br.com.sublimoon.pi.repository;

import br.com.sublimoon.pi.entity.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{
}
