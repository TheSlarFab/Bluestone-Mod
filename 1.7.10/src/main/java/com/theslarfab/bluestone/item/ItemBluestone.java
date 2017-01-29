package com.theslarfab.bluestone.item;

import com.theslarfab.bluestone.Bluestone;
import com.theslarfab.bluestone.init.BluestoneBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBluestone extends Item {

	public ItemBluestone() {
		this.setCreativeTab(Bluestone.tabBluestone);
	}

	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side,
			float hitX, float hitY, float hitZ) {
		if (world.getBlock(x, y, z) != Blocks.snow_layer) {
			if (side == 0) {
				--y;
			}

			if (side == 1) {
				++y;
			}

			if (side == 2) {
				--z;
			}

			if (side == 3) {
				++z;
			}

			if (side == 4) {
				--x;
			}

			if (side == 5) {
				++x;
			}

			if (!world.isAirBlock(x, y, z)) {
				return false;
			}
		}

		if (!player.canPlayerEdit(x, y, z, side, itemstack)) {
			return false;
		} else {
			if (BluestoneBlocks.bluestone_wire.canPlaceBlockAt(world, x, y, z)) {
				--itemstack.stackSize;
				world.setBlock(x, y, z, BluestoneBlocks.bluestone_wire);
			}

			return true;
		}
	}
}
