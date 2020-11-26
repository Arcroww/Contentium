package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class StoneStairs extends BlockStairs implements IConfigurable {

	public StoneStairs() {
		super(Blocks.stone, 0);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("stone_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":stone");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableStoneStairs;
	}

}
