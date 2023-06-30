package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Adm;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface AdmRepository extends JpaRepository<Adm, Long>{

     Adm findByTelefone(String telefone);

     Adm findByEmail(String email);
}
