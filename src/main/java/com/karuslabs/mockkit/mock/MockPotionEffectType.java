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

import org.bukkit.Color;
import org.bukkit.potion.PotionEffectType;

import static org.mockito.Mockito.*;


public class MockPotionEffectType {
    
    private MockPotionEffectType() {}
    
    
    public static @PartialMock PotionEffectType potionEffectType(int id, String name) {
        PotionEffectType type = when(mock(PotionEffectType.class).getId()).thenReturn(id).getMock();
        when(type.getName()).thenReturn(name);
        
        return type;
    }
    
    
    public static Builder builder() {
        return new Builder(mock(PotionEffectType.class));
    }
    
    
    protected static class Builder {
        
        private PotionEffectType type;
        
        
        public Builder(PotionEffectType type) {
            this.type = type;
        }
        
        
        public Builder id(int id) {
            when(type.getId()).thenReturn(id);
            return this;
        }
        
        public Builder name(String name) {
            when(type.getName()).thenReturn(name);
            return this;
        }
        
        
        public Builder duration(double duration) {
            when(type.getDurationModifier()).thenReturn(duration);
            return this;
        }
        
        public Builder instant(boolean instant) {
            when(type.isInstant()).thenReturn(instant);
            return this;
        }
        
        public Builder color(Color color) {
            when(type.getColor()).thenReturn(color);
            return this;
        }
        
        
        public PotionEffectType build() {
            return type;
        }
        
    }
    
}
