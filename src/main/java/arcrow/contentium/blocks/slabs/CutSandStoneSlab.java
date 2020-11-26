package arcrow.contentium.blocks.slabs;

import arcrow.contentium.Contentium;
import arcrow.contentium.blocks.GenericSlab;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class CutSandStoneSlab extends GenericSlab {

	public CutSandStoneSlab() {
		super(Material.rock, Blocks.sandstone);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("sandstone_slab"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":sandstone");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableSandStoneSlab;
	}
}