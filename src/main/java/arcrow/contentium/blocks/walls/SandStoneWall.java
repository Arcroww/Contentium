package arcrow.contentium.blocks.walls;

import java.util.List;

import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class SandStoneWall extends BlockWall {
	private static final String __OBFID = "CL_00000331";

	public SandStoneWall() {
		super(Blocks.sandstone);
		this.setHardness(0.8F);
		this.setResistance(1);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName(Utils.getUnlocalisedName("sandstone_wall"));

	}

	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return Blocks.sandstone.getBlockTextureFromSide(p_149691_1_);
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return 32;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean getBlocksMovement(IBlockAccess p_149655_1_, int p_149655_2_, int p_149655_3_, int p_149655_4_) {
		return false;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether or
	 * not to render the shared face of two adjacent blocks and also whether the
	 * player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y, z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_,
			int p_149719_4_) {
		boolean flag = this.canConnectWallTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ - 1);
		boolean flag1 = this.canConnectWallTo(p_149719_1_, p_149719_2_, p_149719_3_, p_149719_4_ + 1);
		boolean flag2 = this.canConnectWallTo(p_149719_1_, p_149719_2_ - 1, p_149719_3_, p_149719_4_);
		boolean flag3 = this.canConnectWallTo(p_149719_1_, p_149719_2_ + 1, p_149719_3_, p_149719_4_);
		float f = 0.25F;
		float f1 = 0.75F;
		float f2 = 0.25F;
		float f3 = 0.75F;
		float f4 = 1.0F;

		if (flag) {
			f2 = 0.0F;
		}

		if (flag1) {
			f3 = 1.0F;
		}

		if (flag2) {
			f = 0.0F;
		}

		if (flag3) {
			f1 = 1.0F;
		}

		if (flag && flag1 && !flag2 && !flag3) {
			f4 = 0.8125F;
			f = 0.3125F;
			f1 = 0.6875F;
		} else if (!flag && !flag1 && flag2 && flag3) {
			f4 = 0.8125F;
			f2 = 0.3125F;
			f3 = 0.6875F;
		}

		this.setBlockBounds(f, 0.0F, f2, f1, f4, f3);
	}

	/**
	 * Returns a bounding box from the pool of bounding boxes (this means this box
	 * can change after the pool has been cleared to be reused)
	 */
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_,
			int p_149668_4_) {
		this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
		this.maxY = 1.5D;
		return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
	}

	/**
	 * Return whether an adjacent block can connect to a wall.
	 */
	public boolean canConnectWallTo(IBlockAccess p_150091_1_, int p_150091_2_, int p_150091_3_, int p_150091_4_) {
		Block block = p_150091_1_.getBlock(p_150091_2_, p_150091_3_, p_150091_4_);
		return block != this && block != Blocks.fence_gate
				? (block.isOpaqueCube() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false)
				: true;
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
		p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
	}

	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	public int damageDropped(int p_149692_1_) {
		return p_149692_1_;
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if the
	 * adjacent block is at the given coordinates. Args: blockAccess, x, y, z, side
	 */
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_,
			int p_149646_5_) {
		return p_149646_5_ == 0
				? super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_)
				: true;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
	}
}
