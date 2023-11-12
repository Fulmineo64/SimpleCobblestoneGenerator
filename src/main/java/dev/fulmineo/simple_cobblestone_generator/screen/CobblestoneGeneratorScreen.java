package dev.fulmineo.simple_cobblestone_generator.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import dev.fulmineo.simple_cobblestone_generator.SimpleCobblestoneGenerator;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CobblestoneGeneratorScreen extends HandledScreen<CobblestoneGeneratorScreenHandler> {
	private static final Identifier TEXTURE = new Identifier(SimpleCobblestoneGenerator.MOD_ID, "textures/gui/container/generator.png");

   	public CobblestoneGeneratorScreen(CobblestoneGeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
   	}

	protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexProgram);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, TEXTURE);
		// this.client.getTextureManager().bindTexture(TEXTURE);
		int i = (this.width - this.backgroundWidth) / 2;
		int j = (this.height - this.backgroundHeight) / 2;

		// Draws the background
		context.drawTexture(TEXTURE, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
	}

	public void render(DrawContext context, int mouseX, int mouseY, float delta) {
		this.renderBackground(context, mouseX, mouseY, delta);
		super.render(context, mouseX, mouseY, delta);
		this.drawMouseoverTooltip(context, mouseX, mouseY);
	}
}
