package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class RedNetherBrickStairs extends BlockStairs implements IConfigurable {

	public RedNetherBrickStairs() {
		super(ModBlocks.red_nether_brick, 0);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("red_nether_brick_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":red_nether_bricks");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableRedNetherBrickStairs;
	}


}