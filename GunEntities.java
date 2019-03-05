package com.marctron.transformersmod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

import com.marctron.transformersmod.entity.*;
import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.entity.render.RenderBullet;
import com.marctron.transformersmod.util.Reference;

public class GunEntities
{
    private static List<Class<? extends Entity>> ENTITY_CLASSES = new ArrayList<Class<? extends Entity>>();
    private static int modEntityId = 0;

    private static void regEntity(Class<? extends Entity> entityClass, String name)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, name), entityClass, name, ++modEntityId, Main.instance, 64, 20, false);
        ENTITY_CLASSES.add(entityClass);
    }

    private static <T extends Entity> void regRender(Class<T> entityClass, IRenderFactory<? super T> renderFactory)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
    }

    public static void regEntities()
    {
       
        regEntity(EntityBullet.class, "Bullet");
       
       // regEntity(EntityGrenade.class, "Grenade");
    }

    @SideOnly(Side.CLIENT)
    public static void regRenders()
    {
       
        regRender(EntityBullet.class, RenderBullet.FACTORY);
        
       // regRender(EntityGrenade.class, manager -> new RenderSnowball<>(manager, Items.GUNPOWDER, Minecraft.getMinecraft().getRenderItem()));
    }
    
}