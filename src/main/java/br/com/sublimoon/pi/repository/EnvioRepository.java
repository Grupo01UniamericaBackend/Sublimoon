package br.com.sublimoon.pi.repository;

import br.com.sublimoon.pi.entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EnvioRepository extends JpaRepository<Envio,Long>{
}
