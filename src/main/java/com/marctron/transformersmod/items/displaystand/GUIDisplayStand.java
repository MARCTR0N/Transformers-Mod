package com.marctron.transformersmod.items.displaystand;

import com.marctron.transformersmod.blocks.container.ContainerEnergonCrate;
import com.marctron.transformersmod.blocks.tileentity.TileEntityEnergonCrate;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GUIDisplayStand extends GuiContainer {
	private static final ResourceLocation GUI_CHEST = new ResourceLocation(Reference.MOD_ID + ":textures/gui/energon_crate.png");
    private final InventoryPlayer playerInventory;
    private final TileEntityDisplayStand te;

    public GUIDisplayStand(InventoryPlayer playerInventory, TileEntityDisplayStand displayStandInventory, EntityPlayer player) {
        super(new ContainerDisplayStand(playerInventory, displayStandInventory, player));
        this.playerInventory = playerInventory;
        this.te = displayStandInventory;

        this.xSize = 179;
        this.ySize = 256;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 3127295);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 3127295);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);

    }


    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GUI_CHEST);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, -1, this.xSize, this.ySize);
    }
}
