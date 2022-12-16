package com.service;

import com.model.Config;
import com.repository.ConfigRepository;
import com.repository.IConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService implements IConfigService{

    @Autowired
    IConfigRepository configRepository;

    @Override
    public List<String> selectLanguages() {
        return configRepository.selectLanguages();
    }

    public List<Config> selectAll() {
            return configRepository.selectAll();
    }

    public Config selectConfig(String name) {
        return configRepository.selectConfig(name);
    }

    @Override
    public List<Integer> selectSize() {
        return configRepository.selectSize();
    }

    @Override
    public String confirm(Config config) {
        return configRepository.confirm(config);
    }
}
