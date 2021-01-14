package store.shadowclient.client.cosmetics.impl;

import com.mojang.authlib.GameProfile;

import store.shadowclient.client.Shadow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class CosmeticCape implements LayerRenderer<AbstractClientPlayer> {
	
	  private static final GameProfile GameProfile = null;
	  
	  
	  private final RenderPlayer playerRenderer;
	  
	  public CosmeticCape(RenderPlayer playerRendererIn) {
	    this.playerRenderer = playerRendererIn;
	  }
	  public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
		  if(Shadow.instance.moduleManager.getModuleByName("Cosmetics").isToggled()) {
				if(Shadow.instance.settingsManager.getSettingByName("Cape").getValBoolean()) {
				    if (entitylivingbaseIn == (Minecraft.getMinecraft()).thePlayer && !entitylivingbaseIn.isInvisible() && entitylivingbaseIn.isWearing(EnumPlayerModelParts.CAPE)) {
				    		ResourceLocation Cape = new ResourceLocation("client/cape.png");
				    		this.playerRenderer.bindTexture(Cape);
				    	
				      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				      GlStateManager.pushMatrix();
			          GlStateManager.translate(0.0F, 0.0F, 0.125F);
			          double d0 = entitylivingbaseIn.prevChasingPosX + (entitylivingbaseIn.chasingPosX - entitylivingbaseIn.prevChasingPosX) * (double)partialTicks - (entitylivingbaseIn.prevPosX + (entitylivingbaseIn.posX - entitylivingbaseIn.prevPosX) * (double)partialTicks);
			          double d1 = entitylivingbaseIn.prevChasingPosY + (entitylivingbaseIn.chasingPosY - entitylivingbaseIn.prevChasingPosY) * (double)partialTicks - (entitylivingbaseIn.prevPosY + (entitylivingbaseIn.posY - entitylivingbaseIn.prevPosY) * (double)partialTicks);
			          double d2 = entitylivingbaseIn.prevChasingPosZ + (entitylivingbaseIn.chasingPosZ - entitylivingbaseIn.prevChasingPosZ) * (double)partialTicks - (entitylivingbaseIn.prevPosZ + (entitylivingbaseIn.posZ - entitylivingbaseIn.prevPosZ) * (double)partialTicks);
			          float f = entitylivingbaseIn.prevRenderYawOffset + (entitylivingbaseIn.renderYawOffset - entitylivingbaseIn.prevRenderYawOffset) * partialTicks;
			          double d3 = (double)MathHelper.sin(f * (float)Math.PI / 180.0F);
			          double d4 = (double)(-MathHelper.cos(f * (float)Math.PI / 180.0F));
			          float f1 = (float)d1 * 10.0F;
			          f1 = MathHelper.clamp_float(f1, -6.0F, 32.0F);
			          float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
			          float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
			
				      
				      if (f2 < 0.0F)
			          {
			              f2 = 0.0F;
			          }
			
			          if (f2 > 165.0F)
			          {
			              f2 = 165.0F;
			          }
			
			          float f4 = entitylivingbaseIn.prevCameraYaw + (entitylivingbaseIn.cameraYaw - entitylivingbaseIn.prevCameraYaw) * partialTicks;
			          f1 = f1 + MathHelper.sin((entitylivingbaseIn.prevDistanceWalkedModified + (entitylivingbaseIn.distanceWalkedModified - entitylivingbaseIn.prevDistanceWalkedModified) * partialTicks) * 6.0F) * 32.0F * f4;
			
			          if (entitylivingbaseIn.isSneaking())
			          {
			              f1 += 25.0F;
			              GlStateManager.translate(0.0F, 0.142F, -0.0178F);
			          } 
				      
				      GlStateManager.rotate(6.0F + f2 / 2.0F + f1, 1.0F, 0.0F, 0.0F);
			          GlStateManager.rotate(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
			          GlStateManager.rotate(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
			          GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
			          this.playerRenderer.getMainModel().renderCape(0.0625F);
			          GlStateManager.popMatrix();
			    	} 
				}
			}
	  }
	  public boolean shouldCombineTextures() {
	    return false;
	  }
}