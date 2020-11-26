package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PrismarineCrystals extends Item implements IConfigurable {

	public PrismarineCrystals() {
		setTextureName("prismarine_crystals");
		setUnlocalizedName(Utils.getUnlocalisedName("prismarine_crystals"));
		setCreativeTab(CreativeTabs.tabMisc);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enablePrismarine;
	}
}