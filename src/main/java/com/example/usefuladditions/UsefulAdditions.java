package com.example.usefuladditions;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

// Forge-Version 1.7.10-10.13.4.1558
@Mod(modid = UsefulAdditions.MODID,  name = UsefulAdditions.NAME, version = UsefulAdditions.VERSION)
public class UsefulAdditions
{
    public static final String MODID = "UsefulAdditions";
    public static final String VERSION = "0.1";
    public static final String NAME = "Useful Additions";
    public static UsefulAdditions instance;
    @SidedProxy(clientSide="com.example.usefuladditions.CommonProxy", serverSide="com.example.usefuladditions.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	Block mobDropper = new ModBlockTileEntity("Mobdropper").setStepSound(Blocks.stone.stepSound).setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(MODID + ":" + "testBlock").setBlockName("Mobdropper");
    	GameRegistry.addRecipe(new ItemStack(Item.getItemById(264)),"xxx","xxx","xxx",'x',new ItemStack(Block.getBlockById(3)));
    	GameRegistry.registerBlock(mobDropper, "Mobdropper");
    	UsefulAdditions.instance=this;
        proxy.init(event);
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
