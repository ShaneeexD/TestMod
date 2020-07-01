package com.serenity.testmod.items;

import com.serenity.testmod.TestMod;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(TestMod.TAB));
    }
}