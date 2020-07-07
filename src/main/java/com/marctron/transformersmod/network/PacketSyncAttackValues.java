package com.marctron.transformersmod.network;

import com.marctron.transformersmod.events.ClientEvents;
import com.marctron.transformersmod.util.DamageIndicator;

import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketSyncAttackValues implements IMessage {

	/**
	 * States whether the message is valid or not
	 */
	private boolean messageValid;

	/**
	 * The variables to send
	 */
	private float attackYaw;

	/**
	 * Default constructor used for registration
	 */
	public PacketSyncAttackValues() {
		this.messageValid = false;
	}

	/**
	 * Create a packet which will update the max number of items in the
	 * {@link TileEntity} on the {@link Side#SERVER}
	 * 
	 * @param pos          The position of the {@link TileEntity}
	 * @param  The new max number
	 */
	public PacketSyncAttackValues(float attackYaw) {
		this.attackYaw = attackYaw;
		this.messageValid = true;
	}

	/**
	 * Read data from the {@link ByteBuf} provided
	 */
	@Override
	public void fromBytes(ByteBuf buf) {
		this.attackYaw = buf.readFloat();
		this.messageValid = true;
	}

	/**
	 * Write data to the {@link ByteBuf} provided
	 */
	@Override
	public void toBytes(ByteBuf buf) {
		if (!this.messageValid)
			return;
		buf.writeFloat(attackYaw);

	}

	/**
	 * Handles the {@link PacketSyncAttackValues} message
	 * 
	 * @author grillo78
	 *
	 */
	public static class Handler implements IMessageHandler<PacketSyncAttackValues, IMessage> {

		/**
		 * Adds a task to the server handler to process our message
		 */
		@Override
		public IMessage onMessage(PacketSyncAttackValues message, MessageContext ctx) {
			if (!message.messageValid && ctx.side != Side.CLIENT)
				return null;
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> {
				ClientEvents.INDICATORS.add(new DamageIndicator(message.attackYaw));
			});
			return message;
		}
	}

}