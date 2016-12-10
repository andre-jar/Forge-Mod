package com.example.usefuladditions;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ModGuiHandler implements IGuiHandler {

    public static final int MOD_TILE_ENTITY_GUI = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == MOD_TILE_ENTITY_GUI)
            return new ContainerModTileEntity(player.inventory, (ModTileEntity) world.getTileEntity(x, y, z));

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == MOD_TILE_ENTITY_GUI)
            return new GuiModTileEntity(player.inventory, (ModTileEntity) world.getTileEntity(x, y, z));

        return null;
    }
}
