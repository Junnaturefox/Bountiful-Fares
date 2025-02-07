package net.hecco.bountifulfares.compat.jei;

import mezz.jei.api.recipe.RecipeType;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.recipe.FermentationRecipe;

public class BFRecipeTypes {
    public static final RecipeType<FermentationRecipe> FERMENTING = RecipeType.create(BountifulFares.MOD_ID, "fermenting", FermentationRecipe.class);

    public BFRecipeTypes() {
    }
}
