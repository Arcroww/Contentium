package arcrow.contentium.client.model.boat;

import arcrow.contentium.client.renderer.GlStateManager;
import arcrow.contentium.entities.boat.EntityAcaciaBoat;
import arcrow.contentium.entities.boat.EntityJungleBoat;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.MathHelper;

public class ModelJungleBoat extends ModelBase implements IMultipassModel {
	
    public ModelRenderer[] boatSides = new ModelRenderer[5];
    public ModelRenderer[] paddles = new ModelRenderer[2];
    public ModelRenderer noWater;
    private int field_187059_d = GLAllocation.generateDisplayLists(1);

    public ModelJungleBoat() {
        this.boatSides[0] = (new ModelRenderer(this, 0, 0)).setTextureSize(128, 64);
        this.boatSides[1] = (new ModelRenderer(this, 0, 19)).setTextureSize(128, 64);
        this.boatSides[2] = (new ModelRenderer(this, 0, 27)).setTextureSize(128, 64);
        this.boatSides[3] = (new ModelRenderer(this, 0, 35)).setTextureSize(128, 64);
        this.boatSides[4] = (new ModelRenderer(this, 0, 43)).setTextureSize(128, 64);
        int lvt_1_1_ = 32;
        int lvt_2_1_ = 6;
        int lvt_3_1_ = 20;
        int lvt_4_1_ = 4;
        int lvt_5_1_ = 28;
        this.boatSides[0].addBox((float)(-lvt_5_1_ / 2), (float)(-lvt_3_1_ / 2 + 1), -3.0F, lvt_5_1_, lvt_3_1_ - 4, 3, 0.0F);
        this.boatSides[0].setRotationPoint(0.0F, (float)(lvt_4_1_ - 1), 1.0F);
        this.boatSides[1].addBox((float)(-lvt_1_1_ / 2 + 3), (float)(-lvt_2_1_ - 1), -1.0F, lvt_3_1_ - 2, lvt_2_1_, 2, 0.0F);
        this.boatSides[1].setRotationPoint((float)(-lvt_1_1_ / 2 + 1), (float)lvt_4_1_, 4.0F);
        this.boatSides[2].addBox((float)(-lvt_1_1_ / 2 + 8), (float)(-lvt_2_1_ - 1), -1.0F, lvt_3_1_ - 4, lvt_2_1_, 2, 0.0F);
        this.boatSides[2].setRotationPoint((float)(lvt_1_1_ / 2 - 1), (float)lvt_4_1_, 0.0F);
        this.boatSides[3].addBox((float)(-lvt_1_1_ / 2 + 2), (float)(-lvt_2_1_ - 1), -1.0F, lvt_1_1_ - 4, lvt_2_1_, 2, 0.0F);
        this.boatSides[3].setRotationPoint(0.0F, (float)lvt_4_1_, (float)(-lvt_3_1_ / 2 + 1));
        this.boatSides[4].addBox((float)(-lvt_1_1_ / 2 + 2), (float)(-lvt_2_1_ - 1), -1.0F, lvt_1_1_ - 4, lvt_2_1_, 2, 0.0F);
        this.boatSides[4].setRotationPoint(0.0F, (float)lvt_4_1_, (float)(lvt_3_1_ / 2 - 1));
        this.boatSides[0].rotateAngleX = 1.5707964F;
        this.boatSides[1].rotateAngleY = 4.712389F;
        this.boatSides[2].rotateAngleY = 1.5707964F;
        this.boatSides[3].rotateAngleY = 3.1415927F;
        this.paddles[0] = this.func_187056_a(true);
        this.paddles[0].setRotationPoint(3.0F, -5.0F, 9.0F);
        this.paddles[1] = this.func_187056_a(false);
        this.paddles[1].setRotationPoint(3.0F, -5.0F, -9.0F);
        this.paddles[1].rotateAngleY = 3.1415927F;
        this.paddles[0].rotateAngleZ = this.paddles[1].rotateAngleZ = 0.19634955F;
        this.noWater = (new ModelRenderer(this, 0, 0)).setTextureSize(128, 64);
        this.noWater.addBox((float)(-lvt_5_1_ / 2), (float)(-lvt_3_1_ / 2 + 1), -3.0F, lvt_5_1_, lvt_3_1_ - 4, 3, 0.0F);
        this.noWater.setRotationPoint(0.0F, (float)(lvt_4_1_ - 7), 1.0F);
        this.noWater.rotateAngleX = 1.5707964F;
    }

