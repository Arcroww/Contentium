package arcrow.contentium.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.block.BlockDaylightDetector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class NewDaylightSensor extends BlockDaylightDetector implements IConfigurable {

	public NewDaylightSensor() {
		setHardness(0.2F);
		setCreativeTab(null);
		setStepSound(soundTypeWood);
		setBlockTextureName("daylight_detector");
		setBlockName(Utils.getUnlocalisedName("daylight_sensor"));
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.daylight_detector);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(Blocks.daylight_detector);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote)
			world.setBlock(x, y, z, ModBlocks.inverted_daylight_detector);
		return true;
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableInvertedDaylightSensor;
	}
}