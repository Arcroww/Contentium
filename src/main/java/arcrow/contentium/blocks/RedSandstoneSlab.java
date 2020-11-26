package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class RedSandstoneSlab extends GenericSlab {

	public RedSandstoneSlab() {
		super(Material.rock, ModBlocks.red_sandstone);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("red_sandstone_slab"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableRedSandstone;
	}
}