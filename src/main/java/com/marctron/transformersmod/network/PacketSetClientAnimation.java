package com.marctron.transformersmod.network;

import com.marctron.transformersmod.capabilities.EntityAnimatorProvider;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.util.handlers.CapabilityHandler;

import io.netty.buffer.ByteBuf;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketSetClientAnimation implements IMessage {

	private boolean isValid;
	private String playerName;
	private Animation animation;

	public PacketSetClientAnimation() {
		isValid = false;
	}

	public PacketSetClientAnimation(String playerName, Animation animation) {
		isValid = true;
		this.playerName = playerName;
		this.animation = animation;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		isValid = buf.readBoolean();
		playerName = ByteBufUtils.readUTF8String(buf);
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
		ByteBufUtils.writeUTF8String(buf, playerName);
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

	public static class Handler implements IMessageHandler<PacketSetClientAnimation, IMessage> {

		@Override
		public IMessage onMessage(PacketSetClientAnimation message, MessageContext ctx) {
			if (!message.isValid && ctx.side != Side.CLIENT)
				return null;
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> {
				EntityPlayer entity = Minecraft.getMinecraft().world.getPlayerEntityByName(message.playerName);
				IAnimatedEntity animator = null;
				if (entity.hasCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null)) {
					animator = entity.getCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null);
				}
				animator.setAnimation(message.animation);
			});
			return message;
		}

	}

}
