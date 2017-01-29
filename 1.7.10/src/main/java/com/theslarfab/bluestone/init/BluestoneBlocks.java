package com.theslarfab.bluestone.init;

import com.theslarfab.bluestone.Bluestone;
import com.theslarfab.bluestone.block.BlockBluestoneComparator;
import com.theslarfab.bluestone.block.BlockBluestoneOre;
import com.theslarfab.bluestone.block.BlockBluestoneRepeater;
import com.theslarfab.bluestone.block.BlockBluestoneTorch;
import com.theslarfab.bluestone.block.BlockBluestoneWire;
import com.theslarfab.bluestone.client.renderer.block.RenderBlockBluestoneDiode;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCompressedPowered;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class BluestoneBlocks {

	public static Block bluestone_block;
	public static Block unlit_bluestone_torch;
	public static Block bluestone_torch;
	public static Block bluestone_ore;
	public static Block lit_bluestone_ore;
	public static BlockBluestoneRepeater unpowered_bluestone_repeater;
	public static BlockBluestoneRepeater powered_bluestone_repeater;
	public static BlockBluestoneComparator unpowered_bluestone_comparator;
	public static BlockBluestoneComparator powered_bluestone_comparator;
	public static BlockBluestoneWire bluestone_wire;

	public static void init() {
		BluestoneBlocks.initBlocks();
		BluestoneBlocks.registerBlocks();
	}

	public static void initBlocks() {
		bluestone_block = new BlockCompressedPowered(MapColor.blueColor).setHardness(5.0F).setResistance(10.0F)
				.setStepSound(Block.soundTypeMetal).setBlockName("bluestone_block")
				.setBlockTextureName(Bluestone.modid + ":" + "bluestone_block").setCreativeTab(Bluestone.tabBluestone);
		unlit_bluestone_torch = new BlockBluestoneTorch(false).setHardness(0.0F).setStepSound(Block.soundTypeWood)
				.setBlockName("unlit_bluestone_torch")
				.setBlockTextureName(Bluestone.modid + ":" + "bluestone_torch_off");
		bluestone_torch = new BlockBluestoneTorch(true).setHardness(0.0F).setLightLevel(0.5F)
				.setStepSound(Block.soundTypeWood).setBlockName("bluestone_torch")
				.setCreativeTab(Bluestone.tabBluestone)
				.setBlockTextureName(Bluestone.modid + ":" + "bluestone_torch_on");
		bluestone_ore = new BlockBluestoneOre(false).setHardness(3.0F).setResistance(5.0F)
				.setStepSound(Block.soundTypePiston).setBlockName("bluestone_ore").setCreativeTab(CreativeTabs.tabBlock)
				.setBlockTextureName(Bluestone.modid + ":" + "bluestone_ore");
		lit_bluestone_ore = new BlockBluestoneOre(true).setLightLevel(0.625F).setHardness(3.0F).setResistance(5.0F)
				.setStepSound(Block.soundTypePiston).setBlockName("lit_bluestone_ore")
				.setBlockTextureName(Bluestone.modid + ":" + "bluestone_ore");
		unpowered_bluestone_repeater = (BlockBluestoneRepeater) new BlockBluestoneRepeater(false)
				.setBlockName("bluestone_repeater_unlit").setStepSound(Block.soundTypeWood)
				.setBlockTextureName(Bluestone.modid + ":" + "bluestone_repeater_off");
		powered_bluestone_repeater = (BlockBluestoneRepeater) new BlockBluestoneRepeater(true)
				.setBlockName("bluestone_repeater_lit").setStepSound(Block.soundTypeWood).setLightLevel(0.625F)
				.setBlockTextureName(Bluestone.modid + ":" + "bluestone_repeater_on");
		unpowered_bluestone_comparator = (BlockBluestoneComparator) new BlockBluestoneComparator(false)
				.setBlockName("bluestone_comparator_unlit").setStepSound(Block.soundTypeWood)
				.setBlockTextureName(Bluestone.modid + ":" + "bluestone_comparator_off");
		powered_bluestone_comparator = (BlockBluestoneComparator) new BlockBluestoneComparator(true)
				.setBlockName("bluestone_comparator_lit").setStepSound(Block.soundTypeWood)
				.setBlockTextureName(Bluestone.modid + ":" + "bluestone_comparator_on");
		bluestone_wire = (BlockBluestoneWire) new BlockBluestoneWire().setBlockName("bluestone_wire")
				.setBlockTextureName("redstone_dust");
	}

	public static void registerBlocks() {
		GameRegistry.registerBlock(bluestone_block, bluestone_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(unlit_bluestone_torch, unlit_bluestone_torch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(bluestone_torch, bluestone_torch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(bluestone_ore, bluestone_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(lit_bluestone_ore, lit_bluestone_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(unpowered_bluestone_repeater,
				unpowered_bluestone_repeater.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(powered_bluestone_repeater,
				powered_bluestone_repeater.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(unpowered_bluestone_comparator,
				unpowered_bluestone_comparator.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(powered_bluestone_comparator,
				powered_bluestone_comparator.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(bluestone_wire, bluestone_wire.getUnlocalizedName().substring(5));
	}
}
