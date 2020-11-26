package arcrow.contentium.client.renderer.entity.boat;

import org.lwjgl.opengl.GL11;

import arcrow.contentium.client.model.boat.ModelDarkOakBoat;
import arcrow.contentium.entities.boat.EntityDarkOakBoat;
import arcrow.contentium.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class RenderDarkOakBoat extends Render
{
    private static final ResourceLocation boatTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/dark_oak.png");
    protected ModelBase modelBoat;

    public RenderDarkOakBoat() {
        this.shadowSize = 0.5F;
        this.modelBoat = new ModelDarkOakBoat();
    }

    public void doRender(EntityDarkOakBoat boat, double x, double y, double z, float yaw, float partTicks) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glRotatef(90.0F - yaw, 0.0F, 1.0F, 0.0F);
        float timeSinceHit = (float)boat.getTimeSinceHit() - partTicks;
        float damageTaken = boat.getDamageTaken() - partTicks;

        if( damageTaken < 0.0F ) {
            damageTaken = 0.0F;
        }

        if( timeSinceHit > 0.0F ) {
            GL11.glRotatef(MathHelper.sin(timeSinceHit) * timeSinceHit * damageTaken / 10.0F * (float)boat.getForwardDirection(), 1.0F, 0.0F, 0.0F);
        }

        float scale = 0.75F;
        GL11.glScalef(scale, scale, scale);
        GL11.glScalef(1.0F / scale, 1.0F / scale, 1.0F / scale);
        this.bindEntityTexture(boat);
        GL11.glScalef(-1.0F, -1.0F, 1.0F);
        this.modelBoat.render(boat, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return boatTextures;
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partTicks) {
        this.doRender((EntityDarkOakBoat)entity, x, y, z, yaw, partTicks);
    }
}