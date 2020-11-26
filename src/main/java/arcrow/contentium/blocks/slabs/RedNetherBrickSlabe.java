package arcrow.contentium.blocks.slabs;

import arcrow.contentium.Contentium;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.blocks.GenericSlab;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class RedNetherBrickSlabe extends GenericSlab {

	public RedNetherBrickSlabe() {
		super(Material.rock, ModBlocks.red_nether_brick_stairs);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("red_nether_brick_slab"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":red_nether_bricks");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableRedNetherSlab;
	}
}
