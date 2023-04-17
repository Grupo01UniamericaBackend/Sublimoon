package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Usuario;


import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}
