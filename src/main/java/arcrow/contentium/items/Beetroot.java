package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class Beetroot extends ItemFood implements IConfigurable {

	public Beetroot() {
		super(1, 0.6F, false);
		setTextureName("beetroot");
		setUnlocalizedName(Utils.getUnlocalisedName("beetroot"));
		setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableBeetroot;
	}
}