package net.hecco.bountifulfares;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hecco.bountifulfares.datagen.*;
import net.hecco.bountifulfares.datagen.BFLangProvider;
import net.hecco.bountifulfares.datagen.compat.appledog.AppledogBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.compat.appledog.AppledogBlockTagProvider;
import net.hecco.bountifulfares.datagen.compat.appledog.AppledogRecipeProvider;
import net.hecco.bountifulfares.datagen.compat.arts_and_crafts.ArtsAndCraftsBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.compat.arts_and_crafts.ArtsAndCraftsBlockTagProvider;
import net.hecco.bountifulfares.datagen.compat.arts_and_crafts.ArtsAndCraftsRecipeProvider;
import net.hecco.bountifulfares.datagen.compat.delicate_dyes.DelicateDyesBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.compat.delicate_dyes.DelicateDyesBlockTagProvider;
import net.hecco.bountifulfares.datagen.compat.delicate_dyes.DelicateDyesRecipeProvider;
import net.hecco.bountifulfares.datagen.compat.dye_depot.DyeDepotBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.compat.dye_depot.DyeDepotBlockTagProvider;
import net.hecco.bountifulfares.datagen.compat.dye_depot.DyeDepotRecipeProvider;
import net.hecco.bountifulfares.datagen.compat.excessive_building.ExcessiveBuildingBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.compat.excessive_building.ExcessiveBuildingBlockTagProvider;
import net.hecco.bountifulfares.datagen.compat.excessive_building.ExcessiveBuildingRecipeProvider;
import net.hecco.bountifulfares.datagen.compat.farmersdelight.FarmersDelightBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.compat.farmersdelight.FarmersDelightBlockTagProvider;
import net.hecco.bountifulfares.datagen.compat.farmersdelight.FarmersDelightRecipeProvider;
import net.hecco.bountifulfares.datagen.compat.mint.MintBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.compat.mint.MintBlockTagProvider;
import net.hecco.bountifulfares.datagen.compat.mint.MintRecipeProvider;
import net.hecco.bountifulfares.datagen.compat.natures_spirit.NaturesSpiritBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.compat.natures_spirit.NaturesSpiritBlockTagProvider;
import net.hecco.bountifulfares.datagen.compat.natures_spirit.NaturesSpiritItemTagProvider;
import net.hecco.bountifulfares.datagen.compat.natures_spirit.NaturesSpiritRecipeProvider;
import net.hecco.bountifulfares.datagen.compat.spawn.SpawnBlockLootTableProvider;
import net.hecco.bountifulfares.datagen.compat.spawn.SpawnBlockTagProvider;
import net.hecco.bountifulfares.datagen.compat.spawn.SpawnRecipeProvider;
import net.hecco.bountifulfares.registry.misc.BFConfiguredFeatures;
import net.hecco.bountifulfares.registry.misc.BFPlacedFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class BountifulFaresDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BFRecipeProvider::new);
        pack.addProvider(BFBlockLootTableProvider::new);
        pack.addProvider(BFBlockTagProvider::new);
        pack.addProvider(BFItemTagProvider::new);
        pack.addProvider(BFAdvancementProvider::new);
        pack.addProvider(BFModelProvider::new);
        pack.addProvider(BFLangProvider::new);

        FabricDataGenerator.Pack mintDataPack = fabricDataGenerator.createBuiltinResourcePack(Identifier.of(BountifulFares.MOD_ID, BountifulFares.ELS_AND_LS_DYES_MOD_ID + "_dat"));
        mintDataPack.addProvider(MintBlockLootTableProvider::new);
        mintDataPack.addProvider(MintBlockTagProvider::new);
        mintDataPack.addProvider(MintRecipeProvider::new);

        FabricDataGenerator.Pack artsAndCraftsDataPack = fabricDataGenerator.createBuiltinResourcePack(Identifier.of(BountifulFares.MOD_ID, BountifulFares.ARTS_AND_CRAFTS_MOD_ID + "_dat"));
        artsAndCraftsDataPack.addProvider(ArtsAndCraftsBlockLootTableProvider::new);
        artsAndCraftsDataPack.addProvider(ArtsAndCraftsBlockTagProvider::new);
        artsAndCraftsDataPack.addProvider(ArtsAndCraftsRecipeProvider::new);

        FabricDataGenerator.Pack dyeDepotDataPack = fabricDataGenerator.createBuiltinResourcePack(Identifier.of(BountifulFares.MOD_ID, BountifulFares.DYE_DEPOT_MOD_ID + "_dat"));
        dyeDepotDataPack.addProvider(DyeDepotBlockLootTableProvider::new);
        dyeDepotDataPack.addProvider(DyeDepotBlockTagProvider::new);
        dyeDepotDataPack.addProvider(DyeDepotRecipeProvider::new);

        FabricDataGenerator.Pack excessiveBuildingPack = fabricDataGenerator.createBuiltinResourcePack(Identifier.of(BountifulFares.MOD_ID, BountifulFares.EXCESSIVE_BUILDING_MOD_ID + "_dat"));
        excessiveBuildingPack.addProvider(ExcessiveBuildingBlockLootTableProvider::new);
        excessiveBuildingPack.addProvider(ExcessiveBuildingBlockTagProvider::new);
        excessiveBuildingPack.addProvider(ExcessiveBuildingRecipeProvider::new);

