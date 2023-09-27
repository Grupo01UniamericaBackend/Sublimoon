package br.com.Sublimoon.pi.repository;

import br.com.Sublimoon.pi.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{


}
