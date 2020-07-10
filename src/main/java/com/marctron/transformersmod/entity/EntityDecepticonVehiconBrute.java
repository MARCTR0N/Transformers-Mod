package com.marctron.transformersmod.entity;

import java.util.Calendar;

import javax.annotation.Nullable;

import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityBodyHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDecepticonVehiconBrute extends EntityDecepticon implements IAnimatedEntity{

	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.<Boolean>createKey(AbstractSkeleton.class, DataSerializers.BOOLEAN);		

	private RenderLivingBase renderer;
	
//	    		public ControlledAnimation walkAnim = new ControlledAnimation(10);
	
	public EntityDecepticonVehiconBrute(World world) {
		super(world);
		setPathPriority(PathNodeType.WATER, 0);
		
		
        this.initEntityAI();
		
		tasks.addTask(1, new AnimationAI<EntityDecepticonVehiconBrute>(this) {
            {
                setMutexBits(8);
            }

            @Override
            public void updateTask() {
                entity.motionX = 0;
                entity.motionZ = 0;
            }

			@Override
			public Animation getAnimation() {
				return null;
			}
        });
       
       
        
        experienceValue = 0;
        setSize(1F, 2.6F);
        active = true;
        stepHeight = 1;
	}
	
	@Override
	protected void initEntityAI() 
	{
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));	
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
	}
	
	
	  @Override
	    public int getAttack() {
	        return (int)(5 );
	    }
    
	
	protected void applyEntityAI()
    {
       
    }

	 @Override
	    protected PathNavigateGround createNavigator(World world) {
	        return new PathNavigateGround(this, world);
	    }
	
	@Override
    public void onUpdate() {
        super.onUpdate();
    
	}
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
//        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(RegistryHandler.ModItems.Hammer));
//		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(RegistryHandler.RocketLauncher));
    }
	
	@Override
    protected EntityBodyHelper createBodyHelper() {
        return new EntityBodyHelper(this);
    }
	
	@Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
       
//        return super.onInitialSpawn(difficulty, data);
        
      
        data = super.onInitialSpawn(difficulty, data);
            this.setEquipmentBasedOnDifficulty(difficulty);
            this.setEnchantmentBasedOnDifficulty(difficulty);
//            this.setCombatTask();
            this.setCanPickUpLoot(true);

            if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty())
            {
                Calendar calendar = this.world.getCurrentDate();

                if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F)
                {
                    this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
                    this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0F;
                }
            }

            return data;
        
    }
	
    @Override
    protected boolean canDespawn() {
        return false;
    }
	
	@Override
    protected void entityInit() {
        super.entityInit();
	}
	
	@Override
	public Animation[] getAnimations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animation getDeathAnimation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Animation getHurtAnimation() {
		// TODO Auto-generated method stub
		return null;
	}
	 @Override
	    protected void playStepSound(BlockPos pos, Block block) {}
	 
	 @SideOnly(Side.CLIENT)
	    public boolean isSwingingArms()
	    {
	        return ((Boolean)this.dataManager.get(SWINGING_ARMS)).booleanValue();
	    }
	 
	 @Override
	    public boolean attackEntityAsMob(Entity entity) {
	        return super.attackEntityAsMob(entity);
	    }
	 
	    @Override
	    public boolean attackEntityFrom(DamageSource source, float amount) {
	        Entity entitySource = source.getTrueSource();
	        if (entitySource != null) {
	            if ((!active || getAttackTarget() == null) && entitySource instanceof EntityLivingBase && !(entitySource instanceof EntityPlayer && ((EntityPlayer) entitySource).capabilities.isCreativeMode) && !(entitySource instanceof EntityDecepticonBrute)) setAttackTarget((EntityLivingBase) entitySource);

	                int arc = 220;
	                float entityHitAngle = (float) ((Math.atan2(entitySource.posZ - posZ, entitySource.posX - posX) * (180 / Math.PI) - 90) % 360);
	                float entityAttackingAngle = renderYawOffset % 360;
	                if (entityHitAngle < 0) {
	                    entityHitAngle += 360;
	                }
	                if (entityAttackingAngle < 0) {
	                    entityAttackingAngle += 360;
	                }
	                float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
	                if ((entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -arc + 90 / 2)) {
//	                    playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.4F, 0.1F);
	                    return false;
	                } else {
	                    if (currentAnim != null) {
	                        currentAnim.resetTask();
	                        AnimationHandler.INSTANCE.sendAnimationMessage(this, NO_ANIMATION);
	                    }
	                    return super.attackEntityFrom(source, amount);
	                }

	        }
	        return false;
	    }
	 
	 @Override
	    protected void applyEntityAttributes() {
	        super.applyEntityAttributes();
	        
	        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1);
	        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100);
	        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1);
	        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5 );
	        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.275 );
	        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6 );
	        
	    }


	    @SideOnly(Side.CLIENT)
	    public RenderLivingBase getRenderer() {
	    	return renderer;
	    }
	    
	    @SideOnly(Side.CLIENT)
	    public void setRenderer(RenderLivingBase renderer) {
	    	this.renderer = renderer;
	    }
	
}
