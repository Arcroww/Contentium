package arcrow.contentium.blocks;

import arcrow.contentium.Contentium;
import arcrow.contentium.IConfigurable;
import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class MagmaBlock extends Block implements IConfigurable {

	public MagmaBlock() {
		super(Material.rock);
		setHardness(0.5F);
		setLightLevel(3);
		setHarvestLevel("pickaxe", 0);
		setBlockTextureName(Reference.MOD_ID + ":magma");
		setBlockName(Utils.getUnlocalisedName("magma"));
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean isEnabled() {
		return Contentium.enableMagma;
	}

	public void onEntityWalking(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_,
			Entity p_149670_5_) {
		if(p_149670_5_ instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)p_149670_5_;
			if(!player.capabilities.isCreativeMode) {
				if(!p_149670_5_.isSneaking() && !p_149670_5_.isImmuneToFire()) {
					p_149670_5_.attackEntityFrom(DamageSource.onFire, 1.0F);
					if (player.hurtResistantTime == player.maxHurtResistantTime) {
					p_149670_5_.playSound("random.fizz", 0.1F, 2F);
					}
				}
			}
		}else {
			if(!p_149670_5_.isSneaking() && !p_149670_5_.isImmuneToFire()) {
				p_149670_5_.attackEntityFrom(DamageSource.onFire, 1.0F);
				p_149670_5_.playSound("random.fizz", 0.1F, 2F);
			}
		}
		
	}

}