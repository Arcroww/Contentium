package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class RedSandstoneStairs extends BlockStairs implements IConfigurable {

	public RedSandstoneStairs() {
		super(ModBlocks.red_sandstone, 0);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("red_sandstone_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableRedSandstone;
	}
}