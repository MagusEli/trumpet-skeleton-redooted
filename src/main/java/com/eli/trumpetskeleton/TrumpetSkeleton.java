package com.eli.trumpetskeleton;

import com.eli.trumpetskeleton.client.render.TrumpetSkeletonRenderer;
import com.eli.trumpetskeleton.entity.TrumpetSkeletonEntity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(TrumpetSkeleton.MOD_ID)
public class TrumpetSkeleton {

    public static final String MOD_ID = "trumpetskeleton";
    private static final Logger LOGGER = LogManager.getLogger("TrumpetSkeleton");

    public TrumpetSkeleton() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);

        TrumpetRegistry.ITEMS.register(eventBus);
        TrumpetRegistry.SOUNDS.register(eventBus);
        TrumpetRegistry.ENTITIES.register(eventBus);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(TrumpetRegistry.TRUMPET_SKELETON_ENTITY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, SkeletonEntity::canMonsterSpawnInLight);
        GlobalEntityTypeAttributes.put(TrumpetRegistry.TRUMPET_SKELETON_ENTITY.get(), AbstractSkeletonEntity.registerAttributes().create());
    }

    @OnlyIn(Dist.CLIENT)
    public void clientSetup(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                TrumpetRegistry.TRUMPET_SKELETON_ENTITY.get(),
                TrumpetSkeletonRenderer::new
        );
    }
}
