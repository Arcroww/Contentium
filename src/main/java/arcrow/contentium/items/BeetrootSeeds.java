package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class BeetrootSeeds extends ItemSeeds implements IConfigurable {

	public BeetrootSeeds() {
		super(ModBlocks.beetroot, Blocks.farmland);
		setTextureName("beetroot_seeds");
		setUnlocalizedName(Utils.getUnlocalisedName("beetroot_seeds"));
		setCreativeTab(CreativeTabs.tabMisc);

		if (Contentium.enableBeetroot) {
			ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(this), 1, 2, 5));
		}
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableBeetroot;
	}
}