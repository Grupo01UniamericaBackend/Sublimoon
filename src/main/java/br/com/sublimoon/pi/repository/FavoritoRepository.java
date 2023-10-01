package br.com.sublimoon.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sublimoon.pi.entity.Favorito;
import org.springframework.stereotype.Repository;



@Repository
public interface FavoritoRepository extends JpaRepository<Favorito,Long>{





}
