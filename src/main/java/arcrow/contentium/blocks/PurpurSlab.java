package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

public class PurpurSlab extends GenericSlab {

	public PurpurSlab() {
		super(Material.rock, ModBlocks.purpur_block);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("purpur_slab"));
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