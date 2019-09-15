package com.marctron.transformersmod.entity;

import com.marctron.transformersmod.entity.ai.TFPathNavigateGround;

import net.ilexiconn.llibrary.client.model.tools.ControlledAnimation;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRangedBow;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityDecepticonVehiconVariant1 extends EntityDecepticon implements IAnimatedEntity{

				
				
	
//	    		public ControlledAnimation walkAnim = new ControlledAnimation(10);
	
	public EntityDecepticonVehiconVariant1(World world) {
		super(world);
		setPathPriority(PathNodeType.WATER, 0);
		
		
        this.initEntityAI();
		
		tasks.addTask(1, new AnimationAI<EntityDecepticonVehiconVariant1>(this) {
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
				// TODO Auto-generated method stub
				return null;
			}
        });
       
       
        
        experienceValue = 30;
        setSize(0.6F, 1.8F);
        active = true;
        stepHeight = 1;
	}
	
	@Override
	protected void initEntityAI() 
	{
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.15));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.5D, true));
//		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityMob.class, 4.0F, 2.2D, 2.2D));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 1.0F));
		
		 tasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, 0, true, false, null));
	        tasks.addTask(2, new EntityAIAttackMelee(this, 1, true));
		
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	
        
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
        tasks.addTask(4, new EntityAIAttackMelee(this, 0.5D, false));
//        tasks.addTask(5, new EntityAIWander(this, 0.4));
        tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(8, new EntityAILookIdle(this));
	}
	
	
	  @Override
	    public int getAttack() {
	        return (int)(5 );
	    }
    
	
//	protected void applyEntityAI()
//    {
//        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
//        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityPigZombie.class}));
//        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
//        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
//        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
//    }

	 @Override
	    protected PathNavigate createNavigator(World world) {
	        return new TFPathNavigateGround(this, world);
	    }
	
	@Override
    public void onUpdate() {
        super.onUpdate();
        
        
        
        
	
	float moveX = (float) (posX - prevPosX)*2F;
    float moveZ = (float) (posZ - prevPosZ)*2F;
    float speed = MathHelper.sqrt(moveX * moveX + moveZ * moveZ);
    	if (speed > 0.01) 
    	{
        	if (getAnimation() == NO_ANIMATION) {
//            	walkAnim.increaseTimer();
        	}
    	} else {
//        	walkAnim.decreaseTimer();
    	}
    	if (getAnimation() != NO_ANIMATION) {
//    		walkAnim.decreaseTimer(2);
    	}
    	if (frame % 20 == 5 && speed > 0.03 && getAnimation() == NO_ANIMATION && active) {
            playSound(SoundEvents.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 0.5F, 0.5F);
        }

        repelEntities(1.1F, 2, 1.1F, 1.1F);
        
        if (getAttackTarget() != null) {
            if (getAnimation() == NO_ANIMATION) {
                getNavigator().tryMoveToEntityLiving(getAttackTarget(), 0.2);
            }
            else {
                getNavigator().clearPath();
            }
        }
	}

	
	
	@Override
    protected SmartBodyHelper createBodyHelper() {
        return new SmartBodyHelper(this);
    }
	
	@Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
       
        return super.onInitialSpawn(difficulty, data);
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

	 
	 @Override
	    public boolean attackEntityAsMob(Entity entity) {
	        return super.attackEntityAsMob(entity);
	    }
	 
	 @Override
	    protected void applyEntityAttributes() {
	        super.applyEntityAttributes();
	        
	        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1);
	        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100);
	        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.55);
	        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40 );
	        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.5 );
	        getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6 );
	        
	    }


	
}
