package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class GraniteStairs extends BlockStairs implements IConfigurable {

	public GraniteStairs() {
		super(ModBlocks.stone, 1);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("granite_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":granite");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableGraniteStairs;
	}

}