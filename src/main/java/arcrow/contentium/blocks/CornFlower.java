package arcrow.contentium.blocks;


import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockBush;
import net.minecraft.creativetab.CreativeTabs;

public class CornFlower extends BlockBush {

	public CornFlower() {

		this.setHardness(0F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName(Utils.getUnlocalisedName("cornflower"));
		this.setBlockTextureName(Reference.MOD_ID + ":flower/cornflower");

	}
}
