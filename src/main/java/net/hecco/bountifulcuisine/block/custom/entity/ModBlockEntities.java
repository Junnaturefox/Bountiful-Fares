package net.hecco.bountifulcuisine.block.custom.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.hecco.bountifulcuisine.BountifulCuisine;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.hecco.bountifulcuisine.block.ModBlocks.*;

public class ModBlockEntities {
    public static final BlockEntityType<CeramicTilesBlockEntity> CERAMIC_TILES_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "ceramic_tiles_block_entity"),
            FabricBlockEntityTypeBuilder.create(CeramicTilesBlockEntity::new, CERAMIC_TILES, CERAMIC_TILE_STAIRS, CERAMIC_TILE_SLAB).build()
    );

    public static final BlockEntityType<CheckeredCeramicTilesBlockEntity> CHECKERED_CERAMIC_TILES_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BountifulCuisine.MOD_ID, "checkered_ceramic_tiles_block_entity"),
            FabricBlockEntityTypeBuilder.create(CheckeredCeramicTilesBlockEntity::new, CERAMIC_TILES).build()
    );
    public static void registerBlockEntities() {
        BountifulCuisine.LOGGER.debug("Registering Block Entities for " + BountifulCuisine.MOD_ID);
    }
}
