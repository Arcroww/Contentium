package arcrow.contentium.items;

import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;

public class TotemOfUndying extends Item {
	
	public TotemOfUndying() {
		setTextureName(Reference.MOD_ID + ":totem_of_undying");
		setUnlocalizedName(Utils.getUnlocalisedName("totem_of_undying"));
		setCreativeTab(CreativeTabs.tabCombat);
		setMaxStackSize(1);
	}

}
