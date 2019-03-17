package com.marctron.transformersmod.blocks.gui;

import com.marctron.transformersmod.blocks.container.ContainerEnergonCrate;
import com.marctron.transformersmod.blocks.tileentity.TileEntityEnergonCrate;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiEnergonCrate extends GuiContainer
{
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MOD_ID + ":textures/gui/energon_crate.png");
	private final InventoryPlayer playerInventory;
	private final TileEntityEnergonCrate te;
	
	public GuiEnergonCrate(InventoryPlayer playerInventory, TileEntityEnergonCrate chestInventory, EntityPlayer player) 
	{
		super(new ContainerEnergonCrate(playerInventory, chestInventory, player));
		this.playerInventory = playerInventory;
		this.te = chestInventory;
		
		this.xSize = 179;
		this.ySize = 256;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) 
	{
		this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 3127295);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 3127295);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(GUI_CHEST);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, -1, this.xSize, this.ySize);
	}
}
