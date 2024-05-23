package net.hecco.bountifulfares.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.trellis.BFTrellises;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.data.client.*;

import static net.hecco.bountifulfares.datagen.custom.BFTemplateModels.*;

public class BFModelProvider extends FabricModelProvider {
    public BFModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(BFBlocks.WALNUT_LOG).log(BFBlocks.WALNUT_LOG).wood(BFBlocks.WALNUT_WOOD);
        blockStateModelGenerator.registerLog(BFBlocks.STRIPPED_WALNUT_LOG).log(BFBlocks.STRIPPED_WALNUT_LOG).wood(BFBlocks.STRIPPED_WALNUT_WOOD);
        blockStateModelGenerator.registerSingleton(BFBlocks.WALNUT_LEAVES, TexturedModel.LEAVES);
        BlockStateModelGenerator.BlockTexturePool walnutTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(BFBlocks.WALNUT_PLANKS);
        walnutTexturePool.stairs(BFBlocks.WALNUT_STAIRS);
        walnutTexturePool.slab(BFBlocks.WALNUT_SLAB);
        walnutTexturePool.fence(BFBlocks.WALNUT_FENCE);
        walnutTexturePool.fenceGate(BFBlocks.WALNUT_FENCE_GATE);
        walnutTexturePool.pressurePlate(BFBlocks.WALNUT_PRESSURE_PLATE);
        walnutTexturePool.button(BFBlocks.WALNUT_BUTTON);
        blockStateModelGenerator.registerHangingSign(BFBlocks.STRIPPED_WALNUT_LOG, BFBlocks.WALNUT_HANGING_SIGN, BFBlocks.WALNUT_WALL_HANGING_SIGN);
        blockStateModelGenerator.registerDoor(BFBlocks.WALNUT_DOOR);
        blockStateModelGenerator.registerSimpleCubeAll(BFBlocks.CUT_FELDSPAR_BLOCK);
        BlockStateModelGenerator.BlockTexturePool feldsparTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(BFBlocks.FELDSPAR_BRICKS);
        feldsparTexturePool.stairs(BFBlocks.FELDSPAR_BRICK_STAIRS);
        feldsparTexturePool.slab(BFBlocks.FELDSPAR_BRICK_SLAB);

        registerPicketsModels(blockStateModelGenerator, BFBlocks.OAK_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.SPRUCE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.BIRCH_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.JUNGLE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.ACACIA_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.DARK_OAK_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.MANGROVE_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.CHERRY_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.BAMBOO_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.HOARY_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.WALNUT_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.CRIMSON_PICKETS);
        registerPicketsModels(blockStateModelGenerator, BFBlocks.WARPED_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.ASPEN_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.CEDAR_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.COCONUT_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.CYPRESS_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.FIR_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.GHAF_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.JOSHUA_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.LARCH_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.MAHOGANY_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.MAPLE_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.OLIVE_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.PALO_VERDE_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.REDWOOD_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.SAXAUL_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.SUGI_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.WILLOW_PICKETS);
//        registerPicketsModels(blockStateModelGenerator, ModBlocks.WISTERIA_PICKETS);

//        for (TrellisVariant trellis : TrellisVariants.TrellisVariants) {
//            if (Objects.equals(trellis.getId(), BountifulFares.MOD_ID)) {
//                ModTemplateModels.registerTrellis(blockStateModelGenerator, TrellisUtil.getTrellisFromVariant(trellis));
//                for (VineCrop crop : TrellisVariants.VineCrops) {
//                    ModTemplateModels.registerCropTrellis(blockStateModelGenerator,
//                            TrellisUtil.getCropTrellisFromVariant(trellis, crop),
//                            trellis.getTrellisName(),
//                            crop.getName() + "_trellis_vines",
//                            crop.getName() + "_trellis_foliage",
//                            trellis.getId());
//                }
//                for (DecorativeVine vine : TrellisVariants.DecorativeVines) {
//                    if (vine != ModTrellises.TWISTING) {
//                        ModTemplateModels.registerDecorTrellis(blockStateModelGenerator,
//                                TrellisUtil.getDecorTrellisFromVariant(trellis, vine),
//                                trellis.getTrellisName(),
//                                vine.getName() + "_trellis_vines",
//                                vine.getName() + "_trellis_foliage",
//                                trellis.getId());
//                    } else {
//                        ModTemplateModels.registerUpsideDownDecorTrellis(blockStateModelGenerator,
//                                TrellisUtil.getDecorTrellisFromVariant(trellis, vine),
//                                trellis.getTrellisName(),
//                                vine.getName() + "_trellis_vines",
//                                vine.getName() + "_trellis_foliage",
//                                trellis.getId());
//                    }
//                }
//            }
//        }
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.OAK);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.SPRUCE);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.BIRCH);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.JUNGLE);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.ACACIA);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.DARK_OAK);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.MANGROVE);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.CHERRY);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.BAMBOO);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.WALNUT);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.HOARY);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.CRIMSON);
        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.WARPED);

