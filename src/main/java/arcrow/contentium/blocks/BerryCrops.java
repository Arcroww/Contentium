package arcrow.contentium.blocks;

import arcrow.contentium.ModItems;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BerryCrops extends ContenCrops {


	private IIcon[] field_149867_a;
	
	protected Item func_149866_i() {
		return ModItems.sweet_berries;
	}

	protected Item func_149865_P() {
		return ModItems.sweet_berries;
	}

	public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_,
			Entity p_149670_5_) {
		if (p_149670_5_ instanceof EntityLivingBase) {
			EntityLivingBase entity = (EntityLivingBase) p_149670_5_;
			entity.setInWeb();

			entity.attackEntityFrom(DamageSource.cactus, 0.5F);
			if (entity.hurtResistantTime == entity.maxHurtResistantTime) {
				entity.playSound(Reference.MOD_ID + ":block.bush.hurt", 1F, 2F);
			}

//			if(entity.moveForward == 0 && entity.moveStrafing == 0)
//				return;
//			
//			entity.attackEntityFrom(DamageSource.cactus, 0.5F);
//			if(entity.hurtResistantTime == entity.maxHurtResistantTime) {
//				entity.playSound(Reference.MOD_ID + ":block.bush.hurt", 1F, 2F);
//			}
		}
	}

	public void onBlockDestroyed(ItemStack toolInstance, World gameWorld_, Block blockStruck, int worldX, int worldY,
			int worldZ, EntityLivingBase actor) {
		actor.playSound(Reference.MOD_ID + ":block.bush.break", 1F, 2F);
	}
}