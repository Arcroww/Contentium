package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlueIce extends Block implements IConfigurable {

	public BlueIce() {
		super(Material.packedIce);
		setHardness(2.8F);
		setHarvestLevel("pickaxe", 0);
		setStepSound(soundTypeGlass);
		setBlockTextureName(Reference.MOD_ID + ":blue_ice");
		setBlockName(Utils.getUnlocalisedName("blue_ice"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableBlueIce;
	}



}