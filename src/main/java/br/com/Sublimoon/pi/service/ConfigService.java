package br.com.Sublimoon.pi.service;

import br.com.Sublimoon.pi.repository.ConfigRepository;
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