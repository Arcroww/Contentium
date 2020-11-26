package arcrow.contentium.blocks;

import cpw.mods.fml.common.eventhandler.Event.Result;
import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class CoarseDirt extends Block implements IConfigurable {

	public CoarseDirt() {
		super(Material.ground);
		setHardness(0.5F);
		setHarvestLevel("shovel", 0);
		setStepSound(soundTypeGravel);
		setBlockTextureName("coarse_dirt");
		setBlockName(Utils.getUnlocalisedName("coarse_dirt"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
		return Blocks.dirt.canSustainPlant(world, x, y, z, direction, plant);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableCoarseDirt;
	}

	public static void onHoeEvent(UseHoeEvent event) {
		if (Contentium.enableCoarseDirt) {
			World world = event.world;
			if (world.getBlock(event.x, event.y, event.z) == ModBlocks.coarse_dirt) {
				world.setBlock(event.x, event.y, event.z, Blocks.dirt);
				world.playSoundEffect(event.x + 0.5F, event.y + 0.5F, event.z + 0.5F, Block.soundTypeGravel.getStepResourcePath(), 1.0F, 0.8F);
				event.setResult(Result.ALLOW);
			}
		}
	}
}