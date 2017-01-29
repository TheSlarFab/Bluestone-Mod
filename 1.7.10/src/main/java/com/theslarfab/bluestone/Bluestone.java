package com.theslarfab.bluestone;

import com.theslarfab.bluestone.creativetabs.TabBluestone;
import com.theslarfab.bluestone.init.BluestoneBlocks;
import com.theslarfab.bluestone.init.BluestoneItems;
import com.theslarfab.bluestone.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = Bluestone.modid, version = Bluestone.version)
public class Bluestone {

	public static final String modid = "bluestone";
	public static final String version = "1.0";
	public static final String clientside = "com.theslarfab.bluestone.proxy.ClientProxy";
	public static final String serverside = "com.theslarfab.bluestone.proxy.ServerProxy";

	@SidedProxy(clientSide = Bluestone.clientside, serverSide = Bluestone.serverside)
	public static CommonProxy proxy;

	public static final CreativeTabs tabBluestone = new TabBluestone("bluestone");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		BluestoneBlocks.init();
		BluestoneItems.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
