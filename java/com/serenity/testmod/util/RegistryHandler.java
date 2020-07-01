package com.serenity.testmod.util;

import com.serenity.testmod.TestMod;


import com.serenity.testmod.blocks.BlockItemBase;
import com.serenity.testmod.blocks.CactusBlockPoison;
import com.serenity.testmod.blocks.SpiderEggBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CactusBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler
{
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TestMod.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TestMod.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
   // public static final RegistryObject<Item> HANDFULL_SAND = ITEMS.register("handfull_sand", ItemBase::new);


    // Blocks
    public static final RegistryObject<Block> CACTUS_BLOCK_POISON = BLOCKS.register("cactus_block_poison", CactusBlockPoison::new);
    public static final RegistryObject<Block> SPIDER_EGG_BLOCK = BLOCKS.register("spider_egg_block", SpiderEggBlock::new);


    // Block Items
    public static final RegistryObject<Item> CACTUS_BLOCK_POISON_ITEM = ITEMS.register("cactus_block_poison", () -> new BlockItemBase(CACTUS_BLOCK_POISON.get()));
    public static final RegistryObject<Item> SPIDER_EGG_BLOCK_ITEM = ITEMS.register("spider_egg_block", () -> new BlockItemBase(SPIDER_EGG_BLOCK.get()));




}
