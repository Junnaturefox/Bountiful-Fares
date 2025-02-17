package net.hecco.bountifulfares.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class OPStewItem extends StackableBowlFoodItem{
    public OPStewItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.literal("Perfectly balanced!").formatted(Formatting.GREEN).formatted(Formatting.ITALIC));
    }
}
