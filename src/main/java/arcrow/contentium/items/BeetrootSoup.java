package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSoup;

public class BeetrootSoup extends ItemSoup implements IConfigurable {

	public BeetrootSoup() {
		super(6);
		setContainerItem(Items.bowl);
		setTextureName("beetroot_soup");
		setUnlocalizedName(Utils.getUnlocalisedName("beetroot_soup"));
		setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableBeetroot;
	}
}