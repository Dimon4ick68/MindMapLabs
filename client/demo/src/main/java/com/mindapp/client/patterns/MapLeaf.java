package com.mindapp.client.patterns;

import com.mindapp.client.models.Node;

// [Leaf] - Кінцевий елемент
public class MapLeaf implements MapItem {
    private final String title;
    private final int size;

    // Ми приймаємо Node, але беремо з нього тільки дані
    public MapLeaf(Node node) {
        this.title = node.getText();
        this.size = node.getText().length(); // Наприклад, вага = довжина тексту
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📄 " + title + " (" + size + " байт)");
    }

    @Override
    public int getSize() {
        return size;
    }
}
