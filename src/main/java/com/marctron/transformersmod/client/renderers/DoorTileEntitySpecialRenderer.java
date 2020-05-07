package com.marctron.transformersmod.client.renderers;

import com.marctron.transformersmod.blocks.tileentity.AnimatedDoorTileEntity;
import com.marctron.transformersmod.client.renderers.models.ModelWFCEscalationDoor;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DoorTileEntitySpecialRenderer extends TileEntitySpecialRenderer<AnimatedDoorTileEntity> {
	
	private ModelWFCEscalationDoor model = new ModelWFCEscalationDoor();
	private static final ResourceLocation TEXTURE = new ResourceLocation("tm","textures/blocks/door.png");
	
	public DoorTileEntitySpecialRenderer() {
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@Override
	public void render(AnimatedDoorTileEntity te, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
		GlStateManager.pushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("tm","textures/blocks/door.png"));
		GlStateManager.translate(x+0.5, y+0.5, z+0.5);
		switch(te.getWorld().getBlockState(te.getPos()).getValue(BlockHorizontal.FACING)) {
		case EAST:
		case WEST:
			GlStateManager.rotate(90,0,1, 0);
		}
		GlStateManager.scale(0.0625F,0.0625F,0.0625F);
		model.topright.rotateAngleZ = (float)Math.toRadians(te.getOpenedProgress());
		model.topleft.rotateAngleZ = (float)Math.toRadians(-te.getOpenedProgress());
		model.toprightcorner.rotateAngleZ = (float)Math.toRadians(te.getOpenedProgress());
		model.topleftcorner.rotateAngleZ = (float)Math.toRadians(-te.getOpenedProgress());
		model.leftside_1.rotateAngleZ = (float)Math.toRadians(-te.getOpenedProgress());
		model.rightside_1.rotateAngleZ = (float)Math.toRadians(te.getOpenedProgress());
		model.leftcircle1.offsetX = -(17*te.getOpenedProgress()/90);
		model.rightcircle1.offsetX = (17*te.getOpenedProgress()/90);
		model.bottomleft1.offsetY = (20*te.getOpenedProgress()/90);
		model.bottomright1.offsetY = (20*te.getOpenedProgress()/90);
		model.render();
		GlStateManager.popMatrix();
		super.render(te, x, y, z, partialTicks, destroyStage, alpha);
	}

}
