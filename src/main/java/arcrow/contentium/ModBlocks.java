package arcrow.contentium;

import java.lang.reflect.Field;

import arcrow.contentium.blocks.BerryCrops;
import arcrow.contentium.blocks.BlockBanner;
import arcrow.contentium.blocks.BlockBeetroot;
import arcrow.contentium.blocks.BlockBlastFurnace;
import arcrow.contentium.blocks.BlockNewPressurePlate;
import arcrow.contentium.blocks.BlockNewTrapDoor;
import arcrow.contentium.blocks.BlockSilkedMushroom;
import arcrow.contentium.blocks.BlockSmoker;
import arcrow.contentium.blocks.BlockWoodDoor;
import arcrow.contentium.blocks.BlockWoodFence;
import arcrow.contentium.blocks.BlockWoodFenceGate;
import arcrow.contentium.blocks.BlueIce;
import arcrow.contentium.blocks.ChorusFlower;
import arcrow.contentium.blocks.ChorusPlant;
import arcrow.contentium.blocks.CoarseDirt;
import arcrow.contentium.blocks.Concrete;
import arcrow.contentium.blocks.ConcretePowder;
import arcrow.contentium.blocks.CoralBlocks;
import arcrow.contentium.blocks.CornFlower;
import arcrow.contentium.blocks.EndBricks;
import arcrow.contentium.blocks.EndRod;
import arcrow.contentium.blocks.FrostedIce;
import arcrow.contentium.blocks.Glazed;
import arcrow.contentium.blocks.GrassPath;
import arcrow.contentium.blocks.InvertedDaylightDetector;
import arcrow.contentium.blocks.IronTrapdoor;
import arcrow.contentium.blocks.LilyValley;
import arcrow.contentium.blocks.Log;
import arcrow.contentium.blocks.MagmaBlock;
import arcrow.contentium.blocks.NetherWartBlock;
import arcrow.contentium.blocks.NewAnvil;
import arcrow.contentium.blocks.NewBeacon;
import arcrow.contentium.blocks.NewBrewingStand;
import arcrow.contentium.blocks.NewDaylightSensor;
import arcrow.contentium.blocks.NewEnchantmentTable;
import arcrow.contentium.blocks.OldGravel;
import arcrow.contentium.blocks.OldRose;
import arcrow.contentium.blocks.PrismarineBlocks;
import arcrow.contentium.blocks.PurpurBlock;
import arcrow.contentium.blocks.PurpurPillar;
import arcrow.contentium.blocks.PurpurSlab;
import arcrow.contentium.blocks.RedNetherBrick;
import arcrow.contentium.blocks.RedSandstone;
import arcrow.contentium.blocks.RedSandstoneSlab;
import arcrow.contentium.blocks.SeaLantern;
import arcrow.contentium.blocks.SlimeBlock;
import arcrow.contentium.blocks.SmoothStone;
import arcrow.contentium.blocks.Sponge;
import arcrow.contentium.blocks.Stone;
import arcrow.contentium.blocks.WitherRose;
import arcrow.contentium.blocks.Wood;
import arcrow.contentium.blocks.buttons.BlockAcaciaButton;
import arcrow.contentium.blocks.buttons.BlockBirchButton;
import arcrow.contentium.blocks.buttons.BlockDarkOakButton;
import arcrow.contentium.blocks.buttons.BlockJungleButton;
import arcrow.contentium.blocks.buttons.BlockSpruceButton;
import arcrow.contentium.blocks.signs.AcaciaSignBlock;
import arcrow.contentium.blocks.signs.BirchSignBlock;
import arcrow.contentium.blocks.signs.DarkOakSignBlock;
import arcrow.contentium.blocks.signs.JungleSignBlock;
import arcrow.contentium.blocks.signs.SpruceSignBlock;
import arcrow.contentium.blocks.slabs.AndesiteSlab;
import arcrow.contentium.blocks.slabs.CutSandStoneSlab;
import arcrow.contentium.blocks.slabs.DarkPrismarineBrickSlab;
import arcrow.contentium.blocks.slabs.DioriteSlab;
import arcrow.contentium.blocks.slabs.EndStoneBrickSlab;
import arcrow.contentium.blocks.slabs.GraniteSlab;
import arcrow.contentium.blocks.slabs.MossyCobblestoneSlab;
import arcrow.contentium.blocks.slabs.MossyStoneBrickSlab;
import arcrow.contentium.blocks.slabs.PolishedAndesiteSlab;
import arcrow.contentium.blocks.slabs.PolishedDioriteSlab;
import arcrow.contentium.blocks.slabs.PolishedGraniteSlab;
import arcrow.contentium.blocks.slabs.PrismarineBrickSlab;
import arcrow.contentium.blocks.slabs.PrismarineSlab;
import arcrow.contentium.blocks.slabs.RedNetherBrickSlabe;
import arcrow.contentium.blocks.slabs.StoneSlab;
import arcrow.contentium.blocks.stairs.AndesiteStairs;
import arcrow.contentium.blocks.stairs.DarkPrismarineBrickStairs;
import arcrow.contentium.blocks.stairs.DioriteStairs;
import arcrow.contentium.blocks.stairs.EndStoneBrickStairs;
import arcrow.contentium.blocks.stairs.GraniteStairs;
import arcrow.contentium.blocks.stairs.MossyCobblestoneStairs;
import arcrow.contentium.blocks.stairs.MossyStoneBrickStairs;
import arcrow.contentium.blocks.stairs.PolishedAndesiteStairs;
import arcrow.contentium.blocks.stairs.PolishedDioriteStairs;
import arcrow.contentium.blocks.stairs.PolishedGraniteStairs;
import arcrow.contentium.blocks.stairs.PrismarineBrickStairs;
import arcrow.contentium.blocks.stairs.PrismarineStairs;
import arcrow.contentium.blocks.stairs.PurpurStairs;
import arcrow.contentium.blocks.stairs.RedNetherBrickStairs;
import arcrow.contentium.blocks.stairs.RedSandstoneStairs;
import arcrow.contentium.blocks.stairs.SandStoneStairs;
import arcrow.contentium.blocks.stairs.StoneStairs;
import arcrow.contentium.blocks.walls.AndesiteWall;
import arcrow.contentium.blocks.walls.BrickWall;
import arcrow.contentium.blocks.walls.DioriteWall;
import arcrow.contentium.blocks.walls.EndStoneBrickWall;
import arcrow.contentium.blocks.walls.GraniteWall;
import arcrow.contentium.blocks.walls.MossyStoneBrickWall;
import arcrow.contentium.blocks.walls.NeitherBrickWall;
import arcrow.contentium.blocks.walls.PrismarineWall;
import arcrow.contentium.blocks.walls.RedNetherBrickWall;
import arcrow.contentium.blocks.walls.RedSandStoneWall;
import arcrow.contentium.blocks.walls.SandStoneWall;
import arcrow.contentium.blocks.walls.StoneBrickWall;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import arcrow.contentium.tileentities.sign.TileEntityAcaciaSign;
import arcrow.contentium.tileentities.sign.TileEntityBirchSign;
import arcrow.contentium.tileentities.sign.TileEntityDarkOakSign;
import arcrow.contentium.tileentities.sign.TileEntityJungleSign;
import arcrow.contentium.tileentities.sign.TileEntitySpruceSign;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;

