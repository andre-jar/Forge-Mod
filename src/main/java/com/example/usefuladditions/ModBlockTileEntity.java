package com.example.usefuladditions;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModBlockTileEntity extends BlockContainer {
	 protected ModBlockTileEntity(String unlocalizedName) {
	        super(Material.iron);
	        this.setBlockName(unlocalizedName);
	        this.setHardness(2.5f);
	        this.setResistance(6.0f);
	        this.setHarvestLevel("pickaxe", 2);
	    }

	    @Override
	    public TileEntity createNewTileEntity(World worldIn, int meta) {
	        return new ModTileEntity();
	    }
	    
	    @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
	        if (!world.isRemote) {
	            player.openGui(UsefulAdditions.instance, ModGuiHandler.MOD_TILE_ENTITY_GUI, world, x, y, z);
	        }
	        return true;
	    }
}
