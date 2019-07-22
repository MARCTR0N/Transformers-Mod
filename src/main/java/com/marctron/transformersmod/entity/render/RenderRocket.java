package com.marctron.transformersmod.entity.render;


import org.lwjgl.opengl.GL11;

import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.entity.EntityRocket;
import com.marctron.transformersmod.entity.model.ModelBullet;
import com.marctron.transformersmod.entity.model.ModelRocket;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderTippedArrow;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderRocket extends Render<EntityRocket>
	{
		
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bullet.png");
//	public static final Factory FACTORY = new Factory();
    private final ModelRocket model = new ModelRocket();
	


    public RenderRocket(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityRocket entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GL11.glPushMatrix();
        bindTexture(TEXTURES);
        GL11.glTranslated(x, y - 1.3, z);
        model.render(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 20.0F, 0.0F, 4.0F, 0.0F);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        GL11.glPopMatrix();
    }

    

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    public ResourceLocation getEntityTexture(EntityRocket entity)
    {
        return RenderTippedArrow.RES_ARROW;
    }
    
	
	
	
	
//		private final float scale;
//		 
//		public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/bullet.png");
////		public static final Factory FACTORY = new Factory();
//	    private final ModelRocket model = new ModelRocket();
//	 
//	    public RenderRocket(RenderManager manager, float scaleIn) 
//	    {
//			super(manager);
//			this.scale = scaleIn;
//		}
//	 
//	    @Override
//	    public void doRender(EntityRocket entity, double x, double y, double z, float entityYaw, float partialTicks) {
//	        
//	    	GL11.glPushMatrix();
//	        bindTexture(TEXTURES);
//	        GL11.glTranslated(x, y - 1.3, z);
//	        model.render(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
//	        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
//	        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
//	        GL11.glPopMatrix();
//	    }
//	    
//	    @Override
//	    public ResourceLocation getEntityTexture(EntityRocket entity)
//	    {
//	        return RenderBullet.TEXTURES;
//	    }
}