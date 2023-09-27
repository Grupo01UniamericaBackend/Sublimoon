package br.com.sublimoon.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sublimoon.pi.entity.Cliente;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{



    Cliente findByTelefone(String telefone);

    Cliente findByEmail(String email);

    Cliente findByCpf(String cpf);

}
