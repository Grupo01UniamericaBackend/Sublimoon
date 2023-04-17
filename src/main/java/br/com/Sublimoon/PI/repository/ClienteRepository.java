package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Cliente;

import java.util.List;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
