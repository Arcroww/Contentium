package arcrow.contentium.lib;

public class Reference {

	public static final String MOD_ID = "contentium";
	public static final String MOD_NAME = "Contentium";
	public static final String DESCRIPTION = "Contentium - basé sur EtFuturum";
	public static final String DEPENDENCIES = "required-after:Forge@[10.13.4.1558,);";
	public static final String VERSION_NUMBER = "1.0";
	public static final String ITEM_BLOCK_TEXTURE_PATH = MOD_ID + ":";
	public static final String ARMOUR_TEXTURE_PATH = ITEM_BLOCK_TEXTURE_PATH + "textures/models/armor/";
	public static final String ENTITY_TEXTURE_PATH = ITEM_BLOCK_TEXTURE_PATH + "textures/entities/";

	public static final String GUI_FACTORY_CLASS = "arcrow.contentium.configuration.ConfigGuiFactory";
	public static final String SERVER_PROXY_CLASS = "arcrow.contentium.core.proxy.CommonProxy";
	public static final String CLIENT_PROXY_CLASS = "arcrow.contentium.core.proxy.ClientProxy";
}