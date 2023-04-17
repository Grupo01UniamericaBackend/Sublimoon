package br.com.Sublimoon.PI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.Sublimoon.PI.entity.Config;

import java.util.List;

public interface ConfigRepository extends JpaRepository<Config,Long>{
}
