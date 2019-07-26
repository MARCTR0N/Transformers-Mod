package com.marctron.transformersmod.init;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.entity.EntityLargeRocket;
import com.marctron.transformersmod.entity.EntitySwindle;
import com.marctron.transformersmod.entity.EntityVehicon;
import com.marctron.transformersmod.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit {
    public static void registerEntities() {
        registerEntity("vehicon", EntityVehicon.class, Reference.ENTITY_VEHICON, 50, 000000, 660066);
        registerEntity("swindle", EntitySwindle.class, Reference.ENTITY_SWINDLE, 50, 8983288, 16043109);
        registerProjectile("rocket", EntityLargeRocket.class, Reference.ENTITY_LARGE_ROCKET);
        registerProjectile("bullet", EntityBullet.class, Reference.ENTITY_BULLET);
    }


    private static void registerEntity(String name, Class<? extends Entity> entity, int range, int color1, int color2, int id) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
    }


    public static void registerProjectile(String name, Class<? extends Entity> entity, int id) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, 64, 1, true);
    }
}
