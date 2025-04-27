package com.swallows.soundfield.config;

import com.swallows.soundfield.SoundField;
import com.swallows.soundfield.data.SoundFieldFile;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

public class SoundFieldConfig {

    public static Configuration CONFIG;

    public static void ConfigLoader(File Dir) {
        SoundFieldFile.setConfigFile(Dir);
        CONFIG = new Configuration(new File(SoundFieldFile.ConfigDir, SoundField.MOD_ID + ".cfg"));
        Load();
    }

    private static void Load() {
//        List<Score> scoreList = SoundFieldFile.readJSON(SoundFieldFile.ScoreDir);
//        for(Score score : scoreList) {
//            SoundField.LOGGER.info(score.toString());
//        }

    }

    private static void saveConfig() {
        if (CONFIG.hasChanged()) {
            CONFIG.save();
        }
    }

    private static int getInt(String Category, String Key, int Value, String Comment) {
        return CONFIG.get(Category, Key, Value, Comment).getInt();
    }

    private static long getLong(String Category, String Key, long Value, String Comment) {
        return CONFIG.get(Category, Key, Value, Comment).getLong();
    }

    private static boolean getBoolean(String Category, String Key, boolean Value, String Comment) {
        return CONFIG.get(Category, Key, Value, Comment).getBoolean();
    }

    private static double getDouble(String Category, String Key, double Value, String Comment) {
        return CONFIG.get(Category, Key, Value, Comment).getDouble();
    }

    private static String getString(String Category, String key, String Value, String Comment) {
        return CONFIG.get(Category, key, Value, Comment).getString();
    }

    public static int setInt(String Category, String Key, int Value) {
        Property property = CONFIG.getCategory(Category).get(Key);
        if(property.getInt() != Value) {
            property.set(Value);
            saveConfig();
        }
        return Value;
    }

    public static long setLong(String Category, String Key, long Value) {
        Property property = CONFIG.getCategory(Category).get(Key);
        if(property.getLong() != Value) {
            property.set(Value);
            saveConfig();
        }
        return Value;
    }

    public static boolean setBoolean(String Category, String Key, boolean Value) {
        Property property = CONFIG.getCategory(Category).get(Key);
        if(property.getBoolean() != Value) {
            property.set(Value);
            saveConfig();
        }
        return Value;
    }

    public static double setDouble(String Category, String Key, double Value) {
        Property property = CONFIG.getCategory(Category).get(Key);
        if(property.getDouble() != Value) {
            property.set(Value);
            saveConfig();
        }
        return Value;
    }

    public static String setString(String Category, String Key, String Value) {
        Property property = CONFIG.getCategory(Category).get(Key);
        if(property.getString().equals(Value)) {
            property.set(Value);
            saveConfig();
        }
        return Value;
    }
}
