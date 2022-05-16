
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.blockheads.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.blockheads.item.WizardstaffItem;
import net.mcreator.blockheads.item.BookItem;
import net.mcreator.blockheads.BlockheadsMod;

public class BlockheadsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BlockheadsMod.MODID);
	public static final RegistryObject<Item> BOOK = REGISTRY.register("book", () -> new BookItem());
	public static final RegistryObject<Item> WIZARDSTAFF = REGISTRY.register("wizardstaff", () -> new WizardstaffItem());
}