public class ModBlocks {

	public static final Block stone = new Stone();
	public static final Block glazed = new Glazed();
	public static final Block spruce_button = new BlockSpruceButton();
	public static final Block birch_button = new BlockBirchButton();
	public static final Block jungle_button = new BlockJungleButton();
	public static final Block acacia_button = new BlockAcaciaButton();
	public static final Block dark_oak_button = new BlockDarkOakButton();
	public static final Block concrete_powder = new ConcretePowder();
	public static final Block coral_blocks = new CoralBlocks();
	public static final Block wood = new Wood();
	public static final Block log = new Log();
	public static final Block concrete = new Concrete();
	public static final Block iron_trapdoor = new IronTrapdoor();
	public static final Block prismarine = new PrismarineBlocks();
	public static final Block sea_lantern = new SeaLantern();
	public static final Block inverted_daylight_detector = new InvertedDaylightDetector();
	public static final Block red_sandstone = new RedSandstone();
	public static final Block red_sandstone_slab = new RedSandstoneSlab();
	public static final Block red_sandstone_stairs = new RedSandstoneStairs();
	public static final Block brown_mushroom_block = new BlockSilkedMushroom(Blocks.brown_mushroom_block, "brown");
	public static final Block red_mushroom_block = new BlockSilkedMushroom(Blocks.red_mushroom_block, "red");
	public static final Block coarse_dirt = new CoarseDirt();
	public static final Block red_nether_brick = new RedNetherBrick();
	public static final Block banner = new BlockBanner();
	public static final Block slime = new SlimeBlock();
	public static final Block sponge = new Sponge();
	public static final Block end_bricks = new EndBricks();
	public static final Block old_gravel = new OldGravel();
	public static final Block beetroot = new BlockBeetroot();
	public static final Block purpur_block = new PurpurBlock();
	public static final Block purpur_pillar = new PurpurPillar();
	public static final Block purpur_stairs = new PurpurStairs();
	public static final Block sandstone_stairs = new SandStoneStairs();
	public static final Block diorite_stairs = new DioriteStairs();
	public static final Block polished_diorite_stairs = new PolishedDioriteStairs();
	public static final Block prismarine_stairs = new PrismarineStairs();
	public static final Block prismarine_brick_stairs = new PrismarineBrickStairs();
	public static final Block dark_prismarine_brick_stairs = new DarkPrismarineBrickStairs();
	public static final Block granite_stairs = new GraniteStairs();
	public static final Block polished_granite_stairs = new PolishedGraniteStairs();
	public static final Block andesite_stairs = new AndesiteStairs();
	public static final Block polished_andesite_stairs = new PolishedAndesiteStairs();
	public static final Block stone_stairs = new StoneStairs();
	public static final Block mossy_cobblestone_stairs = new MossyCobblestoneStairs();
	public static final Block mossy_stone_brick_stairs = new MossyStoneBrickStairs();
	public static final Block end_stone_brick_stairs = new EndStoneBrickStairs();
	public static final Block red_nether_brick_stairs = new RedNetherBrickStairs();
	public static final Block purpur_slab = new PurpurSlab();
	public static final Block grass_path = new GrassPath();
	public static final Block end_rod = new EndRod();
	public static final Block chorus_plant = new ChorusPlant();
	public static final Block chorus_flower = new ChorusFlower();
	public static final Block frosted_ice = new FrostedIce();
	public static final Block brewing_stand = new NewBrewingStand();
	public static final Block rose = new OldRose();
	public static final Block beacon = new NewBeacon();
	public static final Block enchantment_table = new NewEnchantmentTable();
	public static final Block anvil = new NewAnvil();
	public static final Block daylight_sensor = new NewDaylightSensor();	
	public static final Block cut_sandstone_slab = new CutSandStoneSlab();
	public static final Block diorite_slab = new DioriteSlab();
	public static final Block polished_diorite_slab = new PolishedDioriteSlab();
	public static final Block prismarine_slab = new PrismarineSlab();
	public static final Block prismarine_brick_slab = new PrismarineBrickSlab();
	public static final Block dark_prismarine_brick_slab = new DarkPrismarineBrickSlab();
	public static final Block granite_slab = new GraniteSlab();
	public static final Block polished_granite_slab = new PolishedGraniteSlab();
	public static final Block andesite_slab = new AndesiteSlab();
	public static final Block polished_andesite_slab = new PolishedAndesiteSlab();
	public static final Block stone_slab = new StoneSlab();
	public static final Block mossy_cobblestone_slab = new MossyCobblestoneSlab();
	public static final Block mossy_stone_brick_slab = new MossyStoneBrickSlab();
	public static final Block end_stone_brick_slab = new EndStoneBrickSlab();
	public static final Block red_nether_brick_slab = new RedNetherBrickSlabe();	
	public static final Block nether_wart_block = new NetherWartBlock();
	public static final Block blue_ice = new BlueIce();
	public static final Block magma_block = new MagmaBlock();
	public static final Block smooth_stone = new SmoothStone();
	public static final Block prismarine_wall = new PrismarineWall();
	public static final Block brick_wall = new BrickWall();
	public static final Block diorite_wall = new DioriteWall();
	public static final Block endstonebrick_wall = new EndStoneBrickWall();
	public static final Block granite_wall = new GraniteWall();
	public static final Block mossystonebrick_wall = new MossyStoneBrickWall();
	public static final Block neitherbrick_wall = new NeitherBrickWall();
	public static final Block rednetherbrick_wall = new RedNetherBrickWall();
	public static final Block redsandstone_wall = new RedSandStoneWall();
	public static final Block sandstone_wall = new SandStoneWall();
	public static final Block stonebrick_wall = new StoneBrickWall();
	public static final Block andesite_wall = new AndesiteWall();
	public static final Block wither_rose = new WitherRose();
	public static final Block lily_valley = new LilyValley();
	public static final Block corn_flower = new CornFlower();
	public static final Block spruce_pressure_plate = new BlockNewPressurePlate("planks_spruce", Material.wood, BlockPressurePlate.Sensitivity.mobs).setHardness(0.5F).setBlockName(Utils.getUnlocalisedName("spruce_pressure_plate"));
	public static final Block birch_pressure_plate = new BlockNewPressurePlate("planks_birch", Material.wood, BlockPressurePlate.Sensitivity.mobs).setHardness(0.5F).setBlockName(Utils.getUnlocalisedName("birch_pressure_plate"));
	public static final Block jungle_pressure_plate = new BlockNewPressurePlate("planks_jungle", Material.wood, BlockPressurePlate.Sensitivity.mobs).setHardness(0.5F).setBlockName(Utils.getUnlocalisedName("jungle_pressure_plate"));
	public static final Block acacia_pressure_plate = new BlockNewPressurePlate("planks_acacia", Material.wood, BlockPressurePlate.Sensitivity.mobs).setHardness(0.5F).setBlockName(Utils.getUnlocalisedName("acacia_pressure_plate"));
	public static final Block dark_oak_pressure_plate = new BlockNewPressurePlate("planks_big_oak", Material.wood, BlockPressurePlate.Sensitivity.mobs).setHardness(0.5F).setBlockName(Utils.getUnlocalisedName("dark_oak_pressure_plate"));
	
