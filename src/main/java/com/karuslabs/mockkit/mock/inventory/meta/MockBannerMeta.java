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

import com.karuslabs.mockkit.annotations.*;

import java.util.*;

import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;
import org.bukkit.inventory.meta.BannerMeta;

import static org.mockito.Mockito.*;


public class MockBannerMeta {
    
    private MockBannerMeta() {}
    
    
    public static @PartialMock BannerMeta bannerMeta(List<Pattern> patterns) {
        BannerMeta meta = when(mock(BannerMeta.class).getPatterns()).thenReturn(patterns).getMock();
        when(meta.getPattern(anyInt())).thenAnswer(invocation -> meta.getPatterns().get(invocation.getArgument(0)));
        
        return meta;
    }
    
    public static @PartialMock BannerMeta bannerMeta(DyeColor color, List<Pattern> patterns) {
        BannerMeta meta = when(mock(BannerMeta.class).getPatterns()).thenReturn(patterns).getMock();
        when(meta.getPattern(anyInt())).thenAnswer(invocation -> meta.getPatterns().get(invocation.getArgument(0)));
        when(meta.getBaseColor()).thenReturn(color);
        
        return meta;
    }
    
    
    public Builder builder() {
        return new Builder(mock(BannerMeta.class));
    }
    
    
    protected static class Builder extends MockItemMeta.Builder<BannerMeta>  {
        
        public Builder(BannerMeta meta) {
            super(meta);
        }
        
        
        public Builder base(DyeColor color) {
            when(meta.getBaseColor()).thenReturn(color);
            return this;
        }
        
        public Builder pattern(int i, Pattern pattern) {
            when(meta.getPattern(i)).thenReturn(pattern);
            return this;
        }
        
        public Builder patterns(List<Pattern> patterns) {
            when(meta.getPatterns()).thenReturn(patterns);
            return this;
        }
        
        public Builder numberOfPatterns(int size) {
            when(meta.numberOfPatterns()).thenReturn(size);
            return this;
        }
        
        public Builder remove(int i, Pattern pattern) {
            when(meta.removePattern(i)).thenReturn(pattern);
            return this;
        }
        
    }
    
}
