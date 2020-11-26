package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class RabbitRaw extends ItemFood implements IConfigurable {

	public RabbitRaw() {
		super(3, 0.3F, true);
		setTextureName("rabbit_raw");
		setUnlocalizedName(Utils.getUnlocalisedName("rabbit_raw"));
		setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableRabbit;
	}
}