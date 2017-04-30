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

import org.bukkit.inventory.meta.BookMeta;

import static org.mockito.Mockito.*;


public class MockBookMeta {
    
    private MockBookMeta() {}
    
    
    public static @PartialMock BookMeta bookMeta(String name, String title) {
        BookMeta meta = when(mock(BookMeta.class).getAuthor()).thenReturn(name).getMock();
        when(meta.getTitle()).thenReturn(title);
        
        return meta;
    }
    
    
    public static Builder builder() {
        return new Builder(mock(BookMeta.class));
    }
    
    
    protected static class Builder extends MockItemMeta.Builder<BookMeta> {
        
        public Builder(BookMeta meta) {
            super(meta);
        }
        
        
        public Builder author(String name) {
            when(meta.getAuthor()).thenReturn(name);
            return this;
        }
        
        public Builder hasAuthor(boolean has) {
            when(meta.hasAuthor()).thenReturn(has);
            return this;
        }
        
        
        public Builder generation(BookMeta.Generation generation) {
            when(meta.getGeneration()).thenReturn(generation);
            return this;
        }
        
        public Builder hasGeneration(boolean has) {
            when(meta.hasGeneration()).thenReturn(has);
            return this;
        }
        
        
        public Builder page(int i, String data) {
            when(meta.getPage(i)).thenReturn(data);
            return this;
        }
        
        public Builder count(int size) {
            when(meta.getPageCount()).thenReturn(size);
            return this;
        }
        
        public Builder pages(List<String> pages) {
            when(meta.getPages()).thenReturn(pages);
            return this;
        }
        
        public Builder hasPages(boolean has) {
            when(meta.hasPages()).thenReturn(has);
            return this;
        }
        
        
        public Builder title(String title) {
            when(meta.getTitle()).thenReturn(title);
            return this;
        }
        
        public Builder hasTitle(boolean has) {
            when(meta.hasTitle()).thenReturn(has);
            return this;
        }
        
    }
    
}
