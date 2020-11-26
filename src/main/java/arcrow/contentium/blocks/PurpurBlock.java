package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.world.IBlockAccess;

public class PurpurBlock extends Block implements IConfigurable {

	public PurpurBlock() {
		super(Material.rock);
		setHardness(1.5F);
		setResistance(10.0F);
		setStepSound(soundTypePiston);
		setBlockTextureName("purpur_block");
		setBlockName(Utils.getUnlocalisedName("purpur_block"));
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