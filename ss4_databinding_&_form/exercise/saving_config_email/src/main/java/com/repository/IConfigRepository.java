package com.repository;

import com.model.Config;

import java.util.List;

public interface IConfigRepository {
    List<Config> selectAll();
    List<String> selectLanguages();
    List<Integer> selectSize();
    Config selectConfig(String name);
    String confirm(Config config);
}
