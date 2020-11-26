package arcrow.contentium.blocks;

import arcrow.contentium.IConfigurable;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SmoothQuartz extends Block implements IConfigurable {

	public SmoothQuartz() {
		super(Material.rock);
		setHardness(1F);
		setHarvestLevel("pickaxe", 0);
		setStepSound(soundTypeStone);
		setBlockTextureName("smooth_quartz");
		setBlockName(Reference.MOD_ID + ":smooth_quartz");
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {return false;}



}