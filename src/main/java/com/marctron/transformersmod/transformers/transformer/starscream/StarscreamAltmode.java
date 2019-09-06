package com.marctron.transformersmod.transformers.transformer.starscream;


import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.ModelVehicleBase;
import com.marctron.transformersmod.transformers.models.starscream.ModelStarscreamAltmode;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StarscreamAltmode extends ModelVehicleBase {


 


    public StarscreamAltmode(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(null);
        setMaxStackSize(1);
        

    }
    
    
    protected void applyRotations(AbstractClientPlayer entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
//        if (entityLiving.isEntityAlive() && entityLiving.isPlayerSleeping())
//        {
//            GlStateManager.rotate(entityLiving.getBedOrientationInDegrees(), 0.0F, 1.0F, 0.0F);
////            GlStateManager.rotate(this.getDeathMaxRotation(entityLiving), 0.0F, 0.0F, 1.0F);
//            GlStateManager.rotate(270.0F, 0.0F, 1.0F, 0.0F);
//        }
//        else if (entityLiving.isElytraFlying())
//        {
//            super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
//            float f = (float)entityLiving.getTicksElytraFlying() + partialTicks;
//            float f1 = MathHelper.clamp(f * f / 100.0F, 0.0F, 1.0F);
//            GlStateManager.rotate(f1 * (-90.0F - entityLiving.rotationPitch), 1.0F, 0.0F, 0.0F);
//            Vec3d vec3d = entityLiving.getLook(partialTicks);
//            double d0 = entityLiving.motionX * entityLiving.motionX + entityLiving.motionZ * entityLiving.motionZ;
//            double d1 = vec3d.x * vec3d.x + vec3d.z * vec3d.z;
//
//            if (d0 > 0.0D && d1 > 0.0D)
//            {
//                double d2 = (entityLiving.motionX * vec3d.x + entityLiving.motionZ * vec3d.z) / (Math.sqrt(d0) * Math.sqrt(d1));
//                double d3 = entityLiving.motionX * vec3d.z - entityLiving.motionZ * vec3d.x;
//                GlStateManager.rotate((float)(Math.signum(d3) * Math.acos(d2)) * 180.0F / (float)Math.PI, 0.0F, 1.0F, 0.0F);
//            }
//        }
//        else
//        {
////            super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
//        }
    }

    @Override


    
    public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
        player.fallDistance = 0;

        player.dropItem(true);
        
        
        
        player.setSprinting(false);
        player.moveRelative(0F, 0F, 0.01F, 3F);
        world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 1.3, player.posZ, 0.6D, 0.D, 0.85D);
        world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + 0.2, player.posY + 1.3, player.posZ, 0.6D, 0.0D, 0.85D);
        world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX - 0.2, player.posY + 1.3, player.posZ, 0.6D, 0.0D, 0.85D);
        world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 1.3, player.posZ + 0.2, 0.6D, 0.0D, 0.85D);
        world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 1.3, player.posZ - 0.2, 0.6D, 0.0D, 0.85D);
        player.cameraPitch = 0;
        player.cameraYaw = 0;

        if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {

            world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ, 0.6D, 0.D, 0.85D);
            world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + 0.2, player.posY + 0.15, player.posZ, 0.6D, 0.0D, 0.85D);
            world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX - 0.2, player.posY + 0.15, player.posZ, 0.6D, 0.0D, 0.85D);
            world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ + 0.2, 0.6D, 0.0D, 0.85D);
            world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ - 0.2, 0.6D, 0.0D, 0.85D);

//			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, player.posX, player.posY, player.posZ, 0., -0.1, 0);
            player.setSprinting(false);
            player.moveRelative(0F, 0F, 0.01F, 3F);

        }

        if (Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown()) {
            player.setSprinting(false);
            player.moveRelative(0F, 0F, -0.01F, 3F);
        }


        if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {


            player.motionY += 0.3F;
            player.motionY = Math.min(0.45F, player.motionY);
            if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
                player.setSprinting(false);
                player.moveRelative(0F, 0F, 0.01F, 3F);
            }

        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        Vec3d aim = player.getLookVec();
        
        double d0 = player.motionX * player.motionX + player.motionZ * player.motionZ;
        double d1 = aim.x * aim.x + aim.y * aim.y;
        if (d0 > 0.0D && d1 > 0.0D)
        {
            double d2 = (player.motionX * aim.x + player.motionZ * aim.z) / (Math.sqrt(d0) * Math.sqrt(d1));
            double d3 = player.motionX * aim.z - player.motionZ * aim.x;
//            GlStateManager.rotate((float)(Math.signum(d3) * Math.acos(d2)) * 180.0F / (float)Math.PI, 0.0F, 1.0F, 0.0F);
        }
        
        player.motionY += 0.1F* aim.y +0.01F;
