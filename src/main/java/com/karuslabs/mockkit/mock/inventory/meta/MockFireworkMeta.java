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

import java.util.List;

import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkMeta;

import static org.mockito.Mockito.*;


public class MockFireworkMeta {
    
    private MockFireworkMeta() {}
    
    
    public static @PartialMock FireworkMeta fireworkMeta(List<FireworkEffect> effects, int size, int power) {
        FireworkMeta meta = when(mock(FireworkMeta.class).getEffects()).thenReturn(effects).getMock();
        when(meta.getEffectsSize()).thenReturn(size);
        when(meta.getPower()).thenReturn(power);
        
        return meta;
    }
    
    public static Builder builder() {
        return new Builder(mock(FireworkMeta.class));
    }
    
    
    protected static class Builder extends MockItemMeta.Builder<FireworkMeta> {
        
        public Builder(FireworkMeta meta) {
            super(meta);
        }
        
        
        public Builder effects(List<FireworkEffect> effects) {
            when(meta.getEffects()).thenReturn(effects);
            return this;
        }
        
        public Builder hasEffects(boolean has) {
            when(meta.hasEffects()).thenReturn(has);
            return this;
        }
        
        
        public Builder size(int size) {
            when(meta.getEffectsSize()).thenReturn(size);
            return this;
        }
        
        public Builder power(int power) {
            when(meta.getPower()).thenReturn(power);
            return this;
        }
        
    }
    
}
