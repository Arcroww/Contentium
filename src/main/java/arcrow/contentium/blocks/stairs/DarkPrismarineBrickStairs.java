package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class DarkPrismarineBrickStairs extends BlockStairs implements IConfigurable {

	public DarkPrismarineBrickStairs() {
		super(ModBlocks.prismarine, 2);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("dark_prismarine_brick_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":dark_prismarine");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableDarkPrismarineBrickStairs;
	}

}
