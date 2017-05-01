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
import com.karuslabs.mockkit.annotations.PartialStub;
import com.karuslabs.mockkit.stub.StubEnchantment;

import java.lang.reflect.Field;
import java.util.*;

import org.bukkit.enchantments.Enchantment;

import org.junit.rules.ExternalResource;


public class Enchantments extends ExternalResource {    
    
    public static final Enchantments INSTANCE = new Enchantments();
    
    private Map<Integer, String> cache;
    
    private Map<Integer, Enchantment> byId;
    private Map<String, Enchantment> byName;
    
    private Field accepting;
    
    
    protected Enchantments() {
        try {
            Field idField = Enchantment.class.getDeclaredField("byId");
            Field nameField = Enchantment.class.getDeclaredField("byName");
            accepting = Enchantment.class.getDeclaredField("acceptingNew");
            
            idField.setAccessible(true);
            nameField.setAccessible(true);
            accepting.setAccessible(true);
            
            byId = (Map<Integer, Enchantment>) idField.get(null);
            byName = (Map<String, Enchantment>) nameField.get(null);
            
            cache = new HashMap<>();
            for (Field field : Enchantment.class.getFields()) {
                cache.put(((Enchantment) field.get(null)).getId(), field.getName());
            }
            
        } catch (ReflectiveOperationException e) {
            throw new UncheckedReflectiveException(e);
        }
    }
    
    
    @Override
    protected void before() {
        byId.clear();
        byName.clear();

        cache.forEach((id, name) -> {
            @PartialStub Enchantment enchantment = new StubEnchantment(id, name);
            byId.put(id, enchantment);
            byName.put(name, enchantment);
        });
    }

    
    public void register(Enchantment enchantment) {
        byId.put(enchantment.getId(), enchantment);
        byName.put(enchantment.getName(), enchantment);
    }
    
    public void unregister(Enchantment enchantment) {
        byId.remove(enchantment.getId());
        byName.remove(enchantment.getName());
    }

    
    public Map<Integer, Enchantment> getById() {
        return byId;
    }

    public Map<String, Enchantment> getByName() {
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
