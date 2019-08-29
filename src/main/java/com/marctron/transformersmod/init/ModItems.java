package com.marctron.transformersmod.init;

import com.marctron.transformersmod.items.*;
import com.marctron.transformersmod.items.gun.*;
import com.marctron.transformersmod.transformers.transformer.sideswipe.*;
import com.marctron.transformersmod.transformers.transformer.starscream.*;
import com.marctron.transformersmod.transformers.transformer.tarn.*;
import com.marctron.transformersmod.transformers.transformer.vehicon.ArmorModelVehicon;
import com.marctron.transformersmod.transformers.transformer.vehicon.VehiconAltmode;
import com.marctron.transformersmod.transformers.transformer.vehicon.VehiconMid;
import com.marctron.transformersmod.transformers.transformer.vehicon.VehiconMid2;
import com.marctron.transformersmod.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {


    public static final List<Item> ITEMS = new ArrayList<Item>();

   

    //Ammo
    public static final Item AMMO = new ItemBase("ammo");
    //Consumables
    public static final Item MEDKIT = new ItemMedkit("medkit", 3, 10, 100);

    //Relics
     
    public static final Item PHASE_SHIFTER = new ItemPhaseShifter("phase_shifter");
    public static Item ItemBase = new ItemBasicMeta("basic", EItemBasic.allNames);

//    public static ItemStack getBasicItem(EItemBasic basicName) {
//        return getBasicItem(basicName, 1);
//    }
//
//    public static ItemStack getBasicItem(EItemBasic basicName, int stackSize) {
//        return new ItemStack(ItemBase, stackSize, basicName.ordinal());
//    }
    /*
    public static ItemStack getBaseItem(IShootable basicName)
    {
        return getBaseItem(basicName);
    }
    /*
    public static ItemStack getBaseItem(ItemBase basicName, int stackSize)
    {
        return new ItemStack(ItemBase, stackSize, basicName.);
    }
    */


}
