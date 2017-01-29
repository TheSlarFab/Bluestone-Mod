package com.theslarfab.bluestone.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import com.theslarfab.bluestone.client.renderer.block.BlockRenderingIDs;
import com.theslarfab.bluestone.init.BluestoneBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBluestoneComparator extends BlockBluestoneDiode implements ITileEntityProvider {

	public BlockBluestoneComparator(boolean isPowered) {
		super(isPowered);
		this.isBlockContainer = true;
	}

	public Item getItemDropped(int meta, Random random, int fortune) {
		return Items.comparator;
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Items.comparator;
	}

	protected int func_149901_b(int par1) {
		return 2;
	}

	protected BlockBluestoneDiode getBlockPowered() {
		return BluestoneBlocks.powered_bluestone_comparator;
	}

	protected BlockBluestoneDiode getBlockUnpowered() {
		return BluestoneBlocks.unpowered_bluestone_comparator;
	}

	public int getRenderType() {
		return BlockRenderingIDs.bluestoneComparatorRenderID;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		boolean flag = this.isRepeaterPowered || (meta & 8) != 0;
		return side == 0
				? (flag ? BluestoneBlocks.bluestone_torch.getBlockTextureFromSide(side)
						: BluestoneBlocks.unlit_bluestone_torch.getBlockTextureFromSide(side))
				: (side == 1 ? (flag ? BluestoneBlocks.powered_bluestone_comparator.blockIcon : this.blockIcon)
						: Blocks.double_stone_slab.getBlockTextureFromSide(1));
	}

	protected boolean func_149905_c(int powered) {
		return this.isRepeaterPowered || (powered & 8) != 0;
	}

	protected int func_149904_f(IBlockAccess world, int x, int y, int z, int side) {
		return this.getTileEntityComparator(world, x, y, z).getOutputSignal();
	}

	private int getOutputStrength(World world, int x, int y, int z, int side) {
		return !this.func_149969_d(side) ? this.getInputStrength(world, x, y, z, side)
				: Math.max(this.getInputStrength(world, x, y, z, side) - this.func_149902_h(world, x, y, z, side), 0);
	}

	public static boolean func_149969_d(int par1) {
		return (par1 & 4) == 4;
	}

	protected boolean isGettingInput(World world, int x, int y, int z, int side) {
		int i1 = this.getInputStrength(world, x, y, z, side);

		if (i1 >= 15) {
			return true;
		} else if (i1 == 0) {
			return false;
		} else {
			int j1 = this.func_149902_h(world, x, y, z, side);
			return j1 == 0 ? true : i1 >= j1;
		}
	}

	protected int getInputStrength(World world, int x, int y, int z, int side) {
		int i1 = super.getInputStrength(world, x, y, z, side);
		int j1 = getDirection(side);
		int k1 = x + Direction.offsetX[j1];
		int l1 = z + Direction.offsetZ[j1];
		Block block = world.getBlock(k1, y, l1);

		if (block.hasComparatorInputOverride()) {
			i1 = block.getComparatorInputOverride(world, k1, y, l1, Direction.rotateOpposite[j1]);
		} else if (i1 < 15 && block.isNormalCube()) {
			k1 += Direction.offsetX[j1];
			l1 += Direction.offsetZ[j1];
			block = world.getBlock(k1, y, l1);

			if (block.hasComparatorInputOverride()) {
				i1 = block.getComparatorInputOverride(world, k1, y, l1, Direction.rotateOpposite[j1]);
			}
		}

		return i1;
	}

	public TileEntityComparator getTileEntityComparator(IBlockAccess world, int x, int y, int z) {
		return (TileEntityComparator) world.getTileEntity(x, y, z);
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
			float hitY, float hitZ) {
		int i1 = world.getBlockMetadata(x, y, z);
		boolean flag = this.isRepeaterPowered | (i1 & 8) != 0;
		boolean flag1 = !this.func_149969_d(i1);
		int j1 = flag1 ? 4 : 0;
		j1 |= flag ? 8 : 0;
		world.playSoundEffect((double) x + 0.5D, (double) y + 0.5D, (double) z + 0.5D, "random.click", 0.3F,
				flag1 ? 0.55F : 0.5F);
		world.setBlockMetadataWithNotify(x, y, z, j1 | i1 & 3, 2);
		this.func_149972_c(world, x, y, z, world.rand);
		return true;
	}

	protected void func_149897_b(World world, int x, int y, int z, Block block) {
		if (!world.isBlockTickScheduledThisTick(x, y, z, this)) {
			int l = world.getBlockMetadata(x, y, z);
			int i1 = this.getOutputStrength(world, x, y, z, l);
			int j1 = this.getTileEntityComparator(world, x, y, z).getOutputSignal();

			if (i1 != j1 || this.func_149905_c(l) != this.isGettingInput(world, x, y, z, l)) {
				if (this.func_149912_i(world, x, y, z, l)) {
					world.scheduleBlockUpdateWithPriority(x, y, z, this, this.func_149901_b(0), -1);
				} else {
					world.scheduleBlockUpdateWithPriority(x, y, z, this, this.func_149901_b(0), 0);
				}
			}
		}
	}

	private void func_149972_c(World world, int x, int y, int z, Random random) {
		int l = world.getBlockMetadata(x, y, z);
		int i1 = this.getOutputStrength(world, x, y, z, l);
		int j1 = this.getTileEntityComparator(world, x, y, z).getOutputSignal();
		this.getTileEntityComparator(world, x, y, z).setOutputSignal(i1);

		if (j1 != i1 || !this.func_149969_d(l)) {
			boolean flag = this.isGettingInput(world, x, y, z, l);
			boolean flag1 = this.isRepeaterPowered || (l & 8) != 0;

			if (flag1 && !flag) {
				world.setBlockMetadataWithNotify(x, y, z, l & -9, 2);
			} else if (!flag1 && flag) {
				world.setBlockMetadataWithNotify(x, y, z, l | 8, 2);
			}

			this.func_149911_e(world, x, y, z);
		}
	}

	public void updateTick(World world, int x, int y, int z, Random random) {
		if (this.isRepeaterPowered) {
			int l = world.getBlockMetadata(x, y, z);
			world.setBlock(x, y, z, this.getBlockUnpowered(), l | 8, 4);
		}

		this.func_149972_c(world, x, y, z, random);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		world.setTileEntity(x, y, z, this.createNewTileEntity(world, 0));
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int side) {
		super.breakBlock(world, x, y, z, block, side);
		world.removeTileEntity(x, y, z);
		this.func_149911_e(world, x, y, z);
	}

	public boolean onBlockEventReceived(World world, int x, int y, int z, int i, int j) {
		super.onBlockEventReceived(world, x, y, z, i, j);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		return tileentity != null ? tileentity.receiveClientEvent(i, j) : false;
	}

	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityComparator();
	}

	@Override
	public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ) {
		if (y == tileY && world instanceof World) {
			onNeighborBlockChange((World) world, x, y, z, world.getBlock(tileX, tileY, tileZ));
		}
	}

	@Override
	public boolean getWeakChanges(IBlockAccess world, int x, int y, int z) {
		return true;
	}
}