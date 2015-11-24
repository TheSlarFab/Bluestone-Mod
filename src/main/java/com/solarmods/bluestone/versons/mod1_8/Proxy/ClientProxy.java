package com.solarmods.bluestone.versons.mod1_8.Proxy;

import com.solarmods.bluestone.versons.mod1_8.Blocks.BluestoneBlocks;
import com.solarmods.bluestone.versons.mod1_8.Items.BluestoneItems;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders() {
		BluestoneBlocks.registerRenders();
		BluestoneItems.registerRenders();
	}
}
