package com.marctron.transformersmod.resize.compatibilities;

import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.resize.compatibilities.sizelimit.ISizeLimit;
import com.marctron.transformersmod.resize.compatibilities.sizelimit.SizeLimitPro;
import com.marctron.transformersmod.resize.compatibilities.sizelimit.SizeDefaultLimit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilitiesHandler {

	@SubscribeEvent
	public void onAddCapabilites(AttachCapabilitiesEvent<Entity> event)
	{
		if(event.getObject() instanceof EntityLivingBase  && !event.getObject().hasCapability(SizeLimitPro.sizeCapability, null))
		{
			final EntityLivingBase entity = (EntityLivingBase) event.getObject();
			final boolean transformed = false;
			final float defaultWidth = entity.width;
			final float defaultHeight = entity.height;
			final ISizeLimit cap = new SizeDefaultLimit(transformed, defaultWidth, defaultHeight);
			event.addCapability(new ResourceLocation(Reference.MOD_ID, "Capability"), new SizeLimitPro(cap));
		}
	}
}
