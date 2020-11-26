package arcrow.contentium.configuration;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import arcrow.contentium.Contentium;
import arcrow.contentium.enchantment.FrostWalker;
import arcrow.contentium.enchantment.Mending;
import arcrow.contentium.lib.Reference;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

	public static ConfigurationHandler INSTANCE = new ConfigurationHandler();
	public Configuration configFile;
	public String[] usedCategories = { Configuration.CATEGORY_GENERAL };

	private int configInteger(String name, boolean requireRestart, int def) {
		return configInteger(name, null, requireRestart, def);
	}

	private int configInteger(String name, String tooltip, boolean requireRestart, int def) {
		int config = configFile.get(Configuration.CATEGORY_GENERAL, name, def, tooltip).getInt(def);
		return config >= 0 ? config : def;
	}

	private boolean configBoolean(String name, String tooltip, boolean requireRestart, boolean def) {
		return configFile.get(Configuration.CATEGORY_GENERAL, name, def, tooltip).getBoolean(def);
	}

	private boolean configBoolean(String name, boolean requireRestart, boolean def) {
		return configBoolean(name, null, requireRestart, def);
	}

	public void init(File file) {
		configFile = new Configuration(file);

		syncConfigs();
	}

	private void syncConfigs() {
		Contentium.enableStones = configBoolean("Stones", true, Contentium.enableStones);
		Contentium.enableIronTrapdoor = configBoolean("Iron Trapdoor", true, Contentium.enableIronTrapdoor);
		Contentium.enableMutton = configBoolean("Mutton", true, Contentium.enableMutton);
		Contentium.enableSponge = configBoolean("Sponge", true, Contentium.enableSponge);
		Contentium.enablePrismarine = configBoolean("Prismarine", true, Contentium.enablePrismarine);
		Contentium.enableDoors = configBoolean("Doors", true, Contentium.enableDoors);
		Contentium.enableInvertedDaylightSensor = configBoolean("Inverted Daylight Sensor", true, Contentium.enableInvertedDaylightSensor);
		Contentium.enableCoarseDirt = configBoolean("Coarse Dirt", true, Contentium.enableCoarseDirt);
		Contentium.enableRedSandstone = configBoolean("Red Sandstone", true, Contentium.enableRedSandstone);
		Contentium.enableEnchants = configBoolean("Enchanting Table", true, Contentium.enableEnchants);
		Contentium.enableAnvil = configBoolean("Anvil", true, Contentium.enableAnvil);
		Contentium.enableFences = configBoolean("Fences and Gates", true, Contentium.enableFences);
		Contentium.enableSilkTouchingMushrooms = configBoolean("Mushroom Blocks", true, Contentium.enableSilkTouchingMushrooms);
		Contentium.enableBanners = configBoolean("Banners", true, Contentium.enableBanners);
		Contentium.enableSlimeBlock = configBoolean("Slime Block", true, Contentium.enableSlimeBlock);
		Contentium.enableArmourStand = configBoolean("Armour Stand", true, Contentium.enableArmourStand);
		Contentium.enableRabbit = configBoolean("Rabbits", true, Contentium.enableRabbit);
		Contentium.enableOldGravel = configBoolean("Old Gravel", true, Contentium.enableOldGravel);
		Contentium.enableRecipeForPrismarine = configBoolean("Recipes for prismarine", true, Contentium.enableRecipeForPrismarine);
		Contentium.enableEndermite = configBoolean("Endermite", true, Contentium.enableEndermite);
		Contentium.enableBeetroot = configBoolean("Beetroot", true, Contentium.enableBeetroot);
		Contentium.enableChorusFruit = configBoolean("Chorus Fruit (and related blocks)", true, Contentium.enableChorusFruit);
		Contentium.enableGrassPath = configBoolean("Grass Path", true, Contentium.enableGrassPath);
		Contentium.enableSticksFromDeadBushes = configBoolean("Dead Bushes drop sticks", true, Contentium.enableSticksFromDeadBushes);
		Contentium.enableBowRendering = configBoolean("Bows render pulling animation on inventory", true, Contentium.enableBowRendering);
		Contentium.enableTippedArrows = configBoolean("Tipped Arrows", true, Contentium.enableTippedArrows);
		Contentium.enableLingeringPotions = configBoolean("Lingering Potions", true, Contentium.enableLingeringPotions);
		Contentium.enableDmgIndicator = configBoolean("Heart Damage Indicator", true, Contentium.enableDmgIndicator);
		Contentium.enableTransparentAmour = configBoolean("Allow non-opaque armour", true, Contentium.enableTransparentAmour);
		Contentium.enableCryingObsidian = configBoolean("Crying Obsidian", true, Contentium.enableCryingObsidian);
		Contentium.enableUpdatedFoodValues = configBoolean("Use updated food values", true, Contentium.enableUpdatedFoodValues);
		Contentium.enableUpdatedHarvestLevels = configBoolean("Use updated harvest levels", true, Contentium.enableUpdatedHarvestLevels);
		Contentium.enableVillagerZombies = configBoolean("Villager Zombies", true, Contentium.enableVillagerZombies);
		Contentium.enableStoneBrickRecipes = configBoolean("Stone Brick Recipes", true, Contentium.enableStoneBrickRecipes);
		Contentium.enableBabyGrowthBoost = configBoolean("Baby growth boost", true, Contentium.enableBabyGrowthBoost);
		Contentium.enableVillagerTurnsIntoWitch = configBoolean("Villagers turn into Witches when struck by lightning", true, Contentium.enableVillagerTurnsIntoWitch);
		Contentium.enableElytra = configBoolean("Elytra", true, Contentium.enableElytra);
		Contentium.enableFancySkulls = configBoolean("Fancy Skulls", true, Contentium.enableFancySkulls);
		Contentium.enableSkullDrop = configBoolean("Skulls drop from charged creeper kills", true, Contentium.enableSkullDrop);
		Contentium.enableBurnableBlocks = configBoolean("Fences, gates and dead bushes burn", true, Contentium.enableBurnableBlocks);
		Contentium.enableFrostWalker = configBoolean("Frost Walker", true, Contentium.enableFrostWalker);
		Contentium.enableMending = configBoolean("Mending", true, Contentium.enableMending);
		Contentium.enableFrostWalker = configBoolean("Frost Walker", true, Contentium.enableFrostWalker);
		FrostWalker.ID = configInteger("Frost Walker ID", true, FrostWalker.ID);
		Mending.ID = configInteger("Mending ID", true, Mending.ID);
		Contentium.enableBrewingStands = configBoolean("Brewing Stands", true, Contentium.enableBrewingStands);
		Contentium.enableRoses = configBoolean("Old Roses", true, Contentium.enableRoses);
		Contentium.enableColourfulBeacons = configBoolean("Colourful Beacon Beams", true, Contentium.enableColourfulBeacons);
		Contentium.maxStonesPerCluster = configInteger("Max number of 1.8 stones in a cluster", true, Contentium.maxStonesPerCluster);
		Contentium.enablePlayerSkinOverlay = configBoolean("Skin overlays", true, Contentium.enablePlayerSkinOverlay);
		Contentium.enableShearableGolems = configBoolean("Shearing Snow Golems", true, Contentium.enableShearableGolems);
		Contentium.enableShearableCobwebs = configBoolean("Shears harvest cobwebs", true, Contentium.enableShearableCobwebs);
		Contentium.enableDragonRespawn = configBoolean("Dragon respawning", true, Contentium.enableDragonRespawn);

		if (configFile.hasChanged())
			configFile.save();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (Reference.MOD_ID.equals(eventArgs.modID))
			syncConfigs();
	}
}
