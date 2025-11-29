package com.mindapp.client.patterns;

import java.util.ArrayList;
import java.util.List;

// [Composite] - Контейнер
public class MapGroup implements MapItem {
    private final String groupName;
    private final List<MapItem> children = new ArrayList<>();

    public MapGroup(String name) {
        this.groupName = name;
    }

    public void add(MapItem item) {
        children.add(item);
    }

    public void remove(MapItem item) {
        children.remove(item);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📁 ГРУПА: " + groupName);
        for (MapItem child : children) {
            child.print(indent + "    ");
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (MapItem child : children) {
            totalSize += child.getSize();
        }
        return totalSize;
    }
}
