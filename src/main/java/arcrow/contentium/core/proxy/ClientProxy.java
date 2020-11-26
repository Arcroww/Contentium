package arcrow.contentium.core.proxy;

import arcrow.contentium.Contentium;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.client.renderer.block.BlockChestRenderer;
import arcrow.contentium.client.renderer.block.BlockChorusFlowerRender;
import arcrow.contentium.client.renderer.block.BlockChorusPlantRender;
import arcrow.contentium.client.renderer.block.BlockDoorRenderer;
import arcrow.contentium.client.renderer.block.BlockEndRodRender;
import arcrow.contentium.client.renderer.block.BlockSlimeBlockRender;
import arcrow.contentium.client.renderer.entity.ArmourStandRenderer;
import arcrow.contentium.client.renderer.entity.EndermiteRenderer;
import arcrow.contentium.client.renderer.entity.LingeringEffectRenderer;
import arcrow.contentium.client.renderer.entity.LingeringPotionRenderer;
import arcrow.contentium.client.renderer.entity.NewSnowGolemRenderer;
import arcrow.contentium.client.renderer.entity.PlacedEndCrystalRenderer;
import arcrow.contentium.client.renderer.entity.RabbitRenderer;
import arcrow.contentium.client.renderer.entity.VillagerZombieRenderer;
import arcrow.contentium.client.renderer.entity.boat.RenderAcaciaBoat;
import arcrow.contentium.client.renderer.entity.boat.RenderBirchBoat;
import arcrow.contentium.client.renderer.entity.boat.RenderDarkOakBoat;
import arcrow.contentium.client.renderer.entity.boat.RenderJungleBoat;
import arcrow.contentium.client.renderer.entity.boat.RenderOakBoat;
import arcrow.contentium.client.renderer.entity.boat.RenderSpruceBoat;
import arcrow.contentium.client.renderer.item.ItemBannerRenderer;
import arcrow.contentium.client.renderer.item.ItemBowRenderer;
import arcrow.contentium.client.renderer.item.ItemSkullRenderer;
import arcrow.contentium.client.renderer.tileentity.TileEntityBannerRenderer;
import arcrow.contentium.client.renderer.tileentity.TileEntityEndRodRenderer;
import arcrow.contentium.client.renderer.tileentity.TileEntityFancySkullRenderer;
import arcrow.contentium.client.renderer.tileentity.TileEntityNewBeaconRenderer;
import arcrow.contentium.core.handlers.ClientEventHandler;
import arcrow.contentium.entities.EntityArmourStand;
import arcrow.contentium.entities.EntityEndermite;
import arcrow.contentium.entities.EntityLingeringEffect;
import arcrow.contentium.entities.EntityLingeringPotion;
import arcrow.contentium.entities.EntityNewSnowGolem;
import arcrow.contentium.entities.EntityPlacedEndCrystal;
import arcrow.contentium.entities.EntityRabbit;
import arcrow.contentium.entities.EntityZombieVillager;
import arcrow.contentium.entities.boat.EntityAcaciaBoat;
import arcrow.contentium.entities.boat.EntityBirchBoat;
import arcrow.contentium.entities.boat.EntityDarkOakBoat;
import arcrow.contentium.entities.boat.EntityJungleBoat;
import arcrow.contentium.entities.boat.EntityOakBoat;
import arcrow.contentium.entities.boat.EntitySpruceBoat;
import arcrow.contentium.tileentities.TileEntityBanner;
import arcrow.contentium.tileentities.TileEntityEndRod;
import arcrow.contentium.tileentities.TileEntityNewBeacon;
import arcrow.contentium.tileentities.sign.TileEntityAcaciaSign;
import arcrow.contentium.tileentities.sign.TileEntityAcaciaSignRenderer;
import arcrow.contentium.tileentities.sign.TileEntityBirchSign;
import arcrow.contentium.tileentities.sign.TileEntityBirchSignRenderer;
import arcrow.contentium.tileentities.sign.TileEntityDarkOakSign;
import arcrow.contentium.tileentities.sign.TileEntityDarkOakSignRenderer;
import arcrow.contentium.tileentities.sign.TileEntityJungleSign;
import arcrow.contentium.tileentities.sign.TileEntityJungleSignRenderer;
import arcrow.contentium.tileentities.sign.TileEntitySpruceSign;
import arcrow.contentium.tileentities.sign.TileEntitySpruceSignRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerEvents() {
		super.registerEvents();
		FMLCommonHandler.instance().bus().register(ClientEventHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(ClientEventHandler.INSTANCE);
	}

	@Override
	public void registerRenderers() {
		registerItemRenderers();
		registerBlockRenderers();
		registerEntityRenderers();
	}

	@Override
	public void handleSignGui(TileEntity tile) {
//		System.out.println("AYAYAYAYAAY FDP");
//		if (tile instanceof TileEntityAcaciaSign) {
//            this.mc.displayGuiScreen(new GuiEditAcaciaSign((TileEntityAcaciaSign) tile));
//        }
	}
    
	private void registerItemRenderers() {
		if (Contentium.enableBanners)
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.banner), new ItemBannerRenderer());
		if (Contentium.enableFancySkulls)
			MinecraftForgeClient.registerItemRenderer(Items.skull, new ItemSkullRenderer());
		if (Contentium.enableBowRendering)
			MinecraftForgeClient.registerItemRenderer(Items.bow, new ItemBowRenderer());
	}

	private void registerBlockRenderers() {
		if (Contentium.enableSlimeBlock)
			RenderingRegistry.registerBlockHandler(new BlockSlimeBlockRender());

		if (Contentium.enableDoors)
			RenderingRegistry.registerBlockHandler(new BlockDoorRenderer());

		if (Contentium.enableBanners)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBanner.class, new TileEntityBannerRenderer());

		if (Contentium.enableFancySkulls)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySkull.class, new TileEntityFancySkullRenderer());

		if (Contentium.enableChorusFruit) {
			RenderingRegistry.registerBlockHandler(new BlockEndRodRender());
			RenderingRegistry.registerBlockHandler(new BlockChorusFlowerRender());
			RenderingRegistry.registerBlockHandler(new BlockChorusPlantRender());
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEndRod.class, new TileEntityEndRodRenderer());
		}

		if (Contentium.enableColourfulBeacons)
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityNewBeacon.class, new TileEntityNewBeaconRenderer());

		RenderingRegistry.registerBlockHandler(new BlockChestRenderer());
	}

	private void registerEntityRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityOakBoat.class, new RenderOakBoat());
		RenderingRegistry.registerEntityRenderingHandler(EntitySpruceBoat.class, new RenderSpruceBoat());
		RenderingRegistry.registerEntityRenderingHandler(EntityBirchBoat.class, new RenderBirchBoat());
		RenderingRegistry.registerEntityRenderingHandler(EntityJungleBoat.class, new RenderJungleBoat());
		RenderingRegistry.registerEntityRenderingHandler(EntityAcaciaBoat.class, new RenderAcaciaBoat());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkOakBoat.class, new RenderDarkOakBoat());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAcaciaSign.class, new TileEntityAcaciaSignRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBirchSign.class, new TileEntityBirchSignRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDarkOakSign.class, new TileEntityDarkOakSignRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJungleSign.class, new TileEntityJungleSignRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpruceSign.class, new TileEntitySpruceSignRenderer());
		
		if (Contentium.enableArmourStand)
			RenderingRegistry.registerEntityRenderingHandler(EntityArmourStand.class, new ArmourStandRenderer());
		if (Contentium.enableEndermite)
			RenderingRegistry.registerEntityRenderingHandler(EntityEndermite.class, new EndermiteRenderer());
		if (Contentium.enableRabbit)
			RenderingRegistry.registerEntityRenderingHandler(EntityRabbit.class, new RabbitRenderer());
		if (Contentium.enableLingeringPotions) {
			RenderingRegistry.registerEntityRenderingHandler(EntityLingeringPotion.class, new LingeringPotionRenderer());
			RenderingRegistry.registerEntityRenderingHandler(EntityLingeringEffect.class, new LingeringEffectRenderer());
		}
		if (Contentium.enableVillagerZombies)
			RenderingRegistry.registerEntityRenderingHandler(EntityZombieVillager.class, new VillagerZombieRenderer());
		if (Contentium.enableDragonRespawn)
			RenderingRegistry.registerEntityRenderingHandler(EntityPlacedEndCrystal.class, new PlacedEndCrystalRenderer());
		if (Contentium.enableShearableGolems)
			RenderingRegistry.registerEntityRenderingHandler(EntityNewSnowGolem.class, new NewSnowGolemRenderer());
	}
}