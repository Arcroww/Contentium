package arcrow.contentium.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.tileentities.TileEntityNewBeacon;
import net.minecraft.block.BlockBeacon;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class NewBeacon extends BlockBeacon implements IConfigurable {

	public NewBeacon() {
		setLightLevel(1.0F);
		setCreativeTab(null);
		setBlockTextureName("beacon");
		setBlockName(Utils.getUnlocalisedName("beacon"));
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return Item.getItemFromBlock(Blocks.beacon);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(Blocks.beacon);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityNewBeacon();
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableColourfulBeacons;
	}
}