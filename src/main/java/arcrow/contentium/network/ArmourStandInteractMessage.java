package arcrow.contentium.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import arcrow.contentium.entities.EntityArmourStand;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class ArmourStandInteractMessage implements IMessage {

	public int dimID, standID;
	public Vec3 hitPos;

	public ArmourStandInteractMessage() {
	}

	public ArmourStandInteractMessage(int dimID, EntityArmourStand stand) {
		this.dimID = dimID;
		standID = stand.getEntityId();
		MovingObjectPosition hit = Minecraft.getMinecraft().objectMouseOver;
		hitPos = Vec3.createVectorHelper(hit.hitVec.xCoord - stand.posX, hit.hitVec.yCoord - stand.posY, hit.hitVec.zCoord - stand.posZ);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		dimID = buf.readInt();
		standID = buf.readInt();
		hitPos = Vec3.createVectorHelper(buf.readDouble(), buf.readDouble(), buf.readDouble());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(dimID);
		buf.writeInt(standID);
		buf.writeDouble(hitPos.xCoord);
		buf.writeDouble(hitPos.yCoord);
		buf.writeDouble(hitPos.zCoord);
	}
}