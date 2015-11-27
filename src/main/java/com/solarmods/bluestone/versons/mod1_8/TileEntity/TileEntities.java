package com.solarmods.bluestone.versons.mod1_8.TileEntity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntities {
	public static void register() {
		GameRegistry.registerTileEntity(TileEntityBluestoneComparator.class, "bluestoneBluestoneComparator");
	}
}
