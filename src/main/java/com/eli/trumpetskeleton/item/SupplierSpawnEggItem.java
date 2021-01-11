package com.eli.trumpetskeleton.item;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.ParametersAreNonnullByDefault;

public class SupplierSpawnEggItem extends SpawnEggItem {
    private final RegistryObject<?> supplier;

    public SupplierSpawnEggItem(RegistryObject<?> supplierIn, int primaryColorIn, int secondaryColorIn, Properties builder) {
        super(null, primaryColorIn, secondaryColorIn, builder);
        supplier = supplierIn;
    }

    @Override
    @ParametersAreNonnullByDefault
    @MethodsReturnNonnullByDefault
    public EntityType<?> getType(CompoundNBT p_208076_1_) {
        return (EntityType<?>) supplier.get();
    }
}
