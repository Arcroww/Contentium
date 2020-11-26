package arcrow.contentium.client.gui.inventory;

import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import arcrow.contentium.inventory.ContainerAnvil;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class GuiAnvil extends GuiRepair {

	public GuiAnvil(EntityPlayer player, World world, int x, int y, int z) {
		super(player.inventory, world, x, y, z);

		ContainerAnvil container = new ContainerAnvil(player, world, x, y, z);
		ReflectionHelper.setPrivateValue(GuiRepair.class, this, container, "field_147092_v");
		inventorySlots = container;
	}
}