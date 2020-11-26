package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class NetherWartBlock extends Block implements IConfigurable {

	public NetherWartBlock() {
		super(Material.rock);
		setHardness(1F);
		setHarvestLevel("pickaxe", 0);
		setStepSound(soundTypeWood);
		setBlockTextureName(Reference.MOD_ID + ":nether_wart_block");
		setBlockName(Utils.getUnlocalisedName("nether_wart_block"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableNetherWartBlock;
	}



}