package br.com.Sublimoon.pi.repository;

import br.com.Sublimoon.pi.entity.Adm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AdmRepository extends JpaRepository<Adm, Long>{

}
