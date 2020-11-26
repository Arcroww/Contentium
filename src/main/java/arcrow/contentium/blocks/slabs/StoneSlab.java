package arcrow.contentium.blocks.slabs;

import arcrow.contentium.Contentium;
import arcrow.contentium.blocks.GenericSlab;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class StoneSlab extends GenericSlab {

	public StoneSlab() {
		super(Material.rock, Blocks.stone);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("stone_slab"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":stone");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableStoneSlab;
	}
}