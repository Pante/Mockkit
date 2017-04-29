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
package com.karuslabs.mockkit;

import java.lang.reflect.Field;

import org.bukkit.*;


public class Mockkit {
    
    public static final Mockkit INSTANCE = new Mockkit();
    
    
    private Field field;
    
    
    protected Mockkit() {
        try {
            field = Bukkit.class.getDeclaredField("server");
            field.setAccessible(true);
            
        } catch (ReflectiveOperationException e) {
            throw new UncheckedReflectiveException(e);
        }
    }
    
    
    public void setServer(Server server) {
        try {
            field.set(null, server);
            
        } catch (ReflectiveOperationException e) {
            throw new UncheckedReflectiveException(e);
        }
    }
    
}
