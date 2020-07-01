package com.serenity.testmod.client.entity.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.serenity.testmod.client.entity.model.SmallSpiderModel;
import com.serenity.testmod.client.entity.render.layers.SmallSpiderEyesLayer;
import com.serenity.testmod.entities.monsters.SmallSpider;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SmallSpiderRenderer<T extends SmallSpider> extends MobRenderer<T, SmallSpiderModel<T>> {
    private static final ResourceLocation SPIDER_TEXTURES = new ResourceLocation("textures/entity/spider/spider.png");

    public SmallSpiderRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SmallSpiderModel<>(), 0.8F);
        this.addLayer(new SmallSpiderEyesLayer<>(this));


    }

    protected float getDeathMaxRotation(T entityLivingBaseIn) {
        return 180.0F;
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getEntityTexture(T entity) {
        return SPIDER_TEXTURES;
    }
}
