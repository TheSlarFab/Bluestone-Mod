package com.theslarfab.bluestone.client.renderer.block;

import com.theslarfab.bluestone.block.BlockBluestoneComparator;
import com.theslarfab.bluestone.init.BluestoneBlocks;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderBlockBluestoneComparator implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		RenderBlockBluestoneDiode rbbdiode = new RenderBlockBluestoneDiode();
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		int l = world.getBlockMetadata(x, y, z);
		int i1 = l & 3;
		double d0 = 0.0D;
		double d1 = -0.1875D;
		double d2 = 0.0D;
		double d3 = 0.0D;
		double d4 = 0.0D;
		IIcon iicon;

		if (BlockBluestoneComparator.func_149969_d(l)) {
			iicon = BluestoneBlocks.bluestone_torch.getBlockTextureFromSide(0);
		} else {
			d1 -= 0.1875D;
			iicon = BluestoneBlocks.unlit_bluestone_torch.getBlockTextureFromSide(0);
		}

		switch (i1) {
		case 0:
			d2 = -0.3125D;
			d4 = 1.0D;
			break;
		case 1:
			d0 = 0.3125D;
			d3 = -1.0D;
			break;
		case 2:
			d2 = 0.3125D;
			d4 = -1.0D;
			break;
		case 3:
			d0 = -0.3125D;
			d3 = 1.0D;
		}

		renderer.renderTorchAtAngle(block, (double) x + 0.25D * d3 + 0.1875D * d4, (double) ((float) y - 0.1875F),
				(double) z + 0.25D * d4 + 0.1875D * d3, 0.0D, 0.0D, l);
		renderer.renderTorchAtAngle(block, (double) x + 0.25D * d3 + -0.1875D * d4, (double) ((float) y - 0.1875F),
				(double) z + 0.25D * d4 + -0.1875D * d3, 0.0D, 0.0D, l);
		renderer.setOverrideBlockTexture(iicon);
		renderer.renderTorchAtAngle(block, (double) x + d0, (double) y + d1, (double) z + d2, 0.0D, 0.0D, l);
		renderer.clearOverrideBlockTexture();
		rbbdiode.renderWorldBlock(world, x, y, z, block, modelId, renderer);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return BlockRenderingIDs.bluestoneComparatorRenderID;
	}

}
