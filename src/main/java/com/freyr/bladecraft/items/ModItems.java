package com.freyr.bladecraft.items;

import com.freyr.bladecraft.BladeCraft;
import com.freyr.bladecraft.items.gems.InfusedRuby;
import com.freyr.bladecraft.items.gems.Ruby;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BladeCraft.MOD_ID);

    public static final RegistryObject<Item> GOBLIN_TEAR = ITEMS.register("goblin_tear", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_BREWING)));

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Ruby(new Item.Properties().tab(ModCreativeModeTab.RUBY_ITEM_GROUP)));
    public static final RegistryObject<Item> RAW_RUBY = ITEMS.register("raw_ruby", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.RUBY_ITEM_GROUP)));
    public static final RegistryObject<Item> INFUSED_RUBY = ITEMS.register("infused_ruby", () -> new InfusedRuby(new Item.Properties().tab(ModCreativeModeTab.RUBY_ITEM_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
