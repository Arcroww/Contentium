package arcrow.contentium;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import arcrow.contentium.configuration.ConfigurationHandler;
import arcrow.contentium.core.proxy.CommonProxy;
import arcrow.contentium.entities.ModEntityList;
import arcrow.contentium.entities.boat.EntityAcaciaBoat;
import arcrow.contentium.entities.boat.EntityBirchBoat;
import arcrow.contentium.entities.boat.EntityDarkOakBoat;
import arcrow.contentium.entities.boat.EntityJungleBoat;
import arcrow.contentium.entities.boat.EntityOakBoat;
import arcrow.contentium.entities.boat.EntitySpruceBoat;
import arcrow.contentium.event.Berries;
import arcrow.contentium.event.StrippedWood;
import arcrow.contentium.event.TotemOfUndying;
import arcrow.contentium.items.ItemEntityEgg;
import arcrow.contentium.lib.Reference;
import arcrow.contentium.network.ArmourStandInteractHandler;
import arcrow.contentium.network.ArmourStandInteractMessage;
import arcrow.contentium.network.BlackHeartParticlesHandler;
import arcrow.contentium.network.BlackHeartParticlesMessage;
import arcrow.contentium.network.SetPlayerModelHandler;
import arcrow.contentium.network.SetPlayerModelMessage;
import arcrow.contentium.recipes.BrewingFuelRegistry;
import arcrow.contentium.recipes.ModRecipes;
import arcrow.contentium.tileentities.TileEntityBlastFurnace;
import arcrow.contentium.tileentities.TileEntitySmoker;
import arcrow.contentium.tileentities.sign.TileEntityAcaciaSign;
import arcrow.contentium.tileentities.sign.TileEntityBirchSign;
import arcrow.contentium.tileentities.sign.TileEntityDarkOakSign;
import arcrow.contentium.tileentities.sign.TileEntityJungleSign;
import arcrow.contentium.tileentities.sign.TileEntitySpruceSign;
import arcrow.contentium.world.EtFuturumWorldGenerator;
import arcrow.contentium.world.OceanMonument;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCMessage;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Contentium {

	@Instance(Reference.MOD_ID)
	public static Contentium instance;
	
	public static final String MOD_CHANNEL = "BetterBoatNWCH";

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static SimpleNetworkWrapper networkWrapper;

	public static boolean enableStones = true;
	public static boolean enableGlazed = true;
	public static boolean enableWall = true;
	public static boolean enableWood = true;
	public static boolean enableLog = true;
	public static boolean enableConcretePowder = true;
	public static boolean enableConcrete = true;
	public static boolean enableCoralBlock = true;
	public static boolean enablestairs = true;
	public static boolean enableIronTrapdoor = true;
	public static boolean enableMutton = true;
	public static boolean enableSponge = true;
	public static boolean enablePrismarine = true;
	public static boolean enableDoors = true;
	public static boolean enableInvertedDaylightSensor = true;
	public static boolean enableCoarseDirt = true;
	public static boolean enableRedSandstone = true;
	public static boolean enableEnchants = true;
	public static boolean enableAnvil = true;
	public static boolean enableFences = true;
	public static boolean enableSilkTouchingMushrooms = true;
	public static boolean enableBanners = true;
	public static boolean enableSlimeBlock = true;
	public static boolean enableArmourStand = true;
	public static boolean enableRabbit = true;
	public static boolean enableOldGravel = true;
	public static boolean enableRecipeForPrismarine = true;
	public static boolean enableEndermite = true;
	public static boolean enableBeetroot = true;
	public static boolean enableChorusFruit = true;
	public static boolean enableGrassPath = true;
	public static boolean enableSticksFromDeadBushes = true;
	public static boolean enableBowRendering = true;
	public static boolean enableTippedArrows = true;
	public static boolean enableLingeringPotions = true;
	public static boolean enableBurnableBlocks = true;
	public static boolean enableFancySkulls = true;
	public static boolean enableSkullDrop = true;
	public static boolean enableDmgIndicator = true;
	public static boolean enableTransparentAmour = true;
	public static boolean enableCryingObsidian = true;
	public static boolean enableUpdatedFoodValues = true;
	public static boolean enableUpdatedHarvestLevels = true;
	public static boolean enableVillagerZombies = true;
	public static boolean enableStoneBrickRecipes = true;
	public static boolean enableBabyGrowthBoost = true;
	public static boolean enableVillagerTurnsIntoWitch = true;
	public static boolean enableElytra = true;
	public static boolean enableFrostWalker = true;
	public static boolean enableMending = true;
	public static boolean enableBrewingStands = true;
	public static boolean enableDragonRespawn = true;
	public static boolean enableRoses = true;
	public static boolean enableColourfulBeacons = true;
	public static boolean enablePlayerSkinOverlay = true;
	public static boolean enableShearableGolems = true;
	public static boolean enableShearableCobwebs = true;
	public static boolean enableRedNetherBrick = true;
	public static boolean enableAndesiteStairs = true;
	public static boolean enableDarkPrismarineBrickStairs = true;
	public static boolean enableDioriteStairs = true;
	public static boolean enableEndStoneBrickStairs = true;
	public static boolean enableGraniteStairs = true;
	public static boolean enableMossyCobblestoneStairs = true;
	public static boolean enableMossyStoneBrickStairs = true;
	public static boolean enablePolishedAndesiteStairs = true;
	public static boolean enablePolishedDioriteStairs = true;
	public static boolean enablePolishedGraniteStairs = true;
	public static boolean enablePrismarineBrickStairs = true;
	public static boolean enablePrismarineStairs = true;
	public static boolean enableRedNetherBrickStairs = true;
	public static boolean enableSandStoneStairs = true;
	public static boolean enableStoneStairs = true;
	public static boolean enableAndesiteSlab = true;
	public static boolean enableDarkPrismarineBrickSlab = true;
	public static boolean enableDioriteSlab = true;
	public static boolean enableEndStoneBrickSlab = true;
	public static boolean enableGraniteSlab = true;
	public static boolean enableMossyCobblestoneSlab = true;
	public static boolean enableMossyStoneBrickSlab = true;
	public static boolean enablePolishedAndesiteSlab = true;
	public static boolean enablePolishedDioriteSlab = true;
	public static boolean enablePolishedGraniteSlab = true;
	public static boolean enablePrismarineBrickSlab = true;
	public static boolean enablePrismarineSlab = true;
	public static boolean enableRedNetherSlab = true;
	public static boolean enableSandStoneSlab = true;
	public static boolean enableStoneSlab = true;
	public static boolean enableNetherWartBlock = true;
	public static boolean enableBlueIce = true;
	public static boolean enableMagma = true;
	public static boolean enableSmoothStone = true;

	public static int maxStonesPerCluster = 33;

	public static boolean isTinkersConstructLoaded = false;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigurationHandler.INSTANCE.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.MOD_ID + ".cfg"));

		GameRegistry.registerWorldGenerator(new EtFuturumWorldGenerator(), 0);
		ModBlocks.init();
		ModItems.init();
		ModEnchantments.init();

