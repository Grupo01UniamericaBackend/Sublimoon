package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Produtos;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produtos,Long>{

    public List<Produtos> findByNoNe(final String nome);

}
