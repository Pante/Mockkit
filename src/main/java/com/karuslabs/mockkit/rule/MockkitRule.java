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

import com.karuslabs.mockkit.Mockkit;
import com.karuslabs.mockkit.annotations.PartialMock;
import com.karuslabs.mockkit.stub.StubServer;

import org.junit.rules.ExternalResource;


@PartialMock
public class MockkitRule extends ExternalResource {
    
    public static final MockkitRule INSTANCE = new MockkitRule();
    
    
    protected MockkitRule() {}
    
    
    @Override
    protected void before() {
        Mockkit.INSTANCE.setServer(StubServer.INSTANCE);
        StubServer.INSTANCE.before();
        Enchantments.INSTANCE.before();
        PotionEffectTypes.INSTANCE.before();
    }
    
}
