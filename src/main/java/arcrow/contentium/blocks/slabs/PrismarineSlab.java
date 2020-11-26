package arcrow.contentium.blocks.slabs;

import arcrow.contentium.Contentium;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.blocks.GenericSlab;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PrismarineSlab extends GenericSlab {

	public PrismarineSlab() {
		super(Material.rock, ModBlocks.prismarine);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("prismarine_slab"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":prismarine");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enablePrismarine;
	}
}