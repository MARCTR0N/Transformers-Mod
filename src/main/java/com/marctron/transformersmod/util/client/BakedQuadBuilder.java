package com.marctron.transformersmod.util.client;

import javax.vecmath.Matrix4f;
import javax.vecmath.Vector3f;
import javax.vecmath.Vector4f;

import net.minecraft.client.renderer.EnumFaceDirection;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.ForgeHooksClient;

public class BakedQuadBuilder {

	private Vector3f[] positions = new Vector3f[4];
	private Vector4f uv;
	private long color;
	private TextureAtlasSprite texture;
	private EnumFacing face = null;
	
	public BakedQuadBuilder setPosition(Vector3f position, int index) {
		this.positions[index] = position;
		return this;
	}
	
	public BakedQuadBuilder setUV(Vector4f uv) {
		this.uv = uv;
		return this;
	}
	
	public BakedQuadBuilder setColor(long color) {
		this.color = color;
		return this;
	}
	
	public BakedQuadBuilder setTexture(TextureAtlasSprite texture) {
		this.texture = texture;
		return this;
	}

	public BakedQuadBuilder setFace(EnumFacing face) {
		this.face = face;
		return this;
	}

	public BakedQuadBuilder applyRotation(Vector3f rotation, Vector3f center) {
		
		Matrix4f points = this.buildPositionMatrix();
		
		Matrix4f transformation = new TransformationBuilder().add(null, rotation, center, null, 0).buildMatirx();
		
		points.mul(transformation, points);
		
		this.resolvePositionMatrix(points);
		
		return this;
	}
	
	public BakedQuad build() {
		
		int[] ints = new int[28];

		int norm = calculateNormal(buildPositionMatrix());

		for (int i = 0; i < 4; i++) {
			ints[i*7 + 0] = Float.floatToRawIntBits(positions[i].getX());
			ints[i*7 + 1] = Float.floatToRawIntBits(positions[i].getY());
			ints[i*7 + 2] = Float.floatToRawIntBits(positions[i].getZ());
			ints[i*7 + 3] = (int) color;
			ints[i*7 + 4] = Float.floatToRawIntBits(texture.getInterpolatedU(this.getUPoint(i)));
			ints[i*7 + 5] = Float.floatToRawIntBits(texture.getInterpolatedV(this.getVPoint(i)));
			ints[i*7 + 6] = norm;
		}

		EnumFacing direction = FaceBakery.getFacingFromVertexData(ints);

		//this.applyFacing(ints, direction);

		//ForgeHooksClient.fillNormal(ints, direction);
		
		return new BakedQuad(ints, -1, direction, texture, true, DefaultVertexFormats.ITEM);
		
	}
	
	private float getUPoint(int i) {
		if (i == 0 || i == 1) {
			return uv.x;
		}
		else {
			return uv.z;
		}
	}
	
	private float getVPoint(int i) {
		if (i == 0 || i == 3) {
			return uv.y;
		}
		else {
			return uv.w;
		}
	}

	private int calculateNormal(Matrix4f points) {

		float xp = points.m03 - points.m01;
		float yp = points.m13 - points.m11;
		float zp = points.m23 - points.m21;

		float xq = points.m02 - points.m00;
		float yq = points.m12 - points.m10;
		float zq = points.m22 - points.m20;

		//Cross Product
		float xn = yq * zp - zq * yp;
		float yn = zq * xp - xq * zp;
		float zn = xq * yp - yq * xp;

		//Normalize
		float norm = (float) Math.sqrt(xn * xn + yn * yn + zn * zn);
		final float SMALL_LENGTH = 1.0E-6F;  //Vec3d.normalise() uses this
		if (norm < SMALL_LENGTH) norm = 1.0F;  // protect against degenerate quad

		norm = 1.0F / norm;
		xn *= norm;
		yn *= norm;
		zn *= norm;

		int x = ((byte) (xn * 127)) & 0xFF;
		int y = ((byte) (yn * 127)) & 0xFF;
		int z = ((byte) (zn * 127)) & 0xFF;
		return x | (y << 0x08) | (z << 0x10);
	}
	
	private void resolvePositionMatrix(Matrix4f points) {

		for (int i = 0; i < 4; i++) {
			float[] floats = new float[4];
			points.getColumn(i, floats);
			positions[i] = new Vector3f(floats);
		}
		
	}

	private Matrix4f buildPositionMatrix() {
		
		Matrix4f points = new Matrix4f();
		
		for (int i = 0; i < 4; i++) {
			points.setColumn(i, new Vector4f(positions[i]));
		}
		
		points.setRow(3, 1, 1, 1, 1);
		
		return points;
		
	}
	
	
}