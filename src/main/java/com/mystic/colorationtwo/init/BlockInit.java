package com.mystic.colorationtwo.init;

import com.mystic.colorationtwo.blocks.ColorAirBlock;
import com.mystic.colorationtwo.util.Reference;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Objects;
import java.util.function.Function;

public class BlockInit{

    public static final ItemGroup COLOREDAIRGROUP = FabricItemGroupBuilder.create(new Identifier(Reference.MODID, "air_group")).icon(() -> new ColorAirBlock(FabricBlockSettings.of(Material.AIR)).asItem().getDefaultStack()).build();

    public static final ColorAirBlock COLOR_AIR_BLOCK = (ColorAirBlock) register("color_air_block", new ColorAirBlock(FabricBlockSettings.of(Material.AIR)));

    private static Block baseRegister(String name, Block block, Function<Block, Item> item) {
        Registry.register(Registry.BLOCK, new Identifier(Reference.MODID, name), block);
        ItemInit.register(name, item.apply(block));
        return block;
    }

    private static Block register(String name, Block block) {
        return baseRegister(name, block, BlockInit::registerBlockItem);
    }

    private static BlockItem registerBlockItem(Block block) {
        return new BlockItem(Objects.requireNonNull(block), new Item.Settings().group(COLOREDAIRGROUP));
    }

}
