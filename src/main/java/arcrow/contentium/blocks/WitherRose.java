package arcrow.contentium.blocks;


import java.util.Random;

import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockBush;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class WitherRose extends BlockBush {

	public WitherRose() {

		this.setHardness(0F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName(Utils.getUnlocalisedName("wither_rose"));
		this.setBlockTextureName(Reference.MOD_ID + ":flower/wither_rose");

	}

	public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_,
			Entity p_149670_5_) {
		if (p_149670_5_ instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) p_149670_5_;
			if (!player.capabilities.isCreativeMode) {
				p_149670_5_.attackEntityFrom(DamageSource.cactus, 1.0F);
				((EntityLivingBase) p_149670_5_).addPotionEffect(new PotionEffect(20, 100, 4)); // wither
			}

		} else {
			p_149670_5_.attackEntityFrom(DamageSource.cactus, 1.0F);		}
	}
	
	 public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {

		 float f = (float)p_149734_2_ + 0.5F;
	         float f1 = (float)p_149734_3_ + 0.2F + p_149734_5_.nextFloat() * 3.0F / 8.0F;
	         float f2 = (float)p_149734_4_ + 0.5F;
	         float f3 = 0.0F;
	         float f4 = p_149734_5_.nextFloat() * 0.0F - 0.0F;

		 p_149734_1_.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
	 }

}
