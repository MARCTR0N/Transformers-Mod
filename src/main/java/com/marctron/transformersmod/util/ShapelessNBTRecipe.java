package com.marctron.transformersmod.util;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import java.util.List;

public class ShapelessNBTRecipe extends ShapelessRecipes {


    /**
     * Is a List of ItemStack that composes the recipe.
     */
    public final NonNullList<Ingredient> recipeItems;
    /**
     * Is the ItemStack that you get when craft the recipe.
     */
    private final ItemStack recipeOutput;
    private final String group;
    private final boolean isSimple;

    public ShapelessNBTRecipe(String group, ItemStack output, NonNullList<Ingredient> ingredients) {
        super(group, output, ingredients);

        this.group = group;
        this.recipeOutput = output;
        this.recipeItems = ingredients;
        boolean simple = true;
        for (Ingredient i : ingredients)
            simple &= i.isSimple();
        this.isSimple = simple;
    }

    private static List<ItemStack> parseInputList(Object[] inputList) {
        List<ItemStack> list = Lists.<ItemStack>newArrayList();

        for (Object object : inputList) {
            if (object instanceof ItemStack)
                list.add(((ItemStack) object).copy());
            else if (object instanceof Item)
                list.add(new ItemStack((Item) object));
            else {
                if (!(object instanceof Block))
                    throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + object.getClass().getName() + "!");
                list.add(new ItemStack((Block) object));
            }
        }

        return list;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        int ingredientCount = 0;
        net.minecraft.client.util.RecipeItemHelper recipeItemHelper = new net.minecraft.client.util.RecipeItemHelper();
        List<ItemStack> inputs = Lists.newArrayList();

        for (int i = 0; i < inv.getHeight(); ++i) {
            for (int j = 0; j < inv.getWidth(); ++j) {
                ItemStack itemstack = inv.getStackInRowAndColumn(j, i);

                if (!itemstack.isEmpty()) {
                    ++ingredientCount;
                    if (this.isSimple)
                        recipeItemHelper.accountStack(itemstack, 1);
                    else
                        inputs.add(itemstack);
                }
            }
        }

        if (ingredientCount != this.recipeItems.size())
            return false;

        if (this.isSimple)
            return recipeItemHelper.canCraft(this, null);

        return net.minecraftforge.common.util.RecipeMatcher.findMatches(inputs, this.recipeItems) != null;
    }

}