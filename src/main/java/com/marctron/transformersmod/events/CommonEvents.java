package com.marctron.transformersmod.events;

import com.marctron.transformersmod.network.PacketSyncAttackValues;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonEvents {

	@SubscribeEvent
	public void onEntityDamaged(LivingDamageEvent event) {
		if (event.getEntity() instanceof EntityPlayerMP) {
			if (event.getSource().getDamageLocation() != null) {
				Vec3d damagePosition = event.getEntity().getPositionVector()
						.subtract(event.getSource().getDamageLocation());
				float yaw = (float) (Math.atan2(damagePosition.x, damagePosition.z));
				TFNetworkManager.sendTo(new PacketSyncAttackValues((float) Math.toDegrees(yaw) + 180),
						(EntityPlayerMP) event.getEntity());
			}
		}
	}

}