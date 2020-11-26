package arcrow.contentium.blocks.slabs;

import java.awt.Color;

import arcrow.contentium.Contentium;
import arcrow.contentium.blocks.GenericSlab;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class MossyCobblestoneSlab extends GenericSlab {

	public MossyCobblestoneSlab() {
		super(Material.rock, Blocks.mossy_cobblestone);
		setResistance(30);
		setHardness(2.0F);
		setBlockName(Utils.getUnlocalisedName("mossy_cobblestone_slab"));
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockTextureName(Reference.MOD_ID + ":mossy_cobblestone");
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableMossyCobblestoneSlab;
	}
}