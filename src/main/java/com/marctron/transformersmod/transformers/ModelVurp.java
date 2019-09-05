package com.marctron.transformersmod.transformers;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelRenderer;
import net.ilexiconn.llibrary.client.model.tools.AdvancedModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.tools.nsc.Global.GlobalPhase;




public class ModelVurp extends ModelBiped {
	
	private ModelAnimator animator;
	
	public ModelRenderer shape117_3;
    public ModelRenderer shape44_9;
    public ModelRenderer shape116;
    public ModelRenderer chest;
    public ModelRenderer shape124_4;
    public ModelRenderer shape166;
    public ModelRenderer shape124_6;
    public ModelRenderer torso;
    public ModelRenderer shape18_2;
    public ModelRenderer WHEEL;
    public ModelRenderer shape119_1;
    public ModelRenderer shape117_7;
    public ModelRenderer shape1_1;
    public ModelRenderer shape113_11;
    public ModelRenderer shape115;
    public ModelRenderer shape108_9;
    public ModelRenderer shape259_1;
    public ModelRenderer WHEEL_2;
    public ModelRenderer shape113_2;
    public ModelRenderer shape108_1;
    public ModelRenderer shape205_4;
    public ModelRenderer shape108;
    public ModelRenderer shape44_15;
    public ModelRenderer shape46_2;
    public ModelRenderer RightLowerLeg_1;
    public ModelRenderer cr;
    public ModelRenderer shape113_16;
    public ModelRenderer shape38_5;
    public ModelRenderer rightbumper_5;
    public ModelRenderer shape38_20;
    public ModelRenderer shape38_9;
    public ModelRenderer shape44_4;
    public ModelRenderer shape83;
    public ModelRenderer shape256;
    public ModelRenderer shape244;
    public ModelRenderer shape38_21;
    public ModelRenderer shape26_3;
    public ModelRenderer shape108_8;
    public ModelRenderer shape166_1;
    public ModelRenderer shape108_7;
    public ModelRenderer shape108_17;
    public ModelRenderer shape124_1;
    public ModelRenderer shape113_8;
    public ModelRenderer shape44_7;
    public ModelRenderer shape14_1;
    public ModelRenderer mainchest;
    public ModelRenderer rightbumper_2;
    public ModelRenderer shape44;
    public ModelRenderer shape320_2;
    public ModelRenderer shape113_12;
    public ModelRenderer shape320_5;
    public ModelRenderer shape18_4;
    public ModelRenderer rightbumper_4;
    public ModelRenderer shape320;
    public ModelRenderer shape320_3;
    public ModelRenderer shape108_6;
    public ModelRenderer shape26_4;
    public ModelRenderer shape113_19;
    public ModelRenderer shape117_1;
    public ModelRenderer shape108_16;
    public ModelRenderer shape6;
    public ModelRenderer shape246_3;
    public ModelRenderer shape44_12;
    public ModelRenderer shape119_9;
    public ModelRenderer shape18_1;
    public ModelRenderer shape205_5;
    public ModelRenderer shape26;
    public ModelRenderer shape38_27;
    public ModelRenderer shape108_13;
    public ModelRenderer shape44_5;
    public ModelRenderer shape38_25;
    public ModelRenderer rightbumper;
    public ModelRenderer shape113_15;
    public ModelRenderer RightLowerLeg;
    public ModelRenderer Head;
    public ModelRenderer shape46_5;
    public ModelRenderer shape119_4;
    public ModelRenderer shape38_1;
    public ModelRenderer shape113_14;
    public ModelRenderer rightbumper_1;
    public ModelRenderer shape119_8;
    public ModelRenderer RightFoot_1;
    public ModelRenderer shape46_4;
    public ModelRenderer shape14;
    public ModelRenderer shape44_10;
    public ModelRenderer leftheadlight_2;
    public ModelRenderer shape201;
    public ModelRenderer shape108_2;
    public ModelRenderer shape253_1;
    public ModelRenderer shape46_7;
    public ModelRenderer shape108_11;
    public ModelRenderer shape46;
    public ModelRenderer shape119_7;
    public ModelRenderer shape86;
    public ModelRenderer shape205_2;
    public ModelRenderer shape205_6;
    public ModelRenderer shape207;
    public ModelRenderer shape42_2;
    public ModelRenderer shape116_1;
    public ModelRenderer shape281;
    public ModelRenderer shape253;
    public ModelRenderer shape2_1;
    public ModelRenderer shape108_5;
    public ModelRenderer shape255_1;
    public ModelRenderer shape207_3;
    public ModelRenderer shape38_12;
    public ModelRenderer shape119_6;
    public ModelRenderer rightheadlight;
    public ModelRenderer shape108_3;
    public ModelRenderer RightLowerArm;
    public ModelRenderer shape108_19;
    public ModelRenderer shape108_4;
    public ModelRenderer shape115_3;
    public ModelRenderer shape250;
    public ModelRenderer shape26_5;
    public ModelRenderer WHEELee;
    public ModelRenderer shape46_3;
    public ModelRenderer shape38_23;
    public ModelRenderer shape255;
    public ModelRenderer shape38;
    public ModelRenderer shape119_2;
    public ModelRenderer shape38_16;
    public ModelRenderer shape117_4;
    public ModelRenderer shape38_18;
    public ModelRenderer shape113_3;
    public ModelRenderer shape124_2;
    public ModelRenderer shape42_1;
    public ModelRenderer shape4_1;
    public ModelRenderer shape124_7;
    public ModelRenderer shape47_1;
    public ModelRenderer shape108_18;
    public ModelRenderer cro_1;
    public ModelRenderer shape113_1;
    public ModelRenderer shape2;
    public ModelRenderer shape38_22;
    public ModelRenderer shape113_5;
    public ModelRenderer shape38_7;
    public ModelRenderer shape42_7;
    public ModelRenderer shape26_2;
    public ModelRenderer shape38_10;
    public ModelRenderer shape108_10;
    public ModelRenderer shape256_1;
    public ModelRenderer shape250_1;
    public ModelRenderer shape124_3;
    public ModelRenderer shape47_2;
    public ModelRenderer shape38_19;
    public ModelRenderer shape38_28;
    public ModelRenderer WHEELee_1;
    public ModelRenderer shape204;
    public ModelRenderer RightLeg_1;
    public ModelRenderer shape38_4;
    public ModelRenderer shape108_15;
    public ModelRenderer shape256_2;
    public ModelRenderer shape42_4;
    public ModelRenderer RightLeg;
    public ModelRenderer leftheadlight;
    public ModelRenderer shape26_1;
    public ModelRenderer shape117;
    public ModelRenderer carfront;
    public ModelRenderer shape115_2;
    public ModelRenderer shape115_1;
    public ModelRenderer shape108_14;
    public ModelRenderer croach;
    public ModelRenderer shape115_4;
    public ModelRenderer shape1;
    public ModelRenderer shape117_6;
    public ModelRenderer shape83_2;
    public ModelRenderer shape44_11;
    public ModelRenderer RightArm;
    public ModelRenderer shape246_4;
    public ModelRenderer shape117_5;
    public ModelRenderer shape205_1;
    public ModelRenderer shape115_7;
    public ModelRenderer shape44_8;
    public ModelRenderer shape38_26;
    public ModelRenderer shape46_6;
    public ModelRenderer shape281_1;
    public ModelRenderer RightArm_1;
    public ModelRenderer shape205_7;
    public ModelRenderer shape115_6;
    public ModelRenderer shape113_10;
    public ModelRenderer shape320_4;
    public ModelRenderer shape44_1;
    public ModelRenderer shape44_3;
    public ModelRenderer shape117_2;
    public ModelRenderer shape202;
    public ModelRenderer cro;
    public ModelRenderer shape38_14;
    public ModelRenderer shape38_6;
    public ModelRenderer shape246_1;
    public ModelRenderer shape253_2;
    public ModelRenderer shape42_3;
    public ModelRenderer RightLowerArm_1;
    public ModelRenderer WHEEL_3;
    public ModelRenderer shape44_14;
    public ModelRenderer shape113;
    public ModelRenderer shape44_6;
    public ModelRenderer torso_1;
    public ModelRenderer shape44_13;
    public ModelRenderer shape38_29;
    public ModelRenderer shape44_2;
    public ModelRenderer shape4;
    public ModelRenderer shape124_5;
    public ModelRenderer shape320_1;
    public ModelRenderer shape42_6;
    public ModelRenderer shape113_7;
    public ModelRenderer shape246;
    public ModelRenderer shape113_9;
    public ModelRenderer shape38_17;
    public ModelRenderer RightFoot;
    public ModelRenderer CHEST;
    public ModelRenderer shape87;
    public ModelRenderer shape38_15;
    public ModelRenderer shape205;
    public ModelRenderer shape18_5;
    public ModelRenderer shape204_1;
    public ModelRenderer shape47;
    public ModelRenderer shape113_6;
    public ModelRenderer shape18_3;
    public ModelRenderer shape38_31;
    public ModelRenderer shape83_1;
    public ModelRenderer rightbumper_3;
    public ModelRenderer shape207_2;
    public ModelRenderer shape18;
    public ModelRenderer shape38_24;
    public ModelRenderer shape6_1;
    public ModelRenderer shape46_1;
    public ModelRenderer shape108_12;
    public ModelRenderer shape38_13;
    public ModelRenderer shape38_11;
    public ModelRenderer shape119_5;
    public ModelRenderer shape113_4;
    public ModelRenderer shape119_3;
    public ModelRenderer shape205_3;
    public ModelRenderer shape38_8;
    public ModelRenderer shape207_1;
    public ModelRenderer shape113_17;
    public ModelRenderer shape116_3;
    public ModelRenderer shape201_1;
    public ModelRenderer shape256_3;
    public ModelRenderer shape42_5;
    public ModelRenderer shape116_2;
    public ModelRenderer shape202_1;
    public ModelRenderer shape246_2;
    public ModelRenderer shape113_13;
    public ModelRenderer shape38_30;
    public ModelRenderer WHEELee_2;
    public ModelRenderer shape38_2;
    public ModelRenderer shape88;
    public ModelRenderer shape38_3;
    public ModelRenderer shape42;
    public ModelRenderer leftheadlight_1;
    public ModelRenderer WHEELee_3;
    public ModelRenderer shape246_5;
    public ModelRenderer shape115_5;
    public ModelRenderer shape119;
    public ModelRenderer shape124;
    public ModelRenderer WHEEL_1;
    public ModelRenderer shape259;
    public ModelRenderer shape113_18;

