package com.mystic.colorationtwo.init;

import com.mystic.colorationtwo.util.Reference;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemInit {

    public static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Reference.MODID, name), item);
    }

    //ITEMS
    //put items here!
}
