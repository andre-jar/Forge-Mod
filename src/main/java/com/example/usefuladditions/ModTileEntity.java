package com.example.usefuladditions;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public final class ModTileEntity extends TileEntity implements IUpdatePlayerListBox,IInventory {

	 private ItemStack[] inventory;
	    private String customName;

	    public ModTileEntity() {
	        this.inventory = new ItemStack[this.getSizeInventory()];
	    }

	    public String getCustomName() {
	        return this.customName;
	    }

	    public void setCustomName(String customName) {
	        this.customName = customName;
	    }
	
    public static void init() {
        GameRegistry.registerTileEntity(ModTileEntity.class, "mod_tile_entity");
    }

	@Override
	public void update() {
		
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
	    if (p_70301_1_ < 0 || p_70301_1_ >= this.getSizeInventory())
	        return null;
	    return this.inventory[p_70301_1_];
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		if (this.getStackInSlot(p_70298_1_) != null) {
	        ItemStack itemstack;

	        if (this.getStackInSlot(p_70298_1_).stackSize <= p_70298_2_) {
	            itemstack = this.getStackInSlot(p_70298_1_);
	            this.setInventorySlotContents(p_70298_1_, null);
	            this.markDirty();
	            return itemstack;
	        } else {
	            itemstack = this.getStackInSlot(p_70298_1_).splitStack(p_70298_2_);

	            if (this.getStackInSlot(p_70298_1_).stackSize <= 0) {
	                this.setInventorySlotContents(p_70298_1_, null);
	            } else {
	                //Just to show that changes happened
	                this.setInventorySlotContents(p_70298_1_, this.getStackInSlot(p_70298_1_));
	            }

	            this.markDirty();
	            return itemstack;
	        }
	    } else {
	        return null;
	    }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
	    ItemStack stack = this.getStackInSlot(p_70304_1_);
	    this.setInventorySlotContents(p_70304_1_, null);
	    return stack;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		if (p_70299_1_ < 0 || p_70299_1_ >= this.getSizeInventory())
	        return;

	    if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
	    	p_70299_2_.stackSize = this.getInventoryStackLimit();
	        
	    if (p_70299_2_ != null && p_70299_2_.stackSize == 0)
	    	p_70299_2_ = null;

	    this.inventory[p_70299_1_] = p_70299_2_;
	    this.markDirty();
		
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customName : "container.tutorial_tile_entity";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.customName != null && !this.customName.equals("");
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		TileEntity te = this.worldObj.getTileEntity(xCoord, yCoord, zCoord);
		return te==this && p_70300_1_.getDistanceSq(xCoord, yCoord, zCoord)<=64;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		return true;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
	    super.writeToNBT(nbt);

	    NBTTagList list = new NBTTagList();
	    for (int i = 0; i < this.getSizeInventory(); ++i) {
	        if (this.getStackInSlot(i) != null) {
	            NBTTagCompound stackTag = new NBTTagCompound();
	            stackTag.setByte("Slot", (byte) i);
	            this.getStackInSlot(i).writeToNBT(stackTag);
	            list.appendTag(stackTag);
	        }
	    }
	    nbt.setTag("Items", list);

	    if (this.hasCustomInventoryName()) {
	        nbt.setString("CustomName", this.getCustomName());
	    }
	}


	@Override
	public void readFromNBT(NBTTagCompound nbt) {
	    super.readFromNBT(nbt);

	    NBTTagList list = nbt.getTagList("Items", 10);
	    for (int i = 0; i < list.tagCount(); ++i) {
	        NBTTagCompound stackTag = list.getCompoundTagAt(i);
	        int slot = stackTag.getByte("Slot") & 255;
	        this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
	    }

	    if (nbt.hasKey("CustomName", 8)) {
	        this.setCustomName(nbt.getString("CustomName"));
	    }
	}

}
