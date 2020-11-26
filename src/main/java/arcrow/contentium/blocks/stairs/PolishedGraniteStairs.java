package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class PolishedGraniteStairs extends BlockStairs implements IConfigurable {

	public PolishedGraniteStairs() {
		super(ModBlocks.stone, 2);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("polished_granite_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":polished_granite");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enablePolishedGraniteStairs;
	}

}