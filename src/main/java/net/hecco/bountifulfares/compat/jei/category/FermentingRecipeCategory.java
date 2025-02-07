package net.hecco.bountifulfares.compat.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.registry.content.BFBlocks;
import net.hecco.bountifulfares.compat.jei.BFRecipeTypes;
import net.hecco.bountifulfares.recipe.FermentationRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FermentingRecipeCategory implements IRecipeCategory<FermentationRecipe> {
    private final IDrawable fermentationVessel;
    private final IDrawable background;

    public FermentingRecipeCategory(IGuiHelper helper) {
        fermentationVessel = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BFBlocks.FERMENTATION_VESSEL.asItem()));
        Identifier backgroundImage = Identifier.of(BountifulFares.MOD_ID, "textures/gui/jei/fermenting.png");
        background = helper.createDrawable(backgroundImage, 0, 0, 72, 64);
    }

    @Override
    public RecipeType<FermentationRecipe> getRecipeType() {
        return BFRecipeTypes.FERMENTING;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FermentationRecipe recipe, IFocusGroup focusGroup) {
        List<Ingredient> recipeIngredients = recipe.getIngredients();
        ItemStack resultStack = recipe.getOutput();
        //ItemStack containerStack = recipe.getOutputContainer(); Whichever container slot has the output

        //Code for placing slot locations (input/any misc slot locations)

        builder.addSlot(RecipeIngredientRole.OUTPUT, 0, 0).addItemStack(resultStack); //output slot location

//        if (!containerStack.isEmpty()) {
//            builder.addSlot(RecipeIngredientRole.CATALYST, 0, 0).addItemStack(containerStack); //output itemstack location
//        }
    }

    //this method draws icons (arrow progress etc), i havent converted some mappings here since you use yarn
//    @Override
//    public void draw(FermentationRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
//
//    }

    @Override //you can ignore the errors on this method and getBackground (if they cause errors you can comment them out)
    public List<Text> getTooltipStrings(FermentationRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        return List.of(); //hovering over specific icons to display text (id suggest using it for the clock to show how long itll take and the water)
    }

    @Override
    public Text getTitle() {
        return Text.translatable("jei.bountifulfares.fermentation_vessel");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return fermentationVessel;
    }
}
