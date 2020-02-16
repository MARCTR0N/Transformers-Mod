package com.marctron.transformersmod.resize.potions;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.resize.ClimbingHandler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent;
//import net.minecraftforge.event.entity.living.PotionEvent.PotionApplicableEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@EventBusSubscriber
public class PotionHandler {
	
	@SubscribeEvent
	public static void isPotionApplicable(PotionApplicableEvent event) {
		setPotionApplicability(event, Main.SHRINKING);
		setPotionApplicability(event, Main.GROWTH);
	}

	/**
	 * Allows or denies the addition of a shrinking or growth resize potion
	 *
	 * @param event
	 *            potion applicability event
	 * @param potionTarget
	 *            shrinking or growth resize potion
	 */
	private static void setPotionApplicability(PotionApplicableEvent event, Potion potionTarget) {
		if (event.getPotionEffect().getPotion() == potionTarget) {
			final Potion potionOld = potionTarget == Main.GROWTH ? Main.SHRINKING : Main.GROWTH;
			event.setResult(event.getEntityLiving().isPotionActive(potionOld) ? Event.Result.DENY : Event.Result.ALLOW);
		}
	}

	@SubscribeEvent
	public static void onPlayerUpdate(TickEvent.PlayerTickEvent event) {
		final EntityPlayer player = event.player;
		final PotionEffect growth = player.getActivePotionEffect(Main.GROWTH);
		final PotionEffect shrinking = player.getActivePotionEffect(Main.SHRINKING);

		if ((shrinking != null) || (growth != null)) {
			if (growth == null) {
				player.jumpMovementFactor *= 1.75F;
				player.fallDistance = 0.0F;
				if (shrinking.getAmplifier() >= 1) {
					updateClimbingStatus(player);
				}
			}
			player.stepHeight = player.height / 3;
		}
		
	}

	private static void updateClimbingStatus(final EntityPlayer player) {
		if ((ClimbingHandler.canClimb(player, player.getHorizontalFacing()) != false)) {
			if (player.collidedHorizontally) {
				if (!player.isSneaking()) {
					player.motionY = 0.1F;
				}
				if (player.isSneaking()) {
					player.motionY = 0.0F;
				}
			}
		}
	}

	@SubscribeEvent
	public static void onLivingJump(LivingJumpEvent event) {
		final EntityLivingBase entity = event.getEntityLiving();
		final PotionEffect shrinking = entity.getActivePotionEffect(Main.SHRINKING);
		final PotionEffect growth = entity.getActivePotionEffect(Main.GROWTH);

		if (shrinking != null) {
			if (shrinking.getAmplifier() == 0) {
				entity.motionY += shrinking.getAmplifier() + 0.25D;
			} else {
				entity.motionY += shrinking.getAmplifier() / 2.0D;
			}
		}

		if (growth != null) {
			entity.motionY += (growth.getAmplifier() + 1) * 0.2;
		}
	}
}
