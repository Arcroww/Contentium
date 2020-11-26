package arcrow.contentium.blocks.slabs;

import arcrow.contentium.Contentium;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.blocks.GenericSlab;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MossyStoneBrickSlab extends GenericSlab {

	public MossyStoneBrickSlab() {
		super(Material.rock, ModBlocks.mossy_stone_brick_stairs);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("mossy_stone_slab"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":mossy_stone_bricks");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableMossyStoneBrickSlab;
	}
}
