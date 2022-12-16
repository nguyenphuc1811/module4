package com.repository;

import com.model.Config;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ConfigRepository implements IConfigRepository {
    private static List<Config> configList = new ArrayList<>();
    private static List<String> languagesList = new ArrayList<>();
    private static List<Integer> listSize = new ArrayList<>();

    static {
        configList.add(new Config("config1", "English", 25, true, "abc xyz"));
        configList.add(new Config("config2", "Vietnamese", 50, false, "abc xyz"));
        configList.add(new Config("config3", "Japanese", 75, false, "abc xyz"));
        configList.add(new Config("config4", "Chinese", 100, true, "abc xyz"));
        languagesList.add("English");
        languagesList.add("Vietnamese");
        languagesList.add("Japanese");
        languagesList.add("Chinese");
        listSize.add(5);
        listSize.add(10);
        listSize.add(15);
        listSize.add(25);
        listSize.add(50);
        listSize.add(100);
    }

    public List<Config> selectAll() {
        return configList;
    }

    public List<String> selectLanguages() {
        return languagesList;
    }
    public List<Integer> selectSize(){
        return listSize;
    }

    public Config selectConfig(String name) {
        for (Config config : configList) {
            if (config.getName().equals(name)) {
                return config;
            }
        }
        return null;
    }

    public int findIndex(String name){
        for (int i = 0; i < configList.size(); i++) {
            if(configList.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public String confirm(Config config){
        for (Config c: configList) {
            if(config.getName().equals(c.getName())){
                configList.set(findIndex(config.getName()),config);
                return "Sửa thành công";
            }
        }
        return "Sửa không thành công";
    }
}
