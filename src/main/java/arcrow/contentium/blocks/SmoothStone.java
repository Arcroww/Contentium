package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SmoothStone extends Block implements IConfigurable {

	public SmoothStone() {
		super(Material.rock);
		setHardness(2F);
		setResistance(6F);
		setHarvestLevel("pickaxe", 0);
		setStepSound(soundTypeStone);
		setBlockName(Utils.getUnlocalisedName("smooth_stone"));
		setBlockTextureName(Reference.MOD_ID + ":smooth_stone");
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableSmoothStone;
		}



}