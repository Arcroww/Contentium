package arcrow.contentium.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.GUIsID;
import net.minecraft.block.BlockEnchantmentTable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class NewEnchantmentTable extends BlockEnchantmentTable implements IConfigurable {

	public NewEnchantmentTable() {
		setHardness(5.0F);
		setCreativeTab(null);
		setResistance(2000.0F);
		setBlockTextureName("enchanting_table");
		setBlockName(Utils.getUnlocalisedName("enchantment_table"));
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.enchanting_table);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(Blocks.enchanting_table);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return true;
		else {
			player.openGui(Contentium.instance, GUIsID.ENCHANTING_TABLE, world, x, y, z);
			return true;
		}
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableEnchants;
	}
}