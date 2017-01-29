package com.theslarfab.bluestone.init;

import com.theslarfab.bluestone.Bluestone;
import com.theslarfab.bluestone.item.ItemBluestone;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;

public class BluestoneItems {

	public static Item bluestone;
	public static Item bluestone_repeater;
	public static Item bluestone_comparator;

	public static void init() {
		BluestoneItems.initItems();
		BluestoneItems.registerItems();
	}

	public static void initItems() {

		bluestone = new ItemBluestone().setUnlocalizedName("bluestone").setCreativeTab(Bluestone.tabBluestone)
				.setTextureName(Bluestone.modid + ":" + "bluestone_dust");
		bluestone_repeater = new ItemReed(BluestoneBlocks.unpowered_bluestone_repeater)
				.setUnlocalizedName("bluestone_repeater").setCreativeTab(Bluestone.tabBluestone)
				.setTextureName(Bluestone.modid + ":" + "bluestone_repeater");
		bluestone_comparator = new ItemReed(BluestoneBlocks.unpowered_bluestone_comparator)
				.setUnlocalizedName("bluestone_comparator").setCreativeTab(Bluestone.tabBluestone)
				.setTextureName(Bluestone.modid + ":" + "bluestone_comparator");
	}

	public static void registerItems() {
		GameRegistry.registerItem(bluestone, bluestone.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bluestone_repeater, bluestone_repeater.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bluestone_comparator, bluestone_comparator.getUnlocalizedName().substring(5));
	}
}
