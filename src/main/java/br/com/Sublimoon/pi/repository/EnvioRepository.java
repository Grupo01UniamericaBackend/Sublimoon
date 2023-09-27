package br.com.Sublimoon.pi.repository;

import br.com.Sublimoon.pi.entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EnvioRepository extends JpaRepository<Envio,Long>{
}
