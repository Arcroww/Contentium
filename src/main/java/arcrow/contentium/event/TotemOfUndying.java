package arcrow.contentium.event;

import arcrow.contentium.ModItems;
import arcrow.contentium.lib.Reference;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.valkya.valkyris.api.APIProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class TotemOfUndying {
	
//	@SideOnly(Side.CLIENT)
//	@SubscribeEvent
//	public void onTick(PlayerTickEvent e) {
//		if(!FMLCommonHandler.instance().getEffectiveSide().isClient()) return;
//		
//		if(e.phase == Phase.END) {
//			if (e.player.inventory.hasItem(ModItems.totem_of_undying)) {
//				List<Integer> slots = new ArrayList<Integer>();
//				for(int i = 0; i < e.player.inventory.getSizeInventory(); i++) {
//					ItemStack is = e.player.inventory.getStackInSlot(i);
//					if(is != null && is.getItem() != null && is.getItem() == ModItems.totem_of_undying) {
//						slots.add(i);
//					}
//				}
//				Minecraft mc = Minecraft.getMinecraft();
//				if(slots.size() > 1) {
//					for(int i = 1; i < slots.size(); i++) {
//						int slot = slots.get(i);
////						System.out.println("dropping slot #" + (slot));
//						if(slot < 9) {
//							mc.playerController.sendPacketDropItem(e.player.inventory.getStackInSlot(slot));
//						}else {
//							mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, slot, 0, 0, mc.thePlayer);
//							mc.playerController.windowClick(mc.thePlayer.inventoryContainer.windowId, -999, 0, 0, mc.thePlayer);
//						}
//					}
//				}
//			}
//		}
//	}
	
	
	@SubscribeEvent
	public void onDeath(LivingDeathEvent event) {
		EntityLivingBase entity = event.entityLiving;
		if(!(entity instanceof EntityPlayer)) return;
		
		EntityPlayer entityPlayer = (EntityPlayer)entity;
	
		if (entityPlayer.inventory.hasItem(ModItems.totem_of_undying)) {
			entityPlayer.addPotionEffect(new PotionEffect(15, 50, 2)); // blindness
			entityPlayer.setHealth(5);
			entityPlayer.addPotionEffect(new PotionEffect(22, 350, 1)); // abso
			entityPlayer.addPotionEffect(new PotionEffect(10, 200, 4)); // regen
			entityPlayer.playSound(Reference.MOD_ID + ":block.bush.flem", 1F, 2F);			
			entityPlayer.inventory.clearInventory(ModItems.totem_of_undying, -1);

			entityPlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "Tu es mort, ton totem t'as permis de ressusciter !"));
			
			event.setCanceled(true);
		}
	}
	
}
