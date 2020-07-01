package com.serenity.testmod.init;

import com.serenity.testmod.TestMod;
import com.serenity.testmod.entities.monsters.SmallSpider;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,
            TestMod.MOD_ID);

    public static final RegistryObject<EntityType<SmallSpider>> SMALL_SPIDER = ENTITY_TYPES
            .register("small_spider",
                    () -> EntityType.Builder.<SmallSpider>create(SmallSpider::new, EntityClassification.MONSTER)
                            .size(0.3f, 0.433333f)
                            .build(new ResourceLocation(TestMod.MOD_ID, "small_spider").toString()));
}