//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.ANCIENT);

//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.WINTERGREEN);

//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, BFTrellises.ROTTEN);

//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.ASPEN);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.CEDAR);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.COCONUT);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.CYPRESS);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.FIR);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.GHAF);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.JOSHUA);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.LARCH);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.MAHOGANY);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.MAPLE);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.OLIVE);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.PALO_VERDE);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.REDWOOD);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.SAXAUL);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.SUGI);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.WILLOW);
//        TrellisUtil.registerTrellisModels(blockStateModelGenerator, ModTrellises.WISTERIA);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(BFItems.LEEK, Models.HANDHELD);
        itemModelGenerator.register(BFItems.LEEK_SEEDS, Models.GENERATED);
        itemModelGenerator.register(BFItems.LEEK_STEW, Models.GENERATED);
        itemModelGenerator.register(BFItems.CRUSTED_BEEF, Models.GENERATED);
        itemModelGenerator.register(BFItems.WALNUT, Models.GENERATED);
        itemModelGenerator.register(BFItems.WALNUT_BOAT, Models.GENERATED);
        itemModelGenerator.register(BFItems.WALNUT_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(BFBlocks.WILD_PASSION_FRUIT_VINE.asItem(), Models.GENERATED);
        itemModelGenerator.register(BFBlocks.WILD_ELDERBERRY_VINE.asItem(), Models.GENERATED);
        itemModelGenerator.register(BFItems.FISH_STEW, Models.GENERATED);
        itemModelGenerator.register(BFItems.APPLE_STEW, Models.GENERATED);
        itemModelGenerator.register(BFItems.STONE_STEW, Models.GENERATED);
        itemModelGenerator.register(BFItems.FOREST_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(BFItems.ARID_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(BFItems.MEADOW_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(BFItems.COASTAL_MEDLEY, Models.GENERATED);
        itemModelGenerator.register(BFItems.BERRY_STUFFED_POTATO, Models.GENERATED);
        itemModelGenerator.register(BFItems.MAIZE_STUFFED_POTATO, Models.GENERATED);
        itemModelGenerator.register(BFItems.MAIZE_BREAD, Models.GENERATED);
        itemModelGenerator.register(BFItems.WALNUT_COOKIE, Models.GENERATED);
        itemModelGenerator.register(BFItems.CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.PIQUANT_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.PASSION_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.COCOA_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.GLOWING_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.ANCIENT_CUSTARD, Models.GENERATED);
        itemModelGenerator.register(BFItems.CANDIED_APPLE, Models.GENERATED);
        itemModelGenerator.register(BFItems.CANDIED_PLUM, Models.GENERATED);
        itemModelGenerator.register(BFItems.GRASS_SEEDS, Models.GENERATED);
        itemModelGenerator.register(BFItems.SCORCHKIN_SEEDS, Models.GENERATED);
    }
}