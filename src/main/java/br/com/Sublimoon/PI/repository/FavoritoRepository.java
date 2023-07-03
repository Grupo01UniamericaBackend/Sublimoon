package br.com.Sublimoon.PI.repository;

import br.com.Sublimoon.PI.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Favorito;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito,Long>{





}
