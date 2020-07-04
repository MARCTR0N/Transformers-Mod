package com.marctron.transformersmod.network;

import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.util.handlers.CapabilityHandler;

import io.netty.buffer.ByteBuf;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketNotifyPlayerAnimationStart implements IMessage{
	
	private Animation animation;
	
	/**
	 * States whether the message is valid or not
	 */
	private boolean isValid;

	public PacketNotifyPlayerAnimationStart() {
		isValid = false;
	}
	
	public PacketNotifyPlayerAnimationStart(Animation animation) {
		isValid = true;
		this.animation = animation;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		isValid = buf.readBoolean();
		switch (buf.readInt()) {
		case 0:
			animation = CapabilityHandler.PUNCH_ANIMATION;
			break;
		case 1:
			animation = CapabilityHandler.AXE_ANIMATION;
			break;
		case 2:
			animation = CapabilityHandler.SWORD_ANIMATION;
			break;
		case 3:
			animation = CapabilityHandler.AXE_REVERSE_ANIMATION;
			break;
		case 4:
			animation = CapabilityHandler.SWORD_REVERSE_ANIMATION;
			break;
		case 5:
			animation = CapabilityHandler.RELOAD_ANIMATION;
			break;
		}

	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(isValid);
		if (animation == CapabilityHandler.PUNCH_ANIMATION) {
			buf.writeInt(0);
		} else if (animation == CapabilityHandler.AXE_ANIMATION) {
			buf.writeInt(1);
		} else if (animation == CapabilityHandler.SWORD_ANIMATION) {
			buf.writeInt(2);
		} else if (animation == CapabilityHandler.AXE_REVERSE_ANIMATION) {
			buf.writeInt(3);
		} else if (animation == CapabilityHandler.SWORD_REVERSE_ANIMATION) {
			buf.writeInt(4);
		} else if (animation == CapabilityHandler.RELOAD_ANIMATION) {
			buf.writeInt(5);
		}
	}

	public static class Handler implements IMessageHandler<PacketNotifyPlayerAnimationStart, IMessage>{

		@Override
		public IMessage onMessage(PacketNotifyPlayerAnimationStart message, MessageContext ctx) {
			if (!message.isValid && ctx.side != Side.SERVER)
				return null;
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(()->{
				TFNetworkManager.sendToAll(new PacketSetClientAnimation(ctx.getServerHandler().player.getName(), message.animation));
			});
			return message;
		}
		
	}
	
}
