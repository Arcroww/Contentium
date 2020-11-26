package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Wood extends BlockGeneric implements IConfigurable {
	public static boolean fallInstantly;
    private static final String __OBFID = "CL_00000240";

	public static final int spruce_wood = 1;
	public static final int stripped_spruce_wood = 2;
	public static final int jungle_wood = 3;
	public static final int stripped_jungle_wood = 4;
	public static final int dark_oak_wood = 5;
	public static final int stripped_dark_oak_wood = 6;
	public static final int accacia_wood = 7;
	public static final int stripped_accacia_wood = 8;
	public static final int birch_wood = 9;
	public static final int stripped_birch_wood = 10;
	public static final int oak_wood = 11;
	public static final int stripped_oak = 12;

	public Wood() {
		super(Material.wood, "", "spruce_wood", "stripped_spruce_wood", "jungle_wood",
				"stripped_jungle_wood", "dark_oak_wood", "stripped_dark_oak_wood", "accacia_wood",
				"stripped_accacia_wood", "birch_wood", "stripped_birch_wood", "oak_wood",
				"stripped_oak");
		startMeta = 1;
		setHardness(2F);
		setStepSound(soundTypeWood);
		setBlockTextureName(Reference.MOD_ID + ":wood/");
		setBlockName(Utils.getUnlocalisedName("wood"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableWood;
	}
}