//        player.motionY = Math.min(0.45F, player.motionY);
        
        player.motionX += 0.01F* aim.x;
        player.motionZ += 0.01F* aim.z;
        
        player.moveRelative(0F, 0.01F, 0.00F, 0F);
        
        
        
        
        
        

        if (ClientProxy.ROBOT_MODE.isKeyDown()) {

//				Timer timer = new Timer();
//				timer.schedule(new TimerTask() {
//
//					@Override
//					public void run() {


            //Starscream
            if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_ALTMODE_BOOTS) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.STARSCREAM_MID4_BOOTS));
                    Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMONE, 0.3F, 1.9F);
                }
            }


            if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_ALTMODE_LEGGINGS) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.STARSCREAM_MID4_LEGGINGS));
                }
            }

            if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_ALTMODE_CHESTPLATE) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.STARSCREAM_MID4_CHESTPLATE));
                }
            }

            if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_ALTMODE_HELMET) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.STARSCREAM_MID4_HELMET));
                }
            }

            //Skywarp
            if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_ALTMODE_BOOTS) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.SKYWARP_MID4_BOOTS));
                    Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMONE, 0.3F, 1.9F);
                }

            }

            if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_ALTMODE_LEGGINGS) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.SKYWARP_MID4_LEGGINGS));
                }
            }

            if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_ALTMODE_CHESTPLATE) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.SKYWARP_MID4_CHESTPLATE));
                }
            }

            if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_ALTMODE_HELMET) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.SKYWARP_MID4_HELMET));
                }
            }

            //THUNDERCRACKER
            if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_ALTMODE_BOOTS) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_MID4_BOOTS));
                    Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMONE, 0.3F, 1.9F);
                }

            }

            if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_ALTMODE_LEGGINGS) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_MID4_LEGGINGS));
                }
            }

            if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_ALTMODE_CHESTPLATE) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_MID4_CHESTPLATE));
                }
            }

            if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_ALTMODE_HELMET) {
                if (world.isRemote) {
                    player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_MID4_HELMET));
                }
            }

//					}
//
//				}, 60);


            if (!player.onGround) {
                if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
                    player.setSprinting(false);
                    player.moveRelative(0F, 0F, 0.01F, 3F);
                }
            }


        }
          


                    //world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY, player.posZ, 0., -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX + 0.2, player.posY, player.posZ, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX - 0.2, player.posY, player.posZ, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ + 0.2, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ - 0.2, 0, -0.3, 0);

//						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ, 0.6D, 0.D, 0.85D);
//						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + 0.2, player.posY + 0.15, player.posZ, 0.6D, 0.0D, 0.85D);
//						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX - 0.2, player.posY + 0.15, player.posZ, 0.6D, 0.0D, 0.85D);
//						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ + 0.2, 0.6D, 0.0D, 0.85D);
//						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ - 0.2, 0.6D, 0.0D, 0.85D);
//
//						world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, player.posX, player.posY, player.posZ, 0., -0.1, 0);
                    //world.spawnParticle(EnumParticleTypes.FLAME, player.posX, player.posY, player.posZ, 0, -0.1, 0);


                

            
        


    }

    private void setSize(float f, float f1) {
        f = 0.6f;
        f1 = 2.9f;

    }

    @Override
    @SideOnly(Side.CLIENT)
    public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


            	ArmorTypes.modelStarscreamAltmode.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	ArmorTypes.modelStarscreamAltmode.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	ArmorTypes.modelStarscreamAltmode.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
                ArmorTypes.modelStarscreamAltmode.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelStarscreamAltmode.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelStarscreamAltmode.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
                ArmorTypes.modelStarscreamAltmode.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

                ArmorTypes.modelStarscreamAltmode.isSneak = _default.isSneak;
                ArmorTypes.modelStarscreamAltmode.isRiding = _default.isRiding;
                ArmorTypes.modelStarscreamAltmode.isChild = _default.isChild;
                ArmorTypes.modelStarscreamAltmode.rightArmPose = _default.rightArmPose;
                ArmorTypes.modelStarscreamAltmode.leftArmPose = _default.leftArmPose;

                return ArmorTypes.modelStarscreamAltmode;
            }
        }

        return null;
    }


    public boolean getBoolean(String string) {
        // TODO Auto-generated method stub
        return true;
    }
}
	
	


	



