package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Cliente;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{


    static Cliente findByCpf(String cpf) {
        return null;
    }

    Cliente findByTelefone(String telefone);

    Cliente findByEmail(String email);
}
