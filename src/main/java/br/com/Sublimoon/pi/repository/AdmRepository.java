package br.com.sublimoon.pi.repository;

import br.com.sublimoon.pi.entity.Adm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AdmRepository extends JpaRepository<Adm, Long>{

     Adm findByTelefone(String telefone);

     Adm findByEmail(String email);
}
