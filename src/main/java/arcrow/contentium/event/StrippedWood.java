package arcrow.contentium.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import arcrow.contentium.ModBlocks;
import arcrow.contentium.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class StrippedWood {
	
	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent event) {
		// LOG
		if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			if(event.entityPlayer.inventory.getCurrentItem() == null) return;
			
			if (event.entityPlayer.inventory.getCurrentItem().getItem() == Items.diamond_axe
					|| event.entityPlayer.inventory.getCurrentItem().getItem() == Items.golden_axe
					|| event.entityPlayer.inventory.getCurrentItem().getItem() == Items.iron_axe
					|| event.entityPlayer.inventory.getCurrentItem().getItem() == Items.stone_axe
					|| event.entityPlayer.inventory.getCurrentItem().getItem() == Items.wooden_axe) {

				if (event.world.getBlock(event.x, event.y, event.z) == ModBlocks.wood
						&& event.world.getBlockMetadata(event.x, event.y, event.z) == 11) {
					event.world.setBlock(event.x, event.y, event.z, ModBlocks.wood, 12, 0);
					event.world.markBlockForUpdate(event.x, event.y, event.z);
					event.entityPlayer.inventory.getCurrentItem().damageItem(1, event.entityPlayer);
//					Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation(Reference.MOD_ID + ":sounds/stripped/stripped"), 1.0F));
					event.entityPlayer.playSound(Reference.MOD_ID + ":block.log.stripped", 1F, 2F);
					return;
				}

				if (event.world.getBlock(event.x, event.y, event.z) == ModBlocks.wood
						&& event.world.getBlockMetadata(event.x, event.y, event.z) == 9) {
					event.world.setBlock(event.x, event.y, event.z, ModBlocks.wood, 10, 0);
					event.world.markBlockForUpdate(event.x, event.y, event.z);
					event.entityPlayer.inventory.getCurrentItem().damageItem(1, event.entityPlayer);
					event.entityPlayer.playSound(Reference.MOD_ID + ":block.log.stripped", 1F, 2F);
					return;
				}

				if (event.world.getBlock(event.x, event.y, event.z) == ModBlocks.wood
						&& event.world.getBlockMetadata(event.x, event.y, event.z) == 7) {
					event.world.setBlock(event.x, event.y, event.z, ModBlocks.wood, 8, 0);
					event.world.markBlockForUpdate(event.x, event.y, event.z);
					event.entityPlayer.inventory.getCurrentItem().damageItem(1, event.entityPlayer);
					event.entityPlayer.playSound(Reference.MOD_ID + ":block.log.stripped", 1F, 2F);
					return;
				}

				if (event.world.getBlock(event.x, event.y, event.z) == ModBlocks.wood
						&& event.world.getBlockMetadata(event.x, event.y, event.z) == 5) {
					event.world.setBlock(event.x, event.y, event.z, ModBlocks.wood, 6, 0);
					event.world.markBlockForUpdate(event.x, event.y, event.z);
					event.entityPlayer.inventory.getCurrentItem().damageItem(1, event.entityPlayer);
					event.entityPlayer.playSound(Reference.MOD_ID + ":block.log.stripped", 1F, 2F);
					return;
				}

				if (event.world.getBlock(event.x, event.y, event.z) == ModBlocks.wood
						&& event.world.getBlockMetadata(event.x, event.y, event.z) == 3) {
					event.world.setBlock(event.x, event.y, event.z, ModBlocks.wood, 4, 0);
					event.world.markBlockForUpdate(event.x, event.y, event.z);
					event.entityPlayer.inventory.getCurrentItem().damageItem(1, event.entityPlayer);
					event.entityPlayer.playSound(Reference.MOD_ID + ":block.log.stripped", 1F, 2F);
					return;
				}

				if (event.world.getBlock(event.x, event.y, event.z) == ModBlocks.wood
						&& event.world.getBlockMetadata(event.x, event.y, event.z) == 1) {
					event.world.setBlock(event.x, event.y, event.z, ModBlocks.wood, 2, 0);
					event.world.markBlockForUpdate(event.x, event.y, event.z);
					event.entityPlayer.inventory.getCurrentItem().damageItem(1, event.entityPlayer);
					event.entityPlayer.playSound(Reference.MOD_ID + ":block.log.stripped", 1F, 2F);
					return;
				}
			}
		}
	}
}
