package com.example.usefuladditions;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiModTileEntity extends GuiContainer {

    public GuiModTileEntity(IInventory playerInv, ModTileEntity te) {
        super(new ContainerModTileEntity(playerInv, te));
        
        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    	this.mc.getTextureManager().bindTexture(new ResourceLocation("usefuladditions:textures/blocks/testBlock.png"));
    	this.drawTexturedModalRect(100, 100, 100, 0, xSize, ySize);
    	
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX,int mouseY)
    {
    	super.drawGuiContainerForegroundLayer(mouseX, mouseY);	
    }
}
