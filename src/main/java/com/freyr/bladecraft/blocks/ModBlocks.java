package com.freyr.bladecraft.blocks;

import com.freyr.bladecraft.BladeCraft;
import com.freyr.bladecraft.items.ModCreativeModeTab;
import com.freyr.bladecraft.items.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BladeCraft.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.RUBY_ITEM_GROUP);
    public static final RegistryObject<Block> RAW_RUBY_BLOCK = registerBlock("raw_ruby_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f, 4f).requiresCorrectToolForDrops()), ModCreativeModeTab.RUBY_ITEM_GROUP);
    public static final RegistryObject<Block> RUBY_ORE_BLOCK = registerBlock("ruby_ore_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f, 4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.RUBY_ITEM_GROUP);
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE_BLOCK = registerBlock("deepslate_ruby_ore_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f, 4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.RUBY_ITEM_GROUP);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
