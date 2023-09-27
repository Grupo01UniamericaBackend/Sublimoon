package br.com.Sublimoon.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.pi.entity.Favorito;
import org.springframework.stereotype.Repository;



@Repository
public interface FavoritoRepository extends JpaRepository<Favorito,Long>{





}
