package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Logbackup extends BlockGeneric implements IConfigurable {

	public static final int stripped_spruce_log = 1;
	public static final int stripped_jungle_log = 2;
	public static final int stripped_dark_oak_log = 3;
	public static final int stripped_accacia_log = 4;
	public static final int stripped_birch_log = 5;
	public static final int stripped_oak_log = 6;

	public Logbackup() {
		super(Material.wood, "", "stripped_spruce_log", "stripped_jungle_log", "stripped_dark_oak_log",
				"stripped_accacia_log", "stripped_birch_log", "stripped_oak_log");
		startMeta = 1;
		setHardness(2F);
		setStepSound(soundTypeWood);
//		setBlockTextureName(Reference.MOD_ID + ":wood/");
		setBlockName(Utils.getUnlocalisedName("log"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableLog;
	}

	
	

}