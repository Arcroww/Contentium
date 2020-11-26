package arcrow.contentium.client.renderer.block;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import arcrow.contentium.client.OpenGLHelper;
import arcrow.contentium.client.renderer.tileentity.TileEntityEndRodRenderer;
import arcrow.contentium.lib.RenderIDs;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

@SideOnly(Side.CLIENT)
public class BlockEndRodRender implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int meta, int modelID, RenderBlocks renderer) {
		OpenGLHelper.translate(-0.5F, -0.5F, -0.5F);
		TileEntityEndRodRenderer.renderRod(renderer, block, meta);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return RenderIDs.END_ROD;
	}
}