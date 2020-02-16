package com.marctron.transformersmod.resize.potions;

import java.util.UUID;

import com.marctron.transformersmod.resize.attributes.Attributes;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionGrowth extends Potion {
	public static final ResourceLocation ICON = new ResourceLocation(Reference.MOD_ID, "textures/potions/effects.png");
	public static UUID uuid = UUID.fromString("ecb12bf7-3a91-4783-9750-d62bc9b7f3f1");

	public PotionGrowth(String name) {
		super(false, 16750080);
		this.setPotionName("effect." + name);
		this.setIconIndex(0, 0);

		this.registerPotionAttributeModifier(Attributes.ENTITY_HEIGHT, uuid.toString(), 0.5D, 2);
		this.registerPotionAttributeModifier(Attributes.ENTITY_WIDTH, uuid.toString(), 0.5D, 2);
//		this.registerPotionAttributeModifier(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, uuid.toString(), 0.5D, 2);
//		this.registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, uuid.toString(), 0.5D, 2);
//		this.registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, uuid.toString(), -0.2D, 2);

		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
	}

	@Override
	public void removeAttributesModifiersFromEntity(EntityLivingBase entity, AbstractAttributeMap attributeMapIn, int amplifier) {
		super.removeAttributesModifiersFromEntity(entity, attributeMapIn, amplifier);
		if (entity instanceof EntityPlayer) {
			entity.stepHeight = 0.6f;
			
		}
	}

	@Override
	public boolean hasStatusIcon() {
		Minecraft.getMinecraft().renderEngine.bindTexture(ICON);
		return true;
	}
}