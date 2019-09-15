package com.marctron.transformersmod.entity.render;


import com.marctron.transformersmod.entity.EntityDecepticonVehiconVariant1;
import com.marctron.transformersmod.entity.model.ModelDecepticonVehiconVariant1;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDecepticonVehiconVariant1 extends RenderLiving<EntityDecepticonVehiconVariant1> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/decepticon_vehicon_1.png");

    public RenderDecepticonVehiconVariant1(RenderManager manager) {
        super(manager, new ModelDecepticonVehiconVariant1(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDecepticonVehiconVariant1 entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityDecepticonVehiconVariant1 entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {

        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}
