package com.zsolqrmods.bluestone;

import com.zsolqrmods.bluestone.blocks.BlockBluestoneOre;
import com.zsolqrmods.bluestone.blocks.BlockBluestoneTorch;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCompressedPowered;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

@Mod(modid = "bluestone", version = "1.0")
public class Bluestone {

	public static CreativeTabs tabBluestone;

	public static Block bluestone_block;
	
	public static Block unlit_bluestone_torch;
	public static Block bluestone_torch;
	
	public static Block bluestone_ore;
	public static Block lit_bluestone_ore;
	
	public static Block unpowered_bluestone_repeater;
	public static Block powered_bluestone_repeater;
	
	public static Block bluestone_wire;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		// Tabs
		
		tabBluestone = new CreativeTabs("tabBluestone") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(Bluestone.bluestone_block);
			}
		};
		
		// Blocks
		
		bluestone_block = new BlockCompressedPowered(MapColor.blueColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setBlockName("bluestone_block").setBlockTextureName("bluestone:bluestone_block").setCreativeTab(Bluestone.tabBluestone);
		GameRegistry.registerBlock(bluestone_block, bluestone_block.getUnlocalizedName().substring(5));
		
		unlit_bluestone_torch = new BlockBluestoneTorch(false).setHardness(0.0F).setStepSound(Block.soundTypeWood).setBlockName("unlit_bluestone_torch").setBlockTextureName("bluestone:bluestone_torch_off");
		GameRegistry.registerBlock(unlit_bluestone_torch, unlit_bluestone_torch.getUnlocalizedName().substring(5));
		
		bluestone_torch = new BlockBluestoneTorch(true).setHardness(0.0F).setLightLevel(0.5F).setStepSound(Block.soundTypeWood).setBlockName("bluestone_torch").setCreativeTab(Bluestone.tabBluestone).setBlockTextureName("bluestone:bluestone_torch_on");
		GameRegistry.registerBlock(bluestone_torch, bluestone_torch.getUnlocalizedName().substring(5));

		bluestone_ore = new BlockBluestoneOre(false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("bluestone_ore").setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName("bluestone:bluestone_ore");
		GameRegistry.registerBlock(bluestone_ore, bluestone_ore.getUnlocalizedName().substring(5));
		
		lit_bluestone_ore = new BlockBluestoneOre(true).setLightLevel(0.625F).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("lit_bluestone_ore").setBlockTextureName("bluestone:bluestone_ore");
		GameRegistry.registerBlock(lit_bluestone_ore, lit_bluestone_ore.getUnlocalizedName().substring(5));
		
		// Items
		
		
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
