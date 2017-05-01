/*
 * Copyright (C) 2017 Karus Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.karuslabs.mockkit.stub.inventory;

import com.karuslabs.mockkit.annotations.Unimplemented;
import com.karuslabs.mockkit.mock.inventory.meta.*;

import java.util.*;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;


public class StubItemFactory implements ItemFactory {

    public static StubItemFactory INSTANCE = new StubItemFactory();
    
    
    private StubItemFactory() {};
    
    
    @Override
    public ItemMeta getItemMeta(Material material) {
        switch (material) {
            case AIR:
                return null;
                
            case WRITTEN_BOOK:
            case BOOK_AND_QUILL:
                return MockBookMeta.bookMeta("", "");
                
            case SKULL_ITEM:
                return MockMetas.skullMeta("", true);
                
            case LEATHER_HELMET:
            case LEATHER_CHESTPLATE:
            case LEATHER_LEGGINGS:
            case LEATHER_BOOTS:
                return MockMetas.leatherArmorMeta(Color.FUCHSIA);
                
            case POTION:
            case SPLASH_POTION:
            case LINGERING_POTION:
            case TIPPED_ARROW:
                return MockPotionMeta.potionMeta(Color.SILVER, null, new ArrayList<>());
                
            case MAP:
                return MockMapMeta.mapMeta(Color.SILVER, "", true);
                
            case FIREWORK:
            case FIREWORK_CHARGE:
                return MockFireworkMeta.fireworkMeta(new ArrayList<>(), 0, 0);
                
            case ENCHANTED_BOOK:
                return MockEnchantmentStorageMeta.enchantmentStorageMeta(new HashMap<>());
                        
            case BANNER:
                return MockBannerMeta.bannerMeta(new ArrayList<>());

            case MONSTER_EGG:
                return MockMetas.spawnEggMeta(EntityType.EGG);

            case FURNACE:
            case CHEST:
            case TRAPPED_CHEST:
            case JUKEBOX:
            case DISPENSER:
            case DROPPER:
            case SIGN:
            case MOB_SPAWNER:
            case NOTE_BLOCK:
            case PISTON_BASE:
            case BREWING_STAND_ITEM:
            case ENCHANTMENT_TABLE:
            case COMMAND:
            case COMMAND_REPEATING:
            case COMMAND_CHAIN:
            case BEACON:
            case DAYLIGHT_DETECTOR:
            case DAYLIGHT_DETECTOR_INVERTED:
            case HOPPER:
            case REDSTONE_COMPARATOR:
            case FLOWER_POT_ITEM:
            case SHIELD:
            case STRUCTURE_BLOCK:
            case WHITE_SHULKER_BOX:
            case ORANGE_SHULKER_BOX:
            case MAGENTA_SHULKER_BOX:
            case LIGHT_BLUE_SHULKER_BOX:
            case YELLOW_SHULKER_BOX:
            case LIME_SHULKER_BOX:
            case PINK_SHULKER_BOX:
            case GRAY_SHULKER_BOX:
            case SILVER_SHULKER_BOX:
            case CYAN_SHULKER_BOX:
            case PURPLE_SHULKER_BOX:
            case BLUE_SHULKER_BOX:
            case BROWN_SHULKER_BOX:
            case GREEN_SHULKER_BOX:
            case RED_SHULKER_BOX:
            case BLACK_SHULKER_BOX:
            case ENDER_CHEST:
                return MockMetas.blockstateMeta(null, false);

            default:
                return MockItemMeta.meta("", new ArrayList<>());
        }
    }

    @Override
    @Unimplemented
    public boolean isApplicable(ItemMeta meta, ItemStack item) throws IllegalArgumentException {
        return isApplicable(meta, item.getType());
    }

    @Override
    @Unimplemented
    public boolean isApplicable(ItemMeta meta, Material material) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Unimplemented
    public boolean equals(ItemMeta meta1, ItemMeta meta2) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Unimplemented
    public ItemMeta asMetaFor(ItemMeta meta, ItemStack item) throws IllegalArgumentException {
        return asMetaFor(meta, item.getType());
    }

    @Override
    @Unimplemented
    public ItemMeta asMetaFor(ItemMeta meta, Material material) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getDefaultLeatherColor() {
        return Color.fromRGB(0xA06540);
    }
    
}
