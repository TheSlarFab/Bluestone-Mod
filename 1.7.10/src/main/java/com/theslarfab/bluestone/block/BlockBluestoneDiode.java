package com.theslarfab.bluestone.block;

import java.util.Random;

import com.theslarfab.bluestone.client.renderer.block.BlockRenderingIDs;
import com.theslarfab.bluestone.init.BluestoneBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockBluestoneDiode extends BlockDirectional {

	protected final boolean isRepeaterPowered;

	protected BlockBluestoneDiode(boolean p_i45400_1_) {
		super(Material.circuits);
		this.isRepeaterPowered = p_i45400_1_;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) ? false : super.canPlaceBlockAt(world, x, y, z);
	}

	public boolean canBlockStay(World world, int x, int y, int z) {
		return !World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) ? false : super.canBlockStay(world, x, y, z);
	}

	public void updateTick(World world, int x, int y, int z, Random random) {
		int l = world.getBlockMetadata(x, y, z);

		if (!this.func_149910_g(world, x, y, z, l)) {
			boolean flag = this.isGettingInput(world, x, y, z, l);

			if (this.isRepeaterPowered && !flag) {
				world.setBlock(x, y, z, this.getBlockUnpowered(), l, 2);
			} else if (!this.isRepeaterPowered) {
				world.setBlock(x, y, z, this.getBlockPowered(), l, 2);

				if (!flag) {
					world.scheduleBlockUpdateWithPriority(x, y, z, this.getBlockPowered(), this.func_149899_k(l), -1);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 0
				? (this.isRepeaterPowered ? BluestoneBlocks.bluestone_torch.getBlockTextureFromSide(side)
						: BluestoneBlocks.unlit_bluestone_torch.getBlockTextureFromSide(side))
				: (side == 1 ? this.blockIcon : Blocks.double_stone_slab.getBlockTextureFromSide(1));
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		return side != 0 && side != 1;
	}

	public int getRenderType() {
		return BlockRenderingIDs.bluestoneDiodeRenderID;
	}

	protected boolean func_149905_c(int par1) {
		return this.isRepeaterPowered;
	}

	public int isProvidingStrongPower(IBlockAccess world, int x, int y, int z, int side) {
		return this.isProvidingWeakPower(world, x, y, z, side);
	}

	public int isProvidingWeakPower(IBlockAccess world, int x, int y, int z, int side) {
		int i1 = world.getBlockMetadata(x, y, z);

		if (!this.func_149905_c(i1)) {
			return 0;
		} else {
			int j1 = getDirection(i1);
			return j1 == 0 && side == 3 ? this.func_149904_f(world, x, y, z, i1)
					: (j1 == 1 && side == 4 ? this.func_149904_f(world, x, y, z, i1)
							: (j1 == 2 && side == 2 ? this.func_149904_f(world, x, y, z, i1)
									: (j1 == 3 && side == 5 ? this.func_149904_f(world, x, y, z, i1) : 0)));
		}
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (!this.canBlockStay(world, x, y, z)) {
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
			world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
		} else {
			this.func_149897_b(world, x, y, z, block);
		}
	}

	protected void func_149897_b(World world, int x, int y, int z, Block block) {
		int l = world.getBlockMetadata(x, y, z);

		if (!this.func_149910_g(world, x, y, z, l)) {
			boolean flag = this.isGettingInput(world, x, y, z, l);

			if ((this.isRepeaterPowered && !flag || !this.isRepeaterPowered && flag)
					&& !world.isBlockTickScheduledThisTick(x, y, z, this)) {
				byte b0 = -1;

				if (this.func_149912_i(world, x, y, z, l)) {
					b0 = -3;
				} else if (this.isRepeaterPowered) {
					b0 = -2;
				}

				world.scheduleBlockUpdateWithPriority(x, y, z, this, this.func_149901_b(l), b0);
			}
		}
	}

	public boolean func_149910_g(IBlockAccess world, int x, int y, int z, int side) {
		return false;
	}

	protected boolean isGettingInput(World world, int x, int y, int z, int side) {
		return this.getInputStrength(world, x, y, z, side) > 0;
	}

	protected int getInputStrength(World world, int x, int y, int z, int side) {
		int i1 = getDirection(side);
		int j1 = x + Direction.offsetX[i1];
		int k1 = z + Direction.offsetZ[i1];
		int l1 = world.getIndirectPowerLevelTo(j1, y, k1, Direction.directionToFacing[i1]);
		return l1 >= 15 ? l1
				: Math.max(l1,
						world.getBlock(j1, y, k1) == BluestoneBlocks.bluestone_wire ? world.getBlockMetadata(j1, y, k1) : 0);
	}

	protected int func_149902_h(IBlockAccess world, int x, int y, int z, int side) {
		int i1 = getDirection(side);

		switch (i1) {
		case 0:
		case 2:
			return Math.max(this.func_149913_i(world, x - 1, y, z, 4), this.func_149913_i(world, x + 1, y, z, 5));
		case 1:
		case 3:
			return Math.max(this.func_149913_i(world, x, y, z + 1, 3), this.func_149913_i(world, x, y, z - 1, 2));
		default:
			return 0;
		}
	}

	protected int func_149913_i(IBlockAccess world, int x, int y, int z, int side) {
		Block block = world.getBlock(x, y, z);
		return this.func_149908_a(block) ? (block == BluestoneBlocks.bluestone_wire ? world.getBlockMetadata(x, y, z)
				: world.isBlockProvidingPowerTo(x, y, z, side)) : 0;
	}

	public boolean canProvidePower() {
		return true;
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase livingBase, ItemStack itemstack) {
		int l = ((MathHelper.floor_double((double) (livingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) + 2) % 4;
		world.setBlockMetadataWithNotify(x, y, z, l, 3);
		boolean flag = this.isGettingInput(world, x, y, z, l);

		if (flag) {
			world.scheduleBlockUpdate(x, y, z, this, 1);
		}
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		this.func_149911_e(world, x, y, z);
	}

	protected void func_149911_e(World world, int x, int y, int z) {
		int l = getDirection(world.getBlockMetadata(x, y, z));

		if (l == 1) {
			world.notifyBlockOfNeighborChange(x + 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x + 1, y, z, this, 4);
		}

		if (l == 3) {
			world.notifyBlockOfNeighborChange(x - 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x - 1, y, z, this, 5);
		}

		if (l == 2) {
			world.notifyBlockOfNeighborChange(x, y, z + 1, this);
			world.notifyBlocksOfNeighborChange(x, y, z + 1, this, 2);
		}

		if (l == 0) {
			world.notifyBlockOfNeighborChange(x, y, z - 1, this);
			world.notifyBlocksOfNeighborChange(x, y, z - 1, this, 3);
		}
	}

	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int side) {
		if (this.isRepeaterPowered) {
			world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
			world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
			world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
			world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
			world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
		}

		super.onBlockDestroyedByPlayer(world, x, y, z, side);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	protected boolean func_149908_a(Block block) {
		return block.canProvidePower();
	}

	protected int func_149904_f(IBlockAccess world, int x, int y, int z, int side) {
		return 15;
	}

	public static boolean isRedstoneRepeaterBlockID(Block block) {
		return BluestoneBlocks.unpowered_bluestone_repeater.func_149907_e(block)
				|| BluestoneBlocks.unpowered_bluestone_comparator.func_149907_e(block);
	}

	public boolean func_149907_e(Block block) {
		return block == this.getBlockPowered() || block == this.getBlockUnpowered();
	}

	public boolean func_149912_i(World world, int x, int y, int z, int side) {
		int i1 = getDirection(side);

		if (isRedstoneRepeaterBlockID(world.getBlock(x - Direction.offsetX[i1], y, z - Direction.offsetZ[i1]))) {
			int j1 = world.getBlockMetadata(x - Direction.offsetX[i1], y, z - Direction.offsetZ[i1]);
			int k1 = getDirection(j1);
			return k1 != i1;
		} else {
			return false;
		}
	}

	protected int func_149899_k(int var1) {
		return this.func_149901_b(var1);
	}

	protected abstract int func_149901_b(int par1);

	protected abstract BlockBluestoneDiode getBlockPowered();

	protected abstract BlockBluestoneDiode getBlockUnpowered();

	public boolean isAssociatedBlock(Block block) {
		return this.func_149907_e(block);
	}
}
