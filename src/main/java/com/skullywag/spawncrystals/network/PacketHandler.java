package com.skullywag.spawncrystals.network;

import com.skullywag.spawncrystals.network.message.MessageTileEntitySC;
import com.skullywag.spawncrystals.reference.Reference;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler 
{
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

    public static void init()
    {
        INSTANCE.registerMessage(MessageTileEntitySC.class, MessageTileEntitySC.class, 0, Side.CLIENT);
    }
}
