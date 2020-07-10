package com.marctron.transformersmod.entity.render;


import com.marctron.transformersmod.entity.EntityDecepticonVehiconRocketeer;
import com.marctron.transformersmod.entity.EntityDecepticonVehiconVariant1;
import com.marctron.transformersmod.entity.model.decepticon.wfc.ModelDecepticonVehiconRocketeer;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;

public class RenderDecepticonVehiconRocketeer extends RenderBiped<EntityDecepticonVehiconRocketeer> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/decepticon_wfc_default.png");

    public RenderDecepticonVehiconRocketeer(RenderManager manager) {
        super(manager, new ModelDecepticonVehiconRocketeer(), 0.5F);
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
    protected ResourceLocation getEntityTexture(EntityDecepticonVehiconRocketeer entity) {

        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityDecepticonVehiconRocketeer entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {

        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}
