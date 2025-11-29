package com.mindapp.client.patterns;

import com.mindapp.client.models.MindMap;
import com.mindapp.client.models.Node;

// [Refined Abstraction] - Реалізує логіку обходу всієї карти
public class FullMapExporter extends MapExporter {

    public FullMapExporter(IExportFormat format) {
        super(format);
    }

    @Override
    protected String generateBody(MindMap map) {
        if (map.getRootNode() == null) return "";
        StringBuilder sb = new StringBuilder();
        processNode(map.getRootNode(), 0, sb);
        return sb.toString();
    }

    private void processNode(Node node, int level, StringBuilder sb) {
        // Використовуємо Implementor для форматування конкретного вузла
        sb.append(format.formatNode(node, level));
        
        for (Node child : node.getChildren()) {
            processNode(child, level + 1, sb);
        }
    }
}
