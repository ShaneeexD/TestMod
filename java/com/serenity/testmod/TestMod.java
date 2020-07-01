package com.serenity.testmod;

import com.serenity.testmod.init.ModEntityTypes;
import com.serenity.testmod.util.RegistryHandler;
import com.serenity.testmod.world.gen.CactusGen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("testmod")

public class TestMod
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "testmod";


    public TestMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);


        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);


        RegistryHandler.init();
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

        DeferredWorkQueue.runLater(CactusGen::generateCactus);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(RegistryHandler.CACTUS_BLOCK_POISON.get(), RenderType.getCutout());
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {


    }


    //Custom ItemGroup TAB
    public static final ItemGroup TAB = new ItemGroup("testmod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.CACTUS_BLOCK_POISON.get());
        }
    };




}

