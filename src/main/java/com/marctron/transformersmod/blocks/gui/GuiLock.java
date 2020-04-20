package com.marctron.transformersmod.blocks.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.marctron.transformersmod.blocks.container.ContainerLock;
import com.marctron.transformersmod.blocks.tileentity.TileEntityLock;
import com.marctron.transformersmod.network.PacketSetMaxNumberOfItems;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiLock extends GuiContainer {

    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/lock_gui.png");
    private TileEntityLock tileEntity;
    private EntityPlayer player;
    private GuiTextField nameField;

    public GuiLock(EntityPlayer player, TileEntityLock tileEntity) {
        super(new ContainerLock(player.inventory,tileEntity));
        this.player = player;
        this.tileEntity = tileEntity;
    }

    @Override
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(true);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.nameField = new GuiTextField(0, this.fontRenderer, i + 113, j + 38, 49, 15);
        this.nameField.setText(String.valueOf(tileEntity.getMaxNumberOfItems()));
        this.nameField.setTextColor(-1);
        this.nameField.setDisabledTextColour(-1);
        this.nameField.setEnableBackgroundDrawing(false);
        this.nameField.setMaxStringLength(35);
    }
    
    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        this.nameField.mouseClicked(mouseX, mouseY, mouseButton);
    }
    
    @Override
    public void onGuiClosed() {
    	super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        this.nameField.drawTextBox();
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
    
    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
    	if (this.nameField.textboxKeyTyped(typedChar, keyCode))
        {
    		try{
    			tileEntity.setMaxNumberOfItems(Integer.valueOf(nameField.getText()));
    			TFNetworkManager.sendToServer(new PacketSetMaxNumberOfItems(tileEntity.getPos(),Integer.valueOf(nameField.getText())));
    		}catch(NumberFormatException e) {
    			
    		}
        }
        else
        {
            super.keyTyped(typedChar, keyCode);
        }
    }
}
