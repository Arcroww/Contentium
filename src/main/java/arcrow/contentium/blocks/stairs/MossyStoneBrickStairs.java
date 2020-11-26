package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class MossyStoneBrickStairs extends BlockStairs implements IConfigurable {

	public MossyStoneBrickStairs() {
		super(Blocks.stonebrick, 1);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("mossy_stone_brick_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":mossy_stone_brick");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableMossyStoneBrickStairs;
	}

}