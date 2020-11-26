package arcrow.contentium.blocks.slabs;

import arcrow.contentium.Contentium;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.blocks.GenericSlab;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PrismarineBrickSlab extends GenericSlab {

	public PrismarineBrickSlab() {
		super(Material.rock, ModBlocks.prismarine_brick_stairs);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("prismarine_brick_slab"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":prismarine_bricks");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enablePrismarineBrickSlab;
	}
}