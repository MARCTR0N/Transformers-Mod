package com.marctron.transformersmod.util;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class DamageIndicator {

	private int width = 73;
	private int height = 21;

	private int alpha = 255;
	private float attackYaw;

	public DamageIndicator(float attackYaw) {
		this.attackYaw = attackYaw;
	}

	public int getAlpha() {
		return alpha;
	}

	public void draw(int x, int y, float angle) {
		angle += attackYaw;
		int centerX = width / 2;
		GlStateManager.pushMatrix();
		GlStateManager.pushAttrib();
		GlStateManager.translate(x, y, 0);
		GlStateManager.rotate(180-angle, 0, 0, 1);
		GlStateManager.translate(-centerX, 50, 0);
		GlStateManager.enableBlend();
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
		buffer.begin(GL11.GL_TRIANGLES, DefaultVertexFormats.POSITION_COLOR);
		buffer.pos((double) (centerX), (double) (height), 0.0D).color(255, 0, 0, alpha).endVertex();
		buffer.pos((double) (width), (double) (0), 0.0D).color(255, 0, 0, alpha).endVertex();
		buffer.pos((double) (0), (double) (0), 0.0D).color(255, 0, 0, alpha).endVertex();
		tessellator.draw();
		GlStateManager.disableBlend();
		GlStateManager.popAttrib();
		GlStateManager.popMatrix();
		if (!Minecraft.getMinecraft().isGamePaused())
			alpha--;
	}
}
