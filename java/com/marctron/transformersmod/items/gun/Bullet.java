package com.marctron.transformersmod.items.gun;

import com.marctron.transformersmod.items.ItemBase;

public class Bullet extends ItemBase implements IShootable
{
    public Bullet(String itemName)
    {
        super(itemName);
    }

    public Bullet(String itemName, int maxStackSize)
    {
        super(itemName);
        setMaxStackSize(maxStackSize);
    }

    @Override
    public boolean isClip()
    {
        return false;
    }

    @Override
    public int getMaxAmmo()
    {
        return maxStackSize;
    }
}