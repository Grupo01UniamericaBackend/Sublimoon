package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Categorias;


import java.util.List;

public interface CategoriasRepository extends JpaRepository<Categorias,Long>{
}
