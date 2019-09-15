package com.marctron.transformersmod.entity.render;


import com.marctron.transformersmod.entity.EntityDecepticonVehiconVariant2;
import com.marctron.transformersmod.entity.model.ModelDecepticonVehiconVariant2;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDecepticonVehiconVariant2 extends RenderLiving<EntityDecepticonVehiconVariant2> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/decepticon_vehicon_2.png");

    public RenderDecepticonVehiconVariant2(RenderManager manager) {
        super(manager, new ModelDecepticonVehiconVariant2(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDecepticonVehiconVariant2 entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityDecepticonVehiconVariant2 entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {

        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}
