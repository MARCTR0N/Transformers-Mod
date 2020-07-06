package com.marctron.transformersmod.entity;

import java.util.List;

import javax.annotation.Nullable;


import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.network.packets.MessageEntityPosVelUpdate;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.registry.IThrowableEntity;
import scala.tools.nsc.transform.SpecializeTypes.Abstract;

public class EntityNewBullet extends EntityArrow implements IThrowableEntity{
    
private static final DataParameter<Integer> TIME = EntityDataManager.<Integer>createKey(EntityNewBullet.class, DataSerializers.VARINT);

private int ticksInAir;
private int xTile;
private int yTile;
private int zTile;
private Block inTile;
private int inData;
private int ticksInGround;
private double damage;
private int life = 0;

private int lastupdate = 21;

private static final Predicate<Entity> ARROW_TARGETS = Predicates.and(EntitySelectors.NOT_SPECTATING, EntitySelectors.IS_ALIVE, new Predicate<Entity>()
{
    public boolean apply(@Nullable Entity p_apply_1_)
    {
        return p_apply_1_.canBeCollidedWith();
    }
});

public EntityNewBullet(World world) {
    super(world);
    this.setKnockbackStrength(0);
}

public EntityNewBullet(World worldIn, double x, double y, double z) {
    super(worldIn, x, y, z);
    this.setKnockbackStrength(0);
}

public EntityNewBullet(World world, EntityLivingBase shooter, float inaccuracy) {
    this(world, shooter.posX, shooter.posY + shooter.getEyeHeight() - 0.1d, shooter.posZ);
    setThrower(shooter);
    setHeadingFromShooter(shooter, 5f, inaccuracy);
	this.pickupStatus = EntityArrow.PickupStatus.DISALLOWED;
    this.setKnockbackStrength(0);
}

public EntityNewBullet(World world, int time) {
    this(world);
    setTime(time);
}

public EntityNewBullet(World worldIn, double x, double y, double z, int time) {
    this(worldIn, x, y, z);
    setTime(time);
}

public EntityNewBullet(World worldIn, EntityLivingBase shooter, int time) {
	this(worldIn);
    setTime(time);
}

public void setHeadingFromShooter(Entity shooter, float velocity, float inaccuracy) {
    float rotYaw = shooter.rotationYaw;
    float rotPitch = shooter.rotationPitch;
    float x = -MathHelper.sin(rotYaw * 0.017453292f) * MathHelper.cos(rotPitch * 0.017453292f);
    float y = -MathHelper.sin(rotPitch * 0.017453292f);
    float z = MathHelper.cos(rotYaw * 0.017453292f) * MathHelper.cos(rotPitch * 0.017453292f);
    setThrowableHeading(x, y, z, velocity, inaccuracy);
    motionX += shooter.motionX;
    motionZ += shooter.motionZ;
    if (!shooter.onGround)
        motionY += shooter.motionY;
}

private double genRandInaccuracy(float inaccuracy) {
    return rand.nextGaussian() * 0.007499999832361937D * (double) inaccuracy;
}

public void setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy) {
    double magnitude = MathHelper.sqrt(x * x + y * y + z * z);
    x = (x / magnitude + genRandInaccuracy(inaccuracy)) * velocity;
    y = (y / magnitude + genRandInaccuracy(inaccuracy)) * velocity;
    z = (z / magnitude + genRandInaccuracy(inaccuracy)) * velocity;
    motionX = x;
    motionY = y;
    motionZ = z;
    double hMagnitude = MathHelper.sqrt(x * x + z * z);
    rotationYaw = (float) (MathHelper.atan2(x, z) * (180d / Math.PI));
    rotationPitch = (float) (MathHelper.atan2(y, hMagnitude) * (180D / Math.PI));
    prevRotationYaw = rotationYaw;
    prevRotationPitch = rotationPitch;
}

@Override
protected void entityInit() {
	super.entityInit();
    this.dataManager.register(TIME, 0);
}

@Override
protected ItemStack getArrowStack() {
	return ItemStack.EMPTY;
}

//@Override
public EntityNewBullet setDamage(float amount) {
    damage = amount;
    return this;
}

@Override
public double getDamage() {
    return this.damage;
}

@Override
public void setVelocity(double x, double y, double z) {
	//super.setVelocity(x, y, z);
	Float v=(float) 8;
	x=v;
	y=v;
	z=v;
}

