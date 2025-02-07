package net.hecco.bountifulfares.compat.jei;

import net.hecco.bountifulfares.recipe.BFRecipes;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.recipe.RecipeManager;

import java.util.List;

public class BFJEIRecipes {
    private final RecipeManager recipeManager;

    public BFJEIRecipes() {
        MinecraftClient minecraft = MinecraftClient.getInstance();
        ClientWorld world = minecraft.world;
        if (world != null) {
            this.recipeManager = world.getRecipeManager();
        } else {
            throw new NullPointerException("minecraft world must not be null.");
        }
    }

//    public List<FermentationRecipe> getFermentationRecipes() {
//        return this.recipeManager.getAllRecipesFor(BFRecipes.FERMENTING).stream().toList(); //TODO: convert mappings for getAllRecipesFor to yarn
//    }
}