    public ModelVurp()
    {
    	        textureWidth = 1024;
    	        textureHeight = 512;
    	        shape117_3 = new ModelRenderer(this, "shape117_3").setTextureOffset(0, 500);
    	        shape117_3.mirror = true;
    	        shape117_3.setRotationPoint(0.0F, 0.2F, 0.0F);
    	        shape117_3.addBox(-1.0F, 3.74F, 2.07F, 2, 4, 1, 0.0F);
    	        setRotateAngle(shape117_3, -0.22689280275926282F, 0.0F, 0.0F);
    	        shape44_9 = new ModelRenderer(this, "shape44_9").setTextureOffset(55, 500);
    	        shape44_9.setRotationPoint(0.0F, 1.4F, 0.0F);
    	        shape44_9.addBox(0.0F, 0.9F, -0.5F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape44_9, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape116 = new ModelRenderer(this, "shape116").setTextureOffset(0, 500);
    	        shape116.mirror = true;
    	        shape116.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape116.addBox(-1.0F, 0.7F, -1.0F, 2, 4, 3, 0.0F);
    	        chest = new ModelRenderer(this, "chest").setTextureOffset(0, 0);
    	        chest.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        chest.addBox(-0.5F, 3.8F, -2.5F, 1, 1, 1, 0.0F);
    	        shape124_4 = new ModelRenderer(this, "shape124_4").setTextureOffset(0, 455);
    	        shape124_4.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape124_4.addBox(-1.38F, 5.9F, -0.5F, 1, 2, 2, 0.0F);
    	        setRotateAngle(shape124_4, 0.0F, 0.0F, -0.06981317007977318F);
    	        shape166 = new ModelRenderer(this, "shape166").setTextureOffset(0, 455);
    	        shape166.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape166.addBox(-1.0F, -0.1F, -2.0F, 2, 1, 4, 0.0F);
    	        setRotateAngle(shape166, 0.20943951023931953F, 0.0F, 0.0F);
    	        shape124_6 = new ModelRenderer(this, "shape124_6").setTextureOffset(0, 455);
    	        shape124_6.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape124_6.addBox(-3.35F, 6.53F, -0.5F, 1, 1, 2, 0.0F);
    	        setRotateAngle(shape124_6, 0.0F, 0.0F, -0.4363323129985824F);
    	        torso = new ModelRenderer(this, "torso").setTextureOffset(0, 0);
    	        torso.setRotationPoint(0.0F, -0.4F, -0.3F);
    	        torso.addBox(-0.5F, 7.7F, -1.0F, 1, 1, 1, 0.0F);
    	        setRotateAngle(torso, -0.017453292519943295F, 3.141592653589793F, 0.0F);
    	        shape18_2 = new ModelRenderer(this, "shape18_2").setTextureOffset(1000, 459);
    	        shape18_2.mirror = true;
    	        shape18_2.setRotationPoint(0.0F, -0.85F, 0.17F);
    	        shape18_2.addBox(-2.5F, 0.2F, 1.6F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape18_2, -0.17453292519943295F, 0.0F, 0.0F);
    	        WHEEL = new ModelRenderer(this, "WHEEL").setTextureOffset(0, 500);
    	        WHEEL.mirror = true;
    	        WHEEL.setRotationPoint(2.52F, -1.5F, 1.0F);
    	        WHEEL.addBox(-1.9F, -0.8F, -1.4F, 1, 3, 3, 0.0F);
    	        shape119_1 = new ModelRenderer(this, "shape119_1").setTextureOffset(0, 455);
    	        shape119_1.mirror = true;
    	        shape119_1.setRotationPoint(-0.01F, 0.0F, 0.0F);
    	        shape119_1.addBox(-1.0F, 4.0F, -0.7F, 2, 2, 2, 0.0F);
    	        shape117_7 = new ModelRenderer(this, "shape117_7").setTextureOffset(0, 500);
    	        shape117_7.setRotationPoint(0.0F, 0.2F, 0.0F);
    	        shape117_7.addBox(-1.0F, 3.74F, 2.07F, 2, 4, 1, 0.0F);
    	        setRotateAngle(shape117_7, -0.22689280275926282F, 0.0F, 0.0F);
    	        shape1_1 = new ModelRenderer(this, "shape1_1").setTextureOffset(0, 500);
    	        shape1_1.setRotationPoint(-2.5F, 0.0F, 0.0F);
    	        shape1_1.addBox(0.0F, 1.2F, -0.1F, 5, 5, 1, 0.0F);
    	        setRotateAngle(shape1_1, -0.8726646259971648F, 0.0F, 0.0F);
    	        shape113_11 = new ModelRenderer(this, "shape113_11").setTextureOffset(0, 500);
    	        shape113_11.setRotationPoint(0.0F, 0.0F, 0.1F);
    	        shape113_11.addBox(-1.8F, 0.6F, -1.1F, 1, 5, 1, 0.0F);
    	        setRotateAngle(shape113_11, 0.12217304763960307F, 0.0F, -0.08726646259971647F);
    	        shape115 = new ModelRenderer(this, "shape115").setTextureOffset(0, 455);
    	        shape115.mirror = true;
    	        shape115.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape115.addBox(0.7F, 0.7F, 0.0F, 1, 4, 1, 0.0F);
    	        setRotateAngle(shape115, 0.0F, 0.0F, 0.13962634015954636F);
    	        shape108_9 = new ModelRenderer(this, "shape108_9").setTextureOffset(0, 500);
    	        shape108_9.mirror = true;
    	        shape108_9.setRotationPoint(0.1F, 1.9F, 0.0F);
    	        shape108_9.addBox(0.8999999999999999F, -0.8F, -1.5F, 2, 3, 3, 0.0F);
    	        setRotateAngle(shape108_9, 0.0F, 0.0F, 0.17453292519943295F);
    	        shape259_1 = new ModelRenderer(this, "shape259_1").setTextureOffset(0, 500);
    	        shape259_1.setRotationPoint(0.0F, -0.3F, 0.3F);
    	        shape259_1.addBox(-1.0F, -1.89F, 0.9F, 2, 2, 1, 0.0F);
    	        setRotateAngle(shape259_1, 0.08726646259971647F, 0.0F, 0.0F);
    	        WHEEL_2 = new ModelRenderer(this, "WHEEL_2").setTextureOffset(0, 500);
    	        WHEEL_2.setRotationPoint(-2.52F, -1.5F, 1.0F);
    	        WHEEL_2.addBox(0.8999999999999999F, -0.8F, -1.4F, 1, 3, 3, 0.0F);
    	        shape113_2 = new ModelRenderer(this, "shape113_2").setTextureOffset(0, 500);
    	        shape113_2.setRotationPoint(0.0F, 0.0F, 0.1F);
    	        shape113_2.addBox(-1.6F, 0.7F, -1.1F, 2, 5, 1, 0.0F);
    	        setRotateAngle(shape113_2, 0.12217304763960307F, 0.0F, -0.08726646259971647F);
    	        shape108_1 = new ModelRenderer(this, "shape108_1").setTextureOffset(0, 500);
    	        shape108_1.mirror = true;
    	        shape108_1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape108_1.addBox(0.20000000000000018F, -0.8F, -1.7F, 3, 2, 2, 0.0F);
    	        setRotateAngle(shape108_1, 0.0F, 0.0F, 0.08726646259971647F);
    	        shape205_4 = new ModelRenderer(this, "shape205_4").setTextureOffset(0, 455);
    	        shape205_4.setRotationPoint(-1.4F, 0.9F, -2.5F);
    	        shape205_4.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape205_4, 0.0F, 0.7853981633974483F, 0.0F);
    	        shape108 = new ModelRenderer(this, "shape108").setTextureOffset(0, 500);
    	        shape108.mirror = true;
    	        shape108.setRotationPoint(0.0F, 0.3F, 0.0F);
    	        shape108.addBox(0.5F, -1.4F, -2.0F, 3, 2, 4, 0.0F);
    	        setRotateAngle(shape108, 0.0F, 0.0F, -0.2617993877991494F);
    	        shape44_15 = new ModelRenderer(this, "shape44_15").setTextureOffset(55, 500);
    	        shape44_15.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape44_15.addBox(0.0F, -0.5F, 0.9F, 2, 2, 1, 0.0F);
    	        setRotateAngle(shape44_15, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape46_2 = new ModelRenderer(this, "shape46_2").setTextureOffset(55, 500);
    	        shape46_2.mirror = true;
    	        shape46_2.setRotationPoint(0.0F, 1.4F, 0.0F);
    	        shape46_2.addBox(-2.0F, 0.7F, -1.0F, 2, 1, 2, 0.0F);
    	        RightLowerLeg_1 = new ModelRenderer(this, "RightLowerLeg_1").setTextureOffset(0, 455);
    	        RightLowerLeg_1.setRotationPoint(-1.1F, 4.6F, -0.5F);
    	        RightLowerLeg_1.addBox(-1.0F, -0.3F, -0.9F, 2, 4, 3, 0.0F);
    	        setRotateAngle(RightLowerLeg_1, -0.013962634015954637F, 0.0F, -0.13962634015954636F);
    	        cr = new ModelRenderer(this, "cr").setTextureOffset(0, 455);
    	        cr.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        cr.addBox(-2.1F, -1.6F, -2.2F, 2, 2, 1, 0.0F);
    	        setRotateAngle(cr, 0.0F, -0.17453292519943295F, 0.2792526803190927F);
    	        shape113_16 = new ModelRenderer(this, "shape113_16").setTextureOffset(0, 500);
    	        shape113_16.mirror = true;
    	        shape113_16.setRotationPoint(-0.1F, 3.0F, 0.1F);
    	        shape113_16.addBox(0.0F, -1.6F, -0.2F, 2, 5, 2, 0.0F);
    	        setRotateAngle(shape113_16, 0.03490658503988659F, 0.0F, 0.10471975511965977F);
    	        shape38_5 = new ModelRenderer(this, "shape38_5").setTextureOffset(0, 455);
    	        shape38_5.mirror = true;
    	        shape38_5.setRotationPoint(0.24F, 9.8F, 1.0F);
    	        shape38_5.addBox(-2.1F, -0.95F, -3.2F, 3, 2, 2, 0.0F);
    	        setRotateAngle(shape38_5, 0.17453292519943295F, -0.8726646259971648F, 0.0F);
    	        rightbumper_5 = new ModelRenderer(this, "rightbumper_5").setTextureOffset(0, 500);
    	        rightbumper_5.setRotationPoint(2.9F, 1.3F, -0.8F);
    	        rightbumper_5.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
    	        setRotateAngle(rightbumper_5, 0.0F, 0.0F, 0.03490658503988659F);
    	        shape38_20 = new ModelRenderer(this, "shape38_20").setTextureOffset(0, 455);
    	        shape38_20.setRotationPoint(-0.5F, 9.5F, 1.0F);
    	        shape38_20.addBox(0.0F, -1.0F, -3.2F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape38_20, 0.17453292519943295F, 0.8726646259971648F, 0.0F);
    	        shape38_9 = new ModelRenderer(this, "shape38_9").setTextureOffset(0, 455);
    	        shape38_9.setRotationPoint(0.0F, 11.0F, 1.5F);
    	        shape38_9.addBox(-1.0F, -1.0F, -3.2F, 2, 3, 2, 0.0F);
    	        setRotateAngle(shape38_9, 0.17453292519943295F, 0.0F, 0.0F);
    	        shape44_4 = new ModelRenderer(this, "shape44_4").setTextureOffset(55, 500);
    	        shape44_4.mirror = true;
    	        shape44_4.setRotationPoint(0.0F, 0.7F, -0.7F);
    	        shape44_4.addBox(-2.0F, -0.5F, -1.9F, 2, 2, 1, 0.0F);
    	        setRotateAngle(shape44_4, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape83 = new ModelRenderer(this, "shape83").setTextureOffset(0, 500);
    	        shape83.setRotationPoint(0.1F, 2.4F, 1.8F);
    	        shape83.addBox(-1.0F, 0.2F, 1.0F, 4, 3, 1, 0.0F);
    	        setRotateAngle(shape83, 0.03490658503988659F, 0.17453292519943295F, -0.8726646259971648F);
    	        shape256 = new ModelRenderer(this, "shape256").setTextureOffset(0, 500);
    	        shape256.mirror = true;
    	        shape256.setRotationPoint(-0.7F, -2.8F, -0.2F);
    	        shape256.addBox(-1.0F, 0.0F, 0.2F, 1, 2, 2, 0.0F);
    	        setRotateAngle(shape256, 0.08726646259971647F, -0.19198621771937624F, 0.0F);
    	        shape244 = new ModelRenderer(this, "shape244").setTextureOffset(0, 0);
    	        shape244.setRotationPoint(0.0F, 0.1F, 0.0F);
    	        shape244.addBox(-1.0F, 0.7F, -1.0F, 2, 2, 4, 0.0F);
    	        setRotateAngle(shape244, -0.03490658503988659F, 0.0F, 0.0F);
    	        shape38_21 = new ModelRenderer(this, "shape38_21").setTextureOffset(0, 455);
    	        shape38_21.mirror = true;
    	        shape38_21.setRotationPoint(0.5F, 8.0F, 0.9F);
    	        shape38_21.addBox(-2.0F, -1.0F, -3.2F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape38_21, 0.08726646259971647F, -0.8726646259971648F, 0.0F);
    	        shape26_3 = new ModelRenderer(this, "shape26_3").setTextureOffset(0, 500);
    	        shape26_3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape26_3.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    	        setRotateAngle(shape26_3, 0.0F, 0.2617993877991494F, 0.0F);
    	        shape108_8 = new ModelRenderer(this, "shape108_8").setTextureOffset(0, 455);
    	        shape108_8.mirror = true;
    	        shape108_8.setRotationPoint(0.0F, 2.0F, 0.0F);
    	        shape108_8.addBox(-0.19999999999999996F, -2.8F, -1.0F, 1, 5, 2, 0.0F);
    	        setRotateAngle(shape108_8, 0.0F, 0.0F, 0.017453292519943295F);
    	        shape166_1 = new ModelRenderer(this, "shape166_1").setTextureOffset(0, 0);
    	        shape166_1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape166_1.addBox(-1.0F, -1.7F, 1.0F, 2, 2, 1, 0.0F);
    	        setRotateAngle(shape166_1, -0.05235987755982988F, 0.0F, 0.0F);
    	        shape108_7 = new ModelRenderer(this, "shape108_7").setTextureOffset(0, 500);
    	        shape108_7.mirror = true;
    	        shape108_7.setRotationPoint(0.0F, 1.0F, 0.0F);
    	        shape108_7.addBox(0.6000000000000001F, -1.8F, -0.4F, 2, 5, 2, 0.0F);
    	        setRotateAngle(shape108_7, -0.03490658503988659F, 0.0F, 0.08726646259971647F);
    	        shape108_17 = new ModelRenderer(this, "shape108_17").setTextureOffset(0, 500);
    	        shape108_17.setRotationPoint(0.0F, 1.0F, 0.0F);
    	        shape108_17.addBox(-2.6F, -1.8F, -0.4F, 2, 5, 2, 0.0F);
    	        setRotateAngle(shape108_17, -0.03490658503988659F, 0.0F, -0.08726646259971647F);
    	        shape124_1 = new ModelRenderer(this, "shape124_1").setTextureOffset(0, 455);
    	        shape124_1.mirror = true;
    	        shape124_1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape124_1.addBox(-2.16F, 6.96F, -0.5F, 1, 1, 2, 0.0F);
    	        setRotateAngle(shape124_1, 0.0F, 0.0F, -0.24609142453120048F);
    	        shape113_8 = new ModelRenderer(this, "shape113_8").setTextureOffset(0, 500);
    	        shape113_8.mirror = true;
    	        shape113_8.setRotationPoint(0.0F, 1.7F, 2.3F);
    	        shape113_8.addBox(-1.5F, -0.2F, -1.1F, 3, 4, 2, 0.0F);
    	        setRotateAngle(shape113_8, -0.2617993877991494F, 0.0F, 0.0F);
    	        shape44_7 = new ModelRenderer(this, "shape44_7").setTextureOffset(55, 500);
    	        shape44_7.mirror = true;
    	        shape44_7.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape44_7.addBox(-2.0F, -0.5F, 0.9F, 2, 2, 1, 0.0F);
    	        setRotateAngle(shape44_7, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape14_1 = new ModelRenderer(this, "shape14_1").setTextureOffset(1000, 500);
    	        shape14_1.setRotationPoint(2.0F, 4.5F, -0.2F);
    	        shape14_1.addBox(0.0F, -0.2F, 0.0F, 1, 1, 1, 0.0F);
    	        mainchest = new ModelRenderer(this, "mainchest").setTextureOffset(0, 0);
    	        mainchest.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        mainchest.addBox(0.0F, 2.0F, 0.0F, 1, 1, 1, 0.0F);
    	        rightbumper_2 = new ModelRenderer(this, "rightbumper_2").setTextureOffset(0, 500);
    	        rightbumper_2.mirror = true;
    	        rightbumper_2.setRotationPoint(-2.9F, 0.0F, -0.8F);
    	        rightbumper_2.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
    	        setRotateAngle(rightbumper_2, 0.0F, 0.0F, -0.017453292519943295F);
    	        shape44 = new ModelRenderer(this, "shape44").setTextureOffset(55, 500);
    	        shape44.mirror = true;
    	        shape44.setRotationPoint(0.0F, 0.7F, -0.7F);
    	        shape44.addBox(-2.0F, -0.5F, -1.9F, 2, 2, 1, 0.0F);
    	        setRotateAngle(shape44, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape320_2 = new ModelRenderer(this, "shape320_2").setTextureOffset(0, 500);
    	        shape320_2.mirror = true;
    	        shape320_2.setRotationPoint(-1.0F, -1.2F, -0.4F);
    	        shape320_2.addBox(-0.99F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
    	        shape113_12 = new ModelRenderer(this, "shape113_12").setTextureOffset(0, 500);
    	        shape113_12.mirror = true;
    	        shape113_12.setRotationPoint(0.0F, 0.0F, 0.1F);
    	        shape113_12.addBox(-0.3999999999999999F, 0.7F, -1.1F, 2, 5, 1, 0.0F);
    	        setRotateAngle(shape113_12, 0.12217304763960307F, 0.0F, 0.08726646259971647F);
    	        shape320_5 = new ModelRenderer(this, "shape320_5").setTextureOffset(0, 500);
    	        shape320_5.setRotationPoint(1.0F, -1.2F, -0.4F);
    	        shape320_5.addBox(-2.01F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
    	        shape18_4 = new ModelRenderer(this, "shape18_4").setTextureOffset(1000, 450);
    	        shape18_4.setRotationPoint(0.0F, -1.1F, 1.6F);
    	        shape18_4.addBox(0.5F, 0.2F, 0.7F, 2, 1, 1, 0.0F);
    	        setRotateAngle(shape18_4, -1.1344640137963142F, 0.0F, 0.0F);
    	        rightbumper_4 = new ModelRenderer(this, "rightbumper_4").setTextureOffset(0, 500);
    	        rightbumper_4.setRotationPoint(2.9F, 0.0F, -0.8F);
    	        rightbumper_4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
    	        setRotateAngle(rightbumper_4, 0.0F, 0.0F, 0.017453292519943295F);
    	        shape320 = new ModelRenderer(this, "shape320").setTextureOffset(0, 455);
    	        shape320.mirror = true;
    	        shape320.setRotationPoint(0.0F, 1.1F, -4.0F);
    	        shape320.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    	        shape320_3 = new ModelRenderer(this, "shape320_3").setTextureOffset(0, 455);
    	        shape320_3.setRotationPoint(0.0F, 1.1F, -4.0F);
    	        shape320_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    	        shape108_6 = new ModelRenderer(this, "shape108_6").setTextureOffset(0, 500);
    	        shape108_6.mirror = true;
    	        shape108_6.setRotationPoint(0.0F, 1.0F, 0.0F);
    	        shape108_6.addBox(0.6000000000000001F, -1.8F, -1.7F, 2, 5, 2, 0.0F);
    	        setRotateAngle(shape108_6, 0.05235987755982988F, 0.0F, 0.08726646259971647F);
    	        shape26_4 = new ModelRenderer(this, "shape26_4").setTextureOffset(0, 500);
    	        shape26_4.setRotationPoint(0.0F, 2.0F, 0.0F);
    	        shape26_4.addBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    	        setRotateAngle(shape26_4, 0.0F, 0.2617993877991494F, 0.08726646259971647F);
    	        shape113_19 = new ModelRenderer(this, "shape113_19").setTextureOffset(0, 500);
    	        shape113_19.setRotationPoint(0.1F, 3.0F, 0.1F);
    	        shape113_19.addBox(-2.0F, -1.6F, -0.2F, 2, 5, 2, 0.0F);
    	        setRotateAngle(shape113_19, 0.03490658503988659F, 0.0F, -0.10471975511965977F);
    	        shape117_1 = new ModelRenderer(this, "shape117_1").setTextureOffset(0, 500);
    	        shape117_1.mirror = true;
    	        shape117_1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape117_1.addBox(-1.0F, 3.74F, 2.47F, 2, 1, 1, 0.0F);
    	        setRotateAngle(shape117_1, -0.3490658503988659F, 0.0F, 0.0F);
    	        shape108_16 = new ModelRenderer(this, "shape108_16").setTextureOffset(0, 500);
    	        shape108_16.setRotationPoint(0.0F, 1.0F, 0.0F);
    	        shape108_16.addBox(-2.6F, -1.8F, -1.7F, 2, 5, 2, 0.0F);
    	        setRotateAngle(shape108_16, 0.05235987755982988F, 0.0F, -0.08726646259971647F);
    	        shape6 = new ModelRenderer(this, "shape6").setTextureOffset(0, 500);
    	        shape6.setRotationPoint(0.0F, 0.32F, 3.34F);
    	        shape6.addBox(-0.5F, 5.2F, 0.0F, 6, 1, 1, 0.0F);
    	        setRotateAngle(shape6, -0.13962634015954636F, 0.0F, 0.0F);
    	        shape246_3 = new ModelRenderer(this, "shape246_3").setTextureOffset(1000, 485);
    	        shape246_3.mirror = true;
    	        shape246_3.setRotationPoint(-0.65F, 0.3F, 0.36F);
    	        shape246_3.addBox(-1.0F, -2.9F, -1.4F, 1, 2, 2, 0.0F);
    	        setRotateAngle(shape246_3, 0.0F, -0.17453292519943295F, 0.0F);
    	        shape44_12 = new ModelRenderer(this, "shape44_12").setTextureOffset(55, 500);
    	        shape44_12.setRotationPoint(0.0F, 0.7F, -0.7F);
    	        shape44_12.addBox(0.0F, -0.5F, -1.9F, 2, 2, 1, 0.0F);
    	        setRotateAngle(shape44_12, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape119_9 = new ModelRenderer(this, "shape119_9").setTextureOffset(0, 455);
    	        shape119_9.setRotationPoint(0.0F, 0.5F, 0.8F);
    	        shape119_9.addBox(-1.0F, 4.0F, -0.8F, 2, 3, 2, 0.0F);
    	        setRotateAngle(shape119_9, 0.05235987755982988F, 0.0F, 0.0F);
    	        shape18_1 = new ModelRenderer(this, "shape18_1").setTextureOffset(1000, 450);
    	        shape18_1.mirror = true;
    	        shape18_1.setRotationPoint(0.0F, -1.1F, 1.6F);
    	        shape18_1.addBox(-2.5F, 0.2F, 0.7F, 2, 1, 1, 0.0F);
    	        setRotateAngle(shape18_1, -1.1344640137963142F, 0.0F, 0.0F);
    	        shape205_5 = new ModelRenderer(this, "shape205_5").setTextureOffset(0, 455);
    	        shape205_5.setRotationPoint(-1.4F, 1.1F, -2.6F);
    	        shape205_5.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape205_5, 0.0F, 0.7853981633974483F, 0.0F);
    	        shape26 = new ModelRenderer(this, "shape26").setTextureOffset(0, 500);
    	        shape26.mirror = true;
    	        shape26.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape26.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    	        setRotateAngle(shape26, 0.0F, -0.2617993877991494F, 0.0F);
    	        shape38_27 = new ModelRenderer(this, "shape38_27").setTextureOffset(0, 455);
    	        shape38_27.mirror = true;
    	        shape38_27.setRotationPoint(0.0F, 9.5F, 0.9F);
    	        shape38_27.addBox(-1.8F, -1.0F, -3.2F, 1, 2, 2, 0.0F);
    	        setRotateAngle(shape38_27, 0.17453292519943295F, -1.48352986419518F, 0.0F);
    	        shape108_13 = new ModelRenderer(this, "shape108_13").setTextureOffset(0, 500);
    	        shape108_13.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape108_13.addBox(-2.2F, -1.2F, -2.0F, 2, 4, 4, 0.0F);
    	        setRotateAngle(shape108_13, 0.0F, 0.0F, 0.05235987755982988F);
    	        shape44_5 = new ModelRenderer(this, "shape44_5").setTextureOffset(55, 500);
    	        shape44_5.mirror = true;
    	        shape44_5.setRotationPoint(0.0F, 1.4F, 0.0F);
    	        shape44_5.addBox(-2.0F, 0.9F, -0.5F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape44_5, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape38_25 = new ModelRenderer(this, "shape38_25").setTextureOffset(0, 455);
    	        shape38_25.setRotationPoint(0.0F, 7.3F, 0.7F);
    	        shape38_25.addBox(-1.5F, -1.0F, -3.0F, 3, 3, 2, 0.0F);
    	        rightbumper = new ModelRenderer(this, "rightbumper").setTextureOffset(0, 500);
    	        rightbumper.mirror = true;
    	        rightbumper.setRotationPoint(5.0F, 4.9F, -2.5F);
    	        rightbumper.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
    	        setRotateAngle(rightbumper, 0.17453292519943295F, -0.17453292519943295F, 0.2617993877991494F);
    	        shape113_15 = new ModelRenderer(this, "shape113_15").setTextureOffset(0, 500);
    	        shape113_15.setRotationPoint(0.0F, 0.0F, 0.1F);
    	        shape113_15.addBox(-1.5F, 0.0F, -1.7F, 3, 5, 2, 0.0F);
    	        setRotateAngle(shape113_15, 0.3141592653589793F, 0.0F, 0.0F);
    	        RightLowerLeg = new ModelRenderer(this, "RightLowerLeg").setTextureOffset(0, 455);
    	        RightLowerLeg.mirror = true;
    	        RightLowerLeg.setRotationPoint(1.1F, 4.6F, -0.5F);
    	        RightLowerLeg.addBox(-1.0F, -0.3F, -0.9F, 2, 4, 3, 0.0F);
    	        setRotateAngle(RightLowerLeg, -0.013962634015954637F, 0.0F, 0.13962634015954636F);
    	        Head = new ModelRenderer(this, "Head").setTextureOffset(0, 500);
    	        Head.setRotationPoint(0.0F, 0.4F, 0.4F);
    	        Head.addBox(-1.0F, -0.7F, -1.4F, 2, 1, 2, 0.0F);
    	        shape46_5 = new ModelRenderer(this, "shape46_5").setTextureOffset(55, 500);
    	        shape46_5.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape46_5.addBox(0.0F, -1.7F, -1.0F, 2, 1, 2, 0.0F);
    	        shape119_4 = new ModelRenderer(this, "shape119_4").setTextureOffset(0, 455);
    	        shape119_4.mirror = true;
    	        shape119_4.setRotationPoint(0.0F, 0.5F, 0.8F);
    	        shape119_4.addBox(-1.0F, 4.0F, -0.8F, 2, 3, 2, 0.0F);
    	        setRotateAngle(shape119_4, 0.05235987755982988F, 0.0F, 0.0F);
    	        shape38_1 = new ModelRenderer(this, "shape38_1").setTextureOffset(0, 455);
    	        shape38_1.setRotationPoint(0.0F, 10.6F, 0.3F);
    	        shape38_1.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2, 0.0F);
    	        shape113_14 = new ModelRenderer(this, "shape113_14").setTextureOffset(0, 455);
    	        shape113_14.setRotationPoint(0.0F, 0.0F, -0.2F);
    	        shape113_14.addBox(-1.6F, 0.4F, 1.2F, 1, 5, 1, 0.0F);
    	        setRotateAngle(shape113_14, -0.12217304763960307F, 0.0F, -0.08726646259971647F);
    	        rightbumper_1 = new ModelRenderer(this, "rightbumper_1").setTextureOffset(0, 500);
    	        rightbumper_1.setRotationPoint(-5.0F, 4.9F, -2.5F);
    	        rightbumper_1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
    	        setRotateAngle(rightbumper_1, 0.17453292519943295F, 0.17453292519943295F, -0.2617993877991494F);
    	        shape119_8 = new ModelRenderer(this, "shape119_8").setTextureOffset(0, 500);
    	        shape119_8.setRotationPoint(-0.5F, 0.5F, 1.1F);
    	        shape119_8.addBox(-1.0F, 4.0F, -0.8F, 2, 4, 2, 0.0F);
    	        setRotateAngle(shape119_8, -0.13962634015954636F, 0.0F, 0.0F);
    	        RightFoot_1 = new ModelRenderer(this, "RightFoot_1").setTextureOffset(0, 455);
    	        RightFoot_1.setRotationPoint(-0.5F, 9.4F, 0.2F);
    	        RightFoot_1.addBox(-1.0F, 1.1F, -2.8F, 3, 1, 6, 0.0F);
    	        setRotateAngle(RightFoot_1, 0.03490658503988659F, 0.0F, -0.017453292519943295F);
    	        shape46_4 = new ModelRenderer(this, "shape46_4").setTextureOffset(55, 500);
    	        shape46_4.setRotationPoint(0.0F, 1.4F, 0.0F);
    	        shape46_4.addBox(0.0F, 0.7F, -1.0F, 2, 1, 2, 0.0F);
    	        shape14 = new ModelRenderer(this, "shape14").setTextureOffset(1000, 500);
    	        shape14.setRotationPoint(2.0F, 5.0F, -0.2F);
    	        shape14.addBox(0.0F, -0.2F, 0.0F, 1, 1, 1, 0.0F);
    	        shape44_10 = new ModelRenderer(this, "shape44_10").setTextureOffset(55, 500);
    	        shape44_10.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape44_10.addBox(0.0F, -1.9F, -1.5F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape44_10, 0.7853981633974483F, 0.0F, 0.0F);
    	        leftheadlight_2 = new ModelRenderer(this, "leftheadlight_2").setTextureOffset(0, 500);
    	        leftheadlight_2.mirror = true;
    	        leftheadlight_2.setRotationPoint(1.3F, 1.4F, -0.1F);
    	        leftheadlight_2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
    	        setRotateAngle(leftheadlight_2, 0.17453292519943295F, 0.0F, -0.2617993877991494F);
    	        shape201 = new ModelRenderer(this, "shape201").setTextureOffset(0, 455);
    	        shape201.mirror = true;
    	        shape201.setRotationPoint(0.0F, 0.1F, 2.5F);
    	        shape201.addBox(-2.0F, -1.8F, -1.3F, 3, 3, 1, 0.0F);
    	        setRotateAngle(shape201, 0.8726646259971648F, 0.0F, 0.0F);
    	        shape108_2 = new ModelRenderer(this, "shape108_2").setTextureOffset(0, 500);
    	        shape108_2.mirror = true;
    	        shape108_2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape108_2.addBox(1.2000000000000002F, -0.8F, -0.3F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape108_2, 0.0F, 0.0F, 0.08726646259971647F);
    	        shape253_1 = new ModelRenderer(this, "shape253_1").setTextureOffset(0, 500);
    	        shape253_1.setRotationPoint(0.4F, 0.0F, -0.5F);
    	        shape253_1.addBox(-0.6F, -3.0F, 0.6F, 2, 3, 1, 0.0F);
    	        setRotateAngle(shape253_1, -0.17453292519943295F, 0.0F, 0.0F);
    	        shape46_7 = new ModelRenderer(this, "shape46_7").setTextureOffset(55, 500);
    	        shape46_7.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape46_7.addBox(0.0F, -1.7F, -1.0F, 2, 1, 2, 0.0F);
    	        shape108_11 = new ModelRenderer(this, "shape108_11").setTextureOffset(0, 500);
    	        shape108_11.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape108_11.addBox(-3.2F, -0.8F, -1.7F, 3, 2, 2, 0.0F);
    	        setRotateAngle(shape108_11, 0.0F, 0.0F, -0.08726646259971647F);
    	        shape46 = new ModelRenderer(this, "shape46").setTextureOffset(55, 500);
    	        shape46.mirror = true;
    	        shape46.setRotationPoint(0.0F, 1.4F, 0.0F);
    	        shape46.addBox(-2.0F, 0.7F, -1.0F, 2, 1, 2, 0.0F);
    	        shape119_7 = new ModelRenderer(this, "shape119_7").setTextureOffset(0, 500);
    	        shape119_7.setRotationPoint(0.5F, 0.5F, 1.1F);
    	        shape119_7.addBox(-1.0F, 4.0F, -0.8F, 2, 4, 2, 0.0F);
    	        setRotateAngle(shape119_7, -0.13962634015954636F, 0.0F, 0.0F);
    	        shape86 = new ModelRenderer(this, "shape86").setTextureOffset(0, 455);
    	        shape86.setRotationPoint(0.0F, 2.7F, -2.7F);
    	        shape86.addBox(-4.5F, 0.0F, 0.0F, 9, 2, 3, 0.0F);
    	        shape205_2 = new ModelRenderer(this, "shape205_2").setTextureOffset(0, 455);
    	        shape205_2.mirror = true;
    	        shape205_2.setRotationPoint(0.4F, 1.1F, -2.6F);
    	        shape205_2.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape205_2, 0.0F, -0.7853981633974483F, 0.0F);
    	        shape205_6 = new ModelRenderer(this, "shape205_6").setTextureOffset(0, 455);
    	        shape205_6.setRotationPoint(-0.4F, 1.1F, -2.6F);
    	        shape205_6.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape205_6, 0.0F, 0.7853981633974483F, 0.0F);
    	        shape207 = new ModelRenderer(this, "shape207").setTextureOffset(0, 455);
    	        shape207.mirror = true;
    	        shape207.setRotationPoint(-1.4F, 1.1F, -2.6F);
    	        shape207.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
    	        setRotateAngle(shape207, 0.0F, 0.03490658503988659F, 0.0F);
    	        shape42_2 = new ModelRenderer(this, "shape42_2").setTextureOffset(55, 500);
    	        shape42_2.mirror = true;
    	        shape42_2.setRotationPoint(0.0F, 0.7F, 0.7F);
    	        shape42_2.addBox(-2.0F, -1.0F, 0.7F, 2, 2, 1, 0.0F);
    	        shape116_1 = new ModelRenderer(this, "shape116_1").setTextureOffset(0, 455);
    	        shape116_1.mirror = true;
    	        shape116_1.setRotationPoint(0.0F, 1.1F, 1.6F);
    	        shape116_1.addBox(-1.0F, 0.7F, -1.0F, 2, 4, 3, 0.0F);
    	        setRotateAngle(shape116_1, -0.4363323129985824F, 0.0F, 0.0F);
    	        shape281 = new ModelRenderer(this, "shape281").setTextureOffset(0, 455);
    	        shape281.mirror = true;
    	        shape281.setRotationPoint(0.0F, 0.9F, -3.4F);
    	        shape281.addBox(-1.5F, 0.0F, 0.0F, 2, 1, 4, 0.0F);
    	        setRotateAngle(shape281, 0.6632251157578453F, 0.0F, 0.0F);
    	        shape253 = new ModelRenderer(this, "shape253").setTextureOffset(0, 500);
    	        shape253.setRotationPoint(-0.2F, 0.0F, -0.5F);
    	        shape253.addBox(-1.6F, -3.0F, 0.6F, 2, 3, 1, 0.0F);
    	        setRotateAngle(shape253, -0.17453292519943295F, 0.0F, 0.0F);
    	        shape2_1 = new ModelRenderer(this, "shape2_1").setTextureOffset(0, 500);
    	        shape2_1.mirror = true;
    	        shape2_1.setRotationPoint(7.2F, 0.2F, -0.1F);
    	        shape2_1.addBox(-3.0F, 1.4F, 0.0F, 3, 5, 2, 0.0F);
    	        setRotateAngle(shape2_1, 0.0F, 0.0F, 0.3490658503988659F);
    	        shape108_5 = new ModelRenderer(this, "shape108_5").setTextureOffset(0, 500);
    	        shape108_5.mirror = true;
    	        shape108_5.setRotationPoint(0.1F, 1.4F, 0.0F);
    	        shape108_5.addBox(-0.10000000000000009F, -1.3F, -1.5F, 3, 2, 3, 0.0F);
    	        setRotateAngle(shape108_5, 0.0F, 0.0F, -0.17453292519943295F);
    	        shape255_1 = new ModelRenderer(this, "shape255_1").setTextureOffset(0, 500);
    	        shape255_1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape255_1.addBox(-1.0F, -2.82F, -1.78F, 2, 1, 1, 0.0F);
    	        setRotateAngle(shape255_1, -1.0471975511965976F, 0.0F, 0.0F);
    	        shape207_3 = new ModelRenderer(this, "shape207_3").setTextureOffset(0, 455);
    	        shape207_3.mirror = true;
    	        shape207_3.setRotationPoint(-0.4F, 1.1F, -2.6F);
    	        shape207_3.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
    	        setRotateAngle(shape207_3, 0.0F, 0.03490658503988659F, 0.0F);
    	        shape38_12 = new ModelRenderer(this, "shape38_12").setTextureOffset(0, 500);
    	        shape38_12.mirror = true;
    	        shape38_12.setRotationPoint(-3.6F, 4.9F, 3.3F);
    	        shape38_12.addBox(-2.0F, -3.0F, -3.2F, 3, 5, 2, 0.0F);
    	        setRotateAngle(shape38_12, 0.0F, -0.8726646259971648F, 0.0F);
    	        shape119_6 = new ModelRenderer(this, "shape119_6").setTextureOffset(0, 455);
    	        shape119_6.setRotationPoint(0.01F, 0.0F, 0.0F);
    	        shape119_6.addBox(-1.0F, 4.0F, -0.7F, 2, 2, 2, 0.0F);
    	        rightheadlight = new ModelRenderer(this, "rightheadlight").setTextureOffset(0, 500);
    	        rightheadlight.setRotationPoint(-5.1F, 3.9F, -5.0F);
    	        rightheadlight.addBox(0.0F, 0.0F, 1.0F, 3, 2, 5, 0.0F);
    	        setRotateAngle(rightheadlight, 0.6108652381980153F, 0.0F, 0.2617993877991494F);
    	        shape108_3 = new ModelRenderer(this, "shape108_3").setTextureOffset(0, 500);
    	        shape108_3.mirror = true;
    	        shape108_3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape108_3.addBox(0.20000000000000018F, -1.2F, -2.0F, 2, 4, 4, 0.0F);
    	        setRotateAngle(shape108_3, 0.0F, 0.0F, -0.05235987755982988F);
    	        RightLowerArm = new ModelRenderer(this, "RightLowerArm").setTextureOffset(0, 455);
    	        RightLowerArm.mirror = true;
    	        RightLowerArm.setRotationPoint(1.5F, 2.8F, -0.5F);
    	        RightLowerArm.addBox(-0.99F, -0.3F, -0.5F, 2, 4, 2, 0.0F);
    	        setRotateAngle(RightLowerArm, -0.3141592653589793F, 0.20943951023931953F, 0.0F);
    	        shape108_19 = new ModelRenderer(this, "shape108_19").setTextureOffset(0, 500);
    	        shape108_19.setRotationPoint(-0.1F, 1.9F, 0.0F);
    	        shape108_19.addBox(-2.9F, -0.8F, -1.5F, 2, 3, 3, 0.0F);
    	        setRotateAngle(shape108_19, 0.0F, 0.0F, -0.17453292519943295F);
    	        shape108_4 = new ModelRenderer(this, "shape108_4").setTextureOffset(0, 500);
    	        shape108_4.mirror = true;
    	        shape108_4.setRotationPoint(-0.66F, -1.16F, 0.0F);
    	        shape108_4.addBox(0.5F, -1.4F, -2.0F, 3, 2, 4, 0.0F);
    	        setRotateAngle(shape108_4, 0.0F, 0.0F, 0.15707963267948966F);
    	        shape115_3 = new ModelRenderer(this, "shape115_3").setTextureOffset(0, 0);
    	        shape115_3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape115_3.addBox(-1.5F, 0.7F, 0.0F, 1, 4, 1, 0.0F);
    	        setRotateAngle(shape115_3, 0.0F, 0.0F, -0.13962634015954636F);
    	        shape250 = new ModelRenderer(this, "shape250").setTextureOffset(0, 500);
    	        shape250.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape250.addBox(-0.5F, -0.8F, -1.6F, 1, 1, 1, 0.0F);
    	        setRotateAngle(shape250, -0.08726646259971647F, 0.0F, 0.0F);
    	        shape26_5 = new ModelRenderer(this, "shape26_5").setTextureOffset(55, 500);
    	        shape26_5.setRotationPoint(0.1F, 0.6F, 0.6F);
    	        shape26_5.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
    	        setRotateAngle(shape26_5, 0.0F, 0.17453292519943295F, 0.0F);
    	        WHEELee = new ModelRenderer(this, "WHEELee").setTextureOffset(60, 460);
    	        WHEELee.mirror = true;
    	        WHEELee.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        WHEELee.addBox(-1.1F, -0.8F, -1.4F, 1, 3, 3, 0.0F);
    	        shape46_3 = new ModelRenderer(this, "shape46_3").setTextureOffset(55, 500);
    	        shape46_3.mirror = true;
    	        shape46_3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape46_3.addBox(-2.0F, -1.7F, -1.0F, 2, 1, 2, 0.0F);
    	        shape38_23 = new ModelRenderer(this, "shape38_23").setTextureOffset(0, 500);
    	        shape38_23.setRotationPoint(0.0F, 11.0F, 1.5F);
    	        shape38_23.addBox(-1.0F, -1.0F, -3.2F, 2, 3, 2, 0.0F);
    	        setRotateAngle(shape38_23, 0.17453292519943295F, 0.0F, 0.0F);
    	        shape255 = new ModelRenderer(this, "shape255").setTextureOffset(0, 500);
    	        shape255.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape255.addBox(-1.1F, -2.8F, -0.2F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape255, 0.08726646259971647F, 0.0F, 0.0F);
    	        shape38 = new ModelRenderer(this, "shape38").setTextureOffset(0, 455);
    	        shape38.setRotationPoint(0.0F, 12.5F, 0.6F);
    	        shape38.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2, 0.0F);
    	        shape119_2 = new ModelRenderer(this, "shape119_2").setTextureOffset(0, 500);
    	        shape119_2.mirror = true;
    	        shape119_2.setRotationPoint(-0.5F, 0.5F, 1.1F);
    	        shape119_2.addBox(-1.0F, 4.0F, -0.8F, 2, 4, 2, 0.0F);
    	        setRotateAngle(shape119_2, -0.13962634015954636F, 0.0F, 0.0F);
    	        shape38_16 = new ModelRenderer(this, "shape38_16").setTextureOffset(0, 455);
    	        shape38_16.setRotationPoint(0.0F, 8.9F, 0.5F);
    	        shape38_16.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2, 0.0F);
    	        shape117_4 = new ModelRenderer(this, "shape117_4").setTextureOffset(0, 500);
    	        shape117_4.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape117_4.addBox(-1.0F, 4.04F, -2.55F, 2, 1, 1, 0.0F);
    	        setRotateAngle(shape117_4, 0.3490658503988659F, 0.0F, 0.0F);
    	        shape38_18 = new ModelRenderer(this, "shape38_18").setTextureOffset(0, 455);
    	        shape38_18.setRotationPoint(-0.5F, 11.5F, 1.0F);
    	        shape38_18.addBox(0.0F, -1.0F, -3.2F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape38_18, 0.17453292519943295F, 0.8726646259971648F, 0.17453292519943295F);
    	        shape113_3 = new ModelRenderer(this, "shape113_3").setTextureOffset(0, 500);
    	        shape113_3.setRotationPoint(0.0F, 0.0F, -0.2F);
    	        shape113_3.addBox(-1.6F, 0.5F, 1.2F, 2, 5, 1, 0.0F);
    	        setRotateAngle(shape113_3, -0.12217304763960307F, 0.0F, -0.08726646259971647F);
    	        shape124_2 = new ModelRenderer(this, "shape124_2").setTextureOffset(0, 455);
    	        shape124_2.mirror = true;
    	        shape124_2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape124_2.addBox(2.35F, 6.53F, -0.5F, 1, 1, 2, 0.0F);
    	        setRotateAngle(shape124_2, 0.0F, 0.0F, 0.4363323129985824F);
    	        shape42_1 = new ModelRenderer(this, "shape42_1").setTextureOffset(55, 500);
    	        shape42_1.mirror = true;
    	        shape42_1.setRotationPoint(0.0F, 0.7F, -0.7F);
    	        shape42_1.addBox(-2.0F, -1.0F, -1.7F, 2, 2, 1, 0.0F);
    	        shape4_1 = new ModelRenderer(this, "shape4_1").setTextureOffset(0, 500);
    	        shape4_1.mirror = true;
    	        shape4_1.setRotationPoint(5.2F, 0.0F, 1.4F);
    	        shape4_1.addBox(-1.0F, 5.2F, 0.0F, 1, 1, 3, 0.0F);
    	        setRotateAngle(shape4_1, -0.17453292519943295F, 0.2617993877991494F, 0.0F);
    	        shape124_7 = new ModelRenderer(this, "shape124_7").setTextureOffset(0, 455);
    	        shape124_7.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape124_7.addBox(-0.56F, 5.06F, -0.6F, 1, 2, 2, 0.0F);
    	        setRotateAngle(shape124_7, 0.0F, 0.0F, -0.08726646259971647F);
    	        shape47_1 = new ModelRenderer(this, "shape47_1").setTextureOffset(0, 455);
    	        shape47_1.setRotationPoint(-1.7F, 6.7F, -3.5F);
    	        shape47_1.addBox(-0.5F, 0.0F, 0.0F, 1, 7, 2, 0.0F);
    	        setRotateAngle(shape47_1, 0.17453292519943295F, 0.0F, -0.08726646259971647F);
    	        shape108_18 = new ModelRenderer(this, "shape108_18").setTextureOffset(0, 455);
    	        shape108_18.setRotationPoint(0.0F, 2.0F, 0.0F);
    	        shape108_18.addBox(-0.8F, -2.8F, -1.0F, 1, 5, 2, 0.0F);
    	        setRotateAngle(shape108_18, 0.0F, 0.0F, -0.017453292519943295F);
    	        cro_1 = new ModelRenderer(this, "cro_1").setTextureOffset(0, 455);
    	        cro_1.mirror = true;
    	        cro_1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        cro_1.addBox(0.1F, -1.6F, -2.2F, 2, 2, 1, 0.0F);
    	        setRotateAngle(cro_1, 0.0F, 0.17453292519943295F, -0.2792526803190927F);
    	        shape113_1 = new ModelRenderer(this, "shape113_1").setTextureOffset(0, 500);
    	        shape113_1.mirror = true;
    	        shape113_1.setRotationPoint(0.0F, 0.0F, 0.1F);
    	        shape113_1.addBox(0.8F, 0.6F, -1.1F, 1, 5, 1, 0.0F);
    	        setRotateAngle(shape113_1, 0.12217304763960307F, 0.0F, 0.08726646259971647F);
    	        shape2 = new ModelRenderer(this, "shape2").setTextureOffset(0, 500);
    	        shape2.setRotationPoint(-2.2F, 0.2F, -0.1F);
    	        shape2.addBox(0.0F, 1.4F, 0.0F, 3, 5, 2, 0.0F);
    	        setRotateAngle(shape2, 0.0F, 0.0F, -0.3490658503988659F);
    	        shape38_22 = new ModelRenderer(this, "shape38_22").setTextureOffset(0, 455);
    	        shape38_22.setRotationPoint(-0.5F, 8.0F, 0.9F);
    	        shape38_22.addBox(0.0F, -1.0F, -3.2F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape38_22, 0.08726646259971647F, 0.8726646259971648F, 0.0F);
    	        shape113_5 = new ModelRenderer(this, "shape113_5").setTextureOffset(0, 500);
    	        shape113_5.mirror = true;
    	        shape113_5.setRotationPoint(0.0F, 0.0F, 0.1F);
    	        shape113_5.addBox(-1.5F, 0.0F, -1.7F, 3, 5, 2, 0.0F);
    	        setRotateAngle(shape113_5, 0.3141592653589793F, 0.0F, 0.0F);
    	        shape38_7 = new ModelRenderer(this, "shape38_7").setTextureOffset(0, 455);
    	        shape38_7.mirror = true;
    	        shape38_7.setRotationPoint(0.2F, 8.0F, 0.9F);
    	        shape38_7.addBox(-2.0F, -1.0F, -3.2F, 3, 3, 2, 0.0F);
    	        setRotateAngle(shape38_7, 0.08726646259971647F, -0.8726646259971648F, 0.0F);
    	        shape42_7 = new ModelRenderer(this, "shape42_7").setTextureOffset(55, 500);
    	        shape42_7.setRotationPoint(0.0F, 0.7F, -0.7F);
    	        shape42_7.addBox(0.0F, -1.0F, -1.7F, 2, 2, 1, 0.0F);
    	        shape26_2 = new ModelRenderer(this, "shape26_2").setTextureOffset(55, 500);
    	        shape26_2.mirror = true;
    	        shape26_2.setRotationPoint(-0.1F, 0.6F, 0.6F);
    	        shape26_2.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
    	        setRotateAngle(shape26_2, 0.0F, -0.17453292519943295F, 0.0F);
    	        shape38_10 = new ModelRenderer(this, "shape38_10").setTextureOffset(0, 0);
    	        shape38_10.setRotationPoint(0.0F, 8.8F, 1.1F);
    	        shape38_10.addBox(-1.0F, -1.0F, -3.2F, 2, 3, 2, 0.0F);
    	        setRotateAngle(shape38_10, 0.08726646259971647F, 0.0F, 0.0F);
    	        shape108_10 = new ModelRenderer(this, "shape108_10").setTextureOffset(0, 500);
    	        shape108_10.setRotationPoint(0.0F, 0.3F, 0.0F);
    	        shape108_10.addBox(-3.5F, -1.4F, -2.0F, 3, 2, 4, 0.0F);
    	        setRotateAngle(shape108_10, 0.0F, 0.0F, 0.2617993877991494F);
    	        shape256_1 = new ModelRenderer(this, "shape256_1").setTextureOffset(0, 500);
    	        shape256_1.setRotationPoint(0.7F, -2.8F, -0.2F);
    	        shape256_1.addBox(0.0F, 0.0F, 0.2F, 1, 2, 2, 0.0F);
    	        setRotateAngle(shape256_1, 0.08726646259971647F, 0.19198621771937624F, 0.0F);
    	        shape250_1 = new ModelRenderer(this, "shape250_1").setTextureOffset(1000, 485);
    	        shape250_1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape250_1.addBox(-0.5F, -2.6F, -1.4F, 1, 2, 1, 0.0F);
    	        shape124_3 = new ModelRenderer(this, "shape124_3").setTextureOffset(0, 455);
    	        shape124_3.mirror = true;
    	        shape124_3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape124_3.addBox(-0.43999999999999995F, 5.06F, -0.6F, 1, 2, 2, 0.0F);
    	        setRotateAngle(shape124_3, 0.0F, 0.0F, 0.08726646259971647F);
    	        shape47_2 = new ModelRenderer(this, "shape47_2").setTextureOffset(0, 455);
    	        shape47_2.setRotationPoint(0.0F, 6.8F, -3.1F);
    	        shape47_2.addBox(-0.5F, 0.0F, -0.1F, 1, 6, 2, 0.0F);
    	        setRotateAngle(shape47_2, 0.17453292519943295F, 0.0F, 0.0F);
    	        shape38_19 = new ModelRenderer(this, "shape38_19").setTextureOffset(0, 455);
    	        shape38_19.mirror = true;
    	        shape38_19.setRotationPoint(0.5F, 9.4F, 1.0F);
    	        shape38_19.addBox(-2.0F, -1.0F, -3.2F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape38_19, 0.17453292519943295F, -0.8726646259971648F, 0.0F);
    	        shape38_28 = new ModelRenderer(this, "shape38_28").setTextureOffset(0, 455);
    	        shape38_28.mirror = true;
    	        shape38_28.setRotationPoint(0.2F, 11.5F, 1.0F);
    	        shape38_28.addBox(-1.7F, -1.0F, -3.1F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape38_28, 0.767944870877505F, -1.3962634015954636F, -0.8203047484373349F);
    	        WHEELee_1 = new ModelRenderer(this, "WHEELee_1").setTextureOffset(60, 460);
    	        WHEELee_1.mirror = true;
    	        WHEELee_1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        WHEELee_1.addBox(-1.1F, -0.8F, -1.4F, 1, 3, 3, 0.0F);
    	        shape204 = new ModelRenderer(this, "shape204").setTextureOffset(0, 500);
    	        shape204.mirror = true;
    	        shape204.setRotationPoint(0.0F, 0.1F, -1.6F);
    	        shape204.addBox(-1.99F, -0.3F, -1.3F, 3, 2, 3, 0.0F);
    	        setRotateAngle(shape204, 0.6108652381980153F, 0.0F, 0.0F);
    	        RightLeg_1 = new ModelRenderer(this, "RightLeg_1").setTextureOffset(0, 500);
    	        RightLeg_1.setRotationPoint(-1.0F, 13.3F, 0.1F);
    	        RightLeg_1.addBox(-2.2F, 0.2F, -1.5F, 2, 4, 3, 0.0F);
    	        setRotateAngle(RightLeg_1, -0.017453292519943295F, 0.0F, 0.15707963267948966F);
    	        shape38_4 = new ModelRenderer(this, "shape38_4").setTextureOffset(0, 455);
    	        shape38_4.setRotationPoint(-0.6F, 11.6F, 1.0F);
    	        shape38_4.addBox(-0.05F, -0.95F, -3.2F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape38_4, 0.17453292519943295F, 0.8726646259971648F, 0.17453292519943295F);
    	        shape108_15 = new ModelRenderer(this, "shape108_15").setTextureOffset(0, 500);
    	        shape108_15.setRotationPoint(-0.1F, 1.4F, 0.0F);
    	        shape108_15.addBox(-2.9F, -1.3F, -1.5F, 3, 2, 3, 0.0F);
    	        setRotateAngle(shape108_15, 0.0F, 0.0F, 0.17453292519943295F);
    	        shape256_2 = new ModelRenderer(this, "shape256_2").setTextureOffset(0, 500);
    	        shape256_2.setRotationPoint(0.6F, -2.3F, -0.2F);
    	        shape256_2.addBox(0.0F, 0.0F, 1.2F, 1, 1, 2, 0.0F);
    	        setRotateAngle(shape256_2, 0.2617993877991494F, 0.19198621771937624F, 0.0F);
    	        shape42_4 = new ModelRenderer(this, "shape42_4").setTextureOffset(55, 500);
    	        shape42_4.setRotationPoint(0.0F, 0.7F, 0.7F);
    	        shape42_4.addBox(0.0F, -1.0F, 0.7F, 2, 2, 1, 0.0F);
    	        RightLeg = new ModelRenderer(this, "RightLeg").setTextureOffset(0, 500);
    	        RightLeg.mirror = true;
    	        RightLeg.setRotationPoint(1.0F, 13.3F, 0.1F);
    	        RightLeg.addBox(0.2F, 0.2F, -1.5F, 2, 4, 3, 0.0F);
    	        setRotateAngle(RightLeg, -0.017453292519943295F, 0.0F, -0.15707963267948966F);
    	        leftheadlight = new ModelRenderer(this, "leftheadlight").setTextureOffset(0, 500);
    	        leftheadlight.mirror = true;
    	        leftheadlight.setRotationPoint(5.1F, 3.9F, -5.0F);
    	        leftheadlight.addBox(-3.0F, 0.0F, 1.0F, 3, 2, 5, 0.0F);
    	        setRotateAngle(leftheadlight, 0.6108652381980153F, 0.0F, -0.2617993877991494F);
    	        shape26_1 = new ModelRenderer(this, "shape26_1").setTextureOffset(0, 500);
    	        shape26_1.mirror = true;
    	        shape26_1.setRotationPoint(0.0F, 2.0F, 0.0F);
    	        shape26_1.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    	        setRotateAngle(shape26_1, 0.0F, -0.2617993877991494F, -0.08726646259971647F);
    	        shape117 = new ModelRenderer(this, "shape117").setTextureOffset(0, 500);
    	        shape117.mirror = true;
    	        shape117.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape117.addBox(-1.0F, 4.04F, -2.55F, 2, 1, 1, 0.0F);
    	        setRotateAngle(shape117, 0.3490658503988659F, 0.0F, 0.0F);
    	        carfront = new ModelRenderer(this, "carfront").setTextureOffset(0, 500);
    	        carfront.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        carfront.addBox(-1.5F, 1.0F, -1.0F, 3, 3, 4, 0.0F);
    	        shape115_2 = new ModelRenderer(this, "shape115_2").setTextureOffset(0, 500);
    	        shape115_2.mirror = true;
    	        shape115_2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape115_2.addBox(0.5F, 0.7F, 0.0F, 1, 4, 1, 0.0F);
    	        setRotateAngle(shape115_2, 0.0F, 0.0F, 0.08726646259971647F);
    	        shape115_1 = new ModelRenderer(this, "shape115_1").setTextureOffset(0, 455);
    	        shape115_1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape115_1.addBox(-1.5F, 0.7F, 0.0F, 1, 4, 1, 0.0F);
    	        setRotateAngle(shape115_1, 0.0F, 0.0F, -0.13962634015954636F);
    	        shape108_14 = new ModelRenderer(this, "shape108_14").setTextureOffset(0, 500);
    	        shape108_14.setRotationPoint(0.66F, -1.16F, 0.0F);
    	        shape108_14.addBox(-3.5F, -1.4F, -2.0F, 3, 2, 4, 0.0F);
    	        setRotateAngle(shape108_14, 0.0F, 0.0F, -0.15707963267948966F);
    	        croach = new ModelRenderer(this, "croach").setTextureOffset(0, 455);
    	        croach.setRotationPoint(0.0F, 13.0F, 0.2F);
    	        croach.addBox(-1.0F, -0.6F, -2.3F, 2, 1, 4, 0.0F);
    	        setRotateAngle(croach, -0.10471975511965977F, 0.0F, 0.0F);
    	        shape115_4 = new ModelRenderer(this, "shape115_4").setTextureOffset(0, 455);
    	        shape115_4.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape115_4.addBox(-1.7F, 0.7F, 0.0F, 1, 4, 1, 0.0F);
    	        setRotateAngle(shape115_4, 0.0F, 0.0F, -0.13962634015954636F);
    	        shape1 = new ModelRenderer(this, "shape1").setTextureOffset(0, 500);
    	        shape1.setRotationPoint(-2.5F, 1.45F, 0.9F);
    	        shape1.addBox(0.0F, 4.2F, -0.1F, 5, 2, 1, 0.0F);
    	        setRotateAngle(shape1, -1.1344640137963142F, 0.0F, 0.0F);
    	        shape117_6 = new ModelRenderer(this, "shape117_6").setTextureOffset(0, 455);
    	        shape117_6.setRotationPoint(0.0F, 0.3F, 0.0F);
    	        shape117_6.addBox(-1.0F, 3.94F, -2.8F, 2, 3, 1, 0.0F);
    	        setRotateAngle(shape117_6, 0.3490658503988659F, 0.0F, 0.0F);
    	        shape83_2 = new ModelRenderer(this, "shape83_2").setTextureOffset(0, 500);
    	        shape83_2.setRotationPoint(0.0F, 1.9F, 1.3F);
    	        shape83_2.addBox(-2.0F, -0.6F, 0.7F, 4, 5, 2, 0.0F);
    	        setRotateAngle(shape83_2, 0.03490658503988659F, 0.0F, 0.0F);
    	        shape44_11 = new ModelRenderer(this, "shape44_11").setTextureOffset(55, 500);
    	        shape44_11.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape44_11.addBox(0.0F, -0.5F, 0.9F, 2, 2, 1, 0.0F);
    	        setRotateAngle(shape44_11, 0.7853981633974483F, 0.0F, 0.0F);
    	        RightArm = new ModelRenderer(this, "RightArm").setTextureOffset(0, 455);
    	        RightArm.mirror = true;
    	        RightArm.setRotationPoint(5.0F, 3.0F, 0.5F);
    	        RightArm.addBox(0.0F, -2.0F, -1.5F, 3, 5, 3, 0.0F);
    	        setRotateAngle(RightArm, 0.10471975511965977F, 0.0F, -0.10471975511965977F);
    	        shape246_4 = new ModelRenderer(this, "shape246_4").setTextureOffset(0, 500);
    	        shape246_4.setRotationPoint(0.65F, 0.2F, 0.16F);
    	        shape246_4.addBox(0.0F, -1.0F, -1.4F, 1, 1, 2, 0.0F);
    	        setRotateAngle(shape246_4, 0.0F, 0.17453292519943295F, 0.0F);
    	        shape117_5 = new ModelRenderer(this, "shape117_5").setTextureOffset(0, 500);
    	        shape117_5.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape117_5.addBox(-1.0F, 3.74F, 2.47F, 2, 1, 1, 0.0F);
    	        setRotateAngle(shape117_5, -0.3490658503988659F, 0.0F, 0.0F);
    	        shape205_1 = new ModelRenderer(this, "shape205_1").setTextureOffset(0, 455);
    	        shape205_1.mirror = true;
    	        shape205_1.setRotationPoint(1.4F, 1.1F, -2.6F);
    	        shape205_1.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape205_1, 0.0F, -0.7853981633974483F, 0.0F);
    	        shape115_7 = new ModelRenderer(this, "shape115_7").setTextureOffset(0, 0);
    	        shape115_7.mirror = true;
    	        shape115_7.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape115_7.addBox(0.5F, 0.7F, 0.0F, 1, 4, 1, 0.0F);
    	        setRotateAngle(shape115_7, 0.0F, 0.0F, 0.13962634015954636F);
    	        shape44_8 = new ModelRenderer(this, "shape44_8").setTextureOffset(55, 500);
    	        shape44_8.setRotationPoint(0.0F, 0.7F, -0.7F);
    	        shape44_8.addBox(0.0F, -0.5F, -1.9F, 2, 2, 1, 0.0F);
    	        setRotateAngle(shape44_8, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape38_26 = new ModelRenderer(this, "shape38_26").setTextureOffset(0, 455);
    	        shape38_26.mirror = true;
    	        shape38_26.setRotationPoint(0.1F, 8.0F, 0.9F);
    	        shape38_26.addBox(-1.8F, -2.0F, -3.2F, 1, 3, 2, 0.0F);
    	        setRotateAngle(shape38_26, 0.08726646259971647F, -1.48352986419518F, 0.0F);
    	        shape46_6 = new ModelRenderer(this, "shape46_6").setTextureOffset(55, 500);
    	        shape46_6.setRotationPoint(0.0F, 1.4F, 0.0F);
    	        shape46_6.addBox(0.0F, 0.7F, -1.0F, 2, 1, 2, 0.0F);
    	        shape281_1 = new ModelRenderer(this, "shape281_1").setTextureOffset(0, 455);
    	        shape281_1.setRotationPoint(0.0F, 0.9F, -3.4F);
    	        shape281_1.addBox(-0.5F, 0.0F, 0.0F, 2, 1, 4, 0.0F);
    	        setRotateAngle(shape281_1, 0.6632251157578453F, 0.0F, 0.0F);
    	        RightArm_1 = new ModelRenderer(this, "RightArm_1").setTextureOffset(0, 455);
    	        RightArm_1.setRotationPoint(-5.0F, 3.0F, 0.5F);
    	        RightArm_1.addBox(-3.0F, -2.0F, -1.5F, 3, 5, 3, 0.0F);
    	        setRotateAngle(RightArm_1, 0.10471975511965977F, 0.0F, 0.10471975511965977F);
    	        shape205_7 = new ModelRenderer(this, "shape205_7").setTextureOffset(0, 455);
    	        shape205_7.setRotationPoint(-0.4F, 0.9F, -2.5F);
    	        shape205_7.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape205_7, 0.0F, 0.7853981633974483F, 0.0F);
    	        shape115_6 = new ModelRenderer(this, "shape115_6").setTextureOffset(0, 500);
    	        shape115_6.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape115_6.addBox(-1.5F, 0.7F, 0.0F, 1, 4, 1, 0.0F);
    	        setRotateAngle(shape115_6, 0.0F, 0.0F, -0.08726646259971647F);
    	        shape113_10 = new ModelRenderer(this, "shape113_10").setTextureOffset(0, 500);
    	        shape113_10.setRotationPoint(0.0F, 0.0F, -0.2F);
    	        shape113_10.addBox(-1.8F, 0.4F, 1.2F, 1, 5, 1, 0.0F);
    	        setRotateAngle(shape113_10, -0.12217304763960307F, 0.0F, -0.08726646259971647F);
    	        shape320_4 = new ModelRenderer(this, "shape320_4").setTextureOffset(0, 455);
    	        shape320_4.setRotationPoint(0.0F, 0.9F, -3.9F);
    	        shape320_4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    	        shape44_1 = new ModelRenderer(this, "shape44_1").setTextureOffset(55, 500);
    	        shape44_1.mirror = true;
    	        shape44_1.setRotationPoint(0.0F, 1.4F, 0.0F);
    	        shape44_1.addBox(-2.0F, 0.9F, -0.5F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape44_1, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape44_3 = new ModelRenderer(this, "shape44_3").setTextureOffset(55, 500);
    	        shape44_3.mirror = true;
    	        shape44_3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape44_3.addBox(-2.0F, -0.5F, 0.9F, 2, 2, 1, 0.0F);
    	        setRotateAngle(shape44_3, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape117_2 = new ModelRenderer(this, "shape117_2").setTextureOffset(0, 455);
    	        shape117_2.mirror = true;
    	        shape117_2.setRotationPoint(0.0F, 0.3F, 0.0F);
    	        shape117_2.addBox(-1.0F, 3.94F, -2.8F, 2, 3, 1, 0.0F);
    	        setRotateAngle(shape117_2, 0.3490658503988659F, 0.0F, 0.0F);
    	        shape202 = new ModelRenderer(this, "shape202").setTextureOffset(0, 455);
    	        shape202.mirror = true;
    	        shape202.setRotationPoint(0.0F, 0.0F, 0.1F);
    	        shape202.addBox(-2.0F, -0.7F, -1.0F, 3, 2, 3, 0.0F);
    	        cro = new ModelRenderer(this, "cro").setTextureOffset(0, 455);
    	        cro.setRotationPoint(0.0F, 1.0F, 0.0F);
    	        cro.addBox(-1.0F, -1.54F, -1.8F, 2, 1, 4, 0.0F);
    	        setRotateAngle(cro, 0.45378560551852565F, 0.0F, 0.0F);
    	        shape38_14 = new ModelRenderer(this, "shape38_14").setTextureOffset(0, 0);
    	        shape38_14.setRotationPoint(0.0F, 12.5F, 1.0F);
    	        shape38_14.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2, 0.0F);
    	        shape38_6 = new ModelRenderer(this, "shape38_6").setTextureOffset(0, 455);
    	        shape38_6.setRotationPoint(-0.24F, 9.8F, 1.0F);
    	        shape38_6.addBox(-0.9F, -0.95F, -3.2F, 3, 2, 2, 0.0F);
    	        setRotateAngle(shape38_6, 0.17453292519943295F, 0.8726646259971648F, 0.0F);
    	        shape246_1 = new ModelRenderer(this, "shape246_1").setTextureOffset(1000, 485);
    	        shape246_1.mirror = true;
    	        shape246_1.setRotationPoint(-0.15F, 0.3F, 0.0F);
    	        shape246_1.addBox(-1.0F, -2.9F, -1.4F, 1, 2, 1, 0.0F);
    	        setRotateAngle(shape246_1, 0.0F, 0.17453292519943295F, 0.0F);
    	        shape253_2 = new ModelRenderer(this, "shape253_2").setTextureOffset(0, 500);
    	        shape253_2.setRotationPoint(-1.0F, 1.1F, -0.3F);
    	        shape253_2.addBox(-0.5F, -3.7F, 0.6F, 3, 2, 1, 0.0F);
    	        setRotateAngle(shape253_2, -0.3490658503988659F, 0.0F, 0.0F);
    	        shape42_3 = new ModelRenderer(this, "shape42_3").setTextureOffset(55, 500);
    	        shape42_3.mirror = true;
    	        shape42_3.setRotationPoint(0.0F, 0.7F, -0.7F);
    	        shape42_3.addBox(-2.0F, -1.0F, -1.7F, 2, 2, 1, 0.0F);
    	        RightLowerArm_1 = new ModelRenderer(this, "RightLowerArm_1").setTextureOffset(0, 455);
    	        RightLowerArm_1.setRotationPoint(-1.5F, 2.8F, -0.5F);
    	        RightLowerArm_1.addBox(-1.01F, -0.3F, -0.5F, 2, 4, 2, 0.0F);
    	        setRotateAngle(RightLowerArm_1, -0.3141592653589793F, -0.20943951023931953F, 0.0F);
    	        WHEEL_3 = new ModelRenderer(this, "WHEEL_3").setTextureOffset(0, 500);
    	        WHEEL_3.setRotationPoint(-0.5F, -1.01F, 1.5F);
    	        WHEEL_3.addBox(0.8999999999999999F, -0.8F, -1.4F, 1, 3, 3, 0.0F);
    	        shape44_14 = new ModelRenderer(this, "shape44_14").setTextureOffset(55, 500);
    	        shape44_14.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape44_14.addBox(0.0F, -1.9F, -1.5F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape44_14, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape113 = new ModelRenderer(this, "shape113").setTextureOffset(0, 500);
    	        shape113.mirror = true;
    	        shape113.setRotationPoint(0.0F, 0.0F, -0.2F);
    	        shape113.addBox(0.8F, 0.4F, 1.2F, 1, 5, 1, 0.0F);
    	        setRotateAngle(shape113, -0.12217304763960307F, 0.0F, 0.08726646259971647F);
    	        shape44_6 = new ModelRenderer(this, "shape44_6").setTextureOffset(55, 500);
    	        shape44_6.mirror = true;
    	        shape44_6.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape44_6.addBox(-2.0F, -1.9F, -1.5F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape44_6, 0.7853981633974483F, 0.0F, 0.0F);
    	        torso_1 = new ModelRenderer(this, "torso_1").setTextureOffset(0, 0);
    	        torso_1.setRotationPoint(0.0F, -0.1F, 0.0F);
    	        torso_1.addBox(-0.5F, 8.0F, -1.0F, 1, 1, 1, 0.0F);
    	        setRotateAngle(torso_1, 0.03490658503988659F, 0.0F, 0.0F);
    	        shape44_13 = new ModelRenderer(this, "shape44_13").setTextureOffset(55, 500);
    	        shape44_13.setRotationPoint(0.0F, 1.4F, 0.0F);
    	        shape44_13.addBox(0.0F, 0.9F, -0.5F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape44_13, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape38_29 = new ModelRenderer(this, "shape38_29").setTextureOffset(0, 455);
    	        shape38_29.setRotationPoint(-0.2F, 11.5F, 1.0F);
    	        shape38_29.addBox(-0.1F, -1.0F, -3.1F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape38_29, 0.767944870877505F, 1.3962634015954636F, 0.8203047484373349F);
    	        shape44_2 = new ModelRenderer(this, "shape44_2").setTextureOffset(55, 500);
    	        shape44_2.mirror = true;
    	        shape44_2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape44_2.addBox(-2.0F, -1.9F, -1.5F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape44_2, 0.7853981633974483F, 0.0F, 0.0F);
    	        shape4 = new ModelRenderer(this, "shape4").setTextureOffset(0, 500);
    	        shape4.setRotationPoint(-0.2F, 0.0F, 1.4F);
    	        shape4.addBox(0.0F, 5.2F, 0.0F, 1, 1, 3, 0.0F);
    	        setRotateAngle(shape4, -0.17453292519943295F, -0.2617993877991494F, 0.0F);
    	        shape124_5 = new ModelRenderer(this, "shape124_5").setTextureOffset(0, 455);
    	        shape124_5.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape124_5.addBox(1.1600000000000001F, 6.96F, -0.5F, 1, 1, 2, 0.0F);
    	        setRotateAngle(shape124_5, 0.0F, 0.0F, 0.24609142453120048F);
    	        shape320_1 = new ModelRenderer(this, "shape320_1").setTextureOffset(0, 455);
    	        shape320_1.mirror = true;
    	        shape320_1.setRotationPoint(0.0F, 0.9F, -3.9F);
    	        shape320_1.addBox(-1.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    	        shape42_6 = new ModelRenderer(this, "shape42_6").setTextureOffset(55, 500);
    	        shape42_6.setRotationPoint(0.0F, 0.7F, 0.7F);
    	        shape42_6.addBox(0.0F, -1.0F, 0.7F, 2, 2, 1, 0.0F);
    	        shape113_7 = new ModelRenderer(this, "shape113_7").setTextureOffset(0, 455);
    	        shape113_7.setRotationPoint(0.0F, 0.0F, -0.2F);
    	        shape113_7.addBox(-1.6F, 0.5F, 1.2F, 2, 5, 1, 0.0F);
    	        setRotateAngle(shape113_7, -0.12217304763960307F, 0.0F, -0.08726646259971647F);
    	        shape246 = new ModelRenderer(this, "shape246").setTextureOffset(1000, 485);
    	        shape246.setRotationPoint(0.15F, 0.3F, 0.0F);
    	        shape246.addBox(0.0F, -2.9F, -1.4F, 1, 2, 1, 0.0F);
    	        setRotateAngle(shape246, 0.0F, -0.17453292519943295F, 0.0F);
    	        shape113_9 = new ModelRenderer(this, "shape113_9").setTextureOffset(0, 500);
    	        shape113_9.mirror = true;
    	        shape113_9.setRotationPoint(-0.1F, 3.0F, 0.1F);
    	        shape113_9.addBox(0.0F, -1.6F, -0.2F, 2, 5, 2, 0.0F);
    	        setRotateAngle(shape113_9, 0.03490658503988659F, 0.0F, 0.10471975511965977F);
    	        shape38_17 = new ModelRenderer(this, "shape38_17").setTextureOffset(0, 455);
    	        shape38_17.mirror = true;
    	        shape38_17.setRotationPoint(0.5F, 11.5F, 1.0F);
    	        shape38_17.addBox(-2.0F, -1.0F, -3.2F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape38_17, 0.17453292519943295F, -0.8726646259971648F, -0.17453292519943295F);
    	        RightFoot = new ModelRenderer(this, "RightFoot").setTextureOffset(0, 455);
    	        RightFoot.mirror = true;
    	        RightFoot.setRotationPoint(0.5F, 9.4F, 0.2F);
    	        RightFoot.addBox(-2.0F, 1.1F, -2.8F, 3, 1, 6, 0.0F);
    	        setRotateAngle(RightFoot, 0.03490658503988659F, 0.0F, 0.017453292519943295F);
    	        CHEST = new ModelRenderer(this, "CHEST").setTextureOffset(0, 0);
    	        CHEST.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        CHEST.addBox(-0.5F, 4.0F, 0.0F, 1, 1, 1, 0.0F);
    	        shape87 = new ModelRenderer(this, "shape87").setTextureOffset(0, 500);
    	        shape87.setRotationPoint(0.0F, 1.9F, 0.0F);
    	        shape87.addBox(-4.0F, 0.0F, 0.0F, 8, 5, 1, 0.0F);
    	        shape38_15 = new ModelRenderer(this, "shape38_15").setTextureOffset(0, 455);
    	        shape38_15.setRotationPoint(0.0F, 10.6F, 0.7F);
    	        shape38_15.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2, 0.0F);
    	        shape205 = new ModelRenderer(this, "shape205").setTextureOffset(0, 455);
    	        shape205.mirror = true;
    	        shape205.setRotationPoint(1.4F, 0.9F, -2.5F);
    	        shape205.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape205, 0.0F, -0.7853981633974483F, 0.0F);
    	        shape18_5 = new ModelRenderer(this, "shape18_5").setTextureOffset(1000, 450);
    	        shape18_5.setRotationPoint(0.0F, -0.85F, 0.17F);
    	        shape18_5.addBox(0.5F, 0.2F, 1.6F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape18_5, -0.17453292519943295F, 0.0F, 0.0F);
    	        shape204_1 = new ModelRenderer(this, "shape204_1").setTextureOffset(0, 500);
    	        shape204_1.setRotationPoint(0.0F, 0.1F, -1.6F);
    	        shape204_1.addBox(-1.01F, -0.3F, -1.3F, 3, 2, 3, 0.0F);
    	        setRotateAngle(shape204_1, 0.6108652381980153F, 0.0F, 0.0F);
    	        shape47 = new ModelRenderer(this, "shape47").setTextureOffset(0, 455);
    	        shape47.setRotationPoint(1.7F, 6.7F, -3.5F);
    	        shape47.addBox(-0.5F, 0.0F, 0.0F, 1, 7, 2, 0.0F);
    	        setRotateAngle(shape47, 0.17453292519943295F, 0.0F, 0.08726646259971647F);
    	        shape113_6 = new ModelRenderer(this, "shape113_6").setTextureOffset(0, 500);
    	        shape113_6.setRotationPoint(0.1F, 3.0F, 0.1F);
    	        shape113_6.addBox(-2.0F, -1.6F, -0.2F, 2, 5, 2, 0.0F);
    	        setRotateAngle(shape113_6, 0.03490658503988659F, 0.0F, -0.10471975511965977F);
    	        shape18_3 = new ModelRenderer(this, "shape18_3").setTextureOffset(1000, 450);
    	        shape18_3.setRotationPoint(0.0F, 0.06F, 0.13F);
    	        shape18_3.addBox(0.5F, 0.2F, 0.7F, 2, 1, 1, 0.0F);
    	        setRotateAngle(shape18_3, 0.17453292519943295F, 0.0F, 0.0F);
    	        shape38_31 = new ModelRenderer(this, "shape38_31").setTextureOffset(0, 455);
    	        shape38_31.setRotationPoint(0.0F, 9.5F, 0.9F);
    	        shape38_31.addBox(0.8F, -1.0F, -3.2F, 1, 2, 2, 0.0F);
    	        setRotateAngle(shape38_31, 0.17453292519943295F, 1.48352986419518F, 0.0F);
    	        shape83_1 = new ModelRenderer(this, "shape83_1").setTextureOffset(0, 500);
    	        shape83_1.mirror = true;
    	        shape83_1.setRotationPoint(-0.1F, 2.4F, 1.8F);
    	        shape83_1.addBox(-3.0F, 0.2F, 1.0F, 4, 3, 1, 0.0F);
    	        setRotateAngle(shape83_1, 0.03490658503988659F, -0.17453292519943295F, 0.8726646259971648F);
    	        rightbumper_3 = new ModelRenderer(this, "rightbumper_3").setTextureOffset(0, 500);
    	        rightbumper_3.mirror = true;
    	        rightbumper_3.setRotationPoint(-2.9F, 1.3F, -0.8F);
    	        rightbumper_3.addBox(-1.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
    	        setRotateAngle(rightbumper_3, 0.0F, 0.0F, -0.03490658503988659F);
    	        shape207_2 = new ModelRenderer(this, "shape207_2").setTextureOffset(0, 455);
    	        shape207_2.setRotationPoint(1.4F, 1.1F, -2.6F);
    	        shape207_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
    	        setRotateAngle(shape207_2, 0.0F, -0.03490658503988659F, 0.0F);
    	        shape18 = new ModelRenderer(this, "shape18").setTextureOffset(1000, 450);
    	        shape18.mirror = true;
    	        shape18.setRotationPoint(0.0F, 0.06F, 0.13F);
    	        shape18.addBox(-2.5F, 0.2F, 0.7F, 2, 1, 1, 0.0F);
    	        setRotateAngle(shape18, 0.17453292519943295F, 0.0F, 0.0F);
    	        shape38_24 = new ModelRenderer(this, "shape38_24").setTextureOffset(0, 455);
    	        shape38_24.setRotationPoint(0.0F, 8.8F, 1.1F);
    	        shape38_24.addBox(-1.0F, -1.0F, -3.2F, 2, 3, 2, 0.0F);
    	        setRotateAngle(shape38_24, 0.08726646259971647F, 0.0F, 0.0F);
    	        shape6_1 = new ModelRenderer(this, "shape6_1").setTextureOffset(55, 500);
    	        shape6_1.setRotationPoint(0.0F, -0.5F, 1.8F);
    	        shape6_1.addBox(0.5F, 5.2F, 0.0F, 4, 1, 2, 0.0F);
    	        setRotateAngle(shape6_1, -0.13962634015954636F, 0.0F, 0.0F);
    	        shape46_1 = new ModelRenderer(this, "shape46_1").setTextureOffset(55, 500);
    	        shape46_1.mirror = true;
    	        shape46_1.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape46_1.addBox(-2.0F, -1.7F, -1.0F, 2, 1, 2, 0.0F);
    	        shape108_12 = new ModelRenderer(this, "shape108_12").setTextureOffset(0, 500);
    	        shape108_12.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape108_12.addBox(-3.2F, -0.8F, -0.3F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape108_12, 0.0F, 0.0F, -0.08726646259971647F);
    	        shape38_13 = new ModelRenderer(this, "shape38_13").setTextureOffset(0, 500);
    	        shape38_13.setRotationPoint(3.6F, 4.9F, 3.3F);
    	        shape38_13.addBox(-1.0F, -3.0F, -3.2F, 3, 5, 2, 0.0F);
    	        setRotateAngle(shape38_13, 0.0F, 0.8726646259971648F, 0.0F);
    	        shape38_11 = new ModelRenderer(this, "shape38_11").setTextureOffset(0, 455);
    	        shape38_11.setRotationPoint(0.0F, 7.3F, 0.7F);
    	        shape38_11.addBox(-1.5F, -1.0F, -3.0F, 3, 3, 2, 0.0F);
    	        shape119_5 = new ModelRenderer(this, "shape119_5").setTextureOffset(0, 455);
    	        shape119_5.setRotationPoint(0.01F, 0.0F, 0.0F);
    	        shape119_5.addBox(-1.0F, 4.0F, -0.3F, 2, 2, 2, 0.0F);
    	        shape113_4 = new ModelRenderer(this, "shape113_4").setTextureOffset(0, 455);
    	        shape113_4.mirror = true;
    	        shape113_4.setRotationPoint(0.0F, 0.0F, -0.2F);
    	        shape113_4.addBox(0.6000000000000001F, 0.4F, 1.2F, 1, 5, 1, 0.0F);
    	        setRotateAngle(shape113_4, -0.12217304763960307F, 0.0F, 0.08726646259971647F);
    	        shape119_3 = new ModelRenderer(this, "shape119_3").setTextureOffset(0, 500);
    	        shape119_3.mirror = true;
    	        shape119_3.setRotationPoint(0.5F, 0.5F, 1.1F);
    	        shape119_3.addBox(-1.0F, 4.0F, -0.8F, 2, 4, 2, 0.0F);
    	        setRotateAngle(shape119_3, -0.13962634015954636F, 0.0F, 0.0F);
    	        shape205_3 = new ModelRenderer(this, "shape205_3").setTextureOffset(0, 455);
    	        shape205_3.mirror = true;
    	        shape205_3.setRotationPoint(0.4F, 0.9F, -2.5F);
    	        shape205_3.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    	        setRotateAngle(shape205_3, 0.0F, -0.7853981633974483F, 0.0F);
    	        shape38_8 = new ModelRenderer(this, "shape38_8").setTextureOffset(0, 455);
    	        shape38_8.setRotationPoint(-0.2F, 8.0F, 0.9F);
    	        shape38_8.addBox(-1.0F, -1.0F, -3.2F, 3, 3, 2, 0.0F);
    	        setRotateAngle(shape38_8, 0.08726646259971647F, 0.8726646259971648F, 0.0F);
    	        shape207_1 = new ModelRenderer(this, "shape207_1").setTextureOffset(0, 455);
    	        shape207_1.setRotationPoint(0.4F, 1.1F, -2.6F);
    	        shape207_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
    	        setRotateAngle(shape207_1, 0.0F, -0.03490658503988659F, 0.0F);
    	        shape113_17 = new ModelRenderer(this, "shape113_17").setTextureOffset(0, 455);
    	        shape113_17.mirror = true;
    	        shape113_17.setRotationPoint(0.0F, 0.0F, -0.2F);
    	        shape113_17.addBox(-0.3999999999999999F, 0.5F, 1.2F, 2, 5, 1, 0.0F);
    	        setRotateAngle(shape113_17, -0.12217304763960307F, 0.0F, 0.08726646259971647F);
    	        shape116_3 = new ModelRenderer(this, "shape116_3").setTextureOffset(0, 455);
    	        shape116_3.setRotationPoint(0.0F, 1.1F, 1.6F);
    	        shape116_3.addBox(-1.0F, 0.7F, -1.0F, 2, 4, 3, 0.0F);
    	        setRotateAngle(shape116_3, -0.4363323129985824F, 0.0F, 0.0F);
    	        shape201_1 = new ModelRenderer(this, "shape201_1").setTextureOffset(0, 455);
    	        shape201_1.setRotationPoint(0.0F, 0.1F, 2.5F);
    	        shape201_1.addBox(-1.0F, -1.8F, -1.3F, 3, 3, 1, 0.0F);
    	        setRotateAngle(shape201_1, 0.8726646259971648F, 0.0F, 0.0F);
    	        shape256_3 = new ModelRenderer(this, "shape256_3").setTextureOffset(0, 500);
    	        shape256_3.mirror = true;
    	        shape256_3.setRotationPoint(-0.6F, -2.3F, -0.2F);
    	        shape256_3.addBox(-1.0F, 0.0F, 1.2F, 1, 1, 2, 0.0F);
    	        setRotateAngle(shape256_3, 0.2617993877991494F, -0.19198621771937624F, 0.0F);
    	        shape42_5 = new ModelRenderer(this, "shape42_5").setTextureOffset(55, 500);
    	        shape42_5.setRotationPoint(0.0F, 0.7F, -0.7F);
    	        shape42_5.addBox(0.0F, -1.0F, -1.7F, 2, 2, 1, 0.0F);
    	        shape116_2 = new ModelRenderer(this, "shape116_2").setTextureOffset(0, 500);
    	        shape116_2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape116_2.addBox(-1.0F, 0.7F, -1.0F, 2, 4, 3, 0.0F);
    	        shape202_1 = new ModelRenderer(this, "shape202_1").setTextureOffset(0, 455);
    	        shape202_1.setRotationPoint(0.0F, 0.0F, 0.1F);
    	        shape202_1.addBox(-1.0F, -0.7F, -1.0F, 3, 2, 3, 0.0F);
    	        shape246_2 = new ModelRenderer(this, "shape246_2").setTextureOffset(1000, 485);
    	        shape246_2.setRotationPoint(0.65F, 0.3F, 0.36F);
    	        shape246_2.addBox(0.0F, -2.9F, -1.4F, 1, 2, 2, 0.0F);
    	        setRotateAngle(shape246_2, 0.0F, 0.17453292519943295F, 0.0F);
    	        shape113_13 = new ModelRenderer(this, "shape113_13").setTextureOffset(0, 500);
    	        shape113_13.mirror = true;
    	        shape113_13.setRotationPoint(0.0F, 0.0F, -0.2F);
    	        shape113_13.addBox(-0.3999999999999999F, 0.5F, 1.2F, 2, 5, 1, 0.0F);
    	        setRotateAngle(shape113_13, -0.12217304763960307F, 0.0F, 0.08726646259971647F);
    	        shape38_30 = new ModelRenderer(this, "shape38_30").setTextureOffset(0, 455);
    	        shape38_30.setRotationPoint(-0.1F, 8.0F, 0.9F);
    	        shape38_30.addBox(0.8F, -2.0F, -3.2F, 1, 3, 2, 0.0F);
    	        setRotateAngle(shape38_30, 0.08726646259971647F, 1.48352986419518F, 0.0F);
    	        WHEELee_2 = new ModelRenderer(this, "WHEELee_2").setTextureOffset(60, 460);
    	        WHEELee_2.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        WHEELee_2.addBox(0.10000000000000009F, -0.8F, -1.4F, 1, 3, 3, 0.0F);
    	        shape38_2 = new ModelRenderer(this, "shape38_2").setTextureOffset(0, 455);
    	        shape38_2.setRotationPoint(0.0F, 8.7F, 0.1F);
    	        shape38_2.addBox(-1.5F, -1.0F, -3.0F, 3, 1, 2, 0.0F);
    	        shape88 = new ModelRenderer(this, "shape88").setTextureOffset(0, 455);
    	        shape88.setRotationPoint(0.0F, 1.5F, -1.0F);
    	        shape88.addBox(-5.0F, 0.0F, 0.0F, 10, 3, 3, 0.0F);
    	        shape38_3 = new ModelRenderer(this, "shape38_3").setTextureOffset(0, 455);
    	        shape38_3.mirror = true;
    	        shape38_3.setRotationPoint(0.6F, 11.6F, 1.0F);
    	        shape38_3.addBox(-1.95F, -0.95F, -3.2F, 2, 2, 2, 0.0F);
    	        setRotateAngle(shape38_3, 0.17453292519943295F, -0.8726646259971648F, -0.17453292519943295F);
    	        shape42 = new ModelRenderer(this, "shape42").setTextureOffset(55, 500);
    	        shape42.mirror = true;
    	        shape42.setRotationPoint(0.0F, 0.7F, 0.7F);
    	        shape42.addBox(-2.0F, -1.0F, 0.7F, 2, 2, 1, 0.0F);
    	        leftheadlight_1 = new ModelRenderer(this, "leftheadlight_1").setTextureOffset(0, 500);
    	        leftheadlight_1.setRotationPoint(-1.3F, 1.4F, -0.1F);
    	        leftheadlight_1.addBox(-3.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
    	        setRotateAngle(leftheadlight_1, 0.17453292519943295F, 0.0F, 0.2617993877991494F);
    	        WHEELee_3 = new ModelRenderer(this, "WHEELee_3").setTextureOffset(60, 460);
    	        WHEELee_3.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        WHEELee_3.addBox(0.10000000000000009F, -0.8F, -1.4F, 1, 3, 3, 0.0F);
    	        shape246_5 = new ModelRenderer(this, "shape246_5").setTextureOffset(0, 500);
    	        shape246_5.mirror = true;
    	        shape246_5.setRotationPoint(-0.65F, 0.2F, 0.16F);
    	        shape246_5.addBox(-1.0F, -1.0F, -1.4F, 1, 1, 2, 0.0F);
    	        setRotateAngle(shape246_5, 0.0F, -0.17453292519943295F, 0.0F);
    	        shape115_5 = new ModelRenderer(this, "shape115_5").setTextureOffset(0, 455);
    	        shape115_5.mirror = true;
    	        shape115_5.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape115_5.addBox(0.5F, 0.7F, 0.0F, 1, 4, 1, 0.0F);
    	        setRotateAngle(shape115_5, 0.0F, 0.0F, 0.13962634015954636F);
    	        shape119 = new ModelRenderer(this, "shape119").setTextureOffset(0, 455);
    	        shape119.mirror = true;
    	        shape119.setRotationPoint(-0.01F, 0.0F, 0.0F);
    	        shape119.addBox(-1.0F, 4.0F, -0.3F, 2, 2, 2, 0.0F);
    	        shape124 = new ModelRenderer(this, "shape124").setTextureOffset(0, 455);
    	        shape124.mirror = true;
    	        shape124.setRotationPoint(0.0F, 0.0F, 0.0F);
    	        shape124.addBox(0.3799999999999999F, 5.9F, -0.5F, 1, 2, 2, 0.0F);
    	        setRotateAngle(shape124, 0.0F, 0.0F, 0.06981317007977318F);
    	        WHEEL_1 = new ModelRenderer(this, "WHEEL_1").setTextureOffset(0, 500);
    	        WHEEL_1.mirror = true;
    	        WHEEL_1.setRotationPoint(0.5F, -1.01F, 1.5F);
    	        WHEEL_1.addBox(-1.9F, -0.8F, -1.4F, 1, 3, 3, 0.0F);
    	        shape259 = new ModelRenderer(this, "shape259").setTextureOffset(0, 500);
    	        shape259.setRotationPoint(0.0F, -0.1F, 0.4F);
    	        shape259.addBox(-1.0F, -1.7F, -0.3F, 2, 1, 1, 0.0F);
    	        setRotateAngle(shape259, -1.0471975511965976F, 0.0F, 0.0F);
    	        shape113_18 = new ModelRenderer(this, "shape113_18").setTextureOffset(0, 500);
    	        shape113_18.setRotationPoint(0.0F, 1.7F, 2.3F);
    	        shape113_18.addBox(-1.5F, -0.2F, -1.1F, 3, 4, 2, 0.0F);
    	        setRotateAngle(shape113_18, -0.2617993877991494F, 0.0F, 0.0F);
    	        RightLowerLeg.addChild(shape117_3);
    	        WHEEL_2.addChild(shape44_9);
    	        RightLowerArm.addChild(shape116);
    	        CHEST.addChild(chest);
    	        RightLowerArm_1.addChild(shape124_4);
    	        croach.addChild(shape166);
    	        RightLowerArm_1.addChild(shape124_6);
    	        CHEST.addChild(torso);
    	        leftheadlight.addChild(shape18_2);
    	        RightArm.addChild(WHEEL);
    	        RightLowerArm.addChild(shape119_1);
    	        RightLowerLeg_1.addChild(shape117_7);
    	        carfront.addChild(shape1_1);
    	        RightLowerArm_1.addChild(shape113_11);
    	        RightLowerArm.addChild(shape115);
    	        RightLeg.addChild(shape108_9);
    	        Head.addChild(shape259_1);
    	        RightArm_1.addChild(WHEEL_2);
    	        RightLowerArm.addChild(shape113_2);
    	        RightArm.addChild(shape108_1);
    	        RightFoot_1.addChild(shape205_4);
    	        RightArm.addChild(shape108);
    	        WHEEL_3.addChild(shape44_15);
    	        WHEEL_1.addChild(shape46_2);
    	        RightLeg_1.addChild(RightLowerLeg_1);
    	        croach.addChild(cr);
    	        RightLowerLeg_1.addChild(shape113_16);
    	        torso.addChild(shape38_5);
    	        rightbumper_1.addChild(rightbumper_5);
    	        torso_1.addChild(shape38_20);
    	        torso.addChild(shape38_9);
    	        WHEEL_1.addChild(shape44_4);
    	        chest.addChild(shape83);
    	        Head.addChild(shape256);
    	        CHEST.addChild(shape244);
    	        torso_1.addChild(shape38_21);
    	        rightbumper_1.addChild(shape26_3);
    	        RightLeg.addChild(shape108_8);
    	        croach.addChild(shape166_1);
    	        RightLeg.addChild(shape108_7);
    	        RightLeg_1.addChild(shape108_17);
    	        RightLowerArm.addChild(shape124_1);
    	        RightLowerLeg.addChild(shape113_8);
    	        WHEEL_1.addChild(shape44_7);
    	        shape1_1.addChild(shape14_1);
    	        chest.addChild(mainchest);
    	        rightbumper.addChild(rightbumper_2);
    	        WHEEL.addChild(shape44);
    	        RightFoot.addChild(shape320_2);
    	        RightLowerArm_1.addChild(shape113_12);
    	        RightFoot_1.addChild(shape320_5);
    	        rightheadlight.addChild(shape18_4);
    	        rightbumper_1.addChild(rightbumper_4);
    	        RightFoot.addChild(shape320);
    	        RightFoot_1.addChild(shape320_3);
    	        RightLeg.addChild(shape108_6);
    	        rightbumper_1.addChild(shape26_4);
    	        RightLowerLeg_1.addChild(shape113_19);
    	        RightLowerArm.addChild(shape117_1);
    	        RightLeg_1.addChild(shape108_16);
    	        shape1.addChild(shape6);
    	        Head.addChild(shape246_3);
    	        WHEEL_3.addChild(shape44_12);
    	        RightLowerLeg_1.addChild(shape119_9);
    	        leftheadlight.addChild(shape18_1);
    	        RightFoot_1.addChild(shape205_5);
    	        rightbumper.addChild(shape26);
    	        torso_1.addChild(shape38_27);
    	        RightArm_1.addChild(shape108_13);
    	        WHEEL_1.addChild(shape44_5);
    	        torso_1.addChild(shape38_25);
    	        chest.addChild(rightbumper);
    	        RightLowerLeg_1.addChild(shape113_15);
    	        RightLeg.addChild(RightLowerLeg);
    	        WHEEL_2.addChild(shape46_5);
    	        RightLowerLeg.addChild(shape119_4);
    	        torso.addChild(shape38_1);
    	        RightLowerLeg_1.addChild(shape113_14);
    	        chest.addChild(rightbumper_1);
    	        RightLowerLeg_1.addChild(shape119_8);
    	        RightLowerLeg_1.addChild(RightFoot_1);
    	        WHEEL_2.addChild(shape46_4);
    	        shape1_1.addChild(shape14);
    	        WHEEL_2.addChild(shape44_10);
    	        mainchest.addChild(leftheadlight_2);
    	        RightFoot.addChild(shape201);
    	        RightArm.addChild(shape108_2);
    	        Head.addChild(shape253_1);
    	        WHEEL_3.addChild(shape46_7);
    	        RightArm_1.addChild(shape108_11);
    	        WHEEL.addChild(shape46);
    	        RightLowerLeg_1.addChild(shape119_7);
    	        mainchest.addChild(shape86);
    	        RightFoot.addChild(shape205_2);
    	        RightFoot_1.addChild(shape205_6);
    	        RightFoot.addChild(shape207);
    	        WHEEL_1.addChild(shape42_2);
    	        RightLowerLeg.addChild(shape116_1);
    	        RightFoot.addChild(shape281);
    	        Head.addChild(shape253);
    	        shape1_1.addChild(shape2_1);
    	        RightLeg.addChild(shape108_5);
    	        Head.addChild(shape255_1);
    	        RightFoot_1.addChild(shape207_3);
    	        mainchest.addChild(shape38_12);
    	        RightLowerArm_1.addChild(shape119_6);
    	        chest.addChild(rightheadlight);
    	        RightArm.addChild(shape108_3);
    	        RightArm.addChild(RightLowerArm);
    	        RightLeg_1.addChild(shape108_19);
    	        RightArm.addChild(shape108_4);
    	        RightLowerLeg.addChild(shape115_3);
    	        Head.addChild(shape250);
    	        rightbumper_1.addChild(shape26_5);
    	        WHEEL.addChild(WHEELee);
    	        WHEEL_1.addChild(shape46_3);
    	        torso_1.addChild(shape38_23);
    	        Head.addChild(shape255);
    	        torso.addChild(shape38);
    	        RightLowerLeg.addChild(shape119_2);
    	        torso_1.addChild(shape38_16);
    	        RightLowerArm_1.addChild(shape117_4);
    	        torso_1.addChild(shape38_18);
    	        RightLowerArm.addChild(shape113_3);
    	        RightLowerArm.addChild(shape124_2);
    	        WHEEL.addChild(shape42_1);
    	        shape1.addChild(shape4_1);
    	        RightLowerArm_1.addChild(shape124_7);
    	        torso.addChild(shape47_1);
    	        RightLeg_1.addChild(shape108_18);
    	        croach.addChild(cro_1);
    	        RightLowerArm.addChild(shape113_1);
    	        shape1_1.addChild(shape2);
    	        torso_1.addChild(shape38_22);
    	        RightLowerLeg.addChild(shape113_5);
    	        torso.addChild(shape38_7);
    	        WHEEL_3.addChild(shape42_7);
    	        rightbumper.addChild(shape26_2);
    	        torso.addChild(shape38_10);
    	        RightArm_1.addChild(shape108_10);
    	        Head.addChild(shape256_1);
    	        Head.addChild(shape250_1);
    	        RightLowerArm.addChild(shape124_3);
    	        torso_1.addChild(shape47_2);
    	        torso_1.addChild(shape38_19);
    	        torso_1.addChild(shape38_28);
    	        WHEEL_1.addChild(WHEELee_1);
    	        RightFoot.addChild(shape204);
    	        torso.addChild(shape38_4);
    	        RightLeg_1.addChild(shape108_15);
    	        Head.addChild(shape256_2);
    	        WHEEL_2.addChild(shape42_4);
    	        chest.addChild(leftheadlight);
    	        rightbumper.addChild(shape26_1);
    	        RightLowerArm.addChild(shape117);
    	        chest.addChild(carfront);
    	        RightLowerLeg.addChild(shape115_2);
    	        RightLowerArm.addChild(shape115_1);
    	        RightArm_1.addChild(shape108_14);
    	        CHEST.addChild(croach);
    	        RightLowerArm_1.addChild(shape115_4);
    	        carfront.addChild(shape1);
    	        RightLowerLeg_1.addChild(shape117_6);
    	        mainchest.addChild(shape83_2);
    	        WHEEL_2.addChild(shape44_11);
    	        Head.addChild(shape246_4);
    	        RightLowerArm_1.addChild(shape117_5);
    	        RightFoot.addChild(shape205_1);
    	        RightLowerLeg_1.addChild(shape115_7);
    	        WHEEL_2.addChild(shape44_8);
    	        torso_1.addChild(shape38_26);
    	        WHEEL_3.addChild(shape46_6);
    	        RightFoot_1.addChild(shape281_1);
    	        RightFoot_1.addChild(shape205_7);
    	        RightLowerLeg_1.addChild(shape115_6);
    	        RightLowerArm_1.addChild(shape113_10);
    	        RightFoot_1.addChild(shape320_4);
    	        WHEEL.addChild(shape44_1);
    	        WHEEL.addChild(shape44_3);
    	        RightLowerLeg.addChild(shape117_2);
    	        RightFoot.addChild(shape202);
    	        croach.addChild(cro);
    	        torso_1.addChild(shape38_14);
    	        torso.addChild(shape38_6);
    	        Head.addChild(shape246_1);
    	        Head.addChild(shape253_2);
    	        WHEEL_1.addChild(shape42_3);
    	        RightArm_1.addChild(RightLowerArm_1);
    	        RightFoot_1.addChild(WHEEL_3);
    	        WHEEL_3.addChild(shape44_14);
    	        RightLowerArm.addChild(shape113);
    	        WHEEL_1.addChild(shape44_6);
    	        CHEST.addChild(torso_1);
    	        WHEEL_3.addChild(shape44_13);
    	        torso_1.addChild(shape38_29);
    	        WHEEL.addChild(shape44_2);
    	        shape1.addChild(shape4);
    	        RightLowerArm_1.addChild(shape124_5);
    	        RightFoot.addChild(shape320_1);
    	        WHEEL_3.addChild(shape42_6);
    	        RightLowerLeg.addChild(shape113_7);
    	        Head.addChild(shape246);
    	        RightLowerLeg.addChild(shape113_9);
    	        torso_1.addChild(shape38_17);
    	        RightLowerLeg.addChild(RightFoot);
    	        mainchest.addChild(shape87);
    	        torso_1.addChild(shape38_15);
    	        RightFoot.addChild(shape205);
    	        rightheadlight.addChild(shape18_5);
    	        RightFoot_1.addChild(shape204_1);
    	        torso.addChild(shape47);
    	        RightLowerLeg.addChild(shape113_6);
    	        rightheadlight.addChild(shape18_3);
    	        torso_1.addChild(shape38_31);
    	        chest.addChild(shape83_1);
    	        rightbumper.addChild(rightbumper_3);
    	        RightFoot_1.addChild(shape207_2);
    	        leftheadlight.addChild(shape18);
    	        torso_1.addChild(shape38_24);
    	        shape1.addChild(shape6_1);
    	        WHEEL.addChild(shape46_1);
    	        RightArm_1.addChild(shape108_12);
    	        mainchest.addChild(shape38_13);
    	        torso.addChild(shape38_11);
    	        RightLowerArm_1.addChild(shape119_5);
    	        RightLowerLeg.addChild(shape113_4);
    	        RightLowerLeg.addChild(shape119_3);
    	        RightFoot.addChild(shape205_3);
    	        torso.addChild(shape38_8);
    	        RightFoot.addChild(shape207_1);
    	        RightLowerLeg_1.addChild(shape113_17);
    	        RightLowerLeg_1.addChild(shape116_3);
    	        RightFoot_1.addChild(shape201_1);
    	        Head.addChild(shape256_3);
    	        WHEEL_2.addChild(shape42_5);
    	        RightLowerArm_1.addChild(shape116_2);
    	        RightFoot_1.addChild(shape202_1);
    	        Head.addChild(shape246_2);
    	        RightLowerArm_1.addChild(shape113_13);
    	        torso_1.addChild(shape38_30);
    	        WHEEL_2.addChild(WHEELee_2);
    	        torso.addChild(shape38_2);
    	        mainchest.addChild(shape88);
    	        torso.addChild(shape38_3);
    	        WHEEL.addChild(shape42);
    	        mainchest.addChild(leftheadlight_1);
    	        WHEEL_3.addChild(WHEELee_3);
    	        Head.addChild(shape246_5);
    	        RightLowerArm_1.addChild(shape115_5);
    	        RightLowerArm.addChild(shape119);
    	        RightLowerArm.addChild(shape124);
    	        RightFoot.addChild(WHEEL_1);
    	        Head.addChild(shape259);
    	        RightLowerLeg_1.addChild(shape113_18);
    	    





//        this.bipedHead.addChild(Head);
//
//        this.bipedBody.addChild(CHEST);
//
//        this.bipedLeftArm.addChild(RightArm);
//
//        this.bipedLeftLeg.addChild(RightLeg);
//
//        this.bipedRightArm.addChild(RightArm_1);
//
//        this.bipedRightLeg.addChild(RightLeg_1);
        
    	  this.CHEST.addChild(RightArm);
    	  this.CHEST.addChild(RightArm_1);

        
        
        animator = ModelAnimator.create();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.85F, 0.823F, 0.85F);
//        super.render(entity, f, f1, f2, f3, f4, f5);
        GlStateManager.translate(0.0F, 0.0F * f5, 0.0F);
        this.Head.render(f5);
        this.CHEST.render(f5);
//        this.RightArm.render(f5);
//        this.RightArm_1.render(f5);
        this.RightLeg.render(f5);
        this.RightLeg_1.render(f5);
        GlStateManager.popMatrix();
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
       

    }
    
    public void setRotateAngle(ModelRenderer ModelRenderer, float x, float y, float z) {
        ModelRenderer.rotateAngleX = x;
        ModelRenderer.rotateAngleY = y;
        ModelRenderer.rotateAngleZ = z;
    }

    @Override
   	 public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	    {
	        boolean flag = entityIn instanceof EntityLivingBase && ((EntityLivingBase)entityIn).getTicksElytraFlying() > 4;
	        this.Head.rotateAngleY = netHeadYaw * 0.017453292F;

	        if (flag)
	        {
	            this.Head.rotateAngleX = -((float)Math.PI / 4F);
	        }
	        else
	        {
	            this.Head.rotateAngleX = headPitch * 0.017453292F;
	        }

	        this.bipedBody.rotateAngleY = 0.0F;
	        this.bipedRightArm.rotationPointZ = 0.0F;
	        this.bipedRightArm.rotationPointX = -5.0F;
	        this.bipedLeftArm.rotationPointZ = 0.0F;
	        this.bipedLeftArm.rotationPointX = 5.0F;
	        float f = 1.0F;

	        if (flag)
	        {
	            f = (float)(entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
	            f = f / 0.2F;
	            f = f * f * f;
	        }

	        if (f < 1.0F)
	        {
	            f = 1.0F;
	        }

	        this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
	        this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
	        this.bipedRightArm.rotateAngleZ = 0.0F;
	        this.bipedLeftArm.rotateAngleZ = 0.0F;
	        this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
	        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f;
	        this.bipedRightLeg.rotateAngleY = 0.0F;
	        this.bipedLeftLeg.rotateAngleY = 0.0F;
	        this.bipedRightLeg.rotateAngleZ = 0.0F;
	        this.bipedLeftLeg.rotateAngleZ = 0.0F;

	        if (this.isRiding)
	        {
	            this.bipedRightArm.rotateAngleX += -((float)Math.PI / 5F);
	            this.bipedLeftArm.rotateAngleX += -((float)Math.PI / 5F);
	            this.bipedRightLeg.rotateAngleX = -1.4137167F;
	            this.bipedRightLeg.rotateAngleY = ((float)Math.PI / 10F);
	            this.bipedRightLeg.rotateAngleZ = 0.07853982F;
	            this.bipedLeftLeg.rotateAngleX = -1.4137167F;
	            this.bipedLeftLeg.rotateAngleY = -((float)Math.PI / 10F);
	            this.bipedLeftLeg.rotateAngleZ = -0.07853982F;
	        }

	        this.bipedRightArm.rotateAngleY = 0.0F;
	        this.bipedRightArm.rotateAngleZ = 0.0F;

	        

	        

	        if (this.isSneak)
	        {
	            this.bipedBody.rotateAngleX = 0.5F;
	            this.bipedRightArm.rotateAngleX += 0.4F;
	            this.bipedLeftArm.rotateAngleX += 0.4F;
	            this.bipedRightLeg.rotationPointZ = 4.0F;
	            this.bipedLeftLeg.rotationPointZ = 4.0F;
	            this.bipedRightLeg.rotationPointY = 9.0F;
	            this.bipedLeftLeg.rotationPointY = 9.0F;
	            this.bipedHead.rotationPointY = 1.0F;
	            
	            this.Head.rotationPointY = 1.50F ;
		        this.CHEST.rotationPointY = 1.0F;
//		        this.RightArm.rotationPointY = 1.0F;
//		        this.RightArm_1.rotationPointY = 1.0F;
		        
//		        this.RightLeg.rotationPointY = 1.0F;
//		        this.RightLeg_1.rotationPointY = 1.0F ;
		        
		       
		        this.RightArm.rotateAngleZ = -0.4F;
		        this.RightLowerArm.rotateAngleZ = 0.3F; 
		        
		        this.RightArm_1.rotateAngleZ = 0.4F;
		        this.RightLowerArm_1.rotateAngleZ = -0.3F; 
		        
		        this.RightLeg_1.rotateAngleX = 0.5F;
	        }
	        else
	        {
//	        	this.WHEEL.rotateAngleX = 0;
//	        	this.WHEEL_1.rotateAngleX = 0;
//	        	this.WHEEL_2.rotateAngleX = 0;
//	        	this.WHEEL_3.rotateAngleX = 0;
	        	
	        	this.RightArm.rotateAngleZ = 0;
		        this.RightLowerArm.rotateAngleZ = 0;
		        
	        	this.RightArm_1.rotateAngleZ = 0;
		        this.RightLowerArm_1.rotateAngleZ = 0; 
		        
		        
	        	
	            this.bipedBody.rotateAngleX = 0.0F;
	            this.bipedRightLeg.rotationPointZ = 0.1F;
	            this.bipedLeftLeg.rotationPointZ = 0.1F;
	            this.bipedRightLeg.rotationPointY = 12.0F;
	            this.bipedLeftLeg.rotationPointY = 12.0F;
	            this.bipedHead.rotationPointY = 0.0F;
	            
	            this.Head.rotationPointY = 1.50F ;
		        this.CHEST.rotationPointY = 1.0F;
		        this.RightArm.rotationPointY = 3.50F;
		        this.RightArm_1.rotationPointY = 3.50F;
		        this.RightLeg.rotationPointY = 13.0F;
		        this.RightLeg_1.rotationPointY = 13.0F ;
		        this.RightLeg.rotationPointZ = 0.20F;
		        this.RightLeg_1.rotationPointZ = 0.20F ;
	        }
	        

	        this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	        this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

	        if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
	        {
	            this.bipedRightArm.rotateAngleY = -0.1F + this.Head.rotateAngleY;
	            this.bipedLeftArm.rotateAngleY = 0.1F + this.Head.rotateAngleY + 0.4F;
	            this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
	            this.bipedLeftArm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
	        }
	        else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
	        {
	            this.bipedRightArm.rotateAngleY = -0.1F + this.Head.rotateAngleY - 0.4F;
	            this.bipedLeftArm.rotateAngleY = 0.1F + this.Head.rotateAngleY;
	            this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
	            this.bipedLeftArm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
	        }

	        copyModelAngles(this.bipedHead, this.bipedHeadwear);
	        
	        
	        
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	        float upwardPose = (float) (1 / (1 + Math.exp(-20 * (entityIn.motionY + 0.01))));
		    float downwardPose = (float) (1 / (1 + Math.exp(10 * (entityIn.motionY + 0.2))));
		    
	    	//this prevents helmets from always facing south, and the armor "breathing" on the stand
	        if (entityIn instanceof EntityArmorStand) {
	            EntityArmorStand entityarmorstand = (EntityArmorStand) entityIn;
	            this.Head.rotateAngleX = 0.017453292F * entityarmorstand.getHeadRotation().getX();
	            this.Head.rotateAngleY = 0.017453292F * entityarmorstand.getHeadRotation().getY();
	            this.Head.rotateAngleZ = 0.017453292F * entityarmorstand.getHeadRotation().getZ();
	            this.Head.setRotationPoint(0.0F, 1.0F, 0.0F);

	            this.CHEST.rotateAngleX = 0.017453292F * entityarmorstand.getBodyRotation().getX();
	            this.CHEST.rotateAngleY = 0.017453292F * entityarmorstand.getBodyRotation().getY();
	            this.CHEST.rotateAngleZ = 0.017453292F * entityarmorstand.getBodyRotation().getZ();

	            this.RightArm_1.rotateAngleX = 0.017453292F * entityarmorstand.getLeftArmRotation().getX();
	            this.RightArm_1.rotateAngleY = 0.017453292F * entityarmorstand.getLeftArmRotation().getY();
	            this.RightArm_1.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftArmRotation().getZ();

	            this.RightArm.rotateAngleX = 0.017453292F * entityarmorstand.getRightArmRotation().getX();
	            this.RightArm.rotateAngleY = 0.017453292F * entityarmorstand.getRightArmRotation().getY();
	            this.RightArm.rotateAngleZ = 0.017453292F * entityarmorstand.getRightArmRotation().getZ();

	            this.bipedLeftLeg.rotateAngleX = 0.017453292F * entityarmorstand.getLeftLegRotation().getX();
	            this.bipedLeftLeg.rotateAngleY = 0.017453292F * entityarmorstand.getLeftLegRotation().getY();
	            this.bipedLeftLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftLegRotation().getZ();
	            this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);

	            this.RightLeg.rotateAngleX = 0.017453292F * entityarmorstand.getRightLegRotation().getX();
	            this.RightLeg.rotateAngleY = 0.017453292F * entityarmorstand.getRightLegRotation().getY();
	            this.RightLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getRightLegRotation().getZ();
	            this.RightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
	            copyModelAngles(this.bipedHead, this.bipedHeadwear);
	        } else
	        	
	        	
	        	if (entityIn.onGround){	
	        this.CHEST.rotateAngleY = MathHelper.cos(limbSwing * 0.4662F ) * .25F * limbSwingAmount ;
	        	}
	        this.RightLowerLeg.rotateAngleX =  MathHelper.cos(limbSwing * 0.4662F  ) * 2F * limbSwingAmount  ;
	        this.RightLowerLeg_1.rotateAngleX =  MathHelper.cos(limbSwing * 0.4662F  + (float) Math.PI) * 2F * limbSwingAmount ;
	        
	        this.RightLowerLeg.rotateAngleX =  MathHelper.cos(limbSwing * 0.4662F  ) * 2F * limbSwingAmount  ;
	        this.RightLowerLeg_1.rotateAngleX =  MathHelper.cos(limbSwing * 0.4662F  + (float) Math.PI) * 2F * limbSwingAmount ;
        
	        this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.4662F) * 1.5F * limbSwingAmount  ;
	        this.RightLeg_1.rotateAngleX = MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * 1.5F * limbSwingAmount ;

	        if (this.RightLeg_1.rotateAngleX > 0.3F){
	        	this.RightLeg_1.rotateAngleX = 0.3F;
	        }else{
		        this.RightLeg_1.rotateAngleX = 0f + MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * 1F * limbSwingAmount ;
	        }
	        if (this.RightLeg.rotateAngleX > 0.3F){
	        	this.RightLeg.rotateAngleX = 0.3F;
	        }else{
	        	this.RightLeg.rotateAngleX = 0f + MathHelper.cos(limbSwing * 0.4662F) * 1F * limbSwingAmount ;
	        }
	        
	       
	        
	        
	        if (this.RightLowerLeg_1.rotateAngleX < 0.1F){
	        	this.RightLowerLeg_1.rotateAngleX = 0.1F* limbSwingAmount ;
	        }
	        
	        if (this.RightLowerLeg.rotateAngleX < 0.1F){
	        	this.RightLowerLeg.rotateAngleX = 0.1F* limbSwingAmount;
	        }
	     
	        if (this.RightLowerLeg_1.rotateAngleX > 1.F){
	        	this.RightLowerLeg_1.rotateAngleX = 1.F* limbSwingAmount;
	        }
	     
	        if (this.RightLowerLeg.rotateAngleX > 1.F){
	        	this.RightLowerLeg.rotateAngleX = 1.F* limbSwingAmount;
	        }
	        
	      

	        this.Head.offsetY = -MathHelper.cos(limbSwing * 0.4662F*2 ) * .05F * limbSwingAmount ;
	        this.CHEST.offsetY = -MathHelper.cos(limbSwing * 0.4662F*2 ) * .05F * limbSwingAmount ;
	        this.RightLeg.offsetY = -MathHelper.cos(limbSwing * 0.4662F*2 ) * .05F * limbSwingAmount ;
	        this.RightLeg_1.offsetY = -MathHelper.cos(limbSwing * 0.4662F*2 ) * .05F * limbSwingAmount ;
	        
	        
	        this.RightArm_1.rotateAngleX = MathHelper.cos(limbSwing * 0.4662F) * .8F * limbSwingAmount;
	        this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * .8F * limbSwingAmount  ;
	        
	        this.RightLowerArm_1.rotateAngleX = MathHelper.cos(limbSwing * 0.4662F) * .9F * limbSwingAmount;
	        this.RightLowerArm.rotateAngleX = MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * .9F * limbSwingAmount  ;


	        this.RightLowerArm.rotateAngleX -= 0.1;
	        this.RightLowerArm_1.rotateAngleX -= 0.1;
	      
	        if (this.RightLowerArm_1.rotateAngleX > 0){
	        	this.RightLowerArm_1.rotateAngleX = 0;
	        }
	        if (this.RightLowerArm.rotateAngleX > 0){
	        	this.RightLowerArm.rotateAngleX = 0;
	        }
	        
	        if (isSneak)
	        {
	        	 if (entityIn instanceof EntityPlayer) { 
		    		  EntityPlayer entityplayer = (EntityPlayer) entityIn;
	        	if (!entityplayer.capabilities.isFlying){
	        	this.CHEST.rotateAngleX = 0.3F;
	        	this.CHEST.rotationPointZ = -3.5F;
	        	this.CHEST.rotationPointY = 1F;
	        	
	        	this.Head.rotationPointZ = -4F;
	        	this.Head.rotationPointY = 2F;
	        	
	        	this.RightLeg.rotateAngleZ = -0.3F;
	        	this.RightLeg_1.rotateAngleZ = 0.3F;
	        	
	        	this.RightLeg.rotateAngleY = -0.15F;
	        	this.RightLeg_1.rotateAngleY = 0.15F;
	        	
	        	this.RightLeg.rotateAngleX = -0.7F +MathHelper.cos(limbSwing * 0.4662F ) * 1F * limbSwingAmount ;
	        	this.RightLeg_1.rotateAngleX = -0.7F +MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * 1F * limbSwingAmount  ;
	        	
	        	this.RightLowerLeg.rotateAngleX = +1.1F +MathHelper.cos(limbSwing * 0.4662F ) * 1F * limbSwingAmount ;
	        	this.RightLowerLeg_1.rotateAngleX = +1.1F +MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * 1F * limbSwingAmount ;
	        	
	        	this.RightArm.rotateAngleX = 0.7F +MathHelper.cos(limbSwing * 0.4662F ) * .8F * limbSwingAmount ;
	        	this.RightArm_1.rotateAngleX = 0.7F +MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * .8F * limbSwingAmount ;
	        	
	        	this.RightLowerArm.rotateAngleX = -1.1F +MathHelper.cos(limbSwing * 0.4662F ) * .9F * limbSwingAmount ;
	        	this.RightLowerArm_1.rotateAngleX = -1.1F +MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * .9F * limbSwingAmount ;
	        	
	        	this.RightFoot.rotateAngleX = -0.4F;
	        	this.RightFoot_1.rotateAngleX = -0.4F;
	        	
	        	this.RightFoot.rotateAngleZ = 0.15F;
	        	this.RightFoot_1.rotateAngleZ = -0.15F;
	        	
	        	this.RightFoot.rotateAngleY = 0.15F;
	        	this.RightFoot_1.rotateAngleY = -0.15F;
	        	
	        	}
	        	 }
	        }else
	        {
	        	this.CHEST.rotateAngleX = 0F;
	        	this.CHEST.rotationPointZ = 0F;
	        	this.CHEST.rotationPointY = 0F;
	        	
	        	this.Head.rotationPointZ = 0F;
	        	this.Head.rotationPointY = 0.5F;
	        	
	        	this.RightFoot.rotateAngleX = 0F;
        		this.RightFoot_1.rotateAngleX = 0F;
        		this.RightFoot.rotateAngleZ = 0F;
	        	this.RightFoot_1.rotateAngleZ = 0F;
	        	this.RightFoot.rotateAngleY = 0F;
	        	this.RightFoot_1.rotateAngleY = 0F;
	        	
	        	
	        	this.RightLeg.rotationPointX = 1;
	        	this.RightLeg.rotateAngleY = -0F;
	        	this.RightLeg_1.rotateAngleY = 0F;
	      
        		this.RightLeg.rotateAngleZ = -0.15F;
        		this.RightLeg_1.rotateAngleZ = 0.15F;
        		
	        	 
	        }
	        switch (this.leftArmPose)
	        {
	            case EMPTY:
	                this.RightArm.rotateAngleY = 0.0F;
	                break;
	            case BLOCK:
	                this.RightArm.rotateAngleX = this.RightArm.rotateAngleX * 0.5F - 0.9424779F;
	                this.RightArm.rotateAngleY = 0.5235988F;
	                break;
	            case ITEM:
	                this.RightArm.rotateAngleX = this.RightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
	                this.RightArm.rotateAngleY = 0.0F;
			default:
				break;
	        }

	        switch (this.rightArmPose)
	        {
	            case EMPTY:
	                this.RightArm_1.rotateAngleY = 0.0F;
	                break;
	            case BLOCK:
	                this.RightArm_1.rotateAngleX = this.RightArm_1.rotateAngleX * 0.5F - 0.9424779F;
	                this.RightArm_1.rotateAngleY = -0.5235988F;
	                break;
	            case ITEM:
	                this.RightArm_1.rotateAngleX = this.RightArm_1.rotateAngleX * 0.7F - ((float)Math.PI / 10F);
	                this.RightArm_1.rotateAngleY = 0.0F;
			default:
				break;
	        }
	        
	        if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
	        {
	            this.RightArm_1.rotateAngleY = -0.1F + this.Head.rotateAngleY;
	            this.RightArm.rotateAngleY = 0.1F + this.Head.rotateAngleY + 0.4F;
	            this.RightArm_1.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
	            this.RightArm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
	        }
	        else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
	        {
	            this.RightArm_1.rotateAngleY = -0.1F + this.Head.rotateAngleY - 0.4F;
	            this.RightArm.rotateAngleY = 0.1F + this.Head.rotateAngleY;
	            this.RightArm_1.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
	            this.RightArm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
	        }
	      this.bipedLeftArm.rotateAngleX += 0.1F;
	      this.bipedRightArm.rotateAngleX += 0.1F;
	      
	      if (!entityIn.onGround){
	    	  if (entityIn instanceof EntityPlayer) 
	    	  {
	    		  EntityPlayer entityplayer = (EntityPlayer) entityIn;
	    	  if (!entityplayer.capabilities.isFlying)
	    	  	{
	    		  if(entityplayer.motionY < 0)
	    			  
	    		  
	        	 this.RightLeg.rotateAngleZ = 0;
	        	 this.RightLeg_1.rotateAngleZ = 0;
	        	 this.RightLeg.rotateAngleY = 0;
	        	 this.RightLeg_1.rotateAngleY = 0;
	        	 
	        	 	this.RightArm.rotateAngleZ = -0.4F  *downwardPose;
		        	this.RightArm_1.rotateAngleZ = 0.4F  *downwardPose;
	        	 
	        	 	this.RightArm.rotateAngleX = 0.7F  *downwardPose;
		        	this.RightArm_1.rotateAngleX = 0.7F  *downwardPose;
		        	
		        	this.RightLowerArm.rotateAngleX = -1.1F  *downwardPose;
		        	this.RightLowerArm_1.rotateAngleX = -1.1F  *downwardPose;
		        	
	        	this.RightLeg.rotateAngleX = -1.8F *downwardPose;
	        	this.RightLeg_1.rotateAngleX = -0.8F *downwardPose;
	        	
	        	this.RightLowerLeg.rotateAngleX = 2.3F *downwardPose;
	        	this.RightLowerLeg_1.rotateAngleX = 1.2F *downwardPose;
	        	
	        	this.RightLeg.rotateAngleZ = -0.15F;
        		this.RightLeg_1.rotateAngleZ = 0.15F;
	        	
	        	this.CHEST.rotateAngleX= 0.5F *downwardPose;
	        	this.CHEST.rotationPointZ = -6F*downwardPose;
	        	this.CHEST.rotationPointY = 1F*downwardPose;
	        	
	        	this.Head.rotationPointZ = -5F*downwardPose;
	        	this.Head.rotationPointY = 1F;
	        	this.Head.rotationPointY = 1.5F*downwardPose;
	        	
	        	
//	        	if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
//	        		f = 1F;
//	        		  if(entityplayer.motionY > 0)	{
//	        	 this.RightLeg.rotateAngleZ = 0;
//	        	 this.RightLeg_1.rotateAngleZ = 0;
//	        	 this.RightLeg.rotateAngleY = 0;
//	        	 this.RightLeg_1.rotateAngleY = 0;
//	        	 
//	        	 	this.RightArm.rotateAngleZ = -0.4F *f *upwardPose;
//		        	this.RightArm_1.rotateAngleZ = 0.4F *f *upwardPose;
//	        	 
//	        	 	this.RightArm.rotateAngleX = 0.7F *f *upwardPose;
//		        	this.RightArm_1.rotateAngleX = 0.7F *f *upwardPose;
//		        	
//		        	this.RightLowerArm.rotateAngleX = -1.1F *f *upwardPose;
//		        	this.RightLowerArm_1.rotateAngleX = -1.1F *f *upwardPose;
//		        	
//	        	this.RightLeg.rotateAngleX = -0.8F *f *upwardPose;
//	        	this.RightLeg_1.rotateAngleX = -1.8F *f *upwardPose;
//	        	
//	        	this.RightLowerLeg.rotateAngleX = 1.2F *f *upwardPose;
//	        	this.RightLowerLeg_1.rotateAngleX = 2.3F *f *upwardPose;
//	        	
//	        	this.RightLeg.rotateAngleZ = -0.15F;
//       		this.RightLeg_1.rotateAngleZ = 0.15F;
//	        	
//	        	this.CHEST.rotateAngleX= 0.5F *f *upwardPose;
//	        	this.CHEST.rotationPointZ = -6F *f *upwardPose;
//	        	this.CHEST.rotationPointY = 1F *f *upwardPose;
//	        	
//	        	this.Head.rotationPointZ = -5F *f *upwardPose;
//	        	this.Head.rotationPointY = 1F;
//	        	this.Head.rotationPointY = 1.5F *f *upwardPose;
//	        		  }
	    	  	}
	    	}
	    }
	      
	      
//	      float upwardPose = (float) (1 / (1 + Math.exp(-20 * (entityIn.motionY + 0.2))));
//	      float downwardPose = (float) (1 / (1 + Math.exp(10 * (entityIn.motionY + 0.2))));
	      
	      //falling
//	    if (!(downwardPose == 1)) { 
//	    this.CHEST.rotateAngleX = 0.3F* downwardPose;
//      	this.CHEST.rotationPointZ = -3.5F* downwardPose;
//      	this.CHEST.rotationPointY = 1F* downwardPose;
//      	
//      	this.Head.rotationPointZ = -4F* downwardPose;
//      	this.Head.rotationPointY = 2F* downwardPose;
//      	
//      	this.RightLeg.rotateAngleZ = -0.3F* downwardPose;
//      	this.RightLeg_1.rotateAngleZ = 0.3F* downwardPose;
//      	
//      	this.RightLeg.rotateAngleY = -0.15F* downwardPose;
//      	this.RightLeg_1.rotateAngleY = 0.15F* downwardPose;
//      	
//      	this.RightLeg.rotateAngleX = -0.7F +MathHelper.cos(limbSwing * 0.4662F ) * 1F * limbSwingAmount * downwardPose;
//      	this.RightLeg_1.rotateAngleX = -0.7F +MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * 1F * limbSwingAmount * downwardPose;
//      	
//      	this.RightLowerLeg.rotateAngleX = +1.1F +MathHelper.cos(limbSwing * 0.4662F ) * 1F * limbSwingAmount * downwardPose;
//      	this.RightLowerLeg_1.rotateAngleX = +1.1F +MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * 1F * limbSwingAmount * downwardPose;
//      	
//      	this.RightArm.rotateAngleX = 0.7F +MathHelper.cos(limbSwing * 0.4662F ) * .8F * limbSwingAmount * downwardPose;
//      	this.RightArm_1.rotateAngleX = 0.7F +MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * .8F * limbSwingAmount * downwardPose;
//      	
//      	this.RightLowerArm.rotateAngleX = -1.1F +MathHelper.cos(limbSwing * 0.4662F ) * .9F * limbSwingAmount * downwardPose;
//      	this.RightLowerArm_1.rotateAngleX = -1.1F +MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * .9F * limbSwingAmount * downwardPose;
//      	
//      	this.RightFoot.rotateAngleX = -0.4F* downwardPose;
//      	this.RightFoot_1.rotateAngleX = -0.4F* downwardPose;
//      	
//      	this.RightFoot.rotateAngleZ = 0.15F* downwardPose;
//      	this.RightFoot_1.rotateAngleZ = -0.15F* downwardPose;
//      	
//      	this.RightFoot.rotateAngleY = 0.15F* downwardPose;
//      	this.RightFoot_1.rotateAngleY = -0.15F* downwardPose;
//	    }else
//        {
//        	this.CHEST.rotateAngleX = 0F;
//        	this.CHEST.rotationPointZ = 0F;
//        	this.CHEST.rotationPointY = 0F;
//        	
//        	this.Head.rotationPointZ = 0F;
//        	this.Head.rotationPointY = 0.5F;
//        	
//        	this.RightFoot.rotateAngleX = 0F;
//    		this.RightFoot_1.rotateAngleX = 0F;
//    		this.RightFoot.rotateAngleZ = 0F;
//        	this.RightFoot_1.rotateAngleZ = 0F;
//        	this.RightFoot.rotateAngleY = 0F;
//        	this.RightFoot_1.rotateAngleY = 0F;
//        	
//        	
//        	this.RightLeg.rotateAngleY = -0F;
//        	this.RightLeg_1.rotateAngleY = 0F;
//      
//    		this.RightLeg.rotateAngleZ = -0.15F;
//    		this.RightLeg_1.rotateAngleZ = 0.15F;
//    		}
//	      this.RightLeg.rotateAngleX = -0.3F* downwardPose ;
	            super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	    }
    
    public void doFallingAnimations(EntityPlayer player, float progress, float limbSwing, float limbSwingAmount, float ticks, float rotationYaw, float rotationPitch, boolean wearingHead, boolean wearingChest, boolean wearingLegs, boolean wearingFeet)
    {
    	float upwardPose = (float) (1 / (1 + Math.exp(-20 * (player.motionY + 0.2))));
	      float downwardPose = (float) (1 / (1 + Math.exp(10 * (player.motionY + 0.2))));
//	      this.RightLeg.rotateAngle = -0.3F* downwardPose;
    }
    
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
//    	this.RightArm.rotateAngleZ = MathHelper.cos(limbSwing * 0.4662F ) * .8F * limbSwingAmount ;
//    	this.RightArm_1.rotateAngleZ = MathHelper.cos(limbSwing * 0.4662F + (float) Math.PI) * .8F * limbSwingAmount ;
    }

	    public void setModelAttributes(ModelBase model)
	    {
	        super.setModelAttributes(model);

	        if (model instanceof ModelBiped)
	        {
	            ModelBiped modelbiped = (ModelBiped)model;
	            this.leftArmPose = modelbiped.leftArmPose;
	            this.rightArmPose = modelbiped.rightArmPose;
	            this.isSneak = modelbiped.isSneak;
	        }
	    }

	    public void setVisible(boolean visible)
	    {
	        this.bipedHead.showModel = visible;
	        this.bipedHeadwear.showModel = visible;
	        this.bipedBody.showModel = visible;
	        this.bipedRightArm.showModel = visible;
	        this.bipedLeftArm.showModel = visible;
	        this.bipedRightLeg.showModel = visible;
	        this.bipedLeftLeg.showModel = visible;
	    }

	    public void postRenderArm(float scale, EnumHandSide side)
	    {
	        this.getArmForSide(side).postRender(scale);
	    }

	    protected ModelRenderer getArmForSide(EnumHandSide side)
	    {
	        return side == EnumHandSide.LEFT ? this.RightArm : this.RightArm_1;
	    }

	    protected EnumHandSide getMainHand(Entity entityIn)
	    {
	        if (entityIn instanceof EntityLivingBase)
	        {
	            EntityLivingBase entitylivingbase = (EntityLivingBase)entityIn;
	            EnumHandSide enumhandside = entitylivingbase.getPrimaryHand();
	            return entitylivingbase.swingingHand == EnumHand.MAIN_HAND ? enumhandside : enumhandside.opposite();
	        }
	        else
	        {
	            return EnumHandSide.RIGHT;
	        }
	    }

	    @SideOnly(Side.CLIENT)
	    public static enum ArmPose
	    {
	        EMPTY,
	        ITEM,
	        BLOCK,
	        BOW_AND_ARROW;
	    }
 
    	
    	

   


	
    
	
//	public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5){
//		Vurp vurp = (Vurp) entity;
//		animator.update(vurp);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