@Override
protected void onHit(RayTraceResult raytraceResultIn) {
			
    Entity entity = raytraceResultIn.entityHit;

    if (entity != null)
    {
    	
    	double mx = entity.motionX;
    	double my = entity.motionY;
    	double mz = entity.motionZ;

    	
        float i = (float) this.damage;

        DamageSource damagesource;

        if (this.shootingEntity == null)
        {
            damagesource = (new EntityDamageSourceIndirect("bullet", this, this)).setProjectile();
        }
        else
        {
            damagesource = (new EntityDamageSourceIndirect("bullet", this, this.shootingEntity)).setProjectile();
        }

    	entity.hurtResistantTime = 0;
		    		
		float hitheight = (float) raytraceResultIn.hitVec.y - (float) entity.posY;
		
		float eyeheight = entity.getEyeHeight();
		
		float height = entity.height;
		    		
		if (hitheight > 2*eyeheight - height) {
			i *= 2;
		}
		else if (entity instanceof AbstractSkeleton || entity instanceof EntitySkeletonHorse) {
			i /= 4;
		}

        if (entity.attackEntityFrom(damagesource, i))
        {
            if (entity instanceof EntityLivingBase)
            {
                EntityLivingBase entitylivingbase = (EntityLivingBase)entity;
                
                if (this.shootingEntity instanceof EntityLivingBase) {
                	((EntityLivingBase)this.shootingEntity).setLastAttackedEntity(entity);
                }

                this.arrowHit(entitylivingbase);

                if (this.shootingEntity != null && entitylivingbase != this.shootingEntity && entitylivingbase instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP)
                {
                    ((EntityPlayerMP)this.shootingEntity).connection.sendPacket(new SPacketChangeGameState(6, 0.0F));
                }
            }

            if (!(entity instanceof EntityEnderman))
            {
                this.setDead();
            }

            entity.motionX = mx;
            entity.motionY = my;
            entity.motionZ = mz;

        }
        else
        {

        	if (!world.isRemote) {
            	System.out.println("Unable to damage Entity");
            	this.setDead();
        	}

        }
    }
    else
    {
        BlockPos blockpos = raytraceResultIn.getBlockPos();
        IBlockState iblockstate = this.world.getBlockState(blockpos);
        if (iblockstate.getBlock() == Blocks.GLASS_PANE && !world.isRemote) {
    		world.setBlockState(blockpos, Blocks.AIR.getDefaultState());
    		world.playSound(null, blockpos, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 1, this.rand.nextFloat() * 0.2F + 0.9F);
    		this.inGround = false;
    		this.doRayTrace();
        }
        else {
            this.xTile = blockpos.getX();
            this.yTile = blockpos.getY();
            this.zTile = blockpos.getZ();
            this.inTile = iblockstate.getBlock();
            this.inData = this.inTile.getMetaFromState(iblockstate);
            this.motionX = ((float)(raytraceResultIn.hitVec.x - this.posX));
            this.motionY = ((float)(raytraceResultIn.hitVec.y - this.posY));
            this.motionZ = ((float)(raytraceResultIn.hitVec.z - this.posZ));
            float f2 = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            this.posX -= this.motionX / f2 * 0.05000000074505806D;
            this.posY -= this.motionY / f2 * 0.05000000074505806D;
            this.posZ -= this.motionZ / f2 * 0.05000000074505806D;
            this.inGround = true;
            this.arrowShake = 0;
            this.setIsCritical(false);

            if (iblockstate.getMaterial() != Material.AIR)
            {
                this.inTile.onEntityCollidedWithBlock(this.world, blockpos, iblockstate, this);
            }
        }
    }
}

@Override
protected void arrowHit(EntityLivingBase living) {
	
}

