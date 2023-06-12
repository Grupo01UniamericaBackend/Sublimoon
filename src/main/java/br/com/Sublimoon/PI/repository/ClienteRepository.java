package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Cliente;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{


    Cliente findByCpf(String cpf);

    Cliente findByTelefone(String telefone);

    Cliente findByEmail(String email);

}