	public static final Block spruce_trapdoor = new BlockNewTrapDoor(Material.wood).setHardness(3.0F).setBlockName(Utils.getUnlocalisedName("spruce_trapdoor")).setBlockTextureName(Reference.MOD_ID + ":trapdoor/spruce_trapdoor");
	public static final Block birch_trapdoor = new BlockNewTrapDoor(Material.wood).setHardness(3.0F).setBlockName(Utils.getUnlocalisedName("birch_trapdoor")).setBlockTextureName(Reference.MOD_ID + ":trapdoor/birch_trapdoor");
	public static final Block jungle_trapdoor = new BlockNewTrapDoor(Material.wood).setHardness(3.0F).setBlockName(Utils.getUnlocalisedName("jungle_trapdoor")).setBlockTextureName(Reference.MOD_ID + ":trapdoor/jungle_trapdoor");
	public static final Block acacia_trapdoor = new BlockNewTrapDoor(Material.wood).setHardness(3.0F).setBlockName(Utils.getUnlocalisedName("acacia_trapdoor")).setBlockTextureName(Reference.MOD_ID + ":trapdoor/acacia_trapdoor");
	public static final Block dark_oak_trapdoor = new BlockNewTrapDoor(Material.wood).setHardness(3.0F).setBlockName(Utils.getUnlocalisedName("dark_oak_trapdoor")).setBlockTextureName(Reference.MOD_ID + ":trapdoor/dark_oak_trapdoor");

