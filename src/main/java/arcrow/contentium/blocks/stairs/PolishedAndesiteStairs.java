package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class PolishedAndesiteStairs extends BlockStairs implements IConfigurable {

	public PolishedAndesiteStairs() {
		super(ModBlocks.stone, 6);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("polished_andesite_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":polished_andesite");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enablePolishedAndesiteStairs;
	}

}