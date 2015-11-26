package com.solarmods.bluestone.versons.mod1_8.Recipes;

import com.solarmods.bluestone.versons.mod1_8.Blocks.BluestoneBlocks;
import com.solarmods.bluestone.versons.mod1_8.Items.BluestoneItems;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BluestoneCraftingRecipes {
	public static void register(){
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneBlocks.blockBluestone), new Object[]{"XXX", "XXX", "XXX", 'X', BluestoneItems.itemBluestone});
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneItems.itemBluestoneRepeater), new Object[]{"TBT", "SSS", "   ", 'B', BluestoneItems.itemBluestone, 'T', BluestoneBlocks.blockBluestoneTorchLit, 'S', Blocks.stone});
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneItems.itemBluestoneRepeater), new Object[]{"   ", "TBT", "SSS", 'B', BluestoneItems.itemBluestone, 'T', BluestoneBlocks.blockBluestoneTorchLit, 'S', Blocks.stone});
	}
}
