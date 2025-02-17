package net.hecco.bountifulfares.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.entity.GristmillBlockEntity;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GristmillScreen extends HandledScreen<GristmillScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(BountifulFares.MOD_ID, "textures/gui/gristmill.png");
    private final GristmillBlockEntity blockEntity;
    public GristmillScreen(GristmillScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.blockEntity = handler.blockEntity;
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
        renderProgressArrow(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            //TODO: Fix progress arrow
//            BountifulFares.LOGGER.info("scaledProgress: " + handler.getScaledProgress());
            context.drawTexture(TEXTURE, x + 69, y + 36, 176, 0, handler.getScaledProgress(), 14);
//            context.drawTexture(TEXTURE, x + 69, y + 36, 176 + handler.getScaledProgress(), 0, handler.getScaledProgress(), 16);

        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
