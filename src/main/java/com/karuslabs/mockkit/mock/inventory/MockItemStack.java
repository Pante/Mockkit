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

import com.karuslabs.mockkit.annotations.PartialMock;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

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
        
        
        public Builder containsEnchantment(Enchantment enchantment, boolean contains) {
            return this;
        }
        
        
        public ItemStack build() {
            return item;
        }
        
    }
    
}
