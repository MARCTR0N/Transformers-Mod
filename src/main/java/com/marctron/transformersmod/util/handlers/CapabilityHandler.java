package com.marctron.transformersmod.util.handlers;

import java.util.Random;

import com.marctron.transformersmod.capabilities.DefaultEntityAnimator;
import com.marctron.transformersmod.capabilities.EntityAnimatorProvider;
import com.marctron.transformersmod.util.Reference;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class CapabilityHandler {

    public static final Animation PUNCH_ANIMATION = Animation.create(10);
    public static final Animation AXE_ANIMATION = Animation.create(12);
    public static final Animation SWORD_ANIMATION = Animation.create(12);
    public static final Animation AXE_REVERSE_ANIMATION = Animation.create(12);
    public static final Animation SWORD_REVERSE_ANIMATION = Animation.create(12);

    public static final Animation RELOAD_ANIMATION = Animation.create(18);

    public static boolean isReloading;
    public static boolean isAnimDone = false;

    protected static Random rand = new Random();


    public static AnimationAI currentAnim = null;

    private static final Animation[] ANIMATIONS = {
            PUNCH_ANIMATION,
            RELOAD_ANIMATION,
            AXE_ANIMATION,
            SWORD_ANIMATION
    };

    @SubscribeEvent
    public static void capAttachEventEntity(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation(Reference.MOD_ID, "animator"), new EntityAnimatorProvider(event.getObject()));
        }
    }

    public static Animation[] getAnimations() {
        return ANIMATIONS;
    }


    public static void registerCaps() {
        CapabilityManager.INSTANCE.register(IAnimatedEntity.class, new IStorage<IAnimatedEntity>() {
            @Override
            public NBTBase writeNBT(Capability<IAnimatedEntity> capability, IAnimatedEntity instance, EnumFacing side) {
                return null;
            }

            @Override
            public void readNBT(Capability<IAnimatedEntity> capability, IAnimatedEntity instance, EnumFacing side, NBTBase nbt) {
            }
        }, DefaultEntityAnimator::new);
    }


}
