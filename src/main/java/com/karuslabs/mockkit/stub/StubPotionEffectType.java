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
package com.karuslabs.mockkit.stub;

import org.bukkit.Color;
import org.bukkit.potion.PotionEffectType;


public class StubPotionEffectType extends PotionEffectType {
    
    public StubPotionEffectType(int id, String name) {
        this(id, name, 0, false, Color.AQUA);
    }
    
    public StubPotionEffectType(int id, String name, double duration, boolean instant, Color color) {
        super(id);
        this.name = name;
        this.duration = duration;
        this.instant = instant;
        this.color = color;
    }
    
    
    private String name;
    private double duration;
    private boolean instant;
    private Color color;
    
    
    @Override
    public double getDurationModifier() {
        return duration;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isInstant() {
        return instant;
    }

    @Override
    public Color getColor() {
        return color;
    }
    
}
