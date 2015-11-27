package com.solarmods.bluestone.versons.mod1_8.Items;

import com.solarmods.bluestone.versons.mod1_8.Bluestone;
import com.solarmods.bluestone.versons.mod1_8.Blocks.BluestoneBlocks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BluestoneItems{
	
	public static Item itemBluestone;
	public static Item itemBluestoneRepeater;
	public static Item itemBluestoneComparator;
	
	public static void init()
	{
		itemBluestone = new ItemBluestoneDust().setUnlocalizedName("itemBluestone").setCreativeTab(Bluestone.tabBluestone);
		itemBluestoneRepeater = new ItemReed(BluestoneBlocks.blockBluestoneRepeaterOff).setUnlocalizedName("itemBluestoneRepeater").setCreativeTab(Bluestone.tabBluestone);
		itemBluestoneComparator = new ItemReed(BluestoneBlocks.blockBluestoneComparatorOff).setUnlocalizedName("itemBluestoneComparator").setCreativeTab(Bluestone.tabBluestone);
	}
	
	public static void register()
	{
		GameRegistry.registerItem(itemBluestone, itemBluestone.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBluestoneRepeater, itemBluestoneRepeater.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBluestoneComparator, itemBluestoneComparator.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(itemBluestone);
		registerRender1(itemBluestoneRepeater);
		registerRender2(itemBluestoneComparator);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBluestone, 0, new ModelResourceLocation(Bluestone.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerRender1(Item item1) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBluestoneRepeater, 0, new ModelResourceLocation(Bluestone.MOD_ID + ":" + item1.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerRender2(Item item1) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBluestoneComparator, 0, new ModelResourceLocation(Bluestone.MOD_ID + ":" + item1.getUnlocalizedName().substring(5), "inventory"));
	}
}
