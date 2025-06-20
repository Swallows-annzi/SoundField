package com.swallows.soundfield.misc;

import com.swallows.soundfield.SoundField;
import com.swallows.soundfield.Tags;
import com.swallows.soundfield.common.SoundFieldRegister;
import com.swallows.soundfield.config.SoundFieldConfig;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.Logger;

public class Proxy {

    public static void preInit(FMLPreInitializationEvent event) {
        SoundField.LOGGER.info("欢迎使用“{}”！", Tags.MOD_NAME);
        SoundFieldConfig.ConfigLoader(event.getModConfigurationDirectory());
    }

    public static void Init(FMLInitializationEvent event) {
    }

    public static void postInit(FMLPostInitializationEvent event) {
    }

    public static void serverStarting(FMLServerStartingEvent event) {
    }
}
