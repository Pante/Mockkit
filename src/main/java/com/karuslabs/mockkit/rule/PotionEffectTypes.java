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
package com.karuslabs.mockkit.rule;

import com.karuslabs.mockkit.UncheckedReflectiveException;
import com.karuslabs.mockkit.annotations.PartialMock;
import com.karuslabs.mockkit.mock.MockPotionEffectType;

import java.lang.reflect.Field;
import java.util.*;

import org.bukkit.potion.PotionEffectType;

import org.junit.rules.ExternalResource;


@PartialMock
public class PotionEffectTypes extends ExternalResource {
    
    public static final PotionEffectTypes INSTANCE = new PotionEffectTypes();
    
    
    private Map<Integer, String> cache;
    
    private PotionEffectType[] byId;
    private Map<String, PotionEffectType> byName;
    
    private Field accepting;
    
    
    protected PotionEffectTypes() {
        try {
            Field idField = PotionEffectType.class.getDeclaredField("byId");
            Field nameField = PotionEffectType.class.getDeclaredField("byName");
            accepting = PotionEffectType.class.getDeclaredField("acceptingNew");
            
            idField.setAccessible(true);
            nameField.setAccessible(true);
            accepting.setAccessible(true);
            
            byId = (PotionEffectType[]) idField.get(null);
            byName = (Map<String, PotionEffectType>) nameField.get(null);
            
            cache = new HashMap<>();
            for (Field field : PotionEffectType.class.getFields()) {
                cache.put(((PotionEffectType) field.get(null)).getId(), field.getName());
            }
            
        } catch (ReflectiveOperationException e) {
            throw new UncheckedReflectiveException(e);
        }
    }
    
    
    @Override
    protected void before() {
        byName.clear();
        
        cache.forEach((id, name) -> {
            @PartialMock PotionEffectType type = MockPotionEffectType.potionEffectType(0, name);
            byId[id] = type;
            byName.put(name, type);
        });
    }
    
    
    public void register(PotionEffectType type) {
        byId[type.getId()] = type;
        byName.put(type.getName(), type);
    }
    
    public void unregister(PotionEffectType type) {
        byId[type.getId()] = null;
        byName.remove(type.getName());
    }
    
    
    public PotionEffectType[] getById() {
        return byId;
    }

    public Map<String, PotionEffectType> getByName() {
        return byName;
    }
    
    
    public boolean isAccepting() {
        try {
            return accepting.getBoolean(null);
            
        } catch (ReflectiveOperationException e) {
            throw new UncheckedReflectiveException(e);
        }
    }
    
    public void setAccepting(boolean accepting) {
        try {
            this.accepting.setBoolean(null, accepting);
            
        } catch (ReflectiveOperationException e) {
            throw new UncheckedReflectiveException(e);
        }
    }
    
}
