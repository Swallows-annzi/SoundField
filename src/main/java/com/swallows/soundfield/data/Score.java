package com.swallows.soundfield.data;

import com.swallows.soundfield.SoundField;
import net.minecraft.nbt.NBTTagCompound;

import java.io.File;

public class Score {

    private String RegistryName;
    private String LocalizedName;
    private String MusicFile;
    private String Color;
    private int Level;
    private File Music;

    public Score() {}

    public Score(String Name) {
        RegistryName = Name;
    }

    public String getRegistryName() {
        return RegistryName;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public int getLevel() {
        return Level;
    }

    public String getColor() {
        return Color;
    }

    public String getMusicFile() {
        return MusicFile;
    }

    public File getMusic() {
        return Music;
    }

    public void setLocalizedName(String name) {
        LocalizedName = name;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public void setColor(String color) {
        Color = color;
    }

    public void setMusicFile(String musicFile) {
        MusicFile = musicFile;
        if (musicFile.equals("null")) {
            SoundField.LOGGER.info("乐谱:{}的音频文件未指定！", RegistryName);
        }
        else {
            File music = new File(SoundFieldFile.MusicDir, musicFile);
            if (!music.exists()) {
                SoundField.LOGGER.info("音频文件:{}缺失！", musicFile);
            }
            else {
                Music = music;
                SoundField.LOGGER.info(Music.getAbsolutePath());
            }
        }

    }

    public void setMusic(File file) {
        Music = file;
    }

    public String toString() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("registryname", RegistryName);
        tag.setString("localizedname", LocalizedName);
        tag.setString("musicfile", MusicFile);
        tag.setString("color", Color);
        tag.setInteger("level", Level);
        return tag.toString();
    }

}
