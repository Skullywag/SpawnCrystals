package com.skullywag.spawncrystals.init;

import com.skullywag.spawncrystals.block.BlockSC;
import com.skullywag.spawncrystals.reference.Names;
import com.skullywag.spawncrystals.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks 
{
	public static final BlockSC spawnerBlock = new BlockSpawner();

    public static void init()
    {
        GameRegistry.registerBlock(spawnerBlock, Names.Blocks.SPAWNER);
    }
}
