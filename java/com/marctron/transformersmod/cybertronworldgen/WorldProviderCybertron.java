package com.marctron.transformersmod.cybertronworldgen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import com.marctron.transformersmod.init.CybertronWorldGen;

public class WorldProviderCybertron extends WorldProvider
{
    
    /* (non-Javadoc)
     * @see net.minecraft.world.WorldProvider#getDimensionType()
     */
    @Override
    public DimensionType getDimensionType()
    {
        return CybertronWorldGen.CYBERTRON_DIM_TYPE;
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     *
     * @return true, if is surface world
     */
    @Override
    public boolean isSurfaceWorld()
    {
        return true;
    }

    /*======================================= Forge Start =========================================*/

    /* (non-Javadoc)
     * @see net.minecraft.world.WorldProvider#canDoLightning(net.minecraft.world.chunk.Chunk)
     */
    @Override
    public boolean canDoLightning(net.minecraft.world.chunk.Chunk chunk)
    {
        return true;
    }

    /* (non-Javadoc)
     * @see net.minecraft.world.WorldProvider#canDoRainSnowIce(net.minecraft.world.chunk.Chunk)
     */
    @Override
    public boolean canDoRainSnowIce(Chunk chunk)
    {
        return false;
    }
    
    /* (non-Javadoc)
     * @see net.minecraft.world.WorldProvider#canSnowAt(net.minecraft.util.math.BlockPos, boolean)
     */
    @Override
    public boolean canSnowAt(BlockPos pos, boolean checkLight)
    {
        return false; 
    }
}