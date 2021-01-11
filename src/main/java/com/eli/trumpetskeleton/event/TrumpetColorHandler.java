package com.eli.trumpetskeleton.event;

import com.eli.trumpetskeleton.TrumpetRegistry;
import com.eli.trumpetskeleton.TrumpetSkeleton;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TrumpetSkeleton.MOD_ID)
public class TrumpetColorHandler {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void setupItemColours(final ColorHandlerEvent.Item event) {
        event.getItemColors().register(
                (itemColor, itemsIn) -> TrumpetRegistry.TRUMPET_SKELETON_SPAWN_EGG.get().getColor(itemsIn),
                TrumpetRegistry.TRUMPET_SKELETON_SPAWN_EGG.get()
        );
    }
}
