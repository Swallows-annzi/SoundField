package com.swallows.soundfield.misc;

import com.swallows.soundfield.Tags;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoundFieldLog {

    public static Logger Log() {
        return Log(Tags.MOD_NAME);
    }

    public static Logger Log(String modName) {
        return LogManager.getLogger(modName);
    }

}
