package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class CoralBlocks extends BlockGeneric implements IConfigurable {
	public static boolean fallInstantly;

	public static final int BRAIN = 1;
	public static final int BUBBLE = 2;
	public static final int DEAD_BRAIN = 3;
	public static final int DEAD_BUBBLE = 4;
	public static final int DEAD_FIRE = 5;
	public static final int DEAD_HORN = 6;
	public static final int DEAD_TUBE = 7;
	public static final int FIRE = 8;
	public static final int HORN = 9;
	public static final int TUBE = 10;

	public CoralBlocks() {
		super(Material.rock, "", "brain_coral_block", "bubble_coral_block", "dead_brain_coral_block",
				"dead_bubble_coral_block", "dead_fire_coral_block", "dead_horn_coral_block", "dead_tube_coral_block",
				"fire_coral_block", "horn_coral_block", "tube_coral_block");
		startMeta = 1;
		setHardness(0.5F);
		setStepSound(soundTypeMetal);
		setBlockTextureName(Reference.MOD_ID + ":coralblock/");
		setBlockName(Utils.getUnlocalisedName("coralblock"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableCoralBlock;
	}
}