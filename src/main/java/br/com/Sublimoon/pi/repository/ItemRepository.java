package br.com.Sublimoon.pi.repository;

import br.com.Sublimoon.pi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {



    
}
