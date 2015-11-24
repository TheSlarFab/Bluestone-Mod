package com.solarmods.bluestone.versons.mod1_8.Items;

import com.solarmods.bluestone.versons.mod1_8.Bluestone;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BluestoneItems{
	
	public static Item itemBluestone;
	
	public static void init()
	{
		itemBluestone = new ItemBluestoneDust().setUnlocalizedName("itemBluestone").setCreativeTab(Bluestone.tabBluestone);
	}
	
	public static void register()
	{
		GameRegistry.registerItem(itemBluestone, itemBluestone.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(itemBluestone);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBluestone, 0, new ModelResourceLocation(Bluestone.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
