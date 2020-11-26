package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.entities.EntityPlacedEndCrystal;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSimpleFoiled;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EndCrystal extends ItemSimpleFoiled implements IConfigurable {

	public EndCrystal() {
		setTextureName("end_crystal");
		setUnlocalizedName(Utils.getUnlocalisedName("end_crystal"));
		setCreativeTab(CreativeTabs.tabDecorations);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (side != 1)
			return false;

		Block block = world.getBlock(x, y, z);
		if (block == Blocks.obsidian || block == Blocks.bedrock)
			if (world.isAirBlock(x, y + 1, z)) {
				if (!world.isRemote) {
					EntityPlacedEndCrystal endCrystal = new EntityPlacedEndCrystal(world);
					endCrystal.setPosition(x + 0.5, y, z + 0.5);
					endCrystal.setBlockPos(x, y, z);

					world.spawnEntityInWorld(endCrystal);
					if (!player.capabilities.isCreativeMode)
						stack.stackSize--;
				}
				return true;
			}

		return false;
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableDragonRespawn;
	}
}