package com.marctron.transformersmod.client.modelloaders.bbmodel;

import com.google.common.collect.ImmutableMap;
import com.marctron.transformersmod.client.modelloaders.animator.Animator;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.client.model.PerspectiveMapWrapper;
import net.minecraftforge.common.model.TRSRTransformation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.Map;

public class GunOverrideHandler extends ItemOverrideList {

    private Animator animator;

    public GunOverrideHandler(Animator animator) {
        super(new ArrayList<>());
        this.animator = animator;
    }

    @Nullable
    @Override
    public IBakedModel handleItemState(@Nonnull IBakedModel model, @Nonnull ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {

        if (model instanceof BakedGunModel) {

            BakedGunModel gunModel = (BakedGunModel) model;
            gunModel.setSubTransforms(animator.getSubTransforms(stack, worldIn, entityIn));

            Map<ItemCameraTransforms.TransformType, TRSRTransformation> baseTransforms = animator.getBaseTransforms(stack, worldIn, entityIn);
            PerspectiveMapWrapper.getTransforms(gunModel.getItemCameraTransforms()).forEach((type, transform) -> baseTransforms.put(type, transform.compose(baseTransforms.get(type))));
            gunModel.setCameraTransforms(ImmutableMap.copyOf(baseTransforms));

        }

        return model;
    }
}
