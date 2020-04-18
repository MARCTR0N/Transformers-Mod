package com.marctron.transformersmod.blocks.gui;

import com.marctron.transformersmod.blocks.container.ContainerLock;
import com.marctron.transformersmod.blocks.tileentity.TileEntityLock;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.CapabilityItemHandler;

public class GuiLock extends GuiContainer {

    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lock_gui.png");
    private TileEntityLock tileEntity;
    private EntityPlayer player;

    public GuiLock(EntityPlayer player, TileEntityLock tileEntity) {
        super(new ContainerLock(player.inventory,tileEntity));
        this.player = player;
        this.tileEntity = tileEntity;
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String tileName = this.tileEntity.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(tileName, (this.xSize / 2 - this.fontRenderer.getStringWidth(tileName) / 2) - 5, 6, 4210752);
        this.fontRenderer.drawString(this.player.inventory.getDisplayName().getUnformattedText(), 7, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        int k = this.getItemsStoredScaled(52);
        this.drawTexturedModalRect(this.guiLeft + 31, this.guiTop + 17, 176, 0, 16, 52 - k);
    }
    
    private int getItemsStoredScaled(int pixels) {
    	int i = this.tileEntity.getMaxNumberOfItems();

        if (i == 0)
        {
            return pixels;
        }

        return this.tileEntity.getNumberOfItems() * pixels / i;
    	
    }
    
}
