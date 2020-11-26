package arcrow.contentium.blocks.stairs;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

public class PurpurStairs extends BlockStairs implements IConfigurable {

	public PurpurStairs() {
		super(ModBlocks.purpur_block, 0);
		setHardness(0.8F);
		setLightOpacity(0);
		setBlockName(Utils.getUnlocalisedName("purpur_stairs"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		return !(entity instanceof EntityDragon);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableChorusFruit;
	}
}