package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Usuario;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

    Usuario findByTelefone(String telefone);

    Usuario findByEmail(String email);
}
