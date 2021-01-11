package com.eli.trumpetskeleton.event;

import com.eli.trumpetskeleton.TrumpetRegistry;
import com.eli.trumpetskeleton.TrumpetSkeleton;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TrumpetSkeleton.MOD_ID)
public class TrumpetSpawning {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        List<MobSpawnInfo.Spawners> spawns = event.getSpawns().getSpawner(EntityClassification.MONSTER);
        spawns.add(new MobSpawnInfo.Spawners(TrumpetRegistry.TRUMPET_SKELETON_ENTITY.get(), 85, 1, 4));
    }
}
