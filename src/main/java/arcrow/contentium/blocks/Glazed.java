package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Glazed extends BlockGeneric implements IConfigurable {
	public static boolean fallInstantly;

	public static final int black_glazed_terracotta = 1;
	public static final int blue_glazed_terracotta = 2;
	public static final int brown_glazed_terracotta = 3;
	public static final int cyan_glazed_terracotta = 4;
	public static final int gray_glazed_terracotta = 5;
	public static final int green_glazed_terracotta = 6;
	public static final int light_blue_glazed_terracotta = 7;
	public static final int light_gray_glazed_terracotta = 8;
	public static final int lime_glazed_terracotta = 9;
	public static final int magenta_glazed_terracotta = 10;
	public static final int orange_glazed_terracotta = 11;
	public static final int pink_glazed_terracotta = 12;
	public static final int purple_glazed_terracotta = 13;
	public static final int red_glazed_terracotta = 14;
	public static final int white_glazed_terracotta = 15;
	public static final int yellow_glazed_terracotta = 16;

	public Glazed() {
		super(Material.rock, "", "black_glazed_terracotta", "blue_glazed_terracotta", "brown_glazed_terracotta",
				"cyan_glazed_terracotta", "gray_glazed_terracotta", "green_glazed_terracotta",
				"light_blue_glazed_terracotta", "light_gray_glazed_terracotta", "lime_glazed_terracotta",
				"magenta_glazed_terracotta", "orange_glazed_terracotta", "pink_glazed_terracotta",
				"purple_glazed_terracotta", "red_glazed_terracotta", "white_glazed_terracotta",
				"yellow_glazed_terracotta");
		startMeta = 1;
		setHardness(1.4F);
		setBlockTextureName(Reference.MOD_ID + ":glazed/");
		setBlockName(Utils.getUnlocalisedName("glazed"));
		setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableGlazed;
	}
}