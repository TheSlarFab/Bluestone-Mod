package com.solarmods.bluestone.versons.mod1_8.Blocks;

import com.solarmods.bluestone.versons.mod1_8.Bluestone;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCompressedPowered;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BluestoneBlocks {
	
	//Blocks and Wires
	public static Block blockBluestone;
	public static Block blockBluestoneWire;
	
	//Torch
	public static Block blockBluestoneTorchLit;
	public static Block blockBluestoneTorchUnlit;
	
	//Diode
	public static Block blockBluestoneRepeaterOff;
	public static Block blockBluestoneRepeaterOn;
	
	//Comparator
	public static Block blockBluestoneComparatorOff;
	public static Block blockBluestoneComparatorOn;
	
	//Ore
	public static Block blockBluestoneOreLit;
	public static Block blockBluestoneOreUnlit;
	
	//Rails
	public static Block blockBluestoneRailDetector;
	public static Block blockBluestoneRailGolden;
	
	//Lamps
	public static Block blockBluestoneLampOff;
	public static Block blockBluestoneLampOn;
	
	public static void init() {
		blockBluestone = new BlockCompressedPowered(MapColor.blueColor).setUnlocalizedName("bluestone_block").setCreativeTab(Bluestone.tabBluestone).setStepSound(Block.soundTypeMetal);
		blockBluestoneWire = new BlockBluestoneWire().setUnlocalizedName("bluestone_dust").setStepSound(Block.soundTypeStone);
		blockBluestoneTorchLit = new BlockBluestoneTorch(true).setUnlocalizedName("bluestone_torch_lit").setStepSound(Block.soundTypeWood).setCreativeTab(Bluestone.tabBluestone);
		blockBluestoneTorchUnlit = new BlockBluestoneTorch(false).setUnlocalizedName("bluestone_torch_unlit").setStepSound(Block.soundTypeWood);
		blockBluestoneRepeaterOn = new BlockBluestoneRepeater(true).setUnlocalizedName("bluestone_repeater_lit").setStepSound(Block.soundTypeWood);
		blockBluestoneRepeaterOff = new BlockBluestoneRepeater(false).setUnlocalizedName("bluestone_repeater_unlit").setStepSound(Block.soundTypeWood);
		blockBluestoneOreLit = new BlockBluestoneOre(true).setUnlocalizedName("lit_bluestone_ore");
		blockBluestoneOreUnlit = new BlockBluestoneOre(false).setUnlocalizedName("bluestone_ore");
		blockBluestoneRailDetector = new BlockBluestoneRailDetector().setUnlocalizedName("blue_rail_detector").setStepSound(Block.soundTypeMetal).setCreativeTab(Bluestone.tabBluestone);
		blockBluestoneRailGolden = new BlockBluestoneRailPowered().setHardness(0.7F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("blue_rail_golden").setCreativeTab(Bluestone.tabBluestone);
		blockBluestoneComparatorOff = new BlockBluestoneComparator(false).setUnlocalizedName("bluestone_comparator_unlit").setStepSound(Block.soundTypeWood);
		blockBluestoneComparatorOn = new BlockBluestoneComparator(true).setUnlocalizedName("bluestone_comparator_lit").setStepSound(Block.soundTypeWood);
		blockBluestoneLampOff = new BlockBluestoneLight(false).setUnlocalizedName("bluestone_lamp_off").setCreativeTab(Bluestone.tabBluestone).setStepSound(Block.soundTypeGlass);
		blockBluestoneLampOn = new BlockBluestoneLight(true).setUnlocalizedName("bluestone_lamp_on").setStepSound(Block.soundTypeGlass);
	}

	public static void register() {
		GameRegistry.registerBlock(blockBluestone, blockBluestone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneWire, blockBluestoneWire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneTorchLit, blockBluestoneTorchLit.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneTorchUnlit, blockBluestoneTorchUnlit.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneRepeaterOff, blockBluestoneRepeaterOff.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneRepeaterOn, blockBluestoneRepeaterOn.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneOreLit, blockBluestoneOreLit.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneOreUnlit, blockBluestoneOreUnlit.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneRailDetector, blockBluestoneRailDetector.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneRailGolden, blockBluestoneRailGolden.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneComparatorOff, blockBluestoneComparatorOff.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneComparatorOn, blockBluestoneComparatorOn.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneLampOff, blockBluestoneLampOff.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneLampOn, blockBluestoneLampOn.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(blockBluestone);
		registerRender(blockBluestoneWire);
		registerRender(blockBluestoneTorchLit);
		registerRender(blockBluestoneTorchUnlit);
		registerRender(blockBluestoneRepeaterOn);
		registerRender(blockBluestoneRepeaterOff);
		registerRender(blockBluestoneOreLit);
		registerRender(blockBluestoneOreUnlit);
		registerRender(blockBluestoneRailDetector);
		registerRender(blockBluestoneRailGolden);
		registerRender(blockBluestoneComparatorOff);
		registerRender(blockBluestoneComparatorOn);
		registerRender(blockBluestoneLampOff);
		registerRender(blockBluestoneLampOn);
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Bluestone.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
