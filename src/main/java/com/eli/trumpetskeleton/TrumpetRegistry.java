package com.eli.trumpetskeleton;

import com.eli.trumpetskeleton.entity.TrumpetSkeletonEntity;
import com.eli.trumpetskeleton.item.SupplierSpawnEggItem;
import com.eli.trumpetskeleton.item.TrumpetItem;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TrumpetRegistry {

    // Items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TrumpetSkeleton.MOD_ID);

    public static final RegistryObject<TrumpetItem> TRUMPET_ITEM = ITEMS.register(
            "trumpet",
            () -> new TrumpetItem(
                    new Item.Properties()
                            .group(ItemGroup.MISC)
                            .maxDamage(600)
            )
    );

    public static final RegistryObject<SpawnEggItem> TRUMPET_SKELETON_SPAWN_EGG = ITEMS.register(
            "trumpet_skeleton_spawn_egg",
            () -> new SupplierSpawnEggItem(
                    TrumpetRegistry.TRUMPET_SKELETON_ENTITY,
                    0xC1C1C1,
                    0xFCFC00,
                    new Item.Properties().group(ItemGroup.MISC)
            )
    );

    // Sounds
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TrumpetSkeleton.MOD_ID);

    public static final RegistryObject<SoundEvent> PARROT_DOOT = SOUNDS.register(
            "entity.parrot.imitate.trumpet_skeleton",
            () -> new SoundEvent(new ResourceLocation(TrumpetSkeleton.MOD_ID, "entity.parrot.imitate.trumpet_skeleton"))
    );

    public static final RegistryObject<SoundEvent> SKELETON_DOOT = SOUNDS.register(
            "entity.trumpet_skeleton.ambient",
            () -> new SoundEvent(new ResourceLocation(TrumpetSkeleton.MOD_ID, "entity.trumpet_skeleton.ambient"))
    );

    public static final RegistryObject<SoundEvent> TRUMPET_DOOT = SOUNDS.register(
            "item.trumpet.use",
            () -> new SoundEvent(new ResourceLocation(TrumpetSkeleton.MOD_ID, "item.trumpet.use"))
    );

    // Entities
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, TrumpetSkeleton.MOD_ID);

    public static final RegistryObject<EntityType<TrumpetSkeletonEntity>> TRUMPET_SKELETON_ENTITY = ENTITIES.register(
            "trumpet_skeleton",

            () -> EntityType.Builder
                    .create(TrumpetSkeletonEntity::new, EntityClassification.MONSTER)
                    .size(0.6F, 1.99F)
                    .build("trumpet_skeleton")
    );
}
