package arcrow.contentium.items.signs;

import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import arcrow.contentium.tileentities.sign.TileEntityDarkOakSign;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DarkOakSign extends Item
{
    private static final String __OBFID = "CL_00000064";

    public DarkOakSign()
    {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setTextureName(Reference.MOD_ID + ":sign/dark_oak_sign");
        setUnlocalizedName(Utils.getUnlocalisedName("dark_oak_sign"));
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_7_ == 0)
        {
            return false;
        }
        else if (!p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).getMaterial().isSolid())
        {
            return false;
        }
        else
        {
            if (p_77648_7_ == 1)
            {
                ++p_77648_5_;
            }

            if (p_77648_7_ == 2)
            {
                --p_77648_6_;
            }

            if (p_77648_7_ == 3)
            {
                ++p_77648_6_;
            }

            if (p_77648_7_ == 4)
            {
                --p_77648_4_;
            }

            if (p_77648_7_ == 5)
            {
                ++p_77648_4_;
            }

            if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
            {
                return false;
            }
            else if (!ModBlocks.standing_dark_oak_sign.canPlaceBlockAt(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_))
            {
                return false;
            }
            else if (p_77648_3_.isRemote)
            {
                return true;
            }
            else
            {
                if (p_77648_7_ == 1)
                {
                    int i1 = MathHelper.floor_double((double)((p_77648_2_.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
                    p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, ModBlocks.standing_dark_oak_sign, i1, 3);
                }
                else
                {
                    p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, ModBlocks.wall_dark_oak_sign, p_77648_7_, 3);
                }

                --p_77648_1_.stackSize;
                TileEntityDarkOakSign tileentitysign = (TileEntityDarkOakSign)p_77648_3_.getTileEntity(p_77648_4_, p_77648_5_, p_77648_6_);

                if (tileentitysign != null)
                {
                    p_77648_2_.func_146100_a(tileentitysign);
                }

                return true;
            }
        }
    }
}