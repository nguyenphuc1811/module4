package com.service;

import com.model.Config;

import java.util.List;

public interface IConfigService {
    List<String> selectLanguages();
    List<Config> selectAll();
    Config selectConfig(String name);
    List<Integer> selectSize();
    String confirm(Config config);
}
