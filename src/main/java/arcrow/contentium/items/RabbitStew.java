package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSoup;

public class RabbitStew extends ItemSoup implements IConfigurable {

	public RabbitStew() {
		super(10);
		setTextureName("rabbit_stew");
		setUnlocalizedName(Utils.getUnlocalisedName("rabbit_stew"));
		setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableRabbit;
	}
}