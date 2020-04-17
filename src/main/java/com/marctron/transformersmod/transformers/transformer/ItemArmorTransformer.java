package com.marctron.transformersmod.transformers.transformer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ICrashReportDetail;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ReportedException;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorTransformer extends ItemArmor {



	  
	@SideOnly(Side.CLIENT)
    private RenderLivingBase renderer;
	
	public ItemArmorTransformer(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
	}
	
    @SideOnly(Side.CLIENT)
    public RenderLivingBase getRenderer() {
    	return renderer;
    }
    
    @SideOnly(Side.CLIENT)
    public void setRenderer(RenderLivingBase renderer) {
    	this.renderer = renderer;
    }

    public boolean Altmode(boolean isAltmode){
    	if (isAltmode){
    		Minecraft.getMinecraft().gameSettings.viewBobbing=false;
    	}
    	if (!isAltmode){
    		Minecraft.getMinecraft().gameSettings.viewBobbing=true;
    	}
		return isAltmode;
    }
	

}
