package com.marctron.transformersmod.resize.potions;

import java.util.UUID;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.marctron.transformersmod.resize.attributes.Attributes;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;

public class PotionShrinking extends Potion {
	public static final ResourceLocation ICON = new ResourceLocation(Reference.MOD_ID, "textures/potions/effects.png");
	public static UUID uuid = UUID.fromString("2a69b27f-e024-4b4f-8110-7e35c740e8d6");

	public PotionShrinking(String name, EntityLivingBase entity) {
		super(false, 65480);
		this.setPotionName("effect." + name);
		this.setIconIndex(1, 0);

		this.registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, uuid.toString(), 0.5D, 2);
		this.registerPotionAttributeModifier(Attributes.ENTITY_HEIGHT, uuid.toString(), -0.4D, 1);
		this.registerPotionAttributeModifier(Attributes.ENTITY_WIDTH, uuid.toString(), -0.4D, 1);
		this.registerPotionAttributeModifier(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, uuid.toString(), -1.0D, 2);
		this.registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, uuid.toString(), -0.25D, 2);
		
//		entity.setEntityBoundingBox(new AxisAlignedBB(entity.getEntityBoundingBox().minX, entity.getEntityBoundingBox().minY, entity.getEntityBoundingBox().minZ, entity.getEntityBoundingBox().minX + 0.6F, entity.getEntityBoundingBox().minY + 0.7F, entity.getEntityBoundingBox().minZ + 0.6F));
//		entity.height=0.9F;
		
		
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
//		Minecraft.getMinecraft().renderEngine.bindTexture(ICON);
		return false;
	}
}
