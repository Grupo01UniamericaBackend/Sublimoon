package br.com.Sublimoon.pi.repository;

import br.com.Sublimoon.pi.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.pi.entity.Produto;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{


    Produto findByNome(String nome);

    List<Produto> findByCategoria(Categoria categoria);

    List<Produto> findByAtivo(boolean ativo);

}
