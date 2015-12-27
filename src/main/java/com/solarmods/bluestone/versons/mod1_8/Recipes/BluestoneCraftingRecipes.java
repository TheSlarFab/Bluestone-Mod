package com.solarmods.bluestone.versons.mod1_8.Recipes;

import com.solarmods.bluestone.versons.mod1_8.Blocks.BluestoneBlocks;
import com.solarmods.bluestone.versons.mod1_8.Items.BluestoneItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BluestoneCraftingRecipes {
	public static void register(){
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneBlocks.blockBluestone), new Object[]{"XXX", "XXX", "XXX", 'X', BluestoneItems.itemBluestone});
		
		//Repeater
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneItems.itemBluestoneRepeater), new Object[]{"TBT", "SSS", "   ", 'B', BluestoneItems.itemBluestone, 'T', BluestoneBlocks.blockBluestoneTorchLit, 'S', Blocks.stone});
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneItems.itemBluestoneRepeater), new Object[]{"   ", "TBT", "SSS", 'B', BluestoneItems.itemBluestone, 'T', BluestoneBlocks.blockBluestoneTorchLit, 'S', Blocks.stone});
		
		//Comparator
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneItems.itemBluestoneComparator), new Object[]{" 0 ", "010", "222", '0', BluestoneBlocks.blockBluestoneTorchLit, '1', Items.quartz, '2', Blocks.stone});
		
		//Lamp
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneBlocks.blockBluestoneLampOff), new Object[]{" 0 ", "010", " 0 ", '1', Blocks.glowstone, '0', BluestoneItems.itemBluestone});
		
		//Torch Recipe
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneBlocks.blockBluestoneTorchLit), new Object[]{"0  ", "1  ", "   ", '0', BluestoneItems.itemBluestone, '1', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneBlocks.blockBluestoneTorchLit), new Object[]{" 0 ", " 1 ", "   ", '0', BluestoneItems.itemBluestone, '1', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneBlocks.blockBluestoneTorchLit), new Object[]{"  0", "  1", "   ", '0', BluestoneItems.itemBluestone, '1', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneBlocks.blockBluestoneTorchLit), new Object[]{"   ", "0  ", "1  ", '0', BluestoneItems.itemBluestone, '1', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneBlocks.blockBluestoneTorchLit), new Object[]{"   ", " 0 ", " 1 ", '0', BluestoneItems.itemBluestone, '1', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(BluestoneBlocks.blockBluestoneTorchLit), new Object[]{"   ", "  0", "  1", '0', BluestoneItems.itemBluestone, '1', Items.stick});
	}
}
