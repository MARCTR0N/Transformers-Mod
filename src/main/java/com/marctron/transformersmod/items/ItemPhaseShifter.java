package com.marctron.transformersmod.items;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemPhaseShifter extends Item implements IHasModel{

	protected final String TOOLTIP;
	private PotionEffect[] effects;
	
	public ItemPhaseShifter(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTransformers);
		
		TOOLTIP = getUnlocalizedName() + ".tooltip.";
		setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
		
	}

	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
		player.noClip = true;
		
	}
//	@Override
//	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
//			EnumFacing facing, float hitX, float hitY, float hitZ) {
//		player.noClip = true;
//		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
//	}
	
//	@Override
//	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
//		ItemStack itemstack = playerIn.getHeldItem(handIn);
//		
//		
//		
//		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);		
//	}


	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.DARK_PURPLE + I18n.format(TextFormatting.BOLD + I18n.format("Mythic")));
	}
	
	
	
	
	
//	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
//		
//		ItemStack itemstack = playerIn.getHeldItem(handIn);
//		
//		if (playerIn.noClip = true) {
//			playerIn.noClip = false;
//		} else
//			playerIn.noClip = true;
//		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
//		
//	}
	
	
	
	
	
//	public static void onUpdate(World world, EntityPlayer player, ItemStack itemStack, EnumHand hand)
//	{
//		if (ClientProxy.MY_KEYBINDING.isKeyDown()) {
//		
//		
//		player.noClip = true;
//		}
//	}
}
