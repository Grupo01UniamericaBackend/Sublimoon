package br.com.Sublimoon.PI.repository;

import br.com.Sublimoon.PI.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Produto;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{


    Produto findByNome(String nome);

    List<Produto> findByCategoria(Categoria categoria);


}
