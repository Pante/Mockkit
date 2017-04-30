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

import java.util.*;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.meta.ItemMeta;

import static org.mockito.Mockito.*;


public class MockItemMeta {
    
    private MockItemMeta() {}
    
    
    public static @PartialMock ItemMeta meta(String name, List<String> lore) {
        ItemMeta meta = when(mock(ItemMeta.class).getDisplayName()).thenReturn(name).getMock();
        when(meta.getLore()).thenReturn(lore);
        
        return meta;
    }
    
    public static @PartialMock ItemMeta meta(String name, List<String> lore, Set<ItemFlag> flags) {
        ItemMeta meta = when(mock(ItemMeta.class).getDisplayName()).thenReturn(name).getMock();
        when(meta.getLore()).thenReturn(lore);
        when(meta.getItemFlags()).thenReturn(flags);
        
        return meta;
    }
    
    
    public static Builder<ItemMeta> builder() {
        return new Builder(mock(ItemMeta.class));
    }
    
    
    public static class Builder<GenericMeta extends ItemMeta> {
        
        protected GenericMeta meta;
        
        
        public Builder(GenericMeta meta) {
            this.meta = meta;
        }
        
        
        public Builder addEnchantment(Enchantment enchantment, int level, boolean ignoreLevelRestriction, boolean added) {
            when(meta.addEnchant(enchantment, 0, ignoreLevelRestriction)).thenReturn(added);
            return this;
        }
        
        public Builder hasEnchantment(Enchantment enchantment, boolean has) {
            when(meta.hasEnchant(enchantment)).thenReturn(has);
            return this;
        }
        
        public Builder removeEnchantment(Enchantment enchantment, boolean removed) {
            when(meta.removeEnchant(enchantment)).thenReturn(removed);
            return this;
        }
        
        
        public Builder enchantmentLevel(Enchantment enchantment, int level) {
            when(meta.getEnchantLevel(enchantment)).thenReturn(level);
            return this;
        }
        
        public Builder enchantments(Map<Enchantment, Integer> enchantments) {
            when(meta.getEnchants()).thenReturn(enchantments);
            return this;
        }
        
        public Builder hasEnchantments(boolean has) {
            when(meta.hasEnchants()).thenReturn(has);
            return this;
        }
        
        public Builder conflictingEnchantment(Enchantment enchantment, boolean has) {
            when(meta.hasConflictingEnchant(enchantment)).thenReturn(has);
            return this;
        }
        
        
        public Builder name(String name) {
            when(meta.getDisplayName()).thenReturn(name);
            return this;
        }
        
        public Builder hasName(boolean has) {
            when(meta.hasDisplayName()).thenReturn(has);
            return this;
        }
        
        
        public Builder localizedName(String name) {
            when(meta.getLocalizedName()).thenReturn(name);
            return this;
        }
        
        public Builder hasLocalizedName(boolean has) {
            when(meta.hasLocalizedName()).thenReturn(has);
            return this;
        }
        
        
        public Builder lore(List<String> lore) {
            when(meta.getLore()).thenReturn(lore);
            return this;
        }
        
        public Builder hasLore(boolean has) {
            when(meta.hasLore()).thenReturn(has);
            return this;
        }
        
        
        public Builder unbreakable(boolean unbreakable) {
            when(meta.isUnbreakable()).thenReturn(unbreakable);
            return this;
        }
        
        
        public Builder itemFlags(Set<ItemFlag> flags) {
            when(meta.getItemFlags()).thenReturn(flags);
            return this;
        }
        
        public Builder hasItemFlag(ItemFlag flag, boolean has) {
            when(meta.hasItemFlag(flag)).thenReturn(has);
            return this;
        }
        
        
        public GenericMeta build() {
            return meta;
        }
        
    }
    
}
