package br.com.Sublimoon.PI.repository;

import br.com.Sublimoon.PI.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {



    
}
