package com.swallows.soundfield.data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.swallows.soundfield.SoundField;
import net.minecraft.util.JsonUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SoundFieldFile {

    public static File ConfigDir;
    public static File MusicDir;
    public static File ScoreDir;
    public static File CoverDir;

    public static void setConfigFile(File Dir) {

        ConfigDir = new File(Dir, SoundField.MOD_ID);
        if (!ConfigDir.exists()) {
            ConfigDir.mkdirs();
        }

        MusicDir = new File(ConfigDir, "music");
        if(!MusicDir.exists()) {
            MusicDir.mkdirs();
        }

        ScoreDir = new File(ConfigDir, "score");
        if(!ScoreDir.exists()) {
            ScoreDir.mkdirs();
        }

        CoverDir = new File(ConfigDir, "cover");
        if(!CoverDir.exists()) {
            CoverDir.mkdirs();
        }
    }

    public static List<Score> readJSON(File Dir) {

        List<Score> scoreList = new ArrayList<>();

        if(!Dir.exists() || !Dir.isDirectory()) {
            SoundField.LOGGER.info("未找到目录:{}", Dir.getAbsolutePath());
            return scoreList;
        }

        File[] jsonFiles = Dir.listFiles((dir, name) -> name.endsWith(".json"));
        if (jsonFiles == null)
            return scoreList;

        for (File file : jsonFiles) {
            try (FileReader reader = new FileReader(file)) {

                JsonObject root = new JsonParser().parse(reader).getAsJsonObject();

                Score score = new Score(JsonUtils.getString(root, "registryname", "null"));
                score.setLocalizedName(JsonUtils.getString(root, "localizedname", "未命名乐谱"));
                score.setMusicFile(JsonUtils.getString(root, "musicfile", "null"));
                score.setColor(JsonUtils.getString(root, "color", "0x000000"));
                score.setLevel(JsonUtils.getInt(root, "level", -1));
                scoreList.add(score);

            } catch (IOException e) {
                SoundField.LOGGER.info("读取乐谱文件:{}错误，请检查文件是否合法！", file.getAbsolutePath());
                SoundField.LOGGER.error(e);
            }
        }

        return scoreList;

    }
}
