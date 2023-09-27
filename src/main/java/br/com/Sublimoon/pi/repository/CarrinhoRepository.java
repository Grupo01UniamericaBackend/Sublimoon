package br.com.Sublimoon.pi.repository;


import br.com.Sublimoon.pi.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho,Long>{
}