@Override
public void onUpdate() {
	if (!world.isRemote && (this.firstUpdate || this.life++ % 5 == 0)) {
		TFNetworkManager.sendToAllTracking(new MessageEntityPosVelUpdate(this), this);
	}
	
	if (ticksInAir >= 40) {
		this.setDead();
	}
	
	if (ticksInGround > getTime()) {
		this.setDead();
	}
	
    if (!this.world.isRemote)
    {
        this.setFlag(6, this.isGlowing());
    }

    this.onEntityUpdate();
    
    if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
    {
        float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));
        this.rotationPitch = (float)(MathHelper.atan2(this.motionY, f) * (180D / Math.PI));
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }

    BlockPos blockpos = new BlockPos(this.xTile, this.yTile, this.zTile);
    IBlockState iblockstate = this.world.getBlockState(blockpos);
    Block block = iblockstate.getBlock();

    if (iblockstate.getMaterial() != Material.AIR)
    {
        AxisAlignedBB axisalignedbb = iblockstate.getCollisionBoundingBox(this.world, blockpos);

        if (axisalignedbb != Block.NULL_AABB && axisalignedbb.offset(blockpos).contains(new Vec3d(this.posX, this.posY, this.posZ)))
        {
            this.inGround = true;
        }
    }

    if (this.arrowShake > 0)
    {
        --this.arrowShake;
    }

    if (this.inGround)
    {
        int j = block.getMetaFromState(iblockstate);

        if ((block != this.inTile || j != this.inData) && !this.world.collidesWithAnyBlock(this.getEntityBoundingBox().grow(0.05D)))
        {
            this.inGround = false;
            this.motionX *= this.rand.nextFloat() * 0.2F;
            this.motionY *= this.rand.nextFloat() * 0.2F;
            this.motionZ *= this.rand.nextFloat() * 0.2F;
            this.ticksInGround = 0;
            this.ticksInAir = 0;
        }
        else
        {
            ++this.ticksInGround;

            if (this.ticksInGround >= 1200)
            {
                this.setDead();
            }
        }

        ++this.timeInGround;
    }
    else
    {
        this.timeInGround = 0;
        ++this.ticksInAir;

        this.doRayTrace();
        
        if (this.getIsCritical())
        {
            for (int k = 0; k < 4; ++k)
            {
                this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX + this.motionX * k / 4.0D, this.posY + this.motionY * k / 4.0D, this.posZ + this.motionZ * k / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
            }
        }

        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        float f4 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * (180D / Math.PI));

        for (this.rotationPitch = (float)(MathHelper.atan2(this.motionY, f4) * (180D / Math.PI)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
        {
            ;
        }

        while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
        {
            this.prevRotationPitch += 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw < -180.0F)
        {
            this.prevRotationYaw -= 360.0F;
        }

        while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
        {
            this.prevRotationYaw += 360.0F;
        }

        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
        float f1 = 0.999F;
        float f2 = 0.05F;

        if (this.isInWater())
        {
            for (int i = 0; i < 4; ++i)
            {
                float f3 = 0.25F;
                this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25D, this.posY - this.motionY * 0.25D, this.posZ - this.motionZ * 0.25D, this.motionX, this.motionY, this.motionZ);
            }

            f1 = 0.6F;
        }

        if (this.isWet())
        {
            this.extinguish();
        }

        this.motionX *= f1;
        this.motionY *= f1;
        this.motionZ *= f1;

        if (!this.hasNoGravity())
        {
            this.motionY -= 0.05D;
        }

        this.setPosition(this.posX, this.posY, this.posZ);
        this.doBlockCollisions();
    }
}

@Override
@Nullable
protected Entity findEntityOnPath(Vec3d start, Vec3d end)
{
    Entity entity = null;
    List<Entity> list = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).grow(1.0D), ARROW_TARGETS);
    double d0 = 0.0D;

    for (int i = 0; i < list.size(); ++i)
    {
        Entity entity1 = list.get(i);

        if (entity1 != this.shootingEntity || this.ticksInAir >= 5)
        {
            AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox();
            RayTraceResult raytraceresult = axisalignedbb.calculateIntercept(start, end);

            if (raytraceresult != null)
            {
                double d1 = start.squareDistanceTo(raytraceresult.hitVec);

                if (d1 < d0 || d0 == 0.0D)
                {
                    entity = entity1;
                    d0 = d1;
                }
            }
        }
    }

    return entity;
}

@Override
public void onEntityUpdate() {
	super.onEntityUpdate();
}

public void doRayTrace() {
    Vec3d vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
    Vec3d vec3d = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
    RayTraceResult raytraceresult = this.world.rayTraceBlocks(vec3d1, vec3d, false, true, false);
    vec3d1 = new Vec3d(this.posX, this.posY, this.posZ);
    vec3d = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

    if (raytraceresult != null)
    {
        vec3d = new Vec3d(raytraceresult.hitVec.x, raytraceresult.hitVec.y, raytraceresult.hitVec.z);
    }

    Entity entity = this.findEntityOnPath(vec3d1, vec3d);

    if (entity != null)
    {	            	
        raytraceresult = Main.rayTraceEntity(vec3d1, vec3d, entity);
    }

    if (raytraceresult != null && raytraceresult.entityHit instanceof EntityPlayer)
    {
        EntityPlayer entityplayer = (EntityPlayer)raytraceresult.entityHit;

        if (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer))
        {
            raytraceresult = null;
        }
    }

    if (raytraceresult != null && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult))
    {
        this.onHit(raytraceresult);
    }
}

public void setTime(int time) {
	dataManager.set(TIME, time);
}

public int getTime() {
	int time = dataManager.get(TIME);
	return time;
}

@Override
public void writeEntityToNBT(NBTTagCompound compound) {
	super.writeEntityToNBT(compound);
	compound.setInteger("MaxLife", getTime());
}

@Override
public void readEntityFromNBT(NBTTagCompound compound) {
	super.readEntityFromNBT(compound);
	setTime(compound.getInteger("MaxLife"));
}

@Override
public Entity getThrower() {
	return this.shootingEntity;
}

@Override
public void setThrower(Entity entity) {
	this.shootingEntity = entity;
}

}