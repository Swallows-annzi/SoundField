package com.swallows.soundfield.common;

import com.swallows.soundfield.SoundField;
import com.swallows.soundfield.common.block.SoundFieldBlock;
import com.swallows.soundfield.common.tiem.SoundFieldItem;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = SoundField.MOD_ID)
public class SoundFieldRegister {

    private static final List<Block> BLOCK_LIST = new ArrayList<>();
    private static final List<Item> ITEM_LIST = new ArrayList<>();

    public static void addBlock(Block block) {
        BLOCK_LIST.add(block);
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        addItem(item);
    }

    public static void addItem(Item item) {
        ITEM_LIST.add(item);
    }

    @SubscribeEvent
    public static void onBlockRegistry (RegistryEvent.Register<Block> event)
    {
        SoundFieldBlock blocks = new SoundFieldBlock();
        event.getRegistry().registerAll(BLOCK_LIST.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onItemRegistry (RegistryEvent.Register<Item> event)
    {
        SoundFieldItem items = new SoundFieldItem();
        event.getRegistry().registerAll(ITEM_LIST.toArray(new Item[0]));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelRegistry (ModelRegistryEvent event)
    {
        for(Item item : ITEM_LIST)
        {
            ModelLoader.setCustomModelResourceLocation(item,0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
        }
    }

}
