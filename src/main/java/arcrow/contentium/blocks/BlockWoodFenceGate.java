package arcrow.contentium.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks.IBurnableBlock;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class BlockWoodFenceGate extends BlockFenceGate implements IBurnableBlock, IConfigurable {

	private final int meta;

	public BlockWoodFenceGate(int meta) {
		this.meta = meta;
		setHardness(2.0F);
		setResistance(5.0F);
		setStepSound(soundTypeWood);
		setBlockName(Utils.getUnlocalisedName("fence_gate_" + BlockWoodDoor.names[meta]));
		setCreativeTab(CreativeTabs.tabRedstone);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return Blocks.planks.getIcon(side, this.meta);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableFences;
	}
}