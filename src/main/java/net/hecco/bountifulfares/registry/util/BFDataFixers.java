package net.hecco.bountifulfares.registry.util;


import it.unimi.dsi.fastutil.ints.Int2IntMap;
import net.fabricmc.fabric.api.event.registry.RegistryIdRemapCallback;
import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.Map;

public class BFDataFixers {
//    public static void registerDataFixers() {
//        RegistryIdRemapCallback.event(Registries.ITEM).register((remaps) -> {
//            Int2IntMap changes = remaps.getRawIdChangeMap();
//            RegistryKey<Item> oldKey = RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(BountifulFares.MOD_ID, "jar"));
//            RegistryKey<Item> newKey = RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(BountifulFares.MOD_ID, "cup"));
//
//            if (changes.containsKey(oldKey)) {
//                changes.(oldKey, newKey);
//            }
//        });
//    }

}
