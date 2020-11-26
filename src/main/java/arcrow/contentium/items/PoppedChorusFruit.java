package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PoppedChorusFruit extends Item implements IConfigurable {

	public PoppedChorusFruit() {
		setTextureName("chorus_fruit_popped");
		setUnlocalizedName(Utils.getUnlocalisedName("chorus_fruit_popped"));
		setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableChorusFruit;
	}
}