//        FabricDataGenerator.Pack farmersDelightPack = fabricDataGenerator.createBuiltinResourcePack(Identifier.of(BountifulFares.MOD_ID, BountifulFares.FARMERS_DELIGHT_MOD_ID + "_dat"));
//        farmersDelightPack.addProvider(FarmersDelightBlockLootTableProvider::new);
//        farmersDelightPack.addProvider(FarmersDelightBlockTagProvider::new);
//        farmersDelightPack.addProvider(FarmersDelightRecipeProvider::new);

        FabricDataGenerator.Pack naturesSpiritPack = fabricDataGenerator.createBuiltinResourcePack(Identifier.of(BountifulFares.MOD_ID, BountifulFares.NATURES_SPIRIT_MOD_ID + "_dat"));
        naturesSpiritPack.addProvider(NaturesSpiritBlockLootTableProvider::new);
        naturesSpiritPack.addProvider(NaturesSpiritBlockTagProvider::new);
        naturesSpiritPack.addProvider(NaturesSpiritItemTagProvider::new);
        naturesSpiritPack.addProvider(NaturesSpiritRecipeProvider::new);

        FabricDataGenerator.Pack spawnPack = fabricDataGenerator.createBuiltinResourcePack(Identifier.of(BountifulFares.MOD_ID, BountifulFares.SPAWN_MOD_ID + "_dat"));
        spawnPack.addProvider(SpawnBlockLootTableProvider::new);
        spawnPack.addProvider(SpawnBlockTagProvider::new);
        spawnPack.addProvider(SpawnRecipeProvider::new);

        FabricDataGenerator.Pack twigsPack = fabricDataGenerator.createBuiltinResourcePack(Identifier.of(BountifulFares.MOD_ID, BountifulFares.TWIGS_MOD_ID + "_dat"));
        twigsPack.addProvider(SpawnBlockLootTableProvider::new);
        twigsPack.addProvider(SpawnBlockTagProvider::new);
        twigsPack.addProvider(SpawnRecipeProvider::new);

        FabricDataGenerator.Pack delicateDyesPack = fabricDataGenerator.createBuiltinResourcePack(Identifier.of(BountifulFares.MOD_ID, BountifulFares.DELICATE_DYES_MOD_ID + "_dat"));
        delicateDyesPack.addProvider(DelicateDyesBlockLootTableProvider::new);
        delicateDyesPack.addProvider(DelicateDyesBlockTagProvider::new);
        delicateDyesPack.addProvider(DelicateDyesRecipeProvider::new);

        FabricDataGenerator.Pack appledogPack = fabricDataGenerator.createBuiltinResourcePack(Identifier.of(BountifulFares.MOD_ID, BountifulFares.APPLEDOG_MOD_ID + "_dat"));
        appledogPack.addProvider(AppledogBlockLootTableProvider::new);
        appledogPack.addProvider(AppledogBlockTagProvider::new);
        appledogPack.addProvider(AppledogRecipeProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, BFConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, BFPlacedFeatures::bootstrap);
    }
}