    public void render(Entity p_render_1_, float p_render_2_, float p_render_3_, float p_render_4_, float p_render_5_, float p_render_6_, float p_render_7_) {
        GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
        EntityJungleBoat lvt_8_1_ = (EntityJungleBoat)p_render_1_;
        this.setRotationAngles(p_render_2_, p_render_3_, p_render_4_, p_render_5_, p_render_6_, p_render_7_, p_render_1_);

        for(int lvt_9_1_ = 0; lvt_9_1_ < 5; ++lvt_9_1_) {
            this.boatSides[lvt_9_1_].render(p_render_7_);
        }

        this.renderPaddle(lvt_8_1_, 0, p_render_7_, p_render_2_);
        this.renderPaddle(lvt_8_1_, 1, p_render_7_, p_render_2_);
    }

    public void renderMultipass(Entity p_renderMultipass_1_, float p_renderMultipass_2_, float p_renderMultipass_3_, float p_renderMultipass_4_, float p_renderMultipass_5_, float p_renderMultipass_6_, float p_renderMultipass_7_) {
        GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.colorMask(false, false, false, false);
        this.noWater.render(p_renderMultipass_7_);
        GlStateManager.colorMask(true, true, true, true);
    }

    public void setRotationAngles(float p_setRotationAngles_1_, float p_setRotationAngles_2_, float p_setRotationAngles_3_, float p_setRotationAngles_4_, float p_setRotationAngles_5_, float p_setRotationAngles_6_, Entity p_setRotationAngles_7_) {
    }

    ModelRenderer func_187056_a(boolean p_187056_1_) {
        ModelRenderer lvt_2_1_ = (new ModelRenderer(this, 62, p_187056_1_ ? 0 : 20)).setTextureSize(128, 64);
        int lvt_3_1_ = 20;
        int lvt_4_1_ = 7;
        int lvt_5_1_ = 6;
        float lvt_6_1_ = -5.0F;
        lvt_2_1_.addBox(-1.0F, 0.0F, lvt_6_1_, 2, 2, lvt_3_1_ - 2);
        lvt_2_1_.addBox(p_187056_1_ ? -1.001F : 0.001F, (float)(-lvt_5_1_ / 2), (float)(lvt_3_1_ - lvt_4_1_) + lvt_6_1_, 1, lvt_5_1_, lvt_4_1_);
        return lvt_2_1_;
    }

    void renderPaddle(EntityJungleBoat p_renderPaddle_1_, int p_renderPaddle_2_, float p_renderPaddle_3_, float p_renderPaddle_4_) {
        float lvt_5_1_ = 40.0F;
        float lvt_6_1_ = p_renderPaddle_1_.func_184448_a(p_renderPaddle_2_, p_renderPaddle_4_) * lvt_5_1_;
        ModelRenderer lvt_7_1_ = this.paddles[p_renderPaddle_2_];
        lvt_7_1_.rotateAngleX = (float)MathHelper.denormalizeClamp(-1.0471975803375244D, -0.2617993950843811D, (double)((MathHelper.sin(-lvt_6_1_) + 1.0F) / 2.0F));
        lvt_7_1_.rotateAngleY = (float)MathHelper.denormalizeClamp(-0.7853981852531433D, 0.7853981852531433D, (double)((MathHelper.sin(-lvt_6_1_ + 1.0F) + 1.0F) / 2.0F));
        if (p_renderPaddle_2_ == 1) {
            lvt_7_1_.rotateAngleY = 3.1415927F - lvt_7_1_.rotateAngleY;
        }

        lvt_7_1_.render(p_renderPaddle_3_);
    }
}