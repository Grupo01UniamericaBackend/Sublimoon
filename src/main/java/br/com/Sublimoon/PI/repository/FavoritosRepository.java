package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Favoritos;

import java.util.List;

public interface FavoritosRepository extends JpaRepository<Favoritos,Long>{
}
