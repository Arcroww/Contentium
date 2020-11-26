package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class RedNetherBrick extends Block implements IConfigurable {

	public RedNetherBrick() {
		super(Material.rock);
		setHardness(1F);
		setHarvestLevel("pickaxe", 0);
		setStepSound(soundTypeStone);
		setBlockTextureName(Reference.MOD_ID + ":red_nether_bricks");
		setBlockName(Utils.getUnlocalisedName("red_nether_bricks"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableRedNetherBrick;
	}



}