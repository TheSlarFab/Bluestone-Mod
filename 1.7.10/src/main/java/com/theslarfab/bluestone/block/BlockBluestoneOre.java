package com.theslarfab.bluestone.block;

import java.util.Random;

import com.theslarfab.bluestone.Bluestone;
import com.theslarfab.bluestone.init.BluestoneBlocks;
import com.theslarfab.bluestone.init.BluestoneItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBluestoneOre extends Block {
	private boolean field_150187_a;

	public BlockBluestoneOre(boolean p_i45420_1_) {
		super(Material.rock);

		if (p_i45420_1_) {
			this.setTickRandomly(true);
		}

		this.field_150187_a = p_i45420_1_;
	}

	public int tickRate(World p_149738_1_) {
		return 30;
	}

	public void onBlockClicked(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_,
			EntityPlayer p_149699_5_) {
		this.func_150185_e(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_);
		super.onBlockClicked(p_149699_1_, p_149699_2_, p_149699_3_, p_149699_4_, p_149699_5_);
	}

	public void onEntityWalking(World p_149724_1_, int p_149724_2_, int p_149724_3_, int p_149724_4_,
			Entity p_149724_5_) {
		this.func_150185_e(p_149724_1_, p_149724_2_, p_149724_3_, p_149724_4_);
		super.onEntityWalking(p_149724_1_, p_149724_2_, p_149724_3_, p_149724_4_, p_149724_5_);
	}

	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_,
			EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		this.func_150185_e(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
		return super.onBlockActivated(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_,
				p_149727_7_, p_149727_8_, p_149727_9_);
	}

	private void func_150185_e(World p_150185_1_, int p_150185_2_, int p_150185_3_, int p_150185_4_) {
		this.func_150186_m(p_150185_1_, p_150185_2_, p_150185_3_, p_150185_4_);

		if (this == BluestoneBlocks.bluestone_ore) {
			p_150185_1_.setBlock(p_150185_2_, p_150185_3_, p_150185_4_, BluestoneBlocks.lit_bluestone_ore);
		}
	}

	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
		if (this == BluestoneBlocks.lit_bluestone_ore) {
			p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, BluestoneBlocks.bluestone_ore);
		}
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return BluestoneItems.bluestone;
	}

	public int quantityDroppedWithBonus(int p_149679_1_, Random p_149679_2_) {
		return this.quantityDropped(p_149679_2_) + p_149679_2_.nextInt(p_149679_1_ + 1);
	}

	public int quantityDropped(Random p_149745_1_) {
		return 4 + p_149745_1_.nextInt(2);
	}

	public void dropBlockAsItemWithChance(World p_149690_1_, int p_149690_2_, int p_149690_3_, int p_149690_4_,
			int p_149690_5_, float p_149690_6_, int p_149690_7_) {
		super.dropBlockAsItemWithChance(p_149690_1_, p_149690_2_, p_149690_3_, p_149690_4_, p_149690_5_, p_149690_6_,
				p_149690_7_);
	}

	private Random rand = new Random();

	@Override
	public int getExpDrop(IBlockAccess world, int meta, int fortune) {
		if (this.getItemDropped(meta, rand, fortune) != Item.getItemFromBlock(this)) {
			return 1 + rand.nextInt(5);
		}
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z,
			Random random) {
		if (this.field_150187_a) {
			this.func_150186_m(world, x, y, z);
		}
	}

	private void func_150186_m(World world, int x, int y, int z) {
		Random random = world.rand;
		double d0 = 0.0625D;

		for (int l = 0; l < 6; ++l) {
			double d1 = (double) ((float) x + random.nextFloat());
			double d2 = (double) ((float) y + random.nextFloat());
			double d3 = (double) ((float) z + random.nextFloat());

			if (l == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube()) {
				d2 = (double) (y + 1) + d0;
			}

			if (l == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube()) {
				d2 = (double) (y + 0) - d0;
			}

			if (l == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube()) {
				d3 = (double) (z + 1) + d0;
			}

			if (l == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube()) {
				d3 = (double) (z + 0) - d0;
			}

			if (l == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube()) {
				d1 = (double) (x + 1) + d0;
			}

			if (l == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube()) {
				d1 = (double) (x + 0) - d0;
			}

			if (d1 < (double) x || d1 > (double) (x + 1) || d2 < 0.0D
					|| d2 > (double) (y + 1) || d3 < (double) z
					|| d3 > (double) (z + 1)) {
				world.spawnParticle("reddust", d1, d2, d3, -1.0D, 0.0D, 1.0D);
			}
		}
	}

	protected ItemStack createStackedBlock(int p_149644_1_) {
		return new ItemStack(BluestoneBlocks.bluestone_ore);
	}
}