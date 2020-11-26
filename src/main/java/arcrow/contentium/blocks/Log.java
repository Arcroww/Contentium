package arcrow.contentium.blocks;

import java.util.List;

import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class Log extends BlockLog
{
    public static final String[] field_150168_M = new String[] {"stripped_spruce_log", "stripped_jungle_log", "stripped_dark_oak_log", "stripped_acacia_log", "stripped_birch_log", "stripped_oak_log"};
    
    public Log() {
    	
    	setHardness(2F);
		setStepSound(soundTypeWood);
//		setBlockTextureName(Reference.MOD_ID + ":wood/");		
		setCreativeTab(CreativeTabs.tabBlock);
    }

    @SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 3));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 4));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 5));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 6));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        this.field_150167_a = new IIcon[field_150168_M.length];
        this.field_150166_b = new IIcon[field_150168_M.length];

        for (int i = 0; i < this.field_150167_a.length; ++i)
        {
            this.field_150167_a[i] = register.registerIcon(Reference.MOD_ID + ":log/front/_" + field_150168_M[i]);
            this.field_150166_b[i] = register.registerIcon(Reference.MOD_ID + ":log/top/_" + field_150168_M[i] + "_top");
            
            setBlockName(Utils.getUnlocalisedName(field_150168_M[i]));
        }
    }
    
}