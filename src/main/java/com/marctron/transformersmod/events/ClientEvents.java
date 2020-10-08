package com.marctron.transformersmod.events;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.marctron.transformersmod.capabilities.EntityAnimatorProvider;
import com.marctron.transformersmod.items.ItemPhaseShifter;
import com.marctron.transformersmod.items.gun.IGun;
import com.marctron.transformersmod.network.PacketNotifyPlayerAnimationStart;
import com.marctron.transformersmod.network.PacketSetClientAnimation;
import com.marctron.transformersmod.network.packets.PacketDrivingSound;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeAltmode;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeAltmode2;
import com.marctron.transformersmod.transformers.transformer.movieop.stealth.MovieOptimusPrimeAltmodeWeaponized;
import com.marctron.transformersmod.transformers.transformer.movieop.stealth.MovieOptimusPrimeAltmodeWeaponizedMid1;
import com.marctron.transformersmod.transformers.transformer.movieop.stealth.MovieOptimusPrimeAltmodeWeaponizedMid2;
import com.marctron.transformersmod.transformers.transformer.movieop.stealth.MovieOptimusPrimeAltmodeWeaponizedMid3;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.TFPMagnusAltmode;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.Menasor;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.breakdown.WFCBreakdownAltmode;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.Motormaster;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.MotormasterAltmode;
import com.marctron.transformersmod.util.DamageIndicator;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.CapabilityHandler;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.GetCollisionBoxesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.MouseInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class ClientEvents {

	public static final ArrayList<DamageIndicator> INDICATORS = new ArrayList<>();

	private static int attacks;
	private static int sword;
	public static boolean isAttacking = false;
	public static boolean isReloading = false;

	@SubscribeEvent
	public void onMouseInput(MouseInputEvent event) {
//		if (Minecraft.getMinecraft().gameSettings.keyBindAttack.isPressed())
//		{
//			ModelDeadendpartB.attackTimer = 40;
//		}
//			System.out.println("KeyPressed");
//			TFNetworkManager.networkWrapper.sendToServer(new PacketShootRocket());

//    			       Vec3d aim = entity.getLookVec();
//    			        EntityLargeRocket fireball = new EntityLargeRocket(entity.world, entity, 1, 1, 1);
//
//    			        if (!entity.world.isRemote) {
//    			            fireball.setPosition(entity.posX + aim.x * 1.5D, entity.posY + aim.y + 1 * 1.5D, entity.posZ + aim.z * 1.5D);
//    			            fireball.accelerationX = aim.x * 0.05;
//    			            fireball.accelerationY = aim.y * 0.05;
//    			            fireball.accelerationZ = aim.z * 0.05;
//    			            entity.world.spawnEntity(fireball);
//    			            fireball.explosionPower = 4;
//    			    }
//    			}

	}

	@SubscribeEvent
	public void onKeyInput(InputEvent event) {

//            Minecraft.getMinecraft().player.sendMessage(new TextComponentString ("*Transformation*") );
		// Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_BLAZE_HURT,
		// 0.6F, 3F);
		// Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_SHULKER_HURT_CLOSED,
		// 1F, 3F);
		// Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMONE, 0.3F,
		// 1.8F);

//        	TFNetworkManager.networkWrapper.sendToServer(new PacketShootRocket());

		if (Minecraft.getMinecraft().gameSettings.keyBindTogglePerspective.isKeyDown()) {

			System.out.println("it works?");
		}

		if (ClientProxy.ROBOT_MODE.isPressed()) {
			System.out.println("Y?");

		}

		if (ClientProxy.ALT_MODE.isPressed()) {
			System.out.println("X?");

		}

//        	TFNetworkManager.networkWrapper.sendToServer(new PacketInventory());
		// Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F,
		// 1.8F);
		// Minecraft.getMinecraft().player.sendMessage(new TextComponentString
		// ("*Transformation*") );
		// Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_BLAZE_HURT,
		// 0.6F, 2F);
		// Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_SHULKER_HURT_CLOSED,
		// 1F, 1F);
		// Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 1F,
		// 1F);

	}

	@SubscribeEvent
	public void onlivingRender(RenderLivingEvent.Pre event) {
		// System.out.println("Player Render Event");
		if (event.getEntity() instanceof AbstractClientPlayer) {
			AbstractClientPlayer player = (AbstractClientPlayer) event.getEntity();
			AbstractClientPlayer renderingPlayer = Minecraft.getMinecraft().player;
			boolean flag = false;
			for (ItemStack stack : player.getArmorInventoryList()) {
				if (stack.getItem() instanceof ItemArmorTransformer) {
					if (!flag) {
						double dx, dy, dz;
						if (player.equals(renderingPlayer)) {
							dx = dy = dz = 0;
						} else {
							double x1 = (player.posX - player.prevPosX) * event.getPartialRenderTick()
									+ player.prevPosX;
							double y1 = (player.posY - player.prevPosY) * event.getPartialRenderTick()
									+ player.prevPosY;
							double z1 = (player.posZ - player.prevPosZ) * event.getPartialRenderTick()
									+ player.prevPosZ;

							double x2 = (renderingPlayer.posX - renderingPlayer.prevPosX) * event.getPartialRenderTick()
									+ renderingPlayer.prevPosX;
							double y2 = (renderingPlayer.posY - renderingPlayer.prevPosY) * event.getPartialRenderTick()
									+ renderingPlayer.prevPosY;
							double z2 = (renderingPlayer.posZ - renderingPlayer.prevPosZ) * event.getPartialRenderTick()
									+ renderingPlayer.prevPosZ;

							dx = x1 - x2;
							dy = y1 - y2;
							dz = z1 - z2;
						}
						((ItemArmorTransformer) stack.getItem()).getRenderer().doRender(player, dx, dy, dz,
								player.getRotationYawHead(), event.getPartialRenderTick());
						flag = true;
					}
				}
			}
			if (flag) {
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void CollisionBox(GetCollisionBoxesEvent event) {

		Entity entity = event.getEntity();

		if (event.getEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;

			for (ItemStack stack : player.getArmorInventoryList()) {
				if (stack.getItem() instanceof Menasor) {
					player.height = 5.4F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 5.4F,
							player.getEntityBoundingBox().minZ + 0.6F));
				}

				if (stack.getItem() instanceof Motormaster) {
					player.height = 2.9F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 5.4F,
							player.getEntityBoundingBox().minZ + 0.6F));
				}

				if (stack.getItem() instanceof MotormasterAltmode) {
					player.height = 0.8F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 0.8F,
							player.getEntityBoundingBox().minZ + 0.6F));
					player.getEntityBoundingBox().shrink(4);

				}

				if (stack.getItem() instanceof MovieOptimusPrimeAltmode) {
					player.height = 0.8F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 0.8F,
							player.getEntityBoundingBox().minZ + 0.6F));
					player.getEntityBoundingBox().shrink(4);

				}

				if (stack.getItem() instanceof TFPMagnusAltmode) {
					player.height = 0.8F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 0.8F,
							player.getEntityBoundingBox().minZ + 0.6F));
					player.getEntityBoundingBox().shrink(4);

				}

				if (stack.getItem() instanceof WFCBreakdownAltmode) {
					player.height = 0.8F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 0.8F,
							player.getEntityBoundingBox().minZ + 0.6F));
					player.getEntityBoundingBox().shrink(4);

				}

				if (stack.getItem() instanceof MovieOptimusPrimeAltmode2) {
					player.height = 2.6F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 2.6F,
							player.getEntityBoundingBox().minZ + 0.6F));
				}

				if (stack.getItem() instanceof MovieOptimusPrimeAltmodeWeaponized) {
					player.height = 2.6F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 2.6F,
							player.getEntityBoundingBox().minZ + 0.6F));
				}

				if (stack.getItem() instanceof MovieOptimusPrimeAltmodeWeaponizedMid1) {
					player.height = 2.6F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 2.6F,
							player.getEntityBoundingBox().minZ + 0.6F));
				}

				if (stack.getItem() instanceof MovieOptimusPrimeAltmodeWeaponizedMid2) {
					player.height = 2.6F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 2.6F,
							player.getEntityBoundingBox().minZ + 0.6F));
				}

				if (stack.getItem() instanceof MovieOptimusPrimeAltmodeWeaponizedMid3) {
					player.height = 2.6F;
					player.width = 0.6F;
					player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX,
							player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ,
							player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 2.6F,
							player.getEntityBoundingBox().minZ + 0.6F));
				}
			}

			player.setArrowCountInEntity(0);

		}
	}

	@SubscribeEvent
	public void onLivingJump(LivingJumpEvent event) {
		final EntityLivingBase entity = event.getEntityLiving();
//    	System.out.println("booboo");
		if (entity instanceof EntityPlayer) {
//    		TFNetworkManager.networkWrapper.sendToServer(new PacketShootRocket());
			for (ItemStack stack : entity.getArmorInventoryList()) {
				if (stack.getItem() instanceof MovieOptimusPrimeAltmode2) {
					entity.motionY += 0.05F;
				}

				if (stack.getItem() instanceof Motormaster) {
					entity.motionY += 0.05F;
				}

				if (stack.getItem() instanceof Menasor) {
					entity.motionY += 0.1F;
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityTick(LivingUpdateEvent event) {

		EntityLivingBase entity = event.getEntityLiving();

		IAnimatedEntity animator = null;

		if (entity.world.isRemote && entity instanceof EntityPlayer) {
			if (entity.hasCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null)) {
				animator = entity.getCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null);
				animator.setAnimationTick(animator.getAnimationTick() + 1);
			}

//			if (entity.isSwingInProgress && entity.swingProgressInt == 0) {
//				entity.isSwingInProgress = false;

//			isReloading=true;
			boolean playingAnimation = false;

			for (Animation animation : CapabilityHandler.getAnimations()) {
				if (animator.getAnimation() == animation) {
					playingAnimation = true;
				}
			}

			if (!playingAnimation && Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown() && !isAttacking
					&& entity == Minecraft.getMinecraft().player) {
				isAttacking = true;
				ItemStack stack = entity.getHeldItemMainhand();

				// - - - - - - - - -
				if (stack.getItem() instanceof ItemHoe) {
					if (sword == 0) {
						TFNetworkManager.sendToServer(
								new PacketNotifyPlayerAnimationStart(CapabilityHandler.SWORD_REVERSE_ANIMATION));
						sword++;
					} else if (sword > 0) {
						TFNetworkManager
								.sendToServer(new PacketNotifyPlayerAnimationStart(CapabilityHandler.SWORD_ANIMATION));
						sword--;
					}

				} else {
					// - - - - - - - - -

					if (stack.getItem() instanceof ItemSword) {
						if (sword == 0) {
							TFNetworkManager.sendToAll(new PacketSetClientAnimation(entity.getName(),
									CapabilityHandler.SWORD_REVERSE_ANIMATION));
							sword++;
//                        System.out.println("sword = 0");
						} else if (sword > 0) {
							TFNetworkManager.sendToServer(
									new PacketNotifyPlayerAnimationStart(CapabilityHandler.SWORD_ANIMATION));
							sword--;
//                        System.out.println("sword = 1");
						}
					} else {

						if (stack.getItem() instanceof ItemAxe) {
							TFNetworkManager.sendToServer(
									new PacketNotifyPlayerAnimationStart(CapabilityHandler.AXE_ANIMATION));
//                           
						} else {

							if (stack.getItem() instanceof ItemAir) {
								TFNetworkManager.sendToServer(
										new PacketNotifyPlayerAnimationStart(CapabilityHandler.PUNCH_ANIMATION));
							}
						}
					}

				}

			}

			if (!Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown()) {
				isAttacking = false;
			}

			if (!isReloading && Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown()
					&& Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown() && !playingAnimation) {
				isReloading = true;
//				ClientProxy.RELOAD.isPressed()
				if (entity instanceof EntityPlayer) {
					ItemStack stack = ((EntityPlayer) entity).getHeldItemMainhand();

					if (stack.getItem() instanceof com.marctron.transformersmod.items.gun.Scrapper
							|| stack.getItem() instanceof IGun) {
						TFNetworkManager
								.sendToServer(new PacketNotifyPlayerAnimationStart(CapabilityHandler.RELOAD_ANIMATION));
					}

				}

			}
			if (!Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown()
					&& !Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()) {
				isReloading = false;
			}

		}

		// set animations here I guess, or you could move this event to a new class.

	}

	@SubscribeEvent
	public void editHud(RenderGameOverlayEvent.Pre event) {
		if (!Minecraft.getMinecraft().gameSettings.showDebugInfo) {
			if (event.getType() == ElementType.VIGNETTE) {
				for(int i = 0; i<INDICATORS.size(); i++){
					if(INDICATORS.get(i).getTimeLeft()==0) {
						INDICATORS.remove(i);
					}else {
						INDICATORS.get(i).draw(event.getResolution().getScaledWidth() / 2, event.getResolution().getScaledHeight() / 2,
						Minecraft.getMinecraft().player.getRotationYawHead());
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onAttack(PlayerTickEvent event) {
		final EntityPlayer entity = event.player;
//    	if (entity.world.isRemote)
//    	{
		if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown()) {
			if (entity.getHeldItemMainhand().getItem() instanceof ItemPhaseShifter) {
				System.out.println("booboo");
				entity.noClip = true;
//    				entity.setNoGravity(true);
				entity.fallDistance = 0;
				Vec3d aim = entity.getLookVec();
				entity.hurtResistantTime = 20;
//    	  			entity.collided=false;
				if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
					entity.setPosition(entity.posX + aim.x * 0.05D, entity.posY, entity.posZ + aim.z * 0.05D);
				}
				if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()) {

				}

//    				entity.motionY = 0;
				TFNetworkManager.networkWrapper.sendToServer(new PacketDrivingSound());

//    				entity.moveRelative(1, 1, 1, 1);
			}
		} else {
			entity.noClip = false;
//				entity.setNoGravity(false);
//    			entity.collided=true;

		}
//    	}

		if (entity instanceof EntityPlayer) {
//    		System.out.println("booboo");
//    		if (entity.world.isRemote)
			if (Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown()) {
				for (ItemStack stack : entity.getArmorInventoryList()) {
					if (stack.getItem() instanceof MovieOptimusPrimeAltmode) {

//    			       Vec3d aim = entity.getLookVec();
//    			        EntityLargeRocket fireball = new EntityLargeRocket(entity.world, entity, 1, 1, 1);
//
//    			        if (!entity.world.isRemote) {
//    			            fireball.setPosition(entity.posX + aim.x * 1.5D, entity.posY + aim.y + 1 * 1.5D, entity.posZ + aim.z * 1.5D);
//    			            fireball.accelerationX = aim.x * 0.05;
//    			            fireball.accelerationY = aim.y * 0.05;
//    			            fireball.accelerationZ = aim.z * 0.05;
//    			            entity.world.spawnEntity(fireball);
//    			            fireball.explosionPower = 4;
//    			    }
					}
				}
			}
		}
	}
}
