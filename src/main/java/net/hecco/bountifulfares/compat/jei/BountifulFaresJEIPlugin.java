package net.hecco.bountifulfares.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.recipe.BFRecipes;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;

import java.util.List;

//public class BountifulFaresJEIPlugin implements IModPlugin {
//    public static final RecipeType<MillingRecipe> MILLING =
//            RecipeType.create(BountifulFares.MOD_ID, "milling", MillingRecipe.class);
//    @Override
//    public Identifier getPluginUid() {
//        return Identifier.of(BountifulFares.MOD_ID);
//    }
//
//    @Override
//    public void registerCategories(IRecipeCategoryRegistration registration) {
//        IModPlugin.super.registerCategories(registration);
//        registration.addRecipeCategories(new MillingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
//    }
//
//    @Override
//    public void registerRecipes(IRecipeRegistration registration) {
//        RecipeManager recipeManager;
//        if (MinecraftClient.getInstance().world != null) {
//            recipeManager = MinecraftClient.getInstance().world.getRecipeManager();
//        } else {
//            throw new NullPointerException("World must not be null to get recipes.");
//        }
//
//        registration.addRecipes(MILLING, recipeManager.listAllOfType(BFRecipes.MILLING).stream().map(RecipeEntry::value).toList());
//    }
//
//    @Override
//    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//        registration.addRecipeCatalyst(new ItemStack(BFBlocks.GRISTMILL), MILLING);
//    }
//}
