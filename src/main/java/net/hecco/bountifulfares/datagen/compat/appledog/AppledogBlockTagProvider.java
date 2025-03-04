package net.hecco.bountifulfares.datagen.compat.appledog;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.hecco.bountifulfares.compat.appledog.AppledogBlocks;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.registry.util.BFBlockTags;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.hecco.bountifulfares.trellis.trellis_parts.DecorativeVine;
import net.hecco.bountifulfares.trellis.trellis_parts.TrellisVariant;
import net.hecco.bountifulfares.trellis.trellis_parts.VineCrop;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class AppledogBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public AppledogBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(AppledogBlocks.APPLEDOG_BLOCK)
        ;

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(AppledogBlocks.APPLEDOG_BLOCK)
        ;
    }
}
