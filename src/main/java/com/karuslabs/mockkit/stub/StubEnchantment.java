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

import com.karuslabs.mockkit.annotations.*;

import org.bukkit.enchantments.*;
import org.bukkit.inventory.ItemStack;


@PartialStub
public class StubEnchantment extends Enchantment {
    
    private String name;
    private int maxLevel;
    private int startLevel;
    private EnchantmentTarget target;
    private boolean treasure;
    private boolean cursed;
    
    
    public StubEnchantment(int id, String name) {
        this(id, name, 0, 0, EnchantmentTarget.ALL, false, false);
    }
    
    public StubEnchantment(int id, String name, int maxLevel, int startLevel, EnchantmentTarget target, boolean treasure, boolean cursed) {
        super(id);
        this.name = name;
        this.maxLevel = maxLevel;
        this.startLevel = startLevel;
        this.target = target;
        this.treasure = treasure;
        this.cursed = cursed;
    }
    
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    public int getStartLevel() {
        return startLevel;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return target;
    }

    @Override
    public boolean isTreasure() {
        return treasure;
    }

    @Override
    public boolean isCursed() {
        return cursed;
    }

    @Override
    @Unimplemented
    public boolean conflictsWith(Enchantment other) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    @Unimplemented
    public boolean canEnchantItem(ItemStack item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
