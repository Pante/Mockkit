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
package com.karuslabs.mockkit.mock.inventory;

import com.karuslabs.mockkit.annotations.*;

import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import static org.mockito.Mockito.*;


public class MockItemStack {
    
    private MockItemStack() {}
    
    
    public static @PartialMock ItemStack itemStack(Material type) {
        ItemStack item = when(mock(ItemStack.class).getType()).thenReturn(type).getMock();
        return item;
    }
    
    public static @PartialMock ItemStack itemStack(Material type, int amount) {
        ItemStack item = when(mock(ItemStack.class).getType()).thenReturn(type).getMock();
        when(item.getAmount()).thenReturn(amount);
        return item;
    }
    
    public static @PartialMock ItemStack itemStack(Material type, int amount, short damage) {
        ItemStack item = when(mock(ItemStack.class).getType()).thenReturn(type).getMock();
        when(item.getAmount()).thenReturn(amount);
        when(item.getDurability()).thenReturn(damage);
        return item;
    }
    
    
    public static Builder builder() {
        return new Builder(mock(ItemStack.class));
    }
    
    
    protected static class Builder {
        
        private ItemStack item;
        
        
        public Builder(ItemStack item) {
            this.item = item;
        }
        
        
        public Builder material(Material material) {
            when(item.getType()).thenReturn(material);
            return this;
        }
        
        public Builder amount(int amount) {
            when(item.getAmount()).thenReturn(amount);
            return this;
        }
        
        public Builder damage(short damage) {
            when(item.getDurability()).thenReturn(damage);
            return this;
        }

        public Builder data(MaterialData data) {
            when(item.getData()).thenReturn(data);
            return this;
        }
                
        public Builder maxSize(int size) {
            when(item.getMaxStackSize()).thenReturn(size);
            return this;
        }
        
        public Builder meta(ItemMeta meta) {
            when(item.getItemMeta()).thenReturn(meta);
            return this;
        }
        
        public Builder hasMeta(boolean has) {
            when(item.hasItemMeta()).thenReturn(has);
            return this;
        }     
                
        
        public Builder containsEnchantment(Enchantment enchantment, boolean contains) {
            when(item.containsEnchantment(enchantment)).thenReturn(contains);
            return this;
        }
        
        public Builder containsEnchantment(boolean contains) {
            when(item.containsEnchantment(any(Enchantment.class))).thenReturn(contains);
            return this;
        }
                
        public Builder removeEnchantment(Enchantment enchantment, int level) {
            when(item.removeEnchantment(enchantment)).thenReturn(level);
            return this;
        }
        
        public Builder removeEnchantment(int level) {
            when(item.removeEnchantment(any(Enchantment.class))).thenReturn(level);
            return this;
        }
        
        public Builder enchantmentLevel(Enchantment enchantment, int level) {
            when(item.getEnchantmentLevel(enchantment)).thenReturn(level);
            return this;
        }
        
        public Builder enchantmentLevel(int level) {
            when(item.getEnchantmentLevel(any(Enchantment.class))).thenReturn(level);
            return this;
        }
        
        public Builder enchantments(Map<Enchantment, Integer> enchantments) {
            when(item.getEnchantments()).thenReturn(enchantments);
            return this;
        }
        
        
        public Builder similar(ItemStack item, boolean similar) {
            when(item.isSimilar(item)).thenReturn(similar);
            return this;
        }
        
        public Builder similar(boolean similar) {
            when(item.isSimilar(any(ItemStack.class))).thenReturn(similar);
            return this;
        }
        
        
        public ItemStack build() {
            return item;
        }
        
    }
    
}
