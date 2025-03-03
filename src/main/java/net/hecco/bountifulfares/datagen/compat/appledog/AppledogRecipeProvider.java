package net.hecco.bountifulfares.datagen.compat.appledog;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hecco.bountifulfares.compat.appledog.AppledogBlocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

import static net.hecco.bountifulfares.BountifulFares.APPLEDOG_MOD_ID;

public class AppledogRecipeProvider extends FabricRecipeProvider {
    public AppledogRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerCompactingRecipe(exporter, RecipeCategory.MISC, Registries.ITEM.get(Identifier.of(APPLEDOG_MOD_ID, "dogapple")), AppledogBlocks.APPLEDOG_BLOCK);
    }
}
