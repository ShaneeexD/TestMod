package com.serenity.testmod.world.gen;


import com.serenity.testmod.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CactusBlock;
import net.minecraft.inventory.IClearable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;


public class CactusGen {

    private static BlockState CACTUS_POISIONOUS = RegistryHandler.CACTUS_BLOCK_POISON.get().getDefaultState();
    public static final BlockClusterFeatureConfig CACTUS_POISONOUS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CACTUS_POISIONOUS), new ColumnBlockPlacer(1, 2))).tries(10).func_227317_b_().build();
    private static final BlockState CACTUS = Blocks.CACTUS.getDefaultState();
    public static final BlockClusterFeatureConfig CACTUS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CACTUS), new ColumnBlockPlacer(1, 2))).tries(10).func_227317_b_().build();
    public static float temp;
    public static void generateCactus() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            {

                temp = biome.getDefaultTemperature();
                    if(temp >= 2)
                {

                    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CACTUS_POISONOUS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));

                }
                else
                {

                }
            }
        }
    }
}









