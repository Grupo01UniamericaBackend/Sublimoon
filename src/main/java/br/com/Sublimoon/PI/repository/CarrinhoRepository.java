package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Carrinho;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho,Long>{
}
