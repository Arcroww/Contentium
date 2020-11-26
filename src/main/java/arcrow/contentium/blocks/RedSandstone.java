package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks.ISubBlocksBlock;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.items.block.ItemBlockRedSandstone;
import net.minecraft.block.BlockSandStone;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class RedSandstone extends BlockSandStone implements ISubBlocksBlock, IConfigurable {

	public RedSandstone() {
		setHardness(0.8F);
		setBlockTextureName("red_sandstone");
		setBlockName(Utils.getUnlocalisedName("red_sandstone"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemBlockRedSandstone.class;
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableRedSandstone;
	}
}