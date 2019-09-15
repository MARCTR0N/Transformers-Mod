package com.marctron.transformersmod.entity;

import com.marctron.transformersmod.util.CommonUtils;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IThrowableEntity;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EntityBullet extends Entity implements IProjectile, IThrowableEntity {
    //Copied from EntityArrow
    private static final Predicate<Entity> BULLET_TARGETS = ((Predicate<Entity>) EntitySelectors.NOT_SPECTATING::apply).and(EntitySelectors.IS_ALIVE::apply).and(Entity::canBeCollidedWith);
    public Entity shooter;
    private float damage = 4f;
    private int knockbackStrength = 1;
    private int ticksInAir = 0;

    public EntityBullet(World world) {
        super(world);
        setSize(0.2f, 0.2f);
    }

    public EntityBullet(World world, double x, double y, double z) {
        this(world);
        setPosition(x, y, z);
    }

    public EntityBullet(World world, EntityLivingBase shooter) {
        this(world, shooter, 0.25f);
    }

    public EntityBullet(World world, EntityLivingBase shooter, float inaccuracy) {
        this(world, shooter.posX, shooter.posY + shooter.getEyeHeight() - 0.1d, shooter.posZ);
        setThrower(shooter);
        setHeadingFromShooter(shooter, 5f, inaccuracy);
    }

    public EntityBullet setDamage(float amount) {
        damage = amount;
        return this;
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbt) {
        damage = nbt.getFloat("damage");
        knockbackStrength = nbt.getInteger("knockback");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbt) {
        nbt.setFloat("damage", damage);
        nbt.setInteger("knockback", knockbackStrength);
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

    /**
     * Called when the bullet hits a block or an entity
     */
    protected void onHit(RayTraceResult ray) {
        Entity entityHit = ray.entityHit;
        if (entityHit != null) {
            //Hit an entity
            float magnitude = MathHelper.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);

            //Create damage source
            DamageSource damageSource;
            if (shooter == null)
                damageSource = CommonUtils.causeBulletDamage(this, this);
            else
                damageSource = CommonUtils.causeBulletDamage(this, shooter);

            if (this.isBurning() && !(entityHit instanceof EntityEnderman)) {
                entityHit.setFire(5);
            }
            //Hit entity
            if (entityHit.attackEntityFrom(damageSource, damage)) {
                if (entityHit instanceof EntityLivingBase) {
                    EntityLivingBase entityLiving = (EntityLivingBase) entityHit;

                    //Knockback
                    if (magnitude > 0)
                        entityLiving.addVelocity(knockbackStrength * 0.6d / magnitude, 0.1d, knockbackStrength * 0.6d / magnitude);

                    //Apply enchantments
                    if (shooter instanceof EntityLivingBase) {
                        EnchantmentHelper.applyThornEnchantments(entityLiving, shooter);
                        EnchantmentHelper.applyArthropodEnchantments((EntityLivingBase) shooter, entityLiving);
                    }

                    //Reset hurt timers
                    entityLiving.hurtTime = 0;
                    entityLiving.hurtResistantTime = 0;

                    bulletHit(entityLiving);

                    //Play hit sound for shooter (arrow ding)
                    if (entityLiving != shooter && entityLiving instanceof EntityPlayer && shooter instanceof EntityPlayerMP)
                        ((EntityPlayerMP) shooter).connection.sendPacket(new SPacketChangeGameState(6, 0.0F));
                }

                //Play hit sound
                playSound(SoundEvents.BLOCK_ANVIL_BREAK, 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.9F));

                if (!(entityHit instanceof EntityEnderman))
                    setDead();
            } else {
                //Couldn't hit entity
                setDead();
            }
        } else {
            //Hit a block
            playSound(SoundEvents.BLOCK_ANVIL_BREAK, 1.0F, 1.2F / (rand.nextFloat() * 0.7F + 0.9F));
            BlockPos pos = ray.getBlockPos();
            IBlockState state = world.getBlockState(pos);
            if (state.getMaterial() != Material.AIR)
                state.getBlock().onEntityCollidedWithBlock(world, pos, state, this);
            setDead();
        }
    }

    /**
     * Do anything extra to the entity hit
     */
    protected void bulletHit(EntityLivingBase entityHit) {
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        super.onUpdate();

        //Increase time bullet has been in the air
        ticksInAir++;

        //Ray trace in front of the bullet between its current and next position
        Vec3d posNow = new Vec3d(posX, posY, posZ);
        Vec3d posNext = posNow.addVector(motionX, motionY, motionZ);
        RayTraceResult ray = world.rayTraceBlocks(posNow, posNext, false, true, false);
        posNow = new Vec3d(posX, posY, posZ);
        posNext = posNow.addVector(motionX, motionY, motionZ);
        if (ray != null)
            posNext = ray.hitVec;

        //Get entity hit if one is on the bullet's path
        Entity entityHit = findEntityOnPath(posNow, posNext);
        if (entityHit != null) {
            if (entityHit instanceof EntityPlayer && shooter instanceof EntityPlayer && !((EntityPlayer) shooter).canAttackPlayer((EntityPlayer) entityHit))
                ray = null;
            else
                ray = new RayTraceResult(entityHit);
        }

        //If bullet has hit something, call onHit
        if (ray != null)
            onHit(ray);

        //Move bullet
        posX += motionX;
        posY += motionY;
        posZ += motionZ;

        float motionMult = 0.99f;

        //Spawn bubbles while in water
        if (isInWater()) {
            for (int i = 0; i < 4; ++i)
                world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, posX - motionX * 0.25D, posY - motionY * 0.25D, posZ - motionZ * 0.25D, motionX, motionY, motionZ);
            motionMult = 0.6F;
        }

        if (isWet())
            extinguish();

        //Reduce velocity
        motionX *= motionMult;
        motionY *= motionMult;
        motionZ *= motionMult;

        setPosition(posX, posY, posZ);
        doBlockCollisions();
    }

    private List<Entity> getEntitiesInArea(AxisAlignedBB area, List<Entity> entities) {
        List<Entity> entitiesInArea = new ArrayList<>();
        entities.forEach((entity) ->
        {
            if (entity.getEntityBoundingBox().intersects(area) && BULLET_TARGETS.test(entity))
                entitiesInArea.add(entity);
        });
        return entitiesInArea;
    }

    public Vec3d getCenter(AxisAlignedBB box) {
        return new Vec3d(box.minX + (box.maxX - box.minX) * 0.5D, box.minY + (box.maxY - box.minY) * 0.5D, box.minZ + (box.maxZ - box.minZ) * 0.5D);
    }

    //Copied from EntityArrow
