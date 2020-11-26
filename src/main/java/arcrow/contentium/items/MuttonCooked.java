package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class MuttonCooked extends ItemFood implements IConfigurable {

	public MuttonCooked() {
		super(6, 0.8F, true);
		setTextureName("mutton_cooked");
		setUnlocalizedName(Utils.getUnlocalisedName("mutton_cooked"));
		setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableMutton;
	}
}