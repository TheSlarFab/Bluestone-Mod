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
	
	public static void init() {
		blockBluestone = new BlockCompressedPowered(MapColor.blueColor).setUnlocalizedName("blockBluestone").setCreativeTab(Bluestone.tabBluestone).setStepSound(Block.soundTypeMetal);
		blockBluestoneWire = new BlockBluestoneWire().setUnlocalizedName("blockBluestoneWire").setStepSound(Block.soundTypeStone);
		blockBluestoneTorchLit = new BlockBluestoneTorch(true).setUnlocalizedName("blockBluestoneTorchLit").setStepSound(Block.soundTypeWood).setCreativeTab(Bluestone.tabBluestone);
		blockBluestoneTorchUnlit = new BlockBluestoneTorch(false).setUnlocalizedName("blockBluestoneTorchUnlit").setStepSound(Block.soundTypeWood);
		blockBluestoneRepeaterOn = new BlockBluestoneRepeater(true).setUnlocalizedName("blockBluestoneRepeaterOn").setStepSound(Block.soundTypeWood);
		blockBluestoneRepeaterOff = new BlockBluestoneRepeater(false).setUnlocalizedName("blockBluestoneRepeaterOff").setStepSound(Block.soundTypeWood);
	}

	public static void register() {
		GameRegistry.registerBlock(blockBluestone, blockBluestone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneWire, blockBluestoneWire.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneTorchLit, blockBluestoneTorchLit.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneTorchUnlit, blockBluestoneTorchUnlit.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneRepeaterOff, blockBluestoneRepeaterOff.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockBluestoneRepeaterOn, blockBluestoneRepeaterOn.getUnlocalizedName().substring(5));
	}

	public static void registerRenders() {
		registerRender(blockBluestone);
		registerRender(blockBluestoneWire);
		registerRender(blockBluestoneTorchLit);
		registerRender(blockBluestoneTorchUnlit);
		registerRender(blockBluestoneRepeaterOn);
		registerRender(blockBluestoneRepeaterOff);
	}

	public static void registerRender(Block block) {
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Bluestone.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
