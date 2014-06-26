package com.skullywag.spawncrystals.init;

import com.skullywag.spawncrystals.item.ItemSC;
import com.skullywag.spawncrystals.reference.Names;
import com.skullywag.spawncrystals.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems 
{
	public class SpawnCrystalAlive {

	}

	public static final ItemSC spawnCrystalInert = new ItemCrystalInert();
    public static final ItemSC spawnCrystalInfused = new ItemCrystalInfused();
    public static final ItemSC SpawnCrystalAlive = new ItemCrystalAlive();

    public static void init()
    {
        GameRegistry.registerItem(spawnCrystalInert, Names.Items.CRYSTAL_INERT);
        GameRegistry.registerItem(spawnCrystalInfused, Names.Items.CRYSTAL_INFUSED);
        GameRegistry.registerItem(SpawnCrystalAlive, Names.Items.CRYSTAL_ALIVE);
    }
}
