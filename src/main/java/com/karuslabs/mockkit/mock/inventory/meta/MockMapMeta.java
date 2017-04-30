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

import org.bukkit.Color;
import org.bukkit.inventory.meta.MapMeta;

import static org.mockito.Mockito.*;


public class MockMapMeta {
    
    private MockMapMeta() {}
    
    
    public static @PartialMock MapMeta mapMeta(Color color, String name, boolean scaling) {
        MapMeta meta = when(mock(MapMeta.class).getColor()).thenReturn(color).getMock();
        when(meta.getLocationName()).thenReturn(name);
        when(meta.isScaling()).thenReturn(scaling);
        
        return meta;
    }
    
    
    protected static class Builder extends MockItemMeta.Builder<MapMeta> {
        
        public Builder(MapMeta meta) {
            super(meta);
        }
        
        
        public Builder color(Color color) {
            when(meta.getColor()).thenReturn(color);
            return this;
        }
        
        public Builder hasColor(boolean color) {
            when(meta.hasColor()).thenReturn(color);
            return this;
        }
        
        
        public Builder locationName(String name) {
            when(meta.getLocationName()).thenReturn(name);
            return this;
        }
        
        public Builder hasLocationName(boolean name) {
            when(meta.hasLocationName()).thenReturn(name);
            return this;
        }
        
        
        public Builder scaling(boolean scaling) {
            when(meta.isScaling()).thenReturn(scaling);
            return this;
        }
        
    }
    
}
