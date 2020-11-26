package arcrow.contentium.event;

import arcrow.contentium.ModBlocks;
import arcrow.contentium.ModItems;
import arcrow.contentium.lib.Reference;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class Berries {

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent event) {
		if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			if (event.entityPlayer.inventory.getCurrentItem() == null)
				return;

			if (event.entityPlayer.inventory.getCurrentItem().getItem() == ModItems.sweet_berries) {

				if (event.world.getBlock(event.x, event.y, event.z) == Blocks.grass
						|| event.world.getBlock(event.x, event.y, event.z) == Blocks.dirt
						|| event.world.getBlock(event.x, event.y, event.z) == ModBlocks.coarse_dirt
						|| event.world.getBlock(event.x, event.y, event.z) == Blocks.farmland) {
					event.world.setBlock(event.x, event.y + 1, event.z, ModBlocks.berry_crops);
					event.entityPlayer.playSound(Reference.MOD_ID + ":block.bush.place", 1F, 2F);
					event.entityPlayer.inventory.getCurrentItem().stackSize--;
					return;
				}
			}
			
			if (event.entityPlayer.inventory.getCurrentItem().getItem() == Items.dye) {

				if (event.world.getBlock(event.x, event.y, event.z) == ModBlocks.berry_crops) {
					event.setCanceled(true);
				}
			}
		}
	}
}
