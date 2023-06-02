package br.com.Sublimoon.PI.service;

import br.com.Sublimoon.PI.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    @Autowired
    final ConfigRepository configRepository;


    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;

    }

}