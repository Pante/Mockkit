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
package com.karuslabs.mockkit.mock;

import com.karuslabs.mockkit.annotations.*;

import org.bukkit.enchantments.*;
import org.bukkit.inventory.ItemStack;

import static org.mockito.Mockito.*;


public class MockEnchantment {
    
    private MockEnchantment() {}
    
    
    public static @PartialMock Enchantment enchantment(int id, String name) {
        Enchantment enchantment = when(mock(Enchantment.class).getId()).thenReturn(id).getMock();
        when(enchantment.getName()).thenReturn(name);
        
        return enchantment;
    }
    
    
    public static Builder builder() {
        return new Builder(mock(Enchantment.class));
    }
    
    
    protected static class Builder {
        
        private Enchantment enchantment;
        
        
        public Builder(Enchantment enchantment) {
            this.enchantment = enchantment;
        }
        
                
        public Builder id(int id) {
            when(enchantment.getId()).thenReturn(id);
            return this;
        }
        
        public Builder name(String name) {
            when(enchantment.getName()).thenReturn(name);
            return this;
        }
        
        
        public Builder maxLevel(int level) {
            when(enchantment.getMaxLevel()).thenReturn(level);
            return this;
        }
        
        public Builder startLevel(int level) {
            when(enchantment.getStartLevel()).thenReturn(level);
            return this;
        }
        
        
        public Builder itemTarget(EnchantmentTarget target) {
            when(enchantment.getItemTarget()).thenReturn(target);
            return this;
        }
        
        
        public Builder treasure(boolean treasure) {
            when(enchantment.isTreasure()).thenReturn(treasure);
            return this;
        }
        
        public Builder cursed(boolean cursed) {
            when(enchantment.isCursed()).thenReturn(cursed);
            return this;
        }
        
        
        public Builder conflictsWith(Enchantment enchantment, boolean conflitcs) {
            when(enchantment.conflictsWith(enchantment)).thenReturn(conflitcs);
            return this;
        }
        
        public Builder conflictsWith(boolean conflitcs) {
            when(enchantment.conflictsWith(any(Enchantment.class))).thenReturn(conflitcs);
            return this;
        }
        
        
        public Builder enchantItem(ItemStack item, boolean enchant) {
            when(enchantment.canEnchantItem(item)).thenReturn(enchant);
            return this;
        }
        
        public Builder enchantItem(boolean enchant) {
            when(enchantment.canEnchantItem(any(ItemStack.class))).thenReturn(enchant);
            return this;
        }
        
        
        public Enchantment build() {
            return enchantment;
        } 
        
    }
    
}
