package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class TestBlock extends Block {

	protected TestBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
	}
    
	@Override
	public void onBlockClicked(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {
		p_149699_5_.addChatComponentMessage(new ChatComponentText("Hello " +p_149699_5_.getCommandSenderName() +"!"));
	}
}
