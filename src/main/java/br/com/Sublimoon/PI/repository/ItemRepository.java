package br.com.Sublimoon.PI.repository;

import br.com.Sublimoon.PI.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {


    
}
