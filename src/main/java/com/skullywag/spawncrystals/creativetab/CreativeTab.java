package com.skullywag.spawncrystals.creativetab;

import com.skullywag.spawncrystals.init.ModItems;
import com.skullywag.spawncrystals.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;

public class CreativeTab 
{
	public static final CreativeTabs SC_TAB = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.SpawnCrystalAlive;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public String getTranslatedTabLabel()
        {
            return StatCollector.translateToLocal("key.categories.spawncrystals");
        }
    };
}
