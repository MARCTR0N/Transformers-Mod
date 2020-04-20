package com.marctron.transformersmod.network;

import com.marctron.transformersmod.blocks.tileentity.TileEntityLock;
import com.marctron.transformersmod.init.ModCapabilities;
import com.marctron.transformersmod.util.LogHelper;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketSetMaxNumberOfItems implements IMessage {

	/**
	 * States whether the message is valid or not
	 */
	private boolean messageValid;

	/**
	 * The variables to send
	 */
	private BlockPos pos;
	private int newMaxNumber;

	/**
	 * Default constructor used for registration
	 */
	public PacketSetMaxNumberOfItems() {
		this.messageValid = false;
	}

	/**
	 * Create a packet which will update the max number of items in the
	 * {@link TileEntity} on the {@link Side#SERVER}
	 * 
	 * @param pos                  	The position of the {@link TileEntity}
	 * @param newMaxNumber			The new max number
	 */
	public PacketSetMaxNumberOfItems(BlockPos pos, int newMaxNumber) {
		this.pos = pos;
		this.newMaxNumber = newMaxNumber;
		this.messageValid = true;
	}

	/**
	 * Read data from the {@link ByteBuf} provided
	 */
	@Override
	public void fromBytes(ByteBuf buf) {
		try {
			this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
			this.newMaxNumber = buf.readInt();
		} catch (IndexOutOfBoundsException ioe) {
			LogHelper.getLogger().catching(ioe);
			return;
		}
		this.messageValid = true;
	}

	/**
	 * Write data to the {@link ByteBuf} provided
	 */
	@Override
	public void toBytes(ByteBuf buf) {
		if (!this.messageValid)
			return;
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
		buf.writeInt(newMaxNumber);

	}

	/**
	 * Handles the {@link PacketSetMaxNumberOfItems} message
	 * 
	 * @author grillo78
	 *
	 */
	public static class Handler implements IMessageHandler<PacketSetMaxNumberOfItems, IMessage> {

		/**
		 * Adds a task to the server handler to process our message
		 */
		@Override
		public IMessage onMessage(PacketSetMaxNumberOfItems message, MessageContext ctx) {
			if (!message.messageValid && ctx.side != Side.SERVER)
				return null;
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> {
				TileEntity te = ctx.getServerHandler().player.getServerWorld().getTileEntity(message.pos);
				if (te == null)
					return;
				if (te instanceof TileEntityLock)
					((TileEntityLock) te).setMaxNumberOfItems(message.newMaxNumber);
			});
			return message;
		}
	}

}