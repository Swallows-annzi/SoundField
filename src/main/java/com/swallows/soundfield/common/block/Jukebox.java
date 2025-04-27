package com.swallows.soundfield.common.block;

import com.swallows.soundfield.SoundField;
import com.swallows.soundfield.common.SoundFieldRegister;
import com.swallows.soundfield.common.creativetab.SoundFieldTab;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Jukebox extends Block {

    public Jukebox() {
        super(Material.WOOD);
        setSoundType(SoundType.WOOD);
        setCreativeTab(SoundFieldTab.ItemTab);
        setTranslationKey(SoundField.MOD_ID + ".jukebox");
        setRegistryName("jukebox");
        setHardness(5.0F);
        SoundFieldRegister.addBlock(this);
    }

//    @Override
//    public boolean hasTileEntity(IBlockState state) {
//        return true;
//    }
//
//    @Override
//    public TileEntity createTileEntity(World world, IBlockState state) {
//        return new TileEntityJukebox();
//    }

}
