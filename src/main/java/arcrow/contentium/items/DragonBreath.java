package arcrow.contentium.items;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class DragonBreath extends Item implements IConfigurable {

	public DragonBreath() {
		setPotionEffect("-14+13");
		setTextureName("dragon_breath");
		setContainerItem(Items.glass_bottle);
		setUnlocalizedName(Utils.getUnlocalisedName("dragon_breath"));
		setCreativeTab(CreativeTabs.tabBrewing);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableLingeringPotions;
	}
}