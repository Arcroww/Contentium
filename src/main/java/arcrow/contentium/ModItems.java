package arcrow.contentium;

import java.lang.reflect.Field;

import arcrow.contentium.items.Beetroot;
import arcrow.contentium.items.BeetrootSeeds;
import arcrow.contentium.items.BeetrootSoup;
import arcrow.contentium.items.ChorusFruit;
import arcrow.contentium.items.DragonBreath;
import arcrow.contentium.items.Elytra;
import arcrow.contentium.items.EndCrystal;
import arcrow.contentium.items.ItemArmourStand;
import arcrow.contentium.items.LingeringPotion;
import arcrow.contentium.items.MuttonCooked;
import arcrow.contentium.items.MuttonRaw;
import arcrow.contentium.items.PoppedChorusFruit;
import arcrow.contentium.items.PrismarineCrystals;
import arcrow.contentium.items.PrismarineShard;
import arcrow.contentium.items.RabbitCooked;
import arcrow.contentium.items.RabbitFoot;
import arcrow.contentium.items.RabbitHide;
import arcrow.contentium.items.RabbitRaw;
import arcrow.contentium.items.RabbitStew;
import arcrow.contentium.items.SweetBerries;
import arcrow.contentium.items.TippedArrow;
import arcrow.contentium.items.TotemOfUndying;
import arcrow.contentium.items.boat.AcaciaBoat;
import arcrow.contentium.items.boat.BirchBoat;
import arcrow.contentium.items.boat.DarkOakBoat;
import arcrow.contentium.items.boat.JungleBoat;
import arcrow.contentium.items.boat.OakBoat;
import arcrow.contentium.items.boat.SpruceBoat;
import arcrow.contentium.items.signs.AcaciaSign;
import arcrow.contentium.items.signs.BirchSign;
import arcrow.contentium.items.signs.DarkOakSign;
import arcrow.contentium.items.signs.JungleSign;
import arcrow.contentium.items.signs.SpruceSign;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.valkya.valkyris.api.APIProvider;
import net.minecraft.item.Item;

public class ModItems {

	public static final Item raw_mutton = new MuttonRaw();
	public static final Item cooked_mutton = new MuttonCooked();
	public static final Item prismarine_shard = new PrismarineShard();
	public static final Item prismarine_crystals = new PrismarineCrystals();
	public static final Item armour_stand = new ItemArmourStand();
	public static final Item raw_rabbit = new RabbitRaw();
	public static final Item cooked_rabbit = new RabbitCooked();
	public static final Item rabbit_foot = new RabbitFoot();
	public static final Item rabbit_hide = new RabbitHide();
	public static final Item rabbit_stew = new RabbitStew();
	public static final Item beetroot = new Beetroot();
	public static final Item beetroot_seeds = new BeetrootSeeds();
	public static final Item beetroot_soup = new BeetrootSoup();
	public static final Item chorus_fruit = new ChorusFruit();
	public static final Item popped_chorus_fruit = new PoppedChorusFruit();
	public static final Item tipped_arrow = new TippedArrow();
	public static final Item lingering_potion = new LingeringPotion();
	public static final Item dragon_breath = new DragonBreath();
	public static final Item elytra = new Elytra();
	public static final Item end_crystal = new EndCrystal();
	public static final Item spruce_sign = new SpruceSign();
	public static final Item birch_sign = new BirchSign();
	public static final Item acacia_sign = new AcaciaSign();
	public static final Item jungle_sign = new JungleSign();
	public static final Item dark_oak_sign = new DarkOakSign();
	public static final Item oak_boat = new OakBoat();
	public static final Item spruce_boat = new SpruceBoat();
	public static final Item birch_boat = new BirchBoat();
	public static final Item jungle_boat = new JungleBoat();	
	public static final Item acacia_boat = new AcaciaBoat();
	public static final Item dark_oak_boat = new DarkOakBoat();
	public static final Item sweet_berries = new SweetBerries();
	public static final Item totem_of_undying = new TotemOfUndying();


	public static void init() {
		try {
			for (Field f : ModItems.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof Item)
					registerItem((Item) obj);
				else if (obj instanceof Item[])
					for (Item item : (Item[]) obj)
						registerItem(item);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private static void registerItem(Item item) {
		if (!(item instanceof IConfigurable) || ((IConfigurable) item).isEnabled()) {
			String name = item.getUnlocalizedName();
			String[] strings = name.split("\\.");
			GameRegistry.registerItem(item, strings[strings.length - 1]);
		}
	}
}