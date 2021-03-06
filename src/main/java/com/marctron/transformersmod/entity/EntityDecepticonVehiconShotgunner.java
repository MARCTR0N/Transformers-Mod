package com.marctron.transformersmod.entity;

import java.util.Calendar;

import com.marctron.transformersmod.entity.model.decepticon.wfc.ModelDecepticonVehiconShotgunner;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityBodyHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIAttackRangedBow;
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
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDecepticonVehiconShotgunner extends EntityDecepticon implements IAnimatedEntity, IRangedAttackMob{

	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.<Boolean>createKey(AbstractSkeleton.class, DataSerializers.BOOLEAN);	
	 private final EntityAIAttackRangedBow<EntityDecepticonVehiconShotgunner> aiArrowAttack = new EntityAIAttackRangedBow<EntityDecepticonVehiconShotgunner>(this, 1.0D, 20, 15.0F);
	 private final EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, 1.2D, false);


	private RenderLivingBase renderer;
	
//	    		public ControlledAnimation walkAnim = new ControlledAnimation(10);
	
	public EntityDecepticonVehiconShotgunner(World world) {
		super(world);
		setPathPriority(PathNodeType.WATER, 0);
		this.setCombatTask();
		
        this.initEntityAI();
		
		tasks.addTask(1, new AnimationAI<EntityDecepticonVehiconShotgunner>(this) {
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
        setSize(0.6F, 1.8F);
        active = true;
        stepHeight = 1;
	}
	
	
	@Override
	protected void initEntityAI() 
	{

        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
//		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityPlayer.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));	
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
		 this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	
//		 tasks.addTask(2, new EntityAIAttackMelee(this, 1, true));
		tasks.addTask(2, new EntityAIAttackRanged(this, 1D, 5, 6));
	}
	
	
	  @Override
	    public int getAttack() {
	        return (int)(5 );
	    }
    
	  public boolean attackEntityFrom(DamageSource source, float amount)
	    {
//	        return this.isEntityInvulnerable(source) ? false : super.attackEntityFrom(source, amount);
		  
		  if (super.attackEntityFrom(source, amount))
	        {
	            EntityLivingBase entitylivingbase = this.getAttackTarget();

	            if (entitylivingbase == null && source.getTrueSource() instanceof EntityLivingBase)
	            {
	                entitylivingbase = (EntityLivingBase)source.getTrueSource();
	            }

	            int i = MathHelper.floor(this.posX);
	            int j = MathHelper.floor(this.posY);
	            int k = MathHelper.floor(this.posZ);
	            
	            

	           
	                

	                for (int l = 0; l < 50; ++l)
	                {
	                    int i1 = i + MathHelper.getInt(this.rand, 7, 40) * MathHelper.getInt(this.rand, -1, 1);
	                    int j1 = j + MathHelper.getInt(this.rand, 7, 40) * MathHelper.getInt(this.rand, -1, 1);
	                    int k1 = k + MathHelper.getInt(this.rand, 7, 40) * MathHelper.getInt(this.rand, -1, 1);

	                   
	                }
	            

	            return true;
	        }
	        else
	        {
	            return false;
	        }
	    }
	  
	  
	
	protected void applyEntityAI()
    {
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }
	
	
	


	 @Override
	    protected PathNavigateGround createNavigator(World world) {
	        return new PathNavigateGround(this, world);
	    }
	
	@Override
    public void onUpdate() {
        super.onUpdate();
        float moveX = (float) (posX - prevPosX)*2F;
        float moveZ = (float) (posZ - prevPosZ)*2F;
        float speed = MathHelper.sqrt(moveX * moveX + moveZ * moveZ);
        if (frame % 18 == 5 && speed > 0.03 && getAnimation() == NO_ANIMATION && active) {
        	playSound(SoundEvents.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 0.05F, 0.7F);
        	}
	}
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
//        super.setEquipmentBasedOnDifficulty(difficulty);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(RegistryHandler.ModItems.EMPShotgun));
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
            this.setCombatTask();
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
	
	public void setCombatTask()
    {
        if (this.world != null && !this.world.isRemote)
        {
            this.tasks.removeTask(this.aiAttackOnCollide);
            this.tasks.removeTask(this.aiArrowAttack);
            ItemStack itemstack = this.getHeldItemMainhand();

            if (itemstack.getItem() instanceof net.minecraft.item.ItemBow)
            {
                int i = 20;

                if (this.world.getDifficulty() != EnumDifficulty.HARD)
                {
                    i = 40;
                }

                this.aiArrowAttack.setAttackCooldown(i);
                this.tasks.addTask(4, this.aiArrowAttack);
            }
            else
            {
                this.tasks.addTask(4, this.aiAttackOnCollide);
            }
        }
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
	    protected void playStepSound(BlockPos pos, Block block) {
		 
	 }
	 
	 @SideOnly(Side.CLIENT)
	    public boolean isSwingingArms()
	    {
	        return ((Boolean)this.dataManager.get(SWINGING_ARMS)).booleanValue();
	    }
	 
	 @Override
	    public boolean attackEntityAsMob(Entity entity) {
//	        return super.attackEntityAsMob(entity);
	        
	        float f = (float)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
	        int i = 0;

	        if (entity instanceof EntityLivingBase)
	        {
	            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)entity).getCreatureAttribute());
	            i += EnchantmentHelper.getKnockbackModifier(this);
	        }

	        boolean flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);

	        if (flag)
	        {
	            if (i > 0 && entity instanceof EntityLivingBase)
	            {
	                ((EntityLivingBase)entity).knockBack(this, (float)i * 0.5F, (double)MathHelper.sin(this.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(this.rotationYaw * 0.017453292F)));
	                this.motionX *= 0.6D;
	                this.motionZ *= 0.6D;
	            }

	            int j = EnchantmentHelper.getFireAspectModifier(this);

	            if (j > 0)
	            {
	                entity.setFire(j * 4);
	            }

	            if (entity instanceof EntityPlayer)
	            {
	                EntityPlayer entityplayer = (EntityPlayer)entity;
	                ItemStack itemstack = this.getHeldItemMainhand();
	                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;

	                if (!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer))
	                {
	                    float f1 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

	                    if (this.rand.nextFloat() < f1)
	                    {
	                        entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
	                        this.world.setEntityState(entityplayer, (byte)30);
	                    }
	                }
	            }

	            this.applyEnchantments(this, entity);
	        }

	        return flag;
	    }
	 
	 @Override
	    protected void applyEntityAttributes() {
	        super.applyEntityAttributes();
	        
	        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1);
	        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(100);
	        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.55);
	        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5 );
	        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.275D);
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
				  EntityNewBullet bullet2 = this.getBullet(distanceFactor);
				  EntityNewBullet bullet3 = this.getBullet(distanceFactor);
				  EntityNewBullet bullet4 = this.getBullet(distanceFactor);
			        double dx = target.posX - this.posX;
			        double dy = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - dart.posY;
			        double dz = target.posZ - this.posZ;
			        double dist = (double)MathHelper.sqrt(dx * dx + dz * dz);
			        bullet.shoot(dx, dy + dist * 0.20000000298023224D, dz, 1.6F, in );
			        bullet2.shoot(dx, dy + dist * 0.20000000298023224D, dz, 1.6F, in );
			        bullet3.shoot(dx, dy + dist * 0.20000000298023224D, dz, 1.6F, in );
			        bullet4.shoot(dx, dy + dist * 0.20000000298023224D, dz, 1.6F, in );
			        Vec3d aim = this.getLookVec();
			        
			        
			        
//			        int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, this.getHeldItem(EnumHand.MAIN_HAND));
			        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, this.getHeldItem(EnumHand.MAIN_HAND));
//			        dart.setDamage((double) (distanceFactor * 2.0F) + this.rand.nextGaussian() * 0.25D );

//			        if (i > 0) {
//			            dart.setDamage(dart.getDamage() + (double) i * 0.5D + 0.5D);
//			        }

//			        if (j > 0) {
//			            dart.setKnockbackStrength(j);
//			        }
//
//			        dart.setDamage(dart.getDamage() * 1);
			       
			        
				  bullet.setDamage(0.5f);
				  
				  
				  
				  this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
//				  for (int i = 0; i < 6; i++)
//					  
					this.world.spawnEntity(bullet);
				  	this.world.spawnEntity(bullet2);
				  	this.world.spawnEntity(bullet3);
				  	this.world.spawnEntity(bullet4);
//			        this.world.spawnEntity(dart);
			        
			        
//			        world.spawnEntity(new EntityNewBullet(world, this, 10f).setDamage(0.2f));
//			        attacking = false;
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
