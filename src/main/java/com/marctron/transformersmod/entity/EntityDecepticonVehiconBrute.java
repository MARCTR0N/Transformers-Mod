package com.marctron.transformersmod.entity;

import java.util.Calendar;

import com.marctron.transformersmod.entity.ai.AnimationBruteAttackAI;
import com.marctron.transformersmod.entity.ai.AnimationBrutePoundAttackAI;
import com.marctron.transformersmod.entity.ai.AnimationBruteVerticalAttackAI;
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
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDecepticonVehiconBrute extends EntityDecepticon implements IAnimatedEntity{

	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.<Boolean>createKey(AbstractSkeleton.class, DataSerializers.BOOLEAN);		

	private RenderLivingBase renderer;
	
	public boolean swingDirection;
	
	private int attacksWithoutVertical;

	private int ticksSinceLastSmash;
	
//	    		public ControlledAnimation walkAnim = new ControlledAnimation(10);
	
	public static final Animation DIE_ANIMATION = Animation.create(130);

    public static final Animation HURT_ANIMATION = Animation.create(15);

    public static final Animation ATTACK_ANIMATION = Animation.create(50);

    public static final Animation ATTACK_TWICE_ANIMATION = Animation.create(76);

    public static final Animation ATTACK_THRICE_ANIMATION = Animation.create(125);

    public static final Animation VERTICAL_ATTACK_ANIMATION = Animation.create(105);

    public static final Animation SMASH_ATTACK_ANIMATION = Animation.create(40);
    
    
    private static final Animation[] ANIMATIONS = {
            DIE_ANIMATION,
            HURT_ANIMATION,
            ATTACK_ANIMATION,
            ATTACK_TWICE_ANIMATION,
            ATTACK_THRICE_ANIMATION,
            VERTICAL_ATTACK_ANIMATION,
            SMASH_ATTACK_ANIMATION,
            
        };
	
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
		tasks.addTask(2, new EntityAIAttackMelee(this, 1, true));
	    this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
        this.tasks.addTask(1, new AnimationBruteAttackAI(this, ATTACK_ANIMATION, SoundEvents.BLOCK_ANVIL_HIT, 4F, 5.5F, 100F, 1));
        tasks.addTask(1, new AnimationBruteAttackAI(this, ATTACK_TWICE_ANIMATION, SoundEvents.BLOCK_ANVIL_HIT, 4F, 5.5F, 100F, 2));
        tasks.addTask(1, new AnimationBruteAttackAI(this, ATTACK_THRICE_ANIMATION, SoundEvents.BLOCK_ANVIL_HIT, 4F, 5.5F, 100F, 3));
        tasks.addTask(1, new AnimationBruteVerticalAttackAI(this, VERTICAL_ATTACK_ANIMATION, SoundEvents.BLOCK_ANVIL_HIT, 1F, 5.5F, 40F));
        tasks.addTask(1, new AnimationBrutePoundAttackAI(this, SMASH_ATTACK_ANIMATION));
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


      if (getAttackTarget() != null && (getAttackTarget().isDead || getAttackTarget().getHealth() <= 0)) setAttackTarget(null);

      if (!world.isRemote) {
          if (getAnimation() == NO_ANIMATION && !isAIDisabled()) {
              
          }
          ticksSinceLastSmash++;
      }


      else if (world.isRemote) {
//          MMParticle.ORB.spawn(world, leftEyePos.x, leftEyePos.y, leftEyePos.z, ParticleFactory.ParticleArgs.get().withData(0d, 0d, 0d, 247d / 256d, 94d / 256d, 74d / 256d, 1d, 25));
//          MMParticle.ORB.spawn(world, rightEyePos.x, rightEyePos.y, rightEyePos.z, ParticleFactory.ParticleArgs.get().withData(0d, 0d, 0d, 247d / 256d, 94d / 256d, 74d / 256d, 1d, 25));
      }
      renderYawOffset = rotationYaw;

      if (getAttackTarget() != null) {
          if (getAnimation() == NO_ANIMATION) {
              getNavigator().tryMoveToEntityLiving(getAttackTarget(), 0.2);
          } else {
              getNavigator().clearPath();
          }
          if (getAttackTarget().posY - posY >= -1 && getAttackTarget().posY - posY <= 3 && getAnimation() == NO_ANIMATION && !isAIDisabled()) {
              boolean couldStomp = targetDistance < 6 && ticksSinceLastSmash > 600;
              if (targetDistance < 3.5 && Math.abs(MathHelper.wrapDegrees(getAngleBetweenEntities(getAttackTarget(), this) - rotationYaw)) < 35 && (!couldStomp || rand.nextInt(3) > 0)) {
                  if (attacksWithoutVertical >= 4 || rand.nextInt(4) == 0) {
                      AnimationHandler.INSTANCE.sendAnimationMessage(this, VERTICAL_ATTACK_ANIMATION);
                      attacksWithoutVertical = 0;
                  } else {
                      if (getHealth()/getMaxHealth() <= 0.6 && rand.nextInt(2) == 0) {
                          AnimationHandler.INSTANCE.sendAnimationMessage(this, ATTACK_THRICE_ANIMATION);
                          attacksWithoutVertical += 3;
                      }
                      else if (getHealth()/getMaxHealth() <= 0.9 && rand.nextInt(2) == 0) {
                          AnimationHandler.INSTANCE.sendAnimationMessage(this, ATTACK_TWICE_ANIMATION);
                          attacksWithoutVertical += 2;
                      }
                      else {
                          AnimationHandler.INSTANCE.sendAnimationMessage(this, ATTACK_ANIMATION);
                          attacksWithoutVertical += 1;
                      }
                  }
              } else if (couldStomp) {
                  AnimationHandler.INSTANCE.sendAnimationMessage(this, SMASH_ATTACK_ANIMATION);
                  ticksSinceLastSmash = 0;
                  attacksWithoutVertical++;
              }
          }
      } 

      if (getAnimation() == ATTACK_ANIMATION && getAnimationTick() == 1) {
          swingDirection = rand.nextBoolean();
      } 
      else if (getAnimation() == VERTICAL_ATTACK_ANIMATION && getAnimationTick() == 29) {
//          doVerticalAttackHitFX();
      }

      float moveX = (float) (posX - prevPosX)*2F;
      float moveZ = (float) (posZ - prevPosZ)*2F;
      float speed = MathHelper.sqrt(moveX * moveX + moveZ * moveZ);
      if (speed > 0.01) {
          if (getAnimation() == NO_ANIMATION) {
//              walkAnim.increaseTimer();
          }
      } else {
//          walkAnim.decreaseTimer();
      }
      if (getAnimation() != NO_ANIMATION) {
//          walkAnim.decreaseTimer(2);
      }

      if (frame % 14 == 5 && speed > 0.03 && getAnimation() == NO_ANIMATION && active) {
          playSound(SoundEvents.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 0.5F, 0.5F);
      }

      repelEntities(1.1F, 2, 1.1F, 1.1F);

      if (!active) {
          addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 20, 2, true, true));
      }

     
  }
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
//        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(RegistryHandler.ModItems.Hammer));
        this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(RegistryHandler.DecepticonBruteShield));
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
		return ANIMATIONS;
	}

	@Override
	public Animation getDeathAnimation() {
		 return DIE_ANIMATION;	    
	}

	@Override
	public Animation getHurtAnimation() {
		 return HURT_ANIMATION;
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
