package com.marctron.transformersmod.transformers.models;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;

public class EmptyPlayerModel extends ModelPlayer {

	public EmptyPlayerModel(float modelSize, boolean smallArmsIn) {
		super(modelSize, smallArmsIn);
	    bipedLeftArmwear.cubeList.clear();
	    bipedRightArmwear.cubeList.clear();
	    bipedLeftLegwear.cubeList.clear();
	    bipedRightLegwear.cubeList.clear();
	    bipedBodyWear.cubeList.clear();
	    bipedHead.cubeList.clear();
	    bipedHeadwear.cubeList.clear();
	    bipedBody.cubeList.clear();
	    bipedRightArm.cubeList.clear();
	    bipedLeftArm.cubeList.clear();
	    bipedRightLeg.cubeList.clear();
	    bipedLeftLeg.cubeList.clear();
	}

}