	//sign
	public static final Block standing_spruce_sign = new SpruceSignBlock(TileEntitySpruceSign.class, true).setBlockName("standing_spruce_sign");
	public static final Block wall_spruce_sign = new SpruceSignBlock(TileEntitySpruceSign.class, false).setBlockName("wall_spruce_sign");	
	public static final Block standing_birch_sign = new BirchSignBlock(TileEntityBirchSign.class, true).setBlockName("standing_birch_sign");
	public static final Block wall_birch_sign = new BirchSignBlock(TileEntityBirchSign.class, false).setBlockName("wall_birch_sign");	
	public static final Block standing_acacia_sign = new AcaciaSignBlock(TileEntityAcaciaSign.class, true).setBlockName("standing_acacia_sign");
	public static final Block wall_acacia_sign = new AcaciaSignBlock(TileEntityAcaciaSign.class, false).setBlockName("wall_acacia_sign");	
	public static final Block standing_jungle_sign = new JungleSignBlock(TileEntityJungleSign.class, true).setBlockName("standing_jungle_sign");
	public static final Block wall_jungle_sign = new JungleSignBlock(TileEntityJungleSign.class, false).setBlockName("wall_jungle_sign");	
	public static final Block standing_dark_oak_sign = new DarkOakSignBlock(TileEntityDarkOakSign.class, true).setBlockName("standing_dark_oak_sign");
	public static final Block wall_dark_oak_sign = new DarkOakSignBlock(TileEntityDarkOakSign.class, false).setBlockName("wall_dark_oak_sign");
	
