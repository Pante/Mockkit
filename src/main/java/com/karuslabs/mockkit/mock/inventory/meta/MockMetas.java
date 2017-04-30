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

import org.bukkit.*;
import org.bukkit.block.BlockState;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.meta.*;

import static org.mockito.Mockito.*;


public class MockMetas {
    
    private MockMetas() {}
    
    
    public static @Mock BlockStateMeta blockstateMeta(BlockState state, boolean has) {
        BlockStateMeta meta = when(mock(BlockStateMeta.class).getBlockState()).thenReturn(state).getMock();
        when(meta.hasBlockState()).thenReturn(has);
        
        return meta;
    }
    
    
    public static @Mock FireworkEffectMeta fireworkEffectMeta(FireworkEffect effect, boolean has) {
        FireworkEffectMeta meta = when(mock(FireworkEffectMeta.class).getEffect()).thenReturn(effect).getMock();
        when(meta.hasEffect()).thenReturn(has);
        
        return meta;
    }
    
    
    public static @Mock LeatherArmorMeta leatherArmorMeta(Color color) {
        LeatherArmorMeta meta = when(mock(LeatherArmorMeta.class).getColor()).thenReturn(color).getMock();
        return meta;
    }
    
    
    
    public static @Mock SkullMeta skullMeta(String name, boolean has) {
        SkullMeta meta = when(mock(SkullMeta.class).getOwner()).thenReturn(name).getMock();
        when(meta.hasOwner()).thenReturn(has);
        
        return meta;
    }
    
    
    public static @Mock SpawnEggMeta spawnEggMeta(EntityType type) {
        SpawnEggMeta meta = when(mock(SpawnEggMeta.class).getSpawnedType()).thenReturn(type).getMock();
        return meta;
    }
    
    
    public static <GenericMeta extends ItemMeta> MockItemMeta.Builder<GenericMeta> build(GenericMeta meta) {
        return new MockItemMeta.Builder<>(meta);
    }
    
}
