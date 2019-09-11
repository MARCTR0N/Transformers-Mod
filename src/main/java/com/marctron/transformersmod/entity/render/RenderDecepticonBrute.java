package com.marctron.transformersmod.entity.render;

import com.marctron.transformersmod.entity.EntityDecepticonBrute;
import com.marctron.transformersmod.entity.model.ModelDecepticonBrute;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDecepticonBrute extends RenderLiving<EntityDecepticonBrute> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/decepticon_brute.png");

    public RenderDecepticonBrute(RenderManager manager) {
        super(manager, new ModelDecepticonBrute(), 0.7F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDecepticonBrute entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityDecepticonBrute entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {

        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}