	public static final Block berry_crops = new BerryCrops().setBlockTextureName(Reference.MOD_ID + ":berry/sweet_berry_bush").setBlockName(Utils.getUnlocalisedName("sweet_berry_bush"));

	
	public static final Block smoker = new BlockSmoker(false).setHardness(3.5F).setBlockName("smoker").setCreativeTab(CreativeTabs.tabDecorations);
	public static final Block lit_smoker = new BlockSmoker(true).setHardness(3.5F).setLightLevel(0.875F).setBlockName("lit_smoker");
	
	public static final Block blast_furnace = new BlockBlastFurnace(false).setHardness(3.5F).setBlockName("blast_furnace").setCreativeTab(CreativeTabs.tabDecorations);
	public static final Block lit_blast_furnace = new BlockBlastFurnace(true).setHardness(3.5F).setLightLevel(0.875F).setBlockName("lit_blast_furnace");
	
	
	
	public static final Block[] doors = new Block[BlockWood.field_150096_a.length - 1];
	public static final Block[] fences = new Block[BlockWood.field_150096_a.length];
	public static final Block[] gates = new Block[BlockWood.field_150096_a.length - 1];

	static {
		for (int i = 0; i < doors.length; i++)
			doors[i] = new BlockWoodDoor(i + 1);

		for (int i = 0; i < fences.length; i++)
			fences[i] = new BlockWoodFence(i);

		for (int i = 0; i < gates.length; i++)
			gates[i] = new BlockWoodFenceGate(i + 1);
	}

	public static void init() {
		try {
			for (Field f : ModBlocks.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof Block)
					registerBlock((Block) obj);
				else if (obj instanceof Block[])
					for (Block block : (Block[]) obj)
						if (block != null)
							registerBlock(block);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private static void registerBlock(Block block) {
		if (!(block instanceof IConfigurable) || ((IConfigurable) block).isEnabled()) {
			String name = block.getUnlocalizedName();
			String[] strings = name.split("\\.");

			if (block instanceof ISubBlocksBlock)
				GameRegistry.registerBlock(block, ((ISubBlocksBlock) block).getItemBlockClass(), strings[strings.length - 1]);
			else
				GameRegistry.registerBlock(block, strings[strings.length - 1]);

			if (block instanceof IBurnableBlock)
				Blocks.fire.setFireInfo(block, 5, 20);
		}
	}

	public static interface ISubBlocksBlock {

		Class<? extends ItemBlock> getItemBlockClass();
	}

	public static interface IBurnableBlock {
	}
}