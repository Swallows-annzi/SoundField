package com.swallows.soundfield.common.creativetab;

import com.swallows.soundfield.common.block.SoundFieldBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemTab extends CreativeTabs {

    public ItemTab() {
        super("soundfielditem");
    }

    @Override
    public ItemStack createIcon(){
        return new ItemStack(SoundFieldBlock.jukebox);
    }
}
