package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

// Forge-Version 1.7.10-10.13.4.1558
@Mod(modid = ExampleMod.MODID,  name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Example Mod";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	Block testBlock = new TestBlock(Blocks.dirt.getMaterial()).setHardness(2.5F).setStepSound(Blocks.dirt.stepSound).setCreativeTab(CreativeTabs.tabBlock).setBlockTextureName(MODID + ":" + "testBlock").setBlockName("Super toller Block");
    	GameRegistry.addRecipe(new ItemStack(Item.getItemById(264)),"xxx","xxx","xxx",'x',new ItemStack(Block.getBlockById(3)));
    	GameRegistry.addShapelessRecipe(new ItemStack(Block.getBlockFromName("Super toller Block")), new Object[] {Blocks.dirt, new ItemStack(Blocks.dirt, 5)});
    	GameRegistry.addShapelessRecipe(new ItemStack(Block.getBlockFromName("Super toller Block")), new Object[] {Blocks.stone, new ItemStack(Blocks.stone, 5)});
    	GameRegistry.registerBlock(testBlock, "Supertoller Block");
    }
}
