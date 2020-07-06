package com.marctron.transformersmod.entity.render;

import org.lwjgl.opengl.GL11;

import com.marctron.transformersmod.entity.EntityNewBullet;
import com.marctron.transformersmod.entity.model.ModelBullet;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderTippedArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNewBullet extends Render<EntityNewBullet> {
    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bullet.png");
    //	public static final Factory FACTORY = new Factory();
    private final ModelBullet model = new ModelBullet();

    public RenderNewBullet(RenderManager manager) {
        super(manager);
    }

    @Override
    public void doRender(EntityNewBullet entity, double x, double y, double z, float entityYaw, float partialTicks) {

        GL11.glPushMatrix();
        bindTexture(TEXTURES);
        GL11.glTranslated(x, y - 1.3, z);
        model.render(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
    }

    @Override
    public ResourceLocation getEntityTexture(EntityNewBullet entity) {
        return RenderTippedArrow.RES_ARROW;
    }
}