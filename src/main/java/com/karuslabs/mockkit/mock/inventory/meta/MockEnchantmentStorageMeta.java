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
package com.karuslabs.mockkit.mock.inventory.meta;

import com.karuslabs.mockkit.annotations.PartialMock;

import java.util.Map;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import static org.mockito.Mockito.*;


public class MockEnchantmentStorageMeta {
    
    private MockEnchantmentStorageMeta() {}
    
    
    public static @PartialMock EnchantmentStorageMeta enchantmentStorageMeta(Map<Enchantment, Integer> enchantments) {
        EnchantmentStorageMeta meta = when(mock(EnchantmentStorageMeta.class).getStoredEnchants()).thenReturn(enchantments).getMock();
        return meta;
    }
    
    
    public Builder builder() {
        return new Builder(mock(EnchantmentStorageMeta.class));
    }
    
    
    protected static class Builder extends MockItemMeta.Builder<EnchantmentStorageMeta> {
        
        public Builder(EnchantmentStorageMeta meta) {
            super(meta);
        }
        
        
        public Builder storedEnchantment(Enchantment enchantment, int level, boolean ignoreLevelRestriction, boolean added) {
            when(meta.addEnchant(enchantment, level, ignoreLevelRestriction)).thenReturn(added);
            return this;
        }
        
        public Builder hasStoredEnchantment(Enchantment enchantment, boolean has) {
            when(meta.hasStoredEnchant(enchantment)).thenReturn(has);
            return this;
        }
        
        
        public Builder storedEnchantmentLevel(Enchantment enchantment, int level) {
            when(meta.getStoredEnchantLevel(enchantment)).thenReturn(level);
            return this;
        }
        
        
        public Builder storedEnchantments(Map<Enchantment,Integer> enchantments) {
            when(meta.getStoredEnchants()).thenReturn(enchantments);
            return this;
        }
        
        public Builder hasStoredEnchantments(boolean has) {
            when(meta.hasStoredEnchants()).thenReturn(has);
            return this;
        }
        
        
        public Builder hasConflictingStoredEnchantment(Enchantment enchantment, boolean has) {
            when(meta.hasConflictingStoredEnchant(enchantment)).thenReturn(has);
            return this;
        }
        
        
        public Builder removeStoredEnchantment(Enchantment enchantment, boolean removed) {
            when(meta.removeStoredEnchant(enchantment)).thenReturn(removed);
            return this;
        }
        
    }
    
}
