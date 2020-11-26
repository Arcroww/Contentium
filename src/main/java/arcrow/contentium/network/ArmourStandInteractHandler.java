package arcrow.contentium.network;

import arcrow.contentium.entities.EntityArmourStand;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class ArmourStandInteractHandler implements IMessageHandler<ArmourStandInteractMessage, IMessage> {

	@Override
	public IMessage onMessage(ArmourStandInteractMessage message, MessageContext ctx) {
		World world = DimensionManager.getWorld(message.dimID);
		EntityArmourStand stand = (EntityArmourStand) world.getEntityByID(message.standID);
		EntityPlayerMP player = ctx.getServerHandler().playerEntity;

		stand.interact(player, message.hitPos);
		return null;
	}
}