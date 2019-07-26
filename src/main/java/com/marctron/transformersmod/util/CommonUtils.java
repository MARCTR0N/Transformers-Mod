package com.marctron.transformersmod.util;


import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.util.handlers.EnumGuiID;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.List;

/**
 * Created by Mark on 12/02/2017.
 */
public class CommonUtils {
    public static DamageSource causeBulletDamage(EntityBullet bullet, Entity indirectEntity) {
        return new EntityDamageSourceIndirect(Reference.MOD_ID + ".bullet", bullet, indirectEntity).setProjectile();
    }

    public static void sortStringList(List<String> list) {
        Collections.sort(list);
    }

    /**
     * Open a GUI for a block (Uses a guiID of -1).
     */
    public static void openGui(EntityPlayer player, World world, BlockPos pos) {
        player.openGui(Main.instance, -1, world, pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Open a GUI for an item (Uses the position of the player).
     */
    public static void openGui(EntityPlayer player, World world, EnumGuiID guiID) {
        openGui(player, world, guiID.ordinal());
    }

    /**
     * Open a GUI for an item (Uses the position of the player).
     */
    public static void openGui(EntityPlayer player, World world, int guiID) {
        BlockPos pos = player.getPosition();
        player.openGui(Main.instance, guiID, world, pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Capitalises the first letter of every word in the string
     */
    public static String capitaliseAllFirstLetters(String text) {
        String[] textArray = text.split("\\s");
        String output = "";
        for (String t : textArray) {
            String space = output.equals("") ? "" : " ";
            output += space + capitaliseFirstLetter(t);
        }
        return output;
    }

    /**
     * Capitalises the first letter of the string
     */
    public static String capitaliseFirstLetter(String text) {
        if (text == null || text.length() <= 0)
            return text;
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }

    public static boolean isUsableByPlayer(TileEntity te, EntityPlayer player) {
        BlockPos pos = te.getPos();
        return te.getWorld().getTileEntity(pos) == te && player.getDistanceSq((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D) <= 64.0D;
    }

    public static boolean isStackListEmpty(NonNullList<ItemStack> list) {
        if (list.isEmpty()) return true;
        for (ItemStack stack : list)
            if (!stack.isEmpty())
                return false;
        return true;
    }
}