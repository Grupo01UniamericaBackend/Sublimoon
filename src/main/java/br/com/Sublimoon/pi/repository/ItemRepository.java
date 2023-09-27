package br.com.sublimoon.pi.repository;

import br.com.sublimoon.pi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {



    
}
