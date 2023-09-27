package br.com.Sublimoon.pi.repository;

import br.com.Sublimoon.pi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{



    Cliente findByTelefone(String telefone);

    Cliente findByEmail(String email);

    Cliente findByCpf(String cpf);

}
