package com.swallows.soundfield.common;

import com.swallows.soundfield.SoundField;
import com.swallows.soundfield.common.block.SoundFieldBlock;
import com.swallows.soundfield.common.tiem.SoundFieldItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

}
