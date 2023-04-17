package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Carrinho;


import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho,Long>{
}
