package com.marctron.transformersmod.entity.render;


import com.marctron.transformersmod.entity.EntityDecepticonVehiconShotgunner;
import com.marctron.transformersmod.entity.EntityDecepticonVehiconVariant1;
import com.marctron.transformersmod.entity.model.decepticon.wfc.ModelDecepticonVehiconShotgunner;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderDecepticonVehiconShotgunner extends RenderBiped<EntityDecepticonVehiconShotgunner> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/decepticon_vehicon_1.png");

    public RenderDecepticonVehiconShotgunner(RenderManager manager) {
        super(manager, new ModelDecepticonVehiconShotgunner(), 0.5F);
        this.addLayer(new LayerHeldItem(this));
        this.addLayer(new LayerBipedArmor(this)
        {
            protected void initArmor()
            {
                this.modelLeggings = null;
                this.modelArmor = null;
            }
        });
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDecepticonVehiconShotgunner entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityDecepticonVehiconShotgunner entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {

        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}
