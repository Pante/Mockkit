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

import org.bukkit.Color;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.*;

import static org.mockito.Mockito.*;


public class MockPotionMeta {
    
    private MockPotionMeta() {}
    
    
    public static @PartialMock PotionMeta potionMeta(Color color, PotionData data, List<PotionEffect> effects) {
        PotionMeta meta = when(mock(PotionMeta.class).getColor()).thenReturn(color).getMock();
        when(meta.getBasePotionData()).thenReturn(data);
        when(meta.getCustomEffects()).thenReturn(effects);
        
        return meta;
    }
    
    
    public static Builder build() {
        return new Builder(mock(PotionMeta.class));
    }
    
    
    protected static class Builder extends MockItemMeta.Builder<PotionMeta> {
        
        public Builder(PotionMeta meta) {
            super(meta);
        }
        
        
        public Builder customEffect(PotionEffect effect, boolean overwrite, boolean added) {
            when(meta.addCustomEffect(effect, overwrite)).thenReturn(added);
            return this;
        }
        
        public Builder hasCustomEffect(PotionEffectType type, boolean has) {
            when(meta.hasCustomEffect(type)).thenReturn(has);
            return this;
        }
        
        public Builder removeCustomEffect(PotionEffectType type, boolean removed) {
            when(meta.removeCustomEffect(type)).thenReturn(removed);
            return this;
        }
        
        
        public Builder customEffects(List<PotionEffect> effects) {
            when(meta.getCustomEffects()).thenReturn(effects);
            return this;
        }
        
        public Builder hasCustomEffect(boolean has) {
            when(meta.hasCustomEffects()).thenReturn(has);
            return this;
        }
        
        public Builder clearCustomEffects(boolean clear) {
            when(meta.clearCustomEffects()).thenReturn(clear);
            return this;
        }
        
        
        public Builder basePotionData(PotionData data) {
            when(meta.getBasePotionData()).thenReturn(data);
            return this;
        }
        
        
        public Builder color(Color color) {
            when(meta.getColor()).thenReturn(color);
            return this;
        }
        
        public Builder hasColor(boolean has) {
            when(meta.hasColor()).thenReturn(has);
            return this;
        }
        
    }
    
}
