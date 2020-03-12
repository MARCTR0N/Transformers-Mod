package com.marctron.transformersmod.client.modelloaders.bbmodel;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

import javax.annotation.Nonnull;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.util.Reference;

public class BBGunLoader implements ICustomModelLoader {

    @Override
    public void onResourceManagerReload(@Nonnull IResourceManager resourceManager) {

    }

    /**
     * Checks if given model should be loaded by this loader.
     * Reading file contents is inadvisable, if possible decision should be made based on the location alone.
     *
     * @param modelLocation The path, either to an actual file or a {@link ModelResourceLocation}.
     */
    @Override
    public boolean accepts(ResourceLocation modelLocation) {
        return modelLocation.getResourceDomain().equals(Reference.MOD_ID) && modelLocation.getResourcePath().endsWith(".bbmodel");
    }

    /**
     * @param modelLocation The model to (re)load, either path to an
     *                      actual file or a {@link ModelResourceLocation}.
     */
    @Nonnull
    @Override
    public IModel loadModel(@Nonnull ResourceLocation modelLocation) throws Exception {
        Main.logger.info("Loading Model: {}", modelLocation);
        return new UnbakedBBGunModel(modelLocation);
    }
}
