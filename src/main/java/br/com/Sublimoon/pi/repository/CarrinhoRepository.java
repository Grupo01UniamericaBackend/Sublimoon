package br.com.sublimoon.pi.repository;


import br.com.sublimoon.pi.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho,Long>{
}
