
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.blockheads.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class BlockheadsModTabs {
	public static CreativeModeTab TAB_BLOCKHEADS;

	public static void load() {
		TAB_BLOCKHEADS = new CreativeModeTab("tabblockheads") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(Blocks.PLAYER_WALL_HEAD);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