//		regListeners(new StrippedLog());
		regListeners(new Berries());
		regListeners(new TotemOfUndying());
		regListeners(new StrippedWood());
		
		OceanMonument.makeMap();	
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
		networkWrapper.registerMessage(ArmourStandInteractHandler.class, ArmourStandInteractMessage.class, 0, Side.SERVER);
		networkWrapper.registerMessage(BlackHeartParticlesHandler.class, BlackHeartParticlesMessage.class, 1, Side.CLIENT);
		networkWrapper.registerMessage(SetPlayerModelHandler.class, SetPlayerModelMessage.class, 2, Side.CLIENT);
		
		EntityRegistry.registerModEntity(EntityOakBoat.class, "OakBoat", 500, instance, 40, 1, true);
		EntityRegistry.registerModEntity(EntitySpruceBoat.class, "SpruceBoat", 501, instance, 40, 1, true);
		EntityRegistry.registerModEntity(EntityBirchBoat.class, "BirchBoat", 502, instance, 40, 1, true);
		EntityRegistry.registerModEntity(EntityJungleBoat.class, "JungleBoat", 503, instance, 40, 1, true);
		EntityRegistry.registerModEntity(EntityAcaciaBoat.class, "AcaciaBoat", 504, instance, 40, 1, true);
		EntityRegistry.registerModEntity(EntityDarkOakBoat.class, "DarkOakBoat", 505, instance, 40, 1, true);
	}

	protected void regListeners(Object o) {
		FMLCommonHandler.instance().bus().register(o);
		MinecraftForge.EVENT_BUS.register(o);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
				
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		ModRecipes.init();

		proxy.registerEvents();
		proxy.registerEntities();
		proxy.registerRenderers();		
		
		if (ModEntityList.hasEntitiesWithEggs()) {
			ModEntityList.entity_egg = new ItemEntityEgg();
			GameRegistry.registerItem(ModEntityList.entity_egg, "entity_egg");
			OreDictionary.registerOre("mobEgg", ModEntityList.entity_egg);
		}

		isTinkersConstructLoaded = Loader.isModLoaded("TConstruct");
		
		GameRegistry.registerTileEntity(TileEntitySmoker.class, "Contentium:TileEntitySmoker");
		GameRegistry.registerTileEntity(TileEntityBlastFurnace.class, "Contentium:TileEntityBlastFurnace");
		
		GameRegistry.registerTileEntity(TileEntityAcaciaSign.class, "Contentium:TileEntityAcaciaSign");
		GameRegistry.registerTileEntity(TileEntityBirchSign.class, "Contentium:TileEntityBirchSign");
		GameRegistry.registerTileEntity(TileEntityDarkOakSign.class, "Contentium:TileEntityDarkOakSign");
		GameRegistry.registerTileEntity(TileEntityJungleSign.class, "Contentium:TileEntityJungleSign");
		GameRegistry.registerTileEntity(TileEntitySpruceSign.class, "Contentium:TileEntitySpruceSign");
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Items.blaze_rod.setFull3D();
		Blocks.trapped_chest.setCreativeTab(CreativeTabs.tabRedstone);

		if (enableUpdatedFoodValues) {
			setFinalField(ItemFood.class, Items.carrot, 3, "healAmount", "field_77853_b");
			setFinalField(ItemFood.class, Items.baked_potato, 5, "healAmount", "field_77853_b");
		}

		if (enableUpdatedHarvestLevels) {
			Blocks.packed_ice.setHarvestLevel("pickaxe", 0);
			Blocks.ladder.setHarvestLevel("axe", 0);
			Blocks.melon_block.setHarvestLevel("axe", 0);
		}
	}

	@EventHandler
	public void processIMCRequests(IMCEvent event) {
		for (IMCMessage message : event.getMessages())
			if (message.key.equals("register-brewing-fuel")) {
				NBTTagCompound nbt = message.getNBTValue();
				ItemStack stack = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("Fuel"));
				int brews = nbt.getInteger("Brews");
				BrewingFuelRegistry.registerFuel(stack, brews);
			}
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
//		if (Contentium.enablePlayerSkinOverlay)
//			event.registerServerCommand(new SetPlayerModelCommand());
	}

	private void setFinalField(Class<?> cls, Object obj, Object newValue, String... fieldNames) {
		try {
			Field field = ReflectionHelper.findField(cls, fieldNames);
			field.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			field.set(obj, newValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}