package com.marctron.transformersmod.util.helper;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

import net.minecraft.entity.player.EntityPlayer;

public class TFHelper<T> {
	
	public static final TFHelper<Double> FORWARD_VELOCITY = new TFHelper<Double>(0.0D, Predicates.<EntityPlayer> alwaysTrue());

	public static final List<TFHelper<?>> VALUES = Lists.newArrayList();
	
    public String id;
    public final boolean save;
    public final T defaultValue;
	
    protected TFHelper(T defaultValue, Predicate<EntityPlayer> canSet)
    {
        this(true, defaultValue, canSet);
    }

    protected TFHelper(boolean save, T defaultValue, Predicate<EntityPlayer> canSet)
    {
        this.save = save;
        this.defaultValue = defaultValue;
    }
    
    

	public static float median(float curr, float prev, float partialTicks)
    {
        return prev + (curr - prev) * partialTicks;
    }
	
	public static double median(double curr, double prev, float partialTicks)
    {
        return prev + (curr - prev) * partialTicks;
    }

	
	
	
	
//	public static float getHeight(EntityPlayer player)
//    {
//        return 1.8F + getCameraYOffset(player);
//    }
//	
//	public static float getScale(EntityPlayer player)
//    {
//        return 1;
//    }
	
//	public static float getCameraYOffset(EntityPlayer player)
//    {
//        Transformer transformer = TFHelper.getTransformer(player);
//
//        if (transformer != null)
//        {
//            int altMode = TFData.ALT_MODE.get(player);
//
//            return TFHelper.median(transformer.getVehicleHeightOffset(player, altMode), transformer.getHeightOffset(player, altMode), TFHelper.getTransformationTimer(player));
//        }
//
//        return 0;
//    }


}
