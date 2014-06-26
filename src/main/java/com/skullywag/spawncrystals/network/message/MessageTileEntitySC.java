package com.skullywag.spawncrystals.network.message;

import com.skullywag.spawncrystals.tileentity.TileEntitySC;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageTileEntitySC implements IMessage, IMessageHandler<MessageTileEntitySC, IMessage>
{
	public int x, y, z;
    public byte orientation, state;
    public String customName, owner;

    public MessageTileEntitySC()
    {
    }

    public MessageTileEntitySC(TileEntitySC tileEntitySC)
    {
        this.x = tileEntitySC.xCoord;
        this.y = tileEntitySC.yCoord;
        this.z = tileEntitySC.zCoord;
        this.orientation = (byte) tileEntitySC.getOrientation().ordinal();
        this.state = (byte) tileEntitySC.getState();
        this.customName = tileEntitySC.getCustomName();
        this.owner = tileEntitySC.getOwner();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        int ownerLength = buf.readInt();
        this.owner = new String(buf.readBytes(ownerLength).array());
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        buf.writeInt(owner.length());
        buf.writeBytes(owner.getBytes());
    }

    @Override
    public IMessage onMessage(MessageTileEntitySC message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntitySC)
        {
            ((TileEntitySC) tileEntity).setOrientation(message.orientation);
            ((TileEntitySC) tileEntity).setState(message.state);
            ((TileEntitySC) tileEntity).setCustomName(message.customName);
            ((TileEntitySC) tileEntity).setOwner(message.owner);
        }

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTileEntityEE - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s", x, y, z, orientation, state, customName, owner);
    }
}
