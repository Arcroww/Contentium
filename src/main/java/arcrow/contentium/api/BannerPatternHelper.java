package arcrow.contentium.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class BannerPatternHelper {

	@SuppressWarnings("unchecked")
	public static void addPattern(String name, String id, ItemStack craftingItem) throws ClassNotFoundException {
		EnumHelper.addEnum((Class<Enum<?>>) Class.forName("arcrow.contentium.tileentities.TileEntityBanner$EnumBannerPattern"), name.toUpperCase(), new Class[] { String.class, String.class, ItemStack.class }, new Object[] { name, id, craftingItem });
	}

	@SuppressWarnings("unchecked")
	public static void addPattern(String name, String id, String craftingTop, String craftingMid, String craftingBot) throws ClassNotFoundException {
		EnumHelper.addEnum((Class<Enum<?>>) Class.forName("arcrow.contentium.tileentities.TileEntityBanner$EnumBannerPattern"), name.toUpperCase(), new Class[] { String.class, String.class, String.class, String.class, String.class }, new Object[] { name, id, craftingTop, craftingMid, craftingBot });
	}
}