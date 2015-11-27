package com.solarmods.bluestone.versons.mod1_8;

import com.solarmods.bluestone.versons.mod1_8.Blocks.BluestoneBlocks;
import com.solarmods.bluestone.versons.mod1_8.CreativeTabs.BluestoneTab;
import com.solarmods.bluestone.versons.mod1_8.Items.BluestoneItems;
import com.solarmods.bluestone.versons.mod1_8.Proxy.CommonProxy;
import com.solarmods.bluestone.versons.mod1_8.Recipes.BluestoneCraftingRecipes;
import com.solarmods.bluestone.versons.mod1_8.TileEntity.TileEntities;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Bluestone.MOD_ID, version = Bluestone.VERSION)
public class Bluestone {
	
	@SidedProxy(clientSide = Bluestone.CLIENTSIDE, serverSide = Bluestone.SERVERSIDE)
	public static CommonProxy proxy;
	
	public static final BluestoneTab tabBluestone = new BluestoneTab("tabBluestone");
	
	public static final String MOD_ID = "bluestone";
	public static final String VERSION = "1.0";
	public static final String CLIENTSIDE = "com.solarmods.bluestone.versons.mod1_8.Proxy.ClientProxy";
	public static final String SERVERSIDE = "com.solarmods.bluestone.versons.mod1_8.Proxy.CommonProxy";

	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent) {
		BluestoneBlocks.init();
		BluestoneBlocks.register();
		BluestoneItems.init();
		BluestoneItems.register();
		BluestoneCraftingRecipes.register();
		TileEntities.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent preEvent) {
		
	}
}
