package com.eli.trumpetskeleton.client.render;

import com.eli.trumpetskeleton.TrumpetSkeleton;
import com.eli.trumpetskeleton.entity.TrumpetSkeletonEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;

@OnlyIn(Dist.CLIENT)
public class TrumpetSkeletonRenderer extends BipedRenderer<TrumpetSkeletonEntity, SkeletonModel<TrumpetSkeletonEntity>> {

    private static final ResourceLocation TRUMPET_SKELETON_TEXTURES = new ResourceLocation(TrumpetSkeleton.MOD_ID, "textures/entity/trumpet_skeleton.png");

    public TrumpetSkeletonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SkeletonModel<>(), 0.5F);
        this.addLayer(new BipedArmorLayer<>(this, new SkeletonModel(0.5F, true), new SkeletonModel(1.0F, true)));
    }

    @Override
    @ParametersAreNonnullByDefault
    @MethodsReturnNonnullByDefault
    public ResourceLocation getEntityTexture(TrumpetSkeletonEntity entity) {
        return TRUMPET_SKELETON_TEXTURES;
    }
}
