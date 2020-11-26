package arcrow.contentium.blocks.slabs;

import arcrow.contentium.Contentium;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.blocks.GenericSlab;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class PolishedDioriteSlab extends GenericSlab {

	public PolishedDioriteSlab() {
		super(Material.rock, ModBlocks.polished_diorite_stairs);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("polished_diorite_slab"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":polished_diorite");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enablePolishedDioriteSlab;
	}
}