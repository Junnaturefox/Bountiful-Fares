package net.hecco.bountifulfares.compat.jei;


import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.BFBlocks;
import net.hecco.bountifulfares.recipe.BFRecipes;
import net.hecco.bountifulfares.recipe.MillingRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

//public class MillingRecipeCategory implements IRecipeCategory<MillingRecipe> {
//    private final IDrawable icon;
//    public MillingRecipeCategory(IGuiHelper guiHelper) {
//        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BFBlocks.GRISTMILL));
//    }
//    @Override
//    public RecipeType<MillingRecipe> getRecipeType() {
//        return BountifulFaresJEIPlugin.MILLING;
//    }
//
//    @Override
//    public @NotNull Text getTitle() {
//        return Text.translatable("bountifulfares.milling");
//    }
//
//    @Override
//    public @Nullable IDrawable getIcon() {
//        return icon;
//    }
//
//    @Override
//    public @Nullable Identifier getRegistryName(MillingRecipe recipe) {
//        return Identifier.of(BountifulFares.MOD_ID, "milling");
//    }
//
//    @Override
//    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, MillingRecipe millingRecipe, IFocusGroup iFocusGroup) {
//        ItemStack inputStack = millingRecipe.getOutput();
//        Ingredient resultStack = millingRecipe.getIngredient();
//
//        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 40, 10).addItemStack(inputStack);
//        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 70, 10).addItemStack(resultStack.getMatchingStacks()[0]);
//    }
//
//    @Override
//    public void draw(MillingRecipe recipe, IRecipeSlotsView recipeSlotsView, DrawContext guiGraphics, double mouseX, double mouseY) {
//        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
//    }
//}
