package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class RabbitCooked extends ItemFood implements IConfigurable {

	public RabbitCooked() {
		super(5, 0.6F, true);
		setTextureName("rabbit_cooked");
		setUnlocalizedName(Utils.getUnlocalisedName("rabbit_cooked"));
		setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableRabbit;
	}
}