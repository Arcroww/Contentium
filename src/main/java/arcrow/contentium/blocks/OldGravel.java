package arcrow.contentium.blocks;

import java.util.Random;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.block.BlockGravel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class OldGravel extends BlockGravel implements IConfigurable {

	public OldGravel() {
		setHardness(0.6F);
		setStepSound(soundTypeGravel);
		setBlockTextureName("old_gravel");
		setBlockName(Utils.getUnlocalisedName("old_gravel"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableOldGravel;
	}
}