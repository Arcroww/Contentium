package arcrow.contentium.core.proxy;

import java.util.LinkedList;
import java.util.List;

import arcrow.contentium.Contentium;
import arcrow.contentium.client.gui.inventory.GuiAnvil;
import arcrow.contentium.client.gui.inventory.GuiBlastFurnace;
import arcrow.contentium.client.gui.inventory.GuiEnchantment;
import arcrow.contentium.client.gui.inventory.GuiNewBrewingStand;
import arcrow.contentium.client.gui.inventory.GuiSmoker;
import arcrow.contentium.configuration.ConfigurationHandler;
import arcrow.contentium.container.ContainerBlastFurnace;
import arcrow.contentium.container.ContainerSmoker;
import arcrow.contentium.core.handlers.ServerEventHandler;
import arcrow.contentium.core.handlers.WorldTickEventHandler;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.entities.EntityArmourStand;
import arcrow.contentium.entities.EntityEndermite;
import arcrow.contentium.entities.EntityLingeringEffect;
import arcrow.contentium.entities.EntityLingeringPotion;
import arcrow.contentium.entities.EntityNewSnowGolem;
import arcrow.contentium.entities.EntityPlacedEndCrystal;
import arcrow.contentium.entities.EntityRabbit;
import arcrow.contentium.entities.EntityRespawnedDragon;
import arcrow.contentium.entities.EntityTippedArrow;
import arcrow.contentium.entities.EntityZombieVillager;
import arcrow.contentium.entities.ModEntityList;
import arcrow.contentium.inventory.ContainerAnvil;
import arcrow.contentium.inventory.ContainerEnchantment;
import arcrow.contentium.inventory.ContainerNewBrewingStand;
import arcrow.contentium.lib.GUIsID;
import arcrow.contentium.tileentities.TileEntityBanner;
import arcrow.contentium.tileentities.TileEntityBlastFurnace;
import arcrow.contentium.tileentities.TileEntityEndRod;
import arcrow.contentium.tileentities.TileEntityNewBeacon;
import arcrow.contentium.tileentities.TileEntityNewBrewingStand;
import arcrow.contentium.tileentities.TileEntitySmoker;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy implements IGuiHandler {
	
	protected Minecraft mc;

	public void registerEvents() {
		FMLCommonHandler.instance().bus().register(new WorldTickEventHandler());
		FMLCommonHandler.instance().bus().register(ConfigurationHandler.INSTANCE);
		FMLCommonHandler.instance().bus().register(ServerEventHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(ServerEventHandler.INSTANCE);
	}
	
	public void handleSignGui(TileEntity tile) {}

	public void registerEntities() {
		if (Contentium.enableBanners)
			GameRegistry.registerTileEntity(TileEntityBanner.class, Utils.getUnlocalisedName("banner"));
		if (Contentium.enableArmourStand)
			ModEntityList.registerEntity(EntityArmourStand.class, "wooden_armorstand", 0, Contentium.instance, 64, 1, true);
		if (Contentium.enableEndermite)
			ModEntityList.registerEntity(EntityEndermite.class, "endermite", 1, Contentium.instance, 64, 1, true, 1447446, 7237230);
		if (Contentium.enableChorusFruit)
			GameRegistry.registerTileEntity(TileEntityEndRod.class, Utils.getUnlocalisedName("end_rod"));
		if (Contentium.enableTippedArrows)
			ModEntityList.registerEntity(EntityTippedArrow.class, "tipped_arrow", 2, Contentium.instance, 64, 20, true);
		if (Contentium.enableBrewingStands)
			GameRegistry.registerTileEntity(TileEntityNewBrewingStand.class, Utils.getUnlocalisedName("brewing_stand"));
		if (Contentium.enableColourfulBeacons)
			GameRegistry.registerTileEntity(TileEntityNewBeacon.class, Utils.getUnlocalisedName("beacon"));

		if (Contentium.enableRabbit) {
			ModEntityList.registerEntity(EntityRabbit.class, "rabbit", 3, Contentium.instance, 80, 3, true, 10051392, 7555121);

			List<BiomeGenBase> biomes = new LinkedList<BiomeGenBase>();
			label: for (BiomeGenBase biome : BiomeGenBase.getBiomeGenArray())
				if (biome != null)
					// Check if pigs can spawn on this biome
					for (Object obj : biome.getSpawnableList(EnumCreatureType.creature))
						if (obj instanceof SpawnListEntry) {
							SpawnListEntry entry = (SpawnListEntry) obj;
							if (entry.entityClass == EntityPig.class) {
								biomes.add(biome);
								continue label;
							}
						}
			EntityRegistry.addSpawn(EntityRabbit.class, 10, 3, 3, EnumCreatureType.creature, biomes.toArray(new BiomeGenBase[biomes.size()]));
		}

		if (Contentium.enableLingeringPotions) {
			ModEntityList.registerEntity(EntityLingeringPotion.class, "lingering_potion", 4, Contentium.instance, 64, 10, true);
			ModEntityList.registerEntity(EntityLingeringEffect.class, "lingering_effect", 5, Contentium.instance, 64, 1, true);
		}

		if (Contentium.enableVillagerZombies)
			ModEntityList.registerEntity(EntityZombieVillager.class, "villager_zombie", 6, Contentium.instance, 80, 3, true, 44975, 7969893);

		if (Contentium.enableDragonRespawn) {
			ModEntityList.registerEntity(EntityPlacedEndCrystal.class, "end_crystal", 7, Contentium.instance, 256, Integer.MAX_VALUE, false);
			ModEntityList.registerEntity(EntityRespawnedDragon.class, "ender_dragon", 8, Contentium.instance, 160, 3, true);
		}

		if (Contentium.enableShearableGolems)
			ModEntityList.registerEntity(EntityNewSnowGolem.class, "snow_golem", 9, Contentium.instance, 80, 3, true);
	}

	public void registerRenderers() {
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if(tile instanceof TileEntitySmoker) {
			return new ContainerSmoker(player.inventory, (TileEntitySmoker) tile);
		}
		
		if(tile instanceof TileEntityBlastFurnace) {
			return new ContainerBlastFurnace(player.inventory, (TileEntityBlastFurnace) tile);
		}
		
		switch (ID) {
			case GUIsID.ENCHANTING_TABLE:
				return new ContainerEnchantment(player.inventory, world, x, y, z);
			case GUIsID.ANVIL:
				return new ContainerAnvil(player, world, x, y, z);
			case GUIsID.BREWING_STAND:
				return new ContainerNewBrewingStand(player.inventory, (TileEntityNewBrewingStand) world.getTileEntity(x, y, z));
			default:
				return null;
		}
		
		
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if(tile instanceof TileEntitySmoker) {
			return new GuiSmoker(player.inventory, (TileEntitySmoker) tile);
		}

		if(tile instanceof TileEntityBlastFurnace) {
			return new GuiBlastFurnace(player.inventory, (TileEntityBlastFurnace) tile);
		}		
		
		switch (ID) {
			case GUIsID.ENCHANTING_TABLE:
				return new GuiEnchantment(player.inventory, world, null);
			case GUIsID.ANVIL:
				return new GuiAnvil(player, world, x, y, z);
			case GUIsID.BREWING_STAND:
				return new GuiNewBrewingStand(player.inventory, (TileEntityNewBrewingStand) world.getTileEntity(x, y, z));
			default:
				return null;
		}
	}
		
	
}