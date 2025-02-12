package net.hecco.bountifulfares.datagen.compat.arts_and_crafts;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.arts_and_crafts.ArtsAndCraftsBlocks;
import net.hecco.bountifulfares.compat.mint.MintBlocks;
import net.hecco.bountifulfares.registry.content.BFItems;
import net.hecco.bountifulfares.trellis.TrellisUtil;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.ARTS_AND_CRAFTS_MOD_ID;
import static net.hecco.bountifulfares.BountifulFares.ELS_AND_LS_DYES_MOD_ID;
import static net.hecco.bountifulfares.datagen.BFRecipeProvider.offerPicketsRecipe;
import static net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder.getItemId;

public class ArtsAndCraftsRecipeProvider extends FabricRecipeProvider {
    public ArtsAndCraftsRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        TrellisUtil.registerCompatTrellisRecipe(exporter, ArtsAndCraftsBlocks.CORK);
        offerPicketsRecipe(exporter, ArtsAndCraftsBlocks.CORK_PICKETS, Identifier.of(ARTS_AND_CRAFTS_MOD_ID, "cork_planks"));
    }
}
