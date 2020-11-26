package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class SandStoneStairs extends BlockStairs implements IConfigurable {

	public SandStoneStairs() {
		super(Blocks.sandstone, 1);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("sandstone_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":sandstone");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableSandStoneStairs;
	}

}