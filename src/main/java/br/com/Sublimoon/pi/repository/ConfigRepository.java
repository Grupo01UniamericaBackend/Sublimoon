package br.com.sublimoon.pi.repository;
import br.com.sublimoon.pi.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long>{
}
