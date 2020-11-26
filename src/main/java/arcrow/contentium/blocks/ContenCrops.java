package arcrow.contentium.blocks;

import java.util.Random;

import arcrow.contentium.lib.Reference;
import net.minecraft.block.BlockCrops;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContenCrops extends BlockCrops {
	
	public ContenCrops() {
		setTickRandomly(false);
		setBlockBounds(0F, 0F, 0F, 1F, 0.5F, 1F);
		setStepSound(soundTypeGrass);
		disableStats();
		setHardness(0.0F);
	}
	
	@Override
	public int getRenderType() { return 1; }
		
	@Override
	public void onBlockAdded(World w, int x, int y, int z) {
		w.scheduleBlockUpdate(x, y, z, this, this.tickRate(w));
		super.onBlockAdded(w, x, y, z);
	}
	
	@Override
	public int tickRate(World w) {
		return 30;
	}
	
	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(!w.isRemote) {
			int meta = w.getBlockMetadata(x, y, z);
			boolean flag = false;
			for(ItemStack it : p.inventory.mainInventory) {
				if(it == null || (it.getItem() == this.func_149865_P() && it.stackSize > it.getMaxStackSize())) {
					flag = true;
					break;
				}
			}
			if(meta >= 7) {
				if(flag) {
					p.inventory.addItemStackToInventory(new ItemStack(func_149865_P()));
					((EntityPlayerMP) p).sendContainerToPlayer(p.inventoryContainer);
				}else {
					w.spawnEntityInWorld(new EntityItem(w, x, y, z, new ItemStack(func_149865_P())));
				}
				p.playSound(Reference.MOD_ID + ":block.bush.place", 1F, 2F);
				w.setBlock(x, y, z, this, 5, 0);				
			}
		}
		return false;
	}
		
	@Override
	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		return super.func_149851_a(p_149851_1_, p_149851_2_, p_149851_3_, p_149851_4_, p_149851_5_);
	}
	
	@Override
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return super.func_149852_a(p_149852_1_, p_149852_2_, p_149852_3_, p_149852_4_, p_149852_5_);
	}
	
	@Override
	public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		super.func_149853_b(p_149853_1_, p_149853_2_, p_149853_3_, p_149853_4_, p_149853_5_);
	}
	
}
