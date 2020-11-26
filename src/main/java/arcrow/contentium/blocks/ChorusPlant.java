package arcrow.contentium.blocks;

import java.util.Random;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModItems;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.RenderIDs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ChorusPlant extends Block implements IConfigurable {

	public ChorusPlant() {
		super(Material.wood);
		setHardness(0.5F);
		setStepSound(soundTypeWood);
		setBlockTextureName("chorus_plant");
		setBlockName(Utils.getUnlocalisedName("chorus_plant"));
		setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity) {
		return !(entity instanceof EntityDragon);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbour) {
		if (neighbour == this)
			world.func_147480_a(x, y, z, true);
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	protected boolean canSilkHarvest() {
		return false;
	}

	@Override
	public int getRenderType() {
		return RenderIDs.CHORUS_PLANT;
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return ModItems.chorus_fruit;
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableChorusFruit;
	}
}