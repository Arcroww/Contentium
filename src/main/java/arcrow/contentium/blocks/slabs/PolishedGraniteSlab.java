package arcrow.contentium.blocks.slabs;

import arcrow.contentium.Contentium;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.blocks.GenericSlab;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PolishedGraniteSlab extends GenericSlab {

	public PolishedGraniteSlab() {
		super(Material.rock, ModBlocks.polished_granite_stairs);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("polished_granite_slab"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":polished_granite");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enablePolishedGraniteSlab;
	}
}