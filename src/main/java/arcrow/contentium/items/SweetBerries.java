package arcrow.contentium.items;

import arcrow.contentium.core.utils.Utils;
import arcrow.contentium.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SweetBerries extends ItemFood {

	
	public SweetBerries() {
		super(4, 1F, false);
		this.setUnlocalizedName(Utils.getUnlocalisedName("sweet_berries"));
		this.setTextureName(Reference.MOD_ID + ":sweet_berries");
		this.setCreativeTab(CreativeTabs.tabFood);
	}

	@Override
	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
		--p_77654_1_.stackSize;
		p_77654_3_.getFoodStats().func_151686_a(this, p_77654_1_);
        p_77654_2_.playSoundAtEntity(p_77654_3_, "random.burp", 0.5F, p_77654_2_.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(p_77654_1_, p_77654_2_, p_77654_3_);
        return p_77654_1_;
	}
	
}