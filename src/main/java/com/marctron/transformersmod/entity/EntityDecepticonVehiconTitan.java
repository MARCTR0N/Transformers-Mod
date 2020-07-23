package com.marctron.transformersmod.entity;

import java.util.Calendar;

import javax.annotation.Nullable;

import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityBodyHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDecepticonVehiconTitan extends EntityDecepticon implements IAnimatedEntity, IRangedAttackMob{

	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.<Boolean>createKey(AbstractSkeleton.class, DataSerializers.BOOLEAN);		

	private RenderLivingBase renderer;
	
//	    		public ControlledAnimation walkAnim = new ControlledAnimation(10);
	
	public EntityDecepticonVehiconTitan(World world) {
		super(world);
		setPathPriority(PathNodeType.WATER, 0);
		
		
        this.initEntityAI();
		
		tasks.addTask(1, new AnimationAI<EntityDecepticonVehiconTitan>(this) {
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
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));

        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));	
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
		 this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));

		tasks.addTask(2, new EntityAIAttackRanged(this, 1D, 5, 6));
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
//        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(RegistryHandler.ModItems.IonD));
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(RegistryHandler.IonDisplacer));
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
	    protected void applyEntityAttributes() {
	        super.applyEntityAttributes();
	        
	        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1);
	        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100);
	        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.55);
	        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5 );
	        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(.2 );
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

	    @Override
		public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
			  {
				  Float in= (float) 10;
				  EntityArrow dart = this.getArrow(distanceFactor);
				  EntityNewBullet bullet = this.getBullet(distanceFactor);
				  
			        double dx = target.posX - this.posX;
			        double dy = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - dart.posY;
			        double dz = target.posZ - this.posZ;
			        double dist = (double)MathHelper.sqrt(dx * dx + dz * dz);
			        bullet.shoot(dx, dy + dist * 0.20000000298023224D, dz, 1.6F, in );
			    
			        Vec3d aim = this.getLookVec();


			       
			        
				  bullet.setDamage(0.5f);
				  
				  
				  
				  this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
					  
					this.world.spawnEntity(bullet);

			    }			
		}
	    
	    protected EntityArrow getArrow(float p_190726_1_)
	    {
	        EntityTippedArrow entitytippedarrow = new EntityTippedArrow(this.world, this);
	        entitytippedarrow.setEnchantmentEffectsFromEntity(this, p_190726_1_);
	        return entitytippedarrow;
	    }
	    
	    protected EntityNewBullet getBullet(float p_190726_1_)
	    {
	        EntityNewBullet entitytippedarrow = new EntityNewBullet(this.world, this, p_190726_1_);
	        entitytippedarrow.setEnchantmentEffectsFromEntity(this, p_190726_1_);
	        return entitytippedarrow;
	    }

		@Override
		public void setSwingingArms(boolean swingingArms) {
			// TODO Auto-generated method stub
			
		}
	
}
