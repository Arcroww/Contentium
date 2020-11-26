package arcrow.contentium.items;

import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class MuttonRaw extends ItemFood {

	public MuttonRaw() {
		super(2, 0.3F, true);
		setTextureName("mutton_raw");
		setUnlocalizedName(Utils.getUnlocalisedName("mutton_raw"));
		setCreativeTab(CreativeTabs.tabFood);
	}
}