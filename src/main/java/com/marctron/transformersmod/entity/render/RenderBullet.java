package com.marctron.transformersmod.entity.render;

import org.lwjgl.opengl.GL11;

import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.entity.model.ModelBullet;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderTippedArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBullet extends Render<EntityBullet>
{
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bullet.png");
//	public static final Factory FACTORY = new Factory();
    private final ModelBullet model = new ModelBullet();
 
    public RenderBullet(RenderManager manager) 
    {
		super(manager);
	}
 
    @Override
    public void doRender(EntityBullet entity, double x, double y, double z, float entityYaw, float partialTicks) {
        
    	GL11.glPushMatrix();
        bindTexture(TEXTURES);
        GL11.glTranslated(x, y - 1.3, z);
        model.render(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
    }
    
    @Override
    public ResourceLocation getEntityTexture(EntityBullet entity)
    {
        return RenderTippedArrow.RES_ARROW;
    }
    
    
  
//    public static class Factory implements IRenderFactory<EntityBullet>
//    {
//        @Override
//        public Render<? super EntityBullet> createRenderFor(RenderManager manager)
//        {
//            return new RenderBullet(manager);
//        }
//    }
}





//public class RenderBullet extends Render<EntityBullet>
//{
//    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/swindel.png");
//    //RES_LOC = new ResourceLocation("bitsandbobs:textures/entities");
//    public static final Factory FACTORY = new Factory();
//
//    protected RenderBullet(RenderManager renderManager)
//    {
//        super(renderManager);
//    }
//
//    public void doRender(EntityBullet entity, double x, double y, double z, float entityYaw, float partialTicks)
//    {
//        bindEntityTexture(entity);
//        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//        GlStateManager.pushMatrix();
//        GlStateManager.disableLighting();
//        GlStateManager.translate((float)x, (float)y, (float)z);
//        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
//        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
//        Tessellator tessellator = Tessellator.getInstance();
//        BufferBuilder vertexbuffer = tessellator.getBuffer();
//
//        GlStateManager.enableRescaleNormal();
//
//        GlStateManager.rotate(45.0F, 1.0F, 0.0F, 0.0F);
//        GlStateManager.scale(0.05625F, 0.05625F, 0.05625F);
//        GlStateManager.translate(-4.0F, 0.0F, 0.0F);
//
//        if (this.renderOutlines)
//        {
//            GlStateManager.enableColorMaterial();
//            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
//        }
//
//        //TODO: Need to figure out something for rendering a bullet
//
//        GlStateManager.glNormal3f(0.05625F, 0.0F, 0.0F);
//        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
//        vertexbuffer.pos(-7.0D, -2.0D, -2.0D).tex(0.0D, 0.15625D).endVertex();
//        vertexbuffer.pos(-7.0D, -2.0D, 2.0D).tex(0.15625D, 0.15625D).endVertex();
//        vertexbuffer.pos(-7.0D, 2.0D, 2.0D).tex(0.15625D, 0.3125D).endVertex();
//        vertexbuffer.pos(-7.0D, 2.0D, -2.0D).tex(0.0D, 0.3125D).endVertex();
//        tessellator.draw();
//        GlStateManager.glNormal3f(-0.05625F, 0.0F, 0.0F);
//        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
//        vertexbuffer.pos(-7.0D, 2.0D, -2.0D).tex(0.0D, 0.15625D).endVertex();
//        vertexbuffer.pos(-7.0D, 2.0D, 2.0D).tex(0.15625D, 0.15625D).endVertex();
//        vertexbuffer.pos(-7.0D, -2.0D, 2.0D).tex(0.15625D, 0.3125D).endVertex();
//        vertexbuffer.pos(-7.0D, -2.0D, -2.0D).tex(0.0D, 0.3125D).endVertex();
//        tessellator.draw();
//
//        for (int j = 0; j < 4; ++j)
//        {
//            GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
//            GlStateManager.glNormal3f(0.0F, 0.0F, 0.05625F);
//            vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
//            vertexbuffer.pos(-8.0D, -2.0D, 0.0D).tex(0.0D, 0.0D).endVertex();
//            vertexbuffer.pos(8.0D, -2.0D, 0.0D).tex(0.5D, 0.0D).endVertex();
//            vertexbuffer.pos(8.0D, 2.0D, 0.0D).tex(0.5D, 0.15625D).endVertex();
//            vertexbuffer.pos(-8.0D, 2.0D, 0.0D).tex(0.0D, 0.15625D).endVertex();
//            tessellator.draw();
//        }
//
//        if (this.renderOutlines)
//        {
//            GlStateManager.disableOutlineMode();
//            GlStateManager.disableColorMaterial();
//        }
//
//        GlStateManager.disableRescaleNormal();
//        GlStateManager.enableLighting();
//        GlStateManager.popMatrix();
//        super.doRender(entity, x, y, z, entityYaw, partialTicks);
//    }
//
//    @Override
//    protected ResourceLocation getEntityTexture(EntityBullet entity)
//    {
//        return RenderTippedArrow.RES_ARROW; //RES_LOC;
//    }
//
//    public static class Factory implements IRenderFactory<EntityBullet>
//    {
//        @Override
//        public Render<? super EntityBullet> createRenderFor(RenderManager manager)
//        {
//            return new RenderBullet(manager);
//        }
//    }
