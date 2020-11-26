package arcrow.contentium.blocks;


import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockBush;
import net.minecraft.creativetab.CreativeTabs;

public class LilyValley extends BlockBush {

	public LilyValley() {

		this.setHardness(0F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName(Utils.getUnlocalisedName("lily_valley"));
		this.setBlockTextureName(Reference.MOD_ID + ":flower/lily_valley");

	}

}
