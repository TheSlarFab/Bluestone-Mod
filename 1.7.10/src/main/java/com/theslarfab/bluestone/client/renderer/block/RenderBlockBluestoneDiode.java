package com.theslarfab.bluestone.client.renderer.block;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class RenderBlockBluestoneDiode implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {

		Tessellator tessellator = Tessellator.instance;
		this.renderBlockRedstoneDiodeMetadata(block, x, y, z, world.getBlockMetadata(x, y, z) & 3, renderer);
		return true;
	}

	public void renderBlockRedstoneDiodeMetadata(Block block, int x, int y, int z, int side, RenderBlocks renderer) {
		
		renderer.renderStandardBlock(block, x, y, z);
		Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness(block.getMixedBrightnessForBlock(renderer.blockAccess, x, y, z));
		tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
		int i1 = renderer.blockAccess.getBlockMetadata(x, y, z);
		IIcon iicon = renderer.getBlockIconFromSideAndMetadata(block, 1, i1);
		double d0 = (double) iicon.getMinU();
		double d1 = (double) iicon.getMaxU();
		double d2 = (double) iicon.getMinV();
		double d3 = (double) iicon.getMaxV();
		double d4 = 0.125D;
		double d5 = (double) (x + 1);
		double d6 = (double) (x + 1);
		double d7 = (double) (x + 0);
		double d8 = (double) (x + 0);
		double d9 = (double) (z + 0);
		double d10 = (double) (z + 1);
		double d11 = (double) (z + 1);
		double d12 = (double) (z + 0);
		double d13 = (double) y + d4;

		if (side == 2) {
			d5 = d6 = (double) (x + 0);
			d7 = d8 = (double) (x + 1);
			d9 = d12 = (double) (z + 1);
			d10 = d11 = (double) (z + 0);
		} else if (side == 3) {
			d5 = d8 = (double) (x + 0);
			d6 = d7 = (double) (x + 1);
			d9 = d10 = (double) (z + 0);
			d11 = d12 = (double) (z + 1);
		} else if (side == 1) {
			d5 = d8 = (double) (x + 1);
			d6 = d7 = (double) (x + 0);
			d9 = d10 = (double) (z + 1);
			d11 = d12 = (double) (z + 0);
		}

		tessellator.addVertexWithUV(d8, d13, d12, d0, d2);
		tessellator.addVertexWithUV(d7, d13, d11, d0, d3);
		tessellator.addVertexWithUV(d6, d13, d10, d1, d3);
		tessellator.addVertexWithUV(d5, d13, d9, d1, d2);
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return false;
	}

	@Override
	public int getRenderId() {
		return BlockRenderingIDs.bluestoneDiodeRenderID;
	}
}
