package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RabbitHide extends Item implements IConfigurable {

	public RabbitHide() {
		setTextureName("rabbit_hide");
		setUnlocalizedName(Utils.getUnlocalisedName("rabbit_hide"));
		setCreativeTab(CreativeTabs.tabMisc);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableRabbit;
	}
}