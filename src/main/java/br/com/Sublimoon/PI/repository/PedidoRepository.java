package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Pedido;

import java.util.List;
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

    public List<Pedido> findByNoNe(final String nome);

}
