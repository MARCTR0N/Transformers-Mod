package com.marctron.transformersmod.transformers.transformer;


import com.marctron.transformersmod.transformers.models.ModelDecepticonVehicon;
import com.marctron.transformersmod.transformers.models.g1.optimusprime.ModelG1OptimusPrime;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrime;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeAltmode;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid1;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid2;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid3;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid4;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid5;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid6;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid7;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid8;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid9;
import com.marctron.transformersmod.transformers.models.sideswipe.ModelSideswipeAltmode;
import com.marctron.transformersmod.transformers.models.sideswipe.ModelSideswipeMid;
import com.marctron.transformersmod.transformers.models.sideswipe.ModelSideswipeMid2;
import com.marctron.transformersmod.transformers.models.sideswipe.SideswipeModel;
import com.marctron.transformersmod.transformers.models.starscream.ModelStarscream;
import com.marctron.transformersmod.transformers.models.starscream.ModelStarscreamAltmode;
import com.marctron.transformersmod.transformers.models.starscream.ModelStarscreamMid1;
import com.marctron.transformersmod.transformers.models.starscream.ModelStarscreamMid2;
import com.marctron.transformersmod.transformers.models.starscream.ModelStarscreamMid3;
import com.marctron.transformersmod.transformers.models.stealth.movieop.ModelMovieOptimusPrimeAltmodeWeaponized;
import com.marctron.transformersmod.transformers.models.stealth.movieop.ModelMovieOptimusPrimeAltmodeWeaponizedMid1;
import com.marctron.transformersmod.transformers.models.stealth.movieop.ModelMovieOptimusPrimeAltmodeWeaponizedMid2;
import com.marctron.transformersmod.transformers.models.stealth.movieop.ModelMovieOptimusPrimeAltmodeWeaponizedMid3;
import com.marctron.transformersmod.transformers.models.subwoofer.ModelSubwoofer1;
import com.marctron.transformersmod.transformers.models.subwoofer.ModelSubwoofer2;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarn2Mid1;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarn2Mid2;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarn2Mid3;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarn2Mid4;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarnAltmode;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarnLegs;
import com.marctron.transformersmod.transformers.models.tarn.TarnChest;
import com.marctron.transformersmod.transformers.models.tfpmagnus.ModelTFPMagnus;
import com.marctron.transformersmod.transformers.models.tfpmagnus.ModelTFPUltraMagnuspart1;
import com.marctron.transformersmod.transformers.models.tfpmagnus.ModelTFPUltraMagnuspart2;
import com.marctron.transformersmod.transformers.models.tfpmagnus.ModelTFPUltraMagnuspart3;
import com.marctron.transformersmod.transformers.models.tfpmegatron.ModelMegatron;
import com.marctron.transformersmod.transformers.models.vehicon.ModelVehiconAltmode;
import com.marctron.transformersmod.transformers.models.vehicon.ModelVehiconMid;
import com.marctron.transformersmod.transformers.models.vurp.ModelVurp;
import com.marctron.transformersmod.transformers.models.wfc.autobots.sideswipe.ModelWFCSideswipe;
import com.marctron.transformersmod.transformers.models.wfc.decepticons.starscream.ModelWFCStarscream;
import com.marctron.transformersmod.transformers.models.wfc.stunticons.breakdown.ModelBreakdownBody;
import com.marctron.transformersmod.transformers.models.wfc.stunticons.breakdown.ModelBreakdownLeftArm;
import com.marctron.transformersmod.transformers.models.wfc.stunticons.breakdown.ModelBreakdownRightArm;
import com.marctron.transformersmod.transformers.models.wfc.stunticons.deadend.ModelDeadendpartB;
import com.marctron.transformersmod.transformers.models.wfc.stunticons.dragstrip.ModelDragstrip;
import com.marctron.transformersmod.transformers.models.wfc.stunticons.menasor.ModelMenasor;
import com.marctron.transformersmod.transformers.models.wfc.stunticons.motormaster.ModelMotormasterpartB;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ArmorTypes {

//G1 Optimus Prime 
	public static ModelG1OptimusPrime modelG1OptimusPrime = new ModelG1OptimusPrime();
				    
	public static ModelG1OptimusPrime getModelG1OptimusPrime() {
		return modelG1OptimusPrime;
	}
	
	
//WFC Starscream
	public static ModelWFCStarscream modelWFCStarscream = new ModelWFCStarscream();
			    
	public static ModelWFCStarscream getModelWFCStarscream() {
		return modelWFCStarscream;
	}

//WFC Sideswipe
	public static ModelWFCSideswipe modelWFCSideswipe = new ModelWFCSideswipe();
		    
	public static ModelWFCSideswipe getModelWFCSideswipe() {
		return modelWFCSideswipe;
	}	
	
	
//WFC Menasor
	public static ModelMenasor modelMenasor = new ModelMenasor();
	    
	public static ModelMenasor getModelMenasor() {
	    return modelMenasor;
	}	
	
//WFC Motormaster
	public static ModelMotormasterpartB modelMotormaster = new ModelMotormasterpartB();
    
    public static ModelMotormasterpartB getModelMotormaster() {
        return modelMotormaster;
    }
	
//WFC Deadend
	public static ModelDeadendpartB modelDeadend = new ModelDeadendpartB();
    
    public static ModelDeadendpartB getModelDeadend() {
        return modelDeadend;
    }
	
//WFC Dragstrip
	public static ModelDragstrip modelDragstrip = new ModelDragstrip();
    
    public static ModelDragstrip getModelDragstrip() {
        return modelDragstrip;
    }
	
//WFC Breakdown	
	public static ModelBreakdownBody modelBreakdownBody = new ModelBreakdownBody();
    
    public static ModelBreakdownBody getBreakdownBody() {
        return modelBreakdownBody;
    }
    
    public static ModelBreakdownLeftArm modelBreakdownLeftArm = new ModelBreakdownLeftArm();
    
    public static ModelBreakdownLeftArm getBreakdownLeftArm() {
        return modelBreakdownLeftArm;
    }
    
	public static ModelBreakdownRightArm modelBreakdownRightArm = new ModelBreakdownRightArm();
    
    public static ModelBreakdownRightArm getBreakdownRightArm() {
        return modelBreakdownRightArm;
    }
    
    //TFP Megatron	
    public static ModelMegatron modelTFPMegatron = new ModelMegatron();
        
        public static ModelMegatron getTFPMegatron() {
            return modelTFPMegatron;
        }
	
//TFP Magnus	
public static ModelTFPUltraMagnuspart1 modelMagnuspart1 = new ModelTFPUltraMagnuspart1();
    
    public static ModelTFPUltraMagnuspart1 getMagnuspart1() {
        return modelMagnuspart1;
    }
    
	public static ModelTFPMagnus modelTFPMagnus = new ModelTFPMagnus();
    
    public static ModelTFPMagnus getTFPMagnus() {
        return modelTFPMagnus;
    }
    
    public static ModelTFPUltraMagnuspart2 modelMagnuspart2 = new ModelTFPUltraMagnuspart2();
    
    public static ModelTFPUltraMagnuspart2 getMagnuspart2() {
        return modelMagnuspart2;
    }
    public static ModelTFPUltraMagnuspart3 modelMagnuspart3 = new ModelTFPUltraMagnuspart3();
    
    public static ModelTFPUltraMagnuspart3 getMagnuspart3() {
        return modelMagnuspart3;
    }
	
	
//Tarn
    public static ModelTarnLegs modelTarnLegs = new ModelTarnLegs();
    
    public static ModelTarnLegs getTarnLegsModel() {
        return modelTarnLegs;
    }
    
    public static TarnChest modelTarnChest = new TarnChest();

    public static TarnChest getTarnChestModel() {
        return modelTarnChest;
    }
    
    public static ModelTarnAltmode modelTarnAltmode = new ModelTarnAltmode();
    
    public static ModelTarnAltmode getModelTarnAltmode() {
        return modelTarnAltmode;
    }
    
    
    public static ModelTarn2Mid1 modelTarn2Mid1 = new ModelTarn2Mid1();
    
    public static ModelTarn2Mid1 getModelTarn2Mid1() {
        return modelTarn2Mid1;
    }
    
    public static ModelTarn2Mid2 modelTarn2Mid2 = new ModelTarn2Mid2();
    
    public static ModelTarn2Mid2 getModelTarn2Mid2() {
        return modelTarn2Mid2;
    }
    
    public static ModelTarn2Mid3 modelTarn2Mid3 = new ModelTarn2Mid3();
    
    public static ModelTarn2Mid3 getModelTarn2Mid3() {
        return modelTarn2Mid3;
    }
    
    public static ModelTarn2Mid4 modelTarn2Mid4 = new ModelTarn2Mid4();
    
    public static ModelTarn2Mid4 getModelTarn2Mid4() {
        return modelTarn2Mid4;
    }
    
//Vehicon
    public static ModelDecepticonVehicon modelCustomArmor = new ModelDecepticonVehicon();
    
    public static ModelDecepticonVehicon getModelCustomArmor() {
        return modelCustomArmor;
    }
    
    public static ModelVehiconAltmode modelVehiconAltmode = new ModelVehiconAltmode();
    
    public static ModelVehiconAltmode getModelVehiconAltmode() {
        return modelVehiconAltmode;
    }
    
    public static ModelVehiconMid modelVehiconMid = new ModelVehiconMid();
    
    public static ModelVehiconMid getModelVehiconMid() {
        return modelVehiconMid;
    }
    
//Sideswipe
    public static SideswipeModel modelSideswipe = new SideswipeModel();
    
    public static SideswipeModel getSideswipeModel() {
        return modelSideswipe;
    }
    
    public static ModelSideswipeAltmode modelSideswipeAltmode = new ModelSideswipeAltmode();
    
    public static ModelSideswipeAltmode getModelSideswipeAltmode() {
        return modelSideswipeAltmode;
    }
    
    public static ModelSideswipeMid modelSideswipeMid = new ModelSideswipeMid();
    
    public static ModelSideswipeMid getModelSideswipeMid() {
        return modelSideswipeMid;
    }
    
public static ModelSideswipeMid2 modelSideswipeMid2 = new ModelSideswipeMid2();
    
    public static ModelSideswipeMid2 getModelSideswipeMid2() {
        return modelSideswipeMid2;
    }
    
//Seekers
    public static ModelStarscream modelStarscream = new ModelStarscream();
    
    public static ModelStarscream getModelStarscream() {
        return modelStarscream;
    }
    
    public static ModelStarscreamAltmode modelStarscreamAltmode = new ModelStarscreamAltmode();
    
    public static ModelStarscreamAltmode getModelStarscreamAltmode() {
        return modelStarscreamAltmode;
    }
    
    public static ModelStarscreamMid1 modelStarscreamMid1 = new ModelStarscreamMid1();
    
    public static ModelStarscreamMid1 getModelStarscreamMid1() {
        return modelStarscreamMid1;
    }
    
    public static ModelStarscreamMid2 modelStarscreamMid2 = new ModelStarscreamMid2();
    
    public static ModelStarscreamMid2 getModelStarscreamMid2() {
        return modelStarscreamMid2;
    }
    
    public static ModelStarscreamMid3 modelStarscreamMid3 = new ModelStarscreamMid3();
    
    public static ModelStarscreamMid3 getModelStarscreamMid() {
        return modelStarscreamMid3;
    }
//Vurp
    
    public static ModelVurp modelVurp = new ModelVurp();
    
    public static ModelVurp getModelVurp() {
        return modelVurp;
    }
    
//Subwoofer
    
    public static ModelSubwoofer1 modelSubwoofer1 = new ModelSubwoofer1();
    
    public static ModelSubwoofer1 getModelSubwoofer1() {
        return modelSubwoofer1;
    }
    
 public static ModelSubwoofer2 modelSubwoofer2 = new ModelSubwoofer2();
    
    public static ModelSubwoofer2 getModelSubwoofer2() {
        return modelSubwoofer2;
    }
    
    
//Movie Optimus Prime
    //Stealth
    	public static ModelMovieOptimusPrimeAltmodeWeaponized modelMovieOptimusPrimeAltmodeWeaponized = new ModelMovieOptimusPrimeAltmodeWeaponized();
    
    	public static ModelMovieOptimusPrimeAltmodeWeaponized getModelMovieOptimusPrimeAltmodeWeaponized() {
    		return modelMovieOptimusPrimeAltmodeWeaponized;
    	}
    	
    	public static ModelMovieOptimusPrimeAltmodeWeaponizedMid1 modelMovieOptimusPrimeAltmodeWeaponizedMid1 = new ModelMovieOptimusPrimeAltmodeWeaponizedMid1();
        
    	public static ModelMovieOptimusPrimeAltmodeWeaponizedMid1 getModelMovieOptimusPrimeAltmodeWeaponizedMid1() {
    		return modelMovieOptimusPrimeAltmodeWeaponizedMid1;
    	}
    	
    	public static ModelMovieOptimusPrimeAltmodeWeaponizedMid2 modelMovieOptimusPrimeAltmodeWeaponizedMid2 = new ModelMovieOptimusPrimeAltmodeWeaponizedMid2();
        
    	public static ModelMovieOptimusPrimeAltmodeWeaponizedMid2 getModelMovieOptimusPrimeAltmodeWeaponizedMid2() {
    		return modelMovieOptimusPrimeAltmodeWeaponizedMid2;
    	}
    	
    	public static ModelMovieOptimusPrimeAltmodeWeaponizedMid3 modelMovieOptimusPrimeAltmodeWeaponizedMid3 = new ModelMovieOptimusPrimeAltmodeWeaponizedMid3();
        
    	public static ModelMovieOptimusPrimeAltmodeWeaponizedMid3 getModelMovieOptimusPrimeAltmodeWeaponizedMid3() {
    		return modelMovieOptimusPrimeAltmodeWeaponizedMid3;
    	}
    	
    
    public static ModelMovieOptimusPrime modelMovieOptimusPrime = new ModelMovieOptimusPrime();
    
    public static ModelMovieOptimusPrime getModelMovieOptimusPrime() {
        return modelMovieOptimusPrime;
    }
    
    public static ModelMovieOptimusPrimeAltmode modelMovieOptimusPrimeAltmode = new ModelMovieOptimusPrimeAltmode();
    
    public static ModelMovieOptimusPrimeAltmode getModelMovieOptimusPrimeAltmode() {
        return modelMovieOptimusPrimeAltmode;
    }
    
    public static ModelMovieOptimusPrimeMid1 modelMovieOptimusPrimeMid1 = new ModelMovieOptimusPrimeMid1();
    
    public static ModelMovieOptimusPrimeMid1 getModelMovieOptimusPrimeMid1() {
        return modelMovieOptimusPrimeMid1;
    }
    
    public static ModelMovieOptimusPrimeMid2 modelMovieOptimusPrimeMid2 = new ModelMovieOptimusPrimeMid2();
    
    public static ModelMovieOptimusPrimeMid2 getModelMovieOptimusPrimeMid2() {
        return modelMovieOptimusPrimeMid2;
    }
    
    public static ModelMovieOptimusPrimeMid3 modelMovieOptimusPrimeMid3 = new ModelMovieOptimusPrimeMid3();
    
    public static ModelMovieOptimusPrimeMid3 getModelMovieOptimusPrimeMid3() {
        return modelMovieOptimusPrimeMid3;
    }
    
    public static ModelMovieOptimusPrimeMid4 modelMovieOptimusPrimeMid4 = new ModelMovieOptimusPrimeMid4();
    
    public static ModelMovieOptimusPrimeMid4 getModelMovieOptimusPrimeMid4() {
        return modelMovieOptimusPrimeMid4;
    }
    
    public static ModelMovieOptimusPrimeMid5 modelMovieOptimusPrimeMid5 = new ModelMovieOptimusPrimeMid5();
    
    public static ModelMovieOptimusPrimeMid5 getModelMovieOptimusPrimeMid5() {
        return modelMovieOptimusPrimeMid5;
    }
    
    public static ModelMovieOptimusPrimeMid6 modelMovieOptimusPrimeMid6 = new ModelMovieOptimusPrimeMid6();
    
    public static ModelMovieOptimusPrimeMid6 getModelMovieOptimusPrimeMid6() {
        return modelMovieOptimusPrimeMid6;
    }
    
    public static ModelMovieOptimusPrimeMid7 modelMovieOptimusPrimeMid7 = new ModelMovieOptimusPrimeMid7();
    
    public static ModelMovieOptimusPrimeMid7 getModelMovieOptimusPrimeMid7() {
        return modelMovieOptimusPrimeMid7;
    }
    
    public static ModelMovieOptimusPrimeMid8 modelMovieOptimusPrimeMid8 = new ModelMovieOptimusPrimeMid8();
    
    public static ModelMovieOptimusPrimeMid8 getModelMovieOptimusPrimeMid8() {
        return modelMovieOptimusPrimeMid8;
    }
    
    public static ModelMovieOptimusPrimeMid9 modelMovieOptimusPrimeMid9 = new ModelMovieOptimusPrimeMid9();
    
    public static ModelMovieOptimusPrimeMid9 getModelMovieOptimusPrimeMid9() {
        return modelMovieOptimusPrimeMid9;
    }
}
