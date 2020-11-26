//package arcrow.contentium.client.nei;
//
//import codechicken.nei.api.API;
//import codechicken.nei.api.IConfigureNEI;
//import arcrow.contentium.EtFuturum;
//import arcrow.contentium.ModBlocks;
//import arcrow.contentium.lib.Reference;
//import net.minecraft.item.ItemStack;
//
//public class NEIEtFuturumConfig implements IConfigureNEI {
//
//	@Override
//	public void loadConfig() {
//		if (EtFuturum.enableBanners) {
//			API.registerRecipeHandler(new BannerPatternHandler());
//			API.registerUsageHandler(new BannerPatternHandler());
//		}
//
//		if (EtFuturum.enableBeetroot)
//			API.hideItem(new ItemStack(ModBlocks.beetroot));
//	}
//
//	@Override
//	public String getName() {
//		return Reference.MOD_NAME;
//	}
//
//	@Override
//	public String getVersion() {
//		return Reference.VERSION_NUMBER;
//	}
//}