package arcrow.contentium.blocks.buttons;

import arcrow.contentium.core.utils.Utils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockButton;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class BlockSpruceButton extends BlockButton {
	
    private static final String __OBFID = "CL_00000336";

    public BlockSpruceButton()
    {
        super(true);
        setBlockName(Utils.getUnlocalisedName("spruce_button"));
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return Blocks.spruce_stairs.getBlockTextureFromSide(1);
    }

}