//    @Nullable
//    protected Entity findEntityOnPath(Vec3d start, Vec3d end) {
//        Entity closestEntity = null;
//        double closestDistance = 0.0D;
//
//        AxisAlignedBB startAABB = getEntityBoundingBox();
//        AxisAlignedBB endAABB = startAABB.offset(motionX, motionY, motionZ);
//        Vec3d startCenter = getCenter(getEntityBoundingBox());
//        Vec3d endCenter = getCenter(endAABB);
//
//        AxisAlignedBB area = new AxisAlignedBB(startCenter, endCenter).grow(startAABB.getAverageEdgeLength());
//        List<Entity> possibleEntities = world.getEntitiesInAABBexcluding(this, area, BULLET_TARGETS::test);
//        if (possibleEntities.isEmpty())
//            return null;
//
//        //This will scan down the path of the projectile to its next position for any entities
//
//        //We'll use this AABB to scan down the path
//        AxisAlignedBB movingAABB = new AxisAlignedBB(startAABB.minX, startAABB.minY, startAABB.minZ, startAABB.maxX, startAABB.maxY, startAABB.maxZ);
//        //The direct distance between the centers of the start and end AABBs
//        double distanceToEnd = startCenter.distanceTo(endCenter);
//        //The direct distance we want to move the scanning AABB each iteration
//        double stepMove = startAABB.getAverageEdgeLength() * 1.5;
//        //How many iterations (minus the end position) it will take to scan the path
//        int steps = (int) Math.floor(distanceToEnd / stepMove);
//        //The vector we'll add to the scanning AABB every iteration
//        Vec3d stepVec = steps == 0 ?
//                new Vec3d(motionX, motionY, motionZ) :
//                endCenter.subtract(startCenter).scale(1D / (double) steps);
//
//        for (int i = 0; i < steps; i++) {
//            if (i > 0) movingAABB = movingAABB.offset(stepVec);
//            List<Entity> list = getEntitiesInArea(movingAABB, possibleEntities);
//            for (Entity entity : list) {
//                if (entity != shooter) {
//                    AxisAlignedBB aabb = entity.getEntityBoundingBox();
//                    RayTraceResult raytraceresult = aabb.calculateIntercept(start, end);
//                    if (raytraceresult != null) {
//                        double distance = start.squareDistanceTo(raytraceresult.hitVec);
//                        if (distance < closestDistance || closestDistance == 0.0D) {
//                            closestEntity = entity;
//                            closestDistance = distance;
//                        }
//                    }
//                }
//            }
//            if (closestEntity != null)
//                break;
//        }
//
//        return closestEntity;
//    }
    
    @Nullable
    protected Entity findEntityOnPath(Vec3d start, Vec3d end)
    {
        Entity entity = null;
        List<Entity> list = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ).grow(1.0D), BULLET_TARGETS::test);
        double d0 = 0.0D;

        for (int i = 0; i < list.size(); ++i)
        {
            Entity entity1 = list.get(i);

            if (entity1 != this.shooter || this.ticksInAir >= 5)
            {
                AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow(0.30000001192092896D);
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
    public Entity getThrower() {
        return shooter;
    }

    @Override
    public void setThrower(Entity entity) {
        this.shooter = entity;
    }

    @Override
    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        // TODO Auto-generated method stub

    }
}