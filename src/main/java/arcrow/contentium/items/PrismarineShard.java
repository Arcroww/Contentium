package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PrismarineShard extends Item implements IConfigurable {

	public PrismarineShard() {
		setTextureName("prismarine_shard");
		setUnlocalizedName(Utils.getUnlocalisedName("prismarine_shard"));
		setCreativeTab(CreativeTabs.tabMisc);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enablePrismarine;
	}
}