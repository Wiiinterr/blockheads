
package net.mcreator.blockheads.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.blockheads.init.BlockheadsModTabs;

public class WizardstaffItem extends Item {
	public WizardstaffItem() {
		super(new Item.Properties().tab(BlockheadsModTabs.TAB_BLOCKHEADS).stacksTo(1).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}
}
