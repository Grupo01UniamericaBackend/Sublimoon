package br.com.Sublimoon.PI.service;

<<<<<<< HEAD
public class ConfigService {
}
=======
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
>>>>>>> 7ab800cdf9be5c4a793fda40429e293138963241
