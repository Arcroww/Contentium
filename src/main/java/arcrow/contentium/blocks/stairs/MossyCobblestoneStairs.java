package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class MossyCobblestoneStairs extends BlockStairs implements IConfigurable {

	public MossyCobblestoneStairs() {
		super(Blocks.mossy_cobblestone, 1);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("mossy_cobblestone_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":mossy_cobblestone");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableMossyCobblestoneStairs;
	}

}