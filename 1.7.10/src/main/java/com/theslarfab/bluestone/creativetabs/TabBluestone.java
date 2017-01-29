package com.theslarfab.bluestone.creativetabs;

import com.theslarfab.bluestone.init.BluestoneItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabBluestone extends CreativeTabs {

	public TabBluestone(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return BluestoneItems.bluestone;
	}
}
