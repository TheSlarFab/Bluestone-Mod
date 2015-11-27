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
	
	public static Block blockBluestone;
	public static Block blockBluestoneWire;
	public static Block blockBluestoneTorchLit;
	public static Block blockBluestoneTorchUnlit;
	public static Block blockBluestoneRepeaterOff;
	public static Block blockBluestoneRepeaterOn;
	public static Block blockBluestoneComparatorOff;
	public static Block blockBluestoneComparatorOn;
	public static Block blockBluestoneOreLit;
	public static Block blockBluestoneOreUnlit;
	public static Block blockBluestoneRailDetector;
	public static Block blockBluestoneRailGolden;
	
	public static void init() {
		blockBluestone = new BlockCompressedPowered(MapColor.blueColor).setUnlocalizedName("blockBluestone").setCreativeTab(Bluestone.tabBluestone).setStepSound(Block.soundTypeMetal);
		blockBluestoneWire = new BlockBluestoneWire().setUnlocalizedName("blockBluestoneWire").setStepSound(Block.soundTypeStone);
		blockBluestoneTorchLit = new BlockBluestoneTorch(true).setUnlocalizedName("blockBluestoneTorchLit").setStepSound(Block.soundTypeWood).setCreativeTab(Bluestone.tabBluestone);
		blockBluestoneTorchUnlit = new BlockBluestoneTorch(false).setUnlocalizedName("blockBluestoneTorchUnlit").setStepSound(Block.soundTypeWood);
		blockBluestoneRepeaterOn = new BlockBluestoneRepeater(true).setUnlocalizedName("blockBluestoneRepeaterOn").setStepSound(Block.soundTypeWood);
		blockBluestoneRepeaterOff = new BlockBluestoneRepeater(false).setUnlocalizedName("blockBluestoneRepeaterOff").setStepSound(Block.soundTypeWood);
		blockBluestoneOreLit = new BlockBluestoneOre(true).setUnlocalizedName("blockBluestoneOreLit");
		blockBluestoneOreUnlit = new BlockBluestoneOre(false).setUnlocalizedName("blockBluestoneOreUnlit");
		blockBluestoneRailDetector = new BlockBluestoneRailDetector().setUnlocalizedName("blockBluestoneRailDetector").setStepSound(Block.soundTypeMetal).setCreativeTab(Bluestone.tabBluestone);
		blockBluestoneRailGolden = new BlockBluestoneRailPowered().setHardness(0.7F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("blockBluestoneRailGolden").setCreativeTab(Bluestone.tabBluestone);
		blockBluestoneComparatorOff = new BlockBluestoneComparator(false).setUnlocalizedName("blockBluestoneComparatorOff").setStepSound(Block.soundTypeWood);
		blockBluestoneComparatorOn = new BlockBluestoneComparator(true).setUnlocalizedName("blockBluestoneComparatorOn").setStepSound(Block.soundTypeWood);
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
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Bluestone.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
