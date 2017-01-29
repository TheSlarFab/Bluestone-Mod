package com.theslarfab.bluestone.proxy;

import com.theslarfab.bluestone.client.renderer.block.RenderBlockBluestoneComparator;
import com.theslarfab.bluestone.client.renderer.block.RenderBlockBluestoneDiode;
import com.theslarfab.bluestone.client.renderer.block.RenderBlockBluestoneRepeater;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy implements IProxy {

	@Override
	public void registerRenders() {
		ClientProxy.registerBlockRenderers();
	}

	public static void registerBlockRenderers() {
		RenderingRegistry.registerBlockHandler(new RenderBlockBluestoneDiode());
		RenderingRegistry.registerBlockHandler(new RenderBlockBluestoneRepeater());
		RenderingRegistry.registerBlockHandler(new RenderBlockBluestoneComparator());
	}
}
