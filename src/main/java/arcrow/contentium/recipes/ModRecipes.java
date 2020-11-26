package arcrow.contentium.recipes;

import java.util.List;

import arcrow.contentium.Contentium;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.ModItems;
import arcrow.contentium.blocks.Stone;
import arcrow.contentium.lib.EnumColour;
import arcrow.contentium.lib.Reference;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {

	public static String[] dyes = new String[] { "dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite" };

	public static void init() {
		if (Contentium.enableBanners) {
			RecipeSorter.register(Reference.MOD_ID + ".RecipeDuplicatePattern", RecipeDuplicatePattern.class, Category.SHAPELESS, "after:minecraft:shapeless");
			RecipeSorter.register(Reference.MOD_ID + ".RecipeAddPattern", RecipeAddPattern.class, Category.SHAPED, "after:minecraft:shaped");
		}

		registerOreDictionary();
		registerRecipes();
		tweakRecipes();
	}

	private static void tweakRecipes() {
		if (Contentium.enableDoors) {
			Items.wooden_door.setMaxStackSize(64);
			Items.iron_door.setMaxStackSize(64);
			removeFirstRecipeFor(Items.wooden_door);
			removeFirstRecipeFor(Items.iron_door);
		}

		if (Contentium.enableFences) {
			removeFirstRecipeFor(Blocks.fence);
			removeFirstRecipeFor(Blocks.fence_gate);
			Blocks.fence.setCreativeTab(null);
			Blocks.fence_gate.setCreativeTab(null);
		}

		if (Contentium.enableBurnableBlocks) {
			Blocks.fire.setFireInfo(Blocks.fence_gate, 5, 20);
			Blocks.fire.setFireInfo(Blocks.fence, 5, 20);
			Blocks.fire.setFireInfo(Blocks.deadbush, 60, 100);
		}
	}

	private static void registerOreDictionary() {
		OreDictionary.registerOre("chestWood", new ItemStack(Blocks.chest));
		OreDictionary.registerOre("trapdoorWood", Blocks.trapdoor);

		if (Contentium.enablePrismarine) {
			OreDictionary.registerOre("shardPrismarine", new ItemStack(ModItems.prismarine_shard));
			OreDictionary.registerOre("crystalPrismarine", new ItemStack(ModItems.prismarine_crystals));
			OreDictionary.registerOre("blockPrismarine", new ItemStack(ModBlocks.prismarine, 1, OreDictionary.WILDCARD_VALUE));
		}

		if (Contentium.enableStones) {
			OreDictionary.registerOre("stoneGranite", new ItemStack(ModBlocks.stone, 1, Stone.GRANITE));
			OreDictionary.registerOre("stoneDiorite", new ItemStack(ModBlocks.stone, 1, Stone.DIORITE));
			OreDictionary.registerOre("stoneAndesite", new ItemStack(ModBlocks.stone, 1, Stone.ANDESITE));
			OreDictionary.registerOre("stoneGranitePolished", new ItemStack(ModBlocks.stone, 1, Stone.POLISHED_GRANITE));
			OreDictionary.registerOre("stoneDioritePolished", new ItemStack(ModBlocks.stone, 1, Stone.POLISHED_DIORITE));
			OreDictionary.registerOre("stoneAndesitePolished", new ItemStack(ModBlocks.stone, 1, Stone.POLISHED_ANDESITE));
		}

		if (Contentium.enableSlimeBlock)
			OreDictionary.registerOre("blockSlime", new ItemStack(ModBlocks.slime));

		if (Contentium.enableIronTrapdoor)
			OreDictionary.registerOre("trapdoorIron", ModBlocks.iron_trapdoor);

		if (Contentium.enableBeetroot)
			OreDictionary.registerOre("cropBeetroot", ModItems.beetroot);

//		if (EtFuturum.enableChorusFruit)
//			OreDictionary.registerOre("brickEndStone", ModBlocks.end_bricks);
	}
		

	private static void registerRecipes() {
		if (Contentium.enableStoneBrickRecipes) {
			addShapelessRecipe(new ItemStack(Blocks.mossy_cobblestone), new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.vine));
			addShapelessRecipe(new ItemStack(Blocks.stonebrick, 1, 1), new ItemStack(Blocks.stonebrick), new ItemStack(Blocks.vine));
			addShapedRecipe(new ItemStack(Blocks.stonebrick, 1, 3), "x", "x", 'x', new ItemStack(Blocks.stone_slab, 1, 5));
			GameRegistry.addSmelting(new ItemStack(Blocks.stonebrick), new ItemStack(Blocks.stonebrick, 1, 2), 0.0F);
		}

		if (Contentium.enableSlimeBlock) {
			addShapedRecipe(new ItemStack(ModBlocks.slime), "xxx", "xxx", "xxx", 'x', "slimeball");
			addShapelessRecipe(new ItemStack(Items.slime_ball, 9), ModBlocks.slime);
		}

		if (Contentium.enableCoarseDirt)
			addShapedRecipe(new ItemStack(ModBlocks.coarse_dirt, 4), "xy", "yx", 'x', new ItemStack(Blocks.dirt), 'y', new ItemStack(Blocks.gravel));

		if (Contentium.enableMutton)
			GameRegistry.addSmelting(ModItems.raw_mutton, new ItemStack(ModItems.cooked_mutton), 0.35F);

		if (Contentium.enableIronTrapdoor)
			addShapedRecipe(new ItemStack(ModBlocks.iron_trapdoor), "xx", "xx", 'x', "ingotIron");

		if (Contentium.enableStones) {
			// Diorite
			addShapedRecipe(new ItemStack(ModBlocks.stone, 2, Stone.DIORITE), "xy", "yx", 'x', new ItemStack(Blocks.cobblestone), 'y', "gemQuartz");
			addShapedRecipe(new ItemStack(ModBlocks.stone, 4, Stone.POLISHED_DIORITE), "xx", "xx", 'x', "stoneDiorite");
			// Andesite
			addShapelessRecipe(new ItemStack(ModBlocks.stone, 2, Stone.ANDESITE), new ItemStack(Blocks.cobblestone), "stoneDiorite");
			addShapedRecipe(new ItemStack(ModBlocks.stone, 4, Stone.POLISHED_ANDESITE), "xx", "xx", 'x', "stoneAndesite");
			// Granite
			addShapelessRecipe(new ItemStack(ModBlocks.stone, 2, Stone.GRANITE), "gemQuartz", "stoneDiorite");
			addShapedRecipe(new ItemStack(ModBlocks.stone, 4, Stone.POLISHED_GRANITE), "xx", "xx", 'x', "stoneGranite");
		}

		if (Contentium.enablePrismarine) {
			int PLAIN = 0;
			int BRICKS = 1;
			int DARK = 2;

			addShapedRecipe(new ItemStack(ModBlocks.prismarine, 1, DARK), "xxx", "xyx", "xxx", 'x', "shardPrismarine", 'y', "dyeBlack");
			addShapedRecipe(new ItemStack(ModBlocks.prismarine, 1, PLAIN), "xx", "xx", 'x', "shardPrismarine");
			addShapedRecipe(new ItemStack(ModBlocks.prismarine, 1, BRICKS), "xxx", "xxx", "xxx", 'x', "shardPrismarine");
			addShapedRecipe(new ItemStack(ModBlocks.sea_lantern), "xyx", "yyy", "xyx", 'x', "shardPrismarine", 'y', "crystalPrismarine");

			if (Contentium.enableRecipeForPrismarine && !Loader.isModLoaded("Botania")) {
				addShapedRecipe(new ItemStack(ModItems.prismarine_shard, 4), "xy", "zx", 'x', "gemQuartz", 'y', "dyeBlue", 'z', "dyeGreen");
				addShapedRecipe(new ItemStack(ModItems.prismarine_crystals, 4), "xy", "yx", 'x', "gemQuartz", 'y', "dustGlowstone");
			}
		}

		if (Contentium.enableDoors) {
			for (int i = 0; i < ModBlocks.doors.length; i++)
				addShapedRecipe(new ItemStack(ModBlocks.doors[i], 3), "xx", "xx", "xx", 'x', new ItemStack(Blocks.planks, 1, i + 1));
			addShapedRecipe(new ItemStack(Items.wooden_door, 3), "xx", "xx", "xx", 'x', "plankWood");
			addShapedRecipe(new ItemStack(Items.iron_door, 3), "xx", "xx", "xx", 'x', "ingotIron");
		}

		if (Contentium.enableRedSandstone) {
			addShapedRecipe(new ItemStack(ModBlocks.red_sandstone), "xx", "xx", 'x', new ItemStack(Blocks.sand, 1, 1));
			addShapedRecipe(new ItemStack(ModBlocks.red_sandstone, 1, 1), "x", "x", 'x', new ItemStack(ModBlocks.red_sandstone_slab));
			addShapedRecipe(new ItemStack(ModBlocks.red_sandstone, 4, 2), "xx", "xx", 'x', new ItemStack(ModBlocks.red_sandstone));
			addShapedRecipe(new ItemStack(ModBlocks.red_sandstone_slab, 6), "xxx", 'x', ModBlocks.red_sandstone);
		}

		if (Contentium.enableFences) {
			for (int i = 0; i < ModBlocks.fences.length; i++)
				addShapedRecipe(new ItemStack(ModBlocks.fences[i], 3), "xyx", "xyx", 'x', new ItemStack(Blocks.planks, 1, i), 'y', "stickWood");
			addShapedRecipe(new ItemStack(ModBlocks.fences[0], 3), "xyx", "xyx", 'x', "plankWood", 'y', "stickWood");
			addShapelessRecipe(new ItemStack(Blocks.fence), ModBlocks.fences[0]);
			addShapelessRecipe(new ItemStack(ModBlocks.fences[0]), Blocks.fence);

			for (int i = 0; i < ModBlocks.gates.length; i++)
				addShapedRecipe(new ItemStack(ModBlocks.gates[i]), "yxy", "yxy", 'x', new ItemStack(Blocks.planks, 1, i + 1), 'y', "stickWood");
			addShapedRecipe(new ItemStack(Blocks.fence_gate), "yxy", "yxy", 'x', "plankWood", 'y', "stickWood");
		}

		if (Contentium.enableBanners) {
			for (EnumColour colour : EnumColour.values())
				addShapedRecipe(new ItemStack(ModBlocks.banner, 1, colour.getDamage()), new Object[] { "xxx", "xxx", " y ", 'x', new ItemStack(Blocks.wool, 1, colour.getDamage()), 'y', "stickWood" });
			GameRegistry.addRecipe(new RecipeDuplicatePattern());
			GameRegistry.addRecipe(new RecipeAddPattern());
		}

		if (Contentium.enableArmourStand)
			addShapedRecipe(new ItemStack(ModItems.armour_stand), "xxx", " x ", "xyx", 'x', "stickWood", 'y', new ItemStack(Blocks.stone_slab));

		if (Contentium.enableRabbit) {
			addShapedRecipe(new ItemStack(ModItems.rabbit_stew), " R ", "CPM", " B ", 'R', new ItemStack(ModItems.cooked_rabbit), 'C', Items.carrot, 'P', Items.baked_potato, 'M', Blocks.brown_mushroom, 'B', Items.bowl);
			addShapedRecipe(new ItemStack(ModItems.rabbit_stew), " R ", "CPD", " B ", 'R', new ItemStack(ModItems.cooked_rabbit), 'C', Items.carrot, 'P', Items.baked_potato, 'D', Blocks.red_mushroom, 'B', Items.bowl);
			GameRegistry.addSmelting(ModItems.raw_rabbit, new ItemStack(ModItems.cooked_rabbit), 0.35F);
			addShapedRecipe(new ItemStack(Items.leather), "xx", "xx", 'x', ModItems.rabbit_hide);
		}

		if (Contentium.enableOldGravel)
			addShapedRecipe(new ItemStack(ModBlocks.old_gravel, 4), "xy", "yx", 'x', ModBlocks.coarse_dirt, 'y', Blocks.gravel);

		if (Contentium.enableSponge) {
			addShapelessRecipe(new ItemStack(ModBlocks.sponge), Blocks.sponge);
			addShapelessRecipe(new ItemStack(Blocks.sponge), ModBlocks.sponge);
			GameRegistry.addSmelting(new ItemStack(ModBlocks.sponge, 1, 1), new ItemStack(ModBlocks.sponge), 0.0F);
		}

		if (Contentium.enableBeetroot) {
			addShapedRecipe(new ItemStack(ModItems.beetroot_soup), "xxx", "xxx", " y ", 'x', "cropBeetroot", 'y', Items.bowl);
			addShapelessRecipe(new ItemStack(Items.dye, 1, 1), "cropBeetroot");
		}

		if (Contentium.enableChorusFruit) {
			addShapedRecipe(new ItemStack(ModBlocks.purpur_block, 4), "xx", "xx", 'x', ModItems.popped_chorus_fruit);
						addShapedRecipe(new ItemStack(ModBlocks.purpur_pillar), "x", "x", 'x', ModBlocks.purpur_slab);
			addShapedRecipe(new ItemStack(ModBlocks.end_bricks), "xx", "xx", 'x', Blocks.end_stone);
			GameRegistry.addSmelting(new ItemStack(ModItems.chorus_fruit), new ItemStack(ModItems.popped_chorus_fruit), 0.0F);
			addShapedRecipe(new ItemStack(ModBlocks.end_rod), "x", "y", 'x', Items.blaze_rod, 'y', ModItems.popped_chorus_fruit);
		}

		if (Contentium.enableLingeringPotions)
			addShapelessRecipe(new ItemStack(ModItems.dragon_breath), new ItemStack(Items.potionitem, 1, 8195), ModItems.chorus_fruit, ModItems.chorus_fruit);

		if (Contentium.enableDragonRespawn)
			addShapedRecipe(new ItemStack(ModItems.end_crystal), "xxx", "xyx", "xzx", 'x', "blockGlassColorless", 'y', Items.ender_eye, 'z', Items.ghast_tear);

		if (Contentium.enableRoses) {
			addShapelessRecipe(new ItemStack(Items.dye, 1, 1), ModBlocks.rose);
			addShapedRecipe(new ItemStack(Blocks.double_plant, 1, 4), "xx", "xx", "xx", 'x', new ItemStack(ModBlocks.rose));
			addShapedRecipe(new ItemStack(ModBlocks.rose, 12), "xx", 'x', new ItemStack(Blocks.double_plant, 1, 4));
		}

		if (Contentium.enableTippedArrows && Contentium.enableLingeringPotions) {
			RecipeSorter.register(Reference.MOD_ID + ".RecipeTippedArrow", RecipeTippedArrow.class, Category.SHAPED, "after:minecraft:shaped");
			GameRegistry.addRecipe(new RecipeTippedArrow(new ItemStack(ModItems.tipped_arrow), "xxx", "xyx", "xxx", 'x', Items.arrow, 'y', new ItemStack(ModItems.lingering_potion, 1, OreDictionary.WILDCARD_VALUE)));
		}
		
		//craft Arcrow
		//blocks
		addShapedRecipe(new ItemStack(ModBlocks.red_nether_brick, 4), "xy", "yx", 'x', new ItemStack(Blocks.nether_brick, 1), 'y', new ItemStack(Blocks.nether_wart, 1));
	
		//stairs
		addShapedRecipe(new ItemStack(ModBlocks.andesite_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 5));
		addShapedRecipe(new ItemStack(ModBlocks.dark_prismarine_brick_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.prismarine, 1, 2));
		addShapedRecipe(new ItemStack(ModBlocks.diorite_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 3));
		addShapedRecipe(new ItemStack(ModBlocks.end_stone_brick_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.end_bricks, 0));
		addShapedRecipe(new ItemStack(ModBlocks.granite_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.mossy_cobblestone_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(Blocks.mossy_cobblestone, 1));
		addShapedRecipe(new ItemStack(ModBlocks.mossy_stone_brick_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(Blocks.stonebrick, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.polished_andesite_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 6));
		addShapedRecipe(new ItemStack(ModBlocks.polished_diorite_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 4));
		addShapedRecipe(new ItemStack(ModBlocks.polished_granite_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 2));
		addShapedRecipe(new ItemStack(ModBlocks.prismarine_brick_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.prismarine, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.prismarine_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.prismarine, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.red_nether_brick_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.red_nether_brick, 1));
		addShapedRecipe(new ItemStack(ModBlocks.red_sandstone_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.red_sandstone, 1));
		addShapedRecipe(new ItemStack(ModBlocks.sandstone_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(Blocks.sandstone, 1));
		addShapedRecipe(new ItemStack(ModBlocks.stone_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(Blocks.stone, 1));
		addShapedRecipe(new ItemStack(ModBlocks.purpur_stairs, 4), "x  ", "xx ", "xxx", 'x', new ItemStack(ModBlocks.purpur_block, 1));
		
		//slabs
		addShapedRecipe(new ItemStack(ModBlocks.andesite_slab, 6), "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 5));
		addShapedRecipe(new ItemStack(ModBlocks.dark_prismarine_brick_slab, 6), "xxx", 'x', new ItemStack(ModBlocks.prismarine, 1, 2));
		addShapedRecipe(new ItemStack(ModBlocks.diorite_slab, 6), "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 3));
		addShapedRecipe(new ItemStack(ModBlocks.end_stone_brick_stairs, 6), "xxx", 'x', new ItemStack(ModBlocks.end_bricks, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.granite_slab, 6), "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.mossy_cobblestone_slab, 6), "xxx", 'x', new ItemStack(Blocks.mossy_cobblestone, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.mossy_stone_brick_slab, 6), "xxx", 'x', new ItemStack(Blocks.stonebrick, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.polished_andesite_slab, 6), "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 6));
		addShapedRecipe(new ItemStack(ModBlocks.diorite_slab, 6), "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 4));
		addShapedRecipe(new ItemStack(ModBlocks.granite_slab, 6), "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 2));
		addShapedRecipe(new ItemStack(ModBlocks.prismarine_brick_slab, 6), "xxx", 'x', new ItemStack(ModBlocks.prismarine, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.prismarine_slab, 6), "xxx", 'x', new ItemStack(ModBlocks.prismarine, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.red_nether_brick_slab, 6), "xxx", 'x', new ItemStack(ModBlocks.red_nether_brick, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.cut_sandstone_slab, 6), "xxx", 'x', new ItemStack(Blocks.sandstone, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.stone_slab, 6), "xxx", 'x', new ItemStack(Blocks.stone, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.purpur_slab, 6), "xxx", 'x', ModBlocks.purpur_block);
		
		//Concrete Powder
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 1), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 15), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 2), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 14), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 3), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 13), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 4), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 12), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 5), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 11), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 6), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 10), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 7), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 9), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 8), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 8), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 9), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 7), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 10), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 6), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 11), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 5), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 12), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 4), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 13), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 3), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 14), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 2), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 15), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 1), 'x', Blocks.sand, 'z', Blocks.gravel);
		addShapedRecipe(new ItemStack(ModBlocks.concrete_powder, 8, 16), "yxx", "xxz", "zzz", 'y', new ItemStack(Items.dye, 1, 0), 'x', Blocks.sand, 'z', Blocks.gravel);
		
		//blocks autres
		addShapedRecipe(new ItemStack(ModBlocks.magma_block, 1), "xx", "xx", 'x', new ItemStack(Items.magma_cream, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.blue_ice, 1), "xxx", "xxx", "xxx", 'x', new ItemStack(Blocks.packed_ice, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.nether_wart_block, 1), "xxx", "xxx", "xxx", 'x', new ItemStack(Items.nether_wart, 1, 0));
		
		//wood
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 2), "xx", "xx", 'x', new ItemStack(ModBlocks.log, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 4), "xx", "xx", 'x', new ItemStack(ModBlocks.log, 1, 2));
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 6), "xx", "xx", 'x', new ItemStack(ModBlocks.log, 1, 3));
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 8), "xx", "xx", 'x', new ItemStack(ModBlocks.log, 1, 4));
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 10), "xx", "xx", 'x', new ItemStack(ModBlocks.log, 1, 5));
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 12), "xx", "xx", 'x', new ItemStack(ModBlocks.log, 1, 6));
		
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 1), "x", 'x', new ItemStack(ModBlocks.wood, 1, 2));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 3), "x", 'x', new ItemStack(ModBlocks.wood, 1, 4));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 5), "x", 'x', new ItemStack(ModBlocks.wood, 1, 6));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 4), "x", 'x', new ItemStack(ModBlocks.wood, 1, 8));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 2), "x", 'x', new ItemStack(ModBlocks.wood, 1, 10));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 0), "x", 'x', new ItemStack(ModBlocks.wood, 1, 12));
		
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 1), "x", 'x', new ItemStack(ModBlocks.log, 1, 1));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 3), "x", 'x', new ItemStack(ModBlocks.log, 1, 2));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 5), "x", 'x', new ItemStack(ModBlocks.log, 1, 3));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 4), "x", 'x', new ItemStack(ModBlocks.log, 1, 4));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 2), "x", 'x', new ItemStack(ModBlocks.log, 1, 5));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 0), "x", 'x', new ItemStack(ModBlocks.log, 1, 6));
		
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 1), "xx", "xx", 'x', new ItemStack(Blocks.log, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 3), "xx", "xx", 'x', new ItemStack(Blocks.log, 1, 3));
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 5), "xx", "xx", 'x', new ItemStack(Blocks.log2, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 7), "xx", "xx", 'x', new ItemStack(Blocks.log2, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 9), "xx", "xx", 'x', new ItemStack(Blocks.log, 1, 2));
		addShapedRecipe(new ItemStack(ModBlocks.wood, 3, 11), "xx", "xx", 'x', new ItemStack(Blocks.log, 1, 0));
		
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 1), "x", 'x', new ItemStack(ModBlocks.wood, 3, 1));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 3), "x", 'x', new ItemStack(ModBlocks.wood, 1, 3));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 5), "x", 'x', new ItemStack(ModBlocks.wood, 1, 5));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 4), "x", 'x', new ItemStack(ModBlocks.wood, 1, 7));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 2), "x", 'x', new ItemStack(ModBlocks.wood, 1, 9));
		addShapedRecipe(new ItemStack(Blocks.planks, 4, 0), "x", 'x', new ItemStack(ModBlocks.wood, 1, 11));
		
		//walls
		addShapedRecipe(new ItemStack(ModBlocks.andesite_wall, 6), "xxx", "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 5));
		addShapedRecipe(new ItemStack(ModBlocks.brick_wall, 6), "xxx", "xxx", 'x', Blocks.brick_block);
		addShapedRecipe(new ItemStack(ModBlocks.diorite_wall, 6), "xxx", "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 3));
		addShapedRecipe(new ItemStack(ModBlocks.endstonebrick_wall, 6), "xxx", "xxx", 'x', ModBlocks.end_bricks);
		addShapedRecipe(new ItemStack(ModBlocks.granite_wall, 6), "xxx", "xxx", 'x', new ItemStack(ModBlocks.stone, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.mossystonebrick_wall, 6), "xxx", "xxx", 'x', new ItemStack(Blocks.stonebrick, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.neitherbrick_wall, 6), "xxx", "xxx", 'x', Blocks.nether_brick);
		addShapedRecipe(new ItemStack(ModBlocks.prismarine_wall, 6), "xxx", "xxx", 'x', new ItemStack(ModBlocks.prismarine, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.rednetherbrick_wall, 6), "xxx", "xxx", 'x', ModBlocks.red_nether_brick);
		addShapedRecipe(new ItemStack(ModBlocks.redsandstone_wall, 6), "xxx", "xxx", 'x', ModBlocks.red_sandstone);
		addShapedRecipe(new ItemStack(ModBlocks.sandstone_wall, 6), "xxx", "xxx", 'x', Blocks.sandstone);
		addShapedRecipe(new ItemStack(ModBlocks.stonebrick_wall, 6), "xxx", "xxx", 'x', Blocks.stonebrick);
		
		//sign
		addShapedRecipe(new ItemStack(ModItems.acacia_sign, 3), "xxx", "xxx", " y ", 'x', new ItemStack(Blocks.planks, 1, 5), 'y', Items.stick);
		addShapedRecipe(new ItemStack(ModItems.birch_sign, 3), "xxx", "xxx", " y ", 'x', new ItemStack(Blocks.planks, 1, 3), 'y', Items.stick);
		addShapedRecipe(new ItemStack(ModItems.dark_oak_sign, 3), "xxx", "xxx", " y ", 'x', new ItemStack(Blocks.planks, 1, 6), 'y', Items.stick);
		addShapedRecipe(new ItemStack(ModItems.jungle_sign, 3), "xxx", "xxx", " y ", 'x', new ItemStack(Blocks.planks, 1, 4), 'y', Items.stick);
		addShapedRecipe(new ItemStack(ModItems.spruce_sign, 3), "xxx", "xxx", " y ", 'x', new ItemStack(Blocks.planks, 1, 2), 'y', Items.stick);
		
		//glazed
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 15), new ItemStack(ModBlocks.glazed, 1, 1), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 11), new ItemStack(ModBlocks.glazed, 1, 2), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 12), new ItemStack(ModBlocks.glazed, 1, 3), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 9), new ItemStack(ModBlocks.glazed, 1, 4), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 7), new ItemStack(ModBlocks.glazed, 1, 5), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 13), new ItemStack(ModBlocks.glazed, 1, 6), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 3), new ItemStack(ModBlocks.glazed, 1, 7), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 8), new ItemStack(ModBlocks.glazed, 1, 8), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 5), new ItemStack(ModBlocks.glazed, 1, 9), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 2), new ItemStack(ModBlocks.glazed, 1, 10), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 1), new ItemStack(ModBlocks.glazed, 1, 11), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 6), new ItemStack(ModBlocks.glazed, 1, 12), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 10), new ItemStack(ModBlocks.glazed, 1, 13), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 14), new ItemStack(ModBlocks.glazed, 1, 14), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 0), new ItemStack(ModBlocks.glazed, 1, 15), 3F);
		GameRegistry.addSmelting(new ItemStack(Blocks.stained_hardened_clay, 1, 4), new ItemStack(ModBlocks.glazed, 1, 16), 3F);
		
		//boat
		removeRecipe(new ItemStack(Items.boat));
		addShapedRecipe(new ItemStack(ModItems.oak_boat, 1), "x x", "xxx", 'x', new ItemStack(Blocks.planks, 1, 0));
		addShapedRecipe(new ItemStack(ModItems.spruce_boat, 1), "x x", "xxx", 'x', new ItemStack(Blocks.planks, 1, 1));
		addShapedRecipe(new ItemStack(ModItems.birch_boat, 1), "x x", "xxx", 'x', new ItemStack(Blocks.planks, 1, 2));
		addShapedRecipe(new ItemStack(ModItems.jungle_boat, 1), "x x", "xxx", 'x', new ItemStack(Blocks.planks, 1, 3));
		addShapedRecipe(new ItemStack(ModItems.acacia_boat, 1), "x x", "xxx", 'x', new ItemStack(Blocks.planks, 1, 4));
		addShapedRecipe(new ItemStack(ModItems.dark_oak_boat, 1), "x x", "xxx", 'x', new ItemStack(Blocks.planks, 1, 5));
		
		//button
		removeRecipe(new ItemStack(Blocks.wooden_button));
		addShapedRecipe(new ItemStack(Blocks.wooden_button, 1), "x", 'x', new ItemStack(Blocks.planks, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.spruce_button, 1), "x", 'x', new ItemStack(Blocks.planks, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.birch_button, 1), "x", 'x', new ItemStack(Blocks.planks, 1, 2));
		addShapedRecipe(new ItemStack(ModBlocks.jungle_button, 1), "x", 'x', new ItemStack(Blocks.planks, 1, 3));
		addShapedRecipe(new ItemStack(ModBlocks.acacia_button, 1), "x", 'x', new ItemStack(Blocks.planks, 1, 4));
		addShapedRecipe(new ItemStack(ModBlocks.dark_oak_button, 1), "x", 'x', new ItemStack(Blocks.planks, 1, 5));
		
		//pressure_plate
		removeRecipe(new ItemStack(Blocks.wooden_pressure_plate));
		addShapedRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), "xx", 'x', new ItemStack(Blocks.planks, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.spruce_pressure_plate, 1), "xx", 'x', new ItemStack(Blocks.planks, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.birch_pressure_plate, 1), "xx", 'x', new ItemStack(Blocks.planks, 1, 2));
		addShapedRecipe(new ItemStack(ModBlocks.jungle_pressure_plate, 1), "xx", 'x', new ItemStack(Blocks.planks, 1, 3));
		addShapedRecipe(new ItemStack(ModBlocks.acacia_pressure_plate, 1), "xx", 'x', new ItemStack(Blocks.planks, 1, 4));
		addShapedRecipe(new ItemStack(ModBlocks.dark_oak_pressure_plate, 1), "xx", 'x', new ItemStack(Blocks.planks, 1, 5));
		
		//trapdoor
		removeRecipe(new ItemStack(Blocks.trapdoor));
		addShapedRecipe(new ItemStack(Blocks.trapdoor, 2), "xxx", "xxx", 'x', new ItemStack(Blocks.planks, 1, 0));
		addShapedRecipe(new ItemStack(ModBlocks.spruce_trapdoor, 2), "xxx", "xxx", 'x', new ItemStack(Blocks.planks, 1, 1));
		addShapedRecipe(new ItemStack(ModBlocks.birch_trapdoor, 2), "xxx", "xxx", 'x', new ItemStack(Blocks.planks, 1, 2));
		addShapedRecipe(new ItemStack(ModBlocks.jungle_trapdoor, 2), "xxx", "xxx", 'x', new ItemStack(Blocks.planks, 1, 3));
		addShapedRecipe(new ItemStack(ModBlocks.acacia_trapdoor, 2), "xxx", "xxx", 'x', new ItemStack(Blocks.planks, 1, 4));
		addShapedRecipe(new ItemStack(ModBlocks.dark_oak_trapdoor, 2),"xxx", "xxx", 'x', new ItemStack(Blocks.planks, 1, 5));
		
		//flower
		addShapedRecipe(new ItemStack(Items.dye, 1, 4), "x", 'x', new ItemStack(ModBlocks.corn_flower, 1));
		addShapedRecipe(new ItemStack(Items.dye, 1, 15), "x", 'x', new ItemStack(ModBlocks.lily_valley, 1));
		addShapedRecipe(new ItemStack(Items.dye, 1, 0), "x", 'x', new ItemStack(ModBlocks.wither_rose, 1));
		
		//new furnace
		addShapedRecipe(new ItemStack(ModBlocks.smoker, 1), " y ", "yxy", " y ", 'x', new ItemStack(Blocks.furnace, 1), 'y', new ItemStack(Blocks.log));
		addShapedRecipe(new ItemStack(ModBlocks.smoker, 1), " y ", "yxy", " y ", 'x', new ItemStack(Blocks.furnace, 1), 'y', new ItemStack(Blocks.log2));
		addShapedRecipe(new ItemStack(ModBlocks.smoker, 1), " y ", "yxy", " y ", 'x', new ItemStack(Blocks.furnace, 1), 'y', new ItemStack(ModBlocks.wood));
		addShapedRecipe(new ItemStack(ModBlocks.smoker, 1), " y ", "yxy", " y ", 'x', new ItemStack(Blocks.furnace, 1), 'y', new ItemStack(ModBlocks.log));
		
		addShapedRecipe(new ItemStack(ModBlocks.blast_furnace, 1), "xxx", "xyx", "zzz", 'x', new ItemStack(Items.iron_ingot, 1), 'y', new ItemStack(Blocks.furnace, 1), 'z', new ItemStack(ModBlocks.smooth_stone, 1));
		
		//smoothstone
		GameRegistry.addSmelting(new ItemStack(Blocks.stone, 1), new ItemStack(ModBlocks.smooth_stone, 1, 16), 3F);
	}
	
	public static void removeRecipe(ItemStack stack) {
		List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipeList.size(); i++) {
			ItemStack output = recipeList.get(i).getRecipeOutput();
			if (output != null && stack.getItem() == output.getItem()
					&& stack.getItemDamage() == output.getItemDamage()) {
				recipeList.remove(i);
			}
		}
	}

	private static void addShapedRecipe(ItemStack output, Object... objects) {
		GameRegistry.addRecipe(new ShapedOreRecipe(output, objects));
	}

	private static void addShapelessRecipe(ItemStack output, Object... objects) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(output, objects));
	}

	private static void removeFirstRecipeFor(Block block) {
		removeFirstRecipeFor(Item.getItemFromBlock(block));
	}

	private static void removeFirstRecipeFor(Item item) {
		for (Object recipe : CraftingManager.getInstance().getRecipeList())
			if (recipe != null) {
				ItemStack stack = ((IRecipe) recipe).getRecipeOutput();
				if (stack != null && stack.getItem() == item) {
					CraftingManager.getInstance().getRecipeList().remove(recipe);
					return;
				}
			}
	}
}