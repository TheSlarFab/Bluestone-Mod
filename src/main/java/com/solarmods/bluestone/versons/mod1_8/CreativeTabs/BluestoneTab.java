package com.solarmods.bluestone.versons.mod1_8.CreativeTabs;

import com.solarmods.bluestone.versons.mod1_8.Items.BluestoneItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BluestoneTab extends CreativeTabs {

	public BluestoneTab(String label) {
		super(label);
		this.setBackgroundImageName("bluestone.png");
	}

	@Override
	public Item getTabIconItem() {
		return BluestoneItems.itemBluestone;
	}
}
