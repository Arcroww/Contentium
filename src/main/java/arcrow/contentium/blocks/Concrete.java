package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Concrete extends BlockGeneric implements IConfigurable {
	public static boolean fallInstantly;

	public static final int WHITE = 1;
	public static final int ORANGE = 2;
	public static final int MAGENTA = 3;
	public static final int LIGHT_BLUE = 4;
	public static final int YELLOW = 5;
	public static final int LIME = 6;
	public static final int PINK = 7;
	public static final int GRAY = 8;
	public static final int LIGHT_GRAY = 9;
	public static final int CYAN = 10;
	public static final int PURPLE = 11;
	public static final int BLUE = 12;
	public static final int BROWN = 13;
	public static final int GREEN = 14;
	public static final int RED = 15;
	public static final int BLACK = 16;

	public Concrete() {
		super(Material.rock, "", "white_concrete", "orange_concrete", "magenta_concrete",
				"light_blue_concrete", "yellow_concrete", "lime_concrete", "pink_concrete",
				"gray_concrete", "light_gray_concrete", "cyan_concrete", "purple_concrete",
				"blue_concrete", "brown_concrete", "green_concrete", "red_concrete",
				"black_concrete");
		startMeta = 1;
		setHardness(1.8F);
		setStepSound(soundTypeStone);
		setBlockTextureName(Reference.MOD_ID + ":concrete/");
		setBlockName(Utils.getUnlocalisedName("concrete"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableConcrete;
	}
}

