package com.marctron.transformersmod.blocks.machinery.energonengine;

import com.marctron.transformersmod.network.PacketGetWorker;
import com.marctron.transformersmod.network.PacketHandler;
import com.marctron.transformersmod.util.Reference;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;


import cjminecraft.core.CJCore;
import cjminecraft.core.client.gui.GuiBase;
import cjminecraft.core.client.gui.element.ElementEnergyBar;
import cjminecraft.core.client.gui.element.ElementProgressBar;
import cjminecraft.core.client.gui.element.ElementProgressBar.ProgressBarDirection;
import cjminecraft.core.config.CJCoreConfig;
import cjminecraft.core.energy.EnergyUtils;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class GuiEnergonEngine  extends GuiBase {

    	/**
    	 * The location of the background texture
    	 */
    	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/gui/glowstone_generator.png");

    	/**
    	 * The {@link TileEntityFurnaceGenerator} to sync with
    	 */
    	private EnergonEngineTile te;

    	/**
    	 * The cooldown and max cooldown gathered from when synced with the server
    	 */
    	public static int cooldown, maxCooldown = 0;

    	/**
    	 * The counter so that we sync every 10 ticks and not every tick
    	 */
    	public static int sync = 0;

    	/**
    	 * Initialise the gui for the furnace generator
    	 * 
    	 * @param playerInv
    	 *            The player's inventory (for the container)
    	 * @param te
    	 *            The {@link TileEntityFurnaceGenerator} for syncing and for the
    	 *            container
    	 */
    	public GuiEnergonEngine(IInventory playerInv, EnergonEngineTile te) {
    		// Set the container and the texture which will automatically be drawn
    		super(new ContainerEnergonEngine(playerInv, te), TEXTURE);
    		setGuiSize(176, 166); // Set the size of the gui for the texture

    		this.te = te;
    		this.name = "container.energon_engine"; // Will automatically be
    													// localised using CJCore
    	}

    	/**
    	 * Where we should add all of the gui elements
    	 */
    	@Override
    	public void initGui() {
    		super.initGui();
    		addElement(new ElementEnergyBar(this, 7, 16, 18, 54).shouldSync(this.te.getPos(), null));
    		addElement(new ElementProgressBar(this, 81, 53, 14, 13).setDirection(ProgressBarDirection.UP_TO_DOWN)
    				.setTextureUV(176, 0).setTexture(TEXTURE, 256, 256));
    	}

    	/**
    	 * Where we update the gui elements
    	 */
    	@Override
    	protected void updateElementInformation() {
    		super.updateElementInformation();
    		if (cooldown == 0)
    			cooldown = maxCooldown;
    		((ElementProgressBar) this.elements.get(1)).setMin(cooldown).setMax(maxCooldown);
    		sync++;
    		sync %= 10;
    		updateElements();
//    		if (sync == 0) {
//    			PacketHandler.INSTANCE
//				.sendToServer(new PacketGetWorker(this.te.getPos(), this.mc.player.getAdjustedHorizontalFacing(),
//    							"com.marctron.transformersmod.blocks.energonengine.GuiEnergonEngine", "cooldown", "maxCooldown"));
//    		}
    	}

    }