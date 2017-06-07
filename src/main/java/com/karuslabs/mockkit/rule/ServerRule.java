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
import com.karuslabs.mockkit.annotations.Mock;

import org.bukkit.Server;

import org.junit.rules.ExternalResource;

import static org.mockito.Mockito.*;


@Mock
public class ServerRule extends ExternalResource {
    
    private Server server;
    
    
    public ServerRule() {
        server = mock(Server.class);
    }
    
    
    @Override
    protected void before() {
        reset(server);
        Mockkit.INSTANCE.setServer(server);
    }
    
}
