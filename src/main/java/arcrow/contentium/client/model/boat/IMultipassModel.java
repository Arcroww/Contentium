package arcrow.contentium.client.model.boat;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public interface IMultipassModel {
    void renderMultipass(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7);
}
