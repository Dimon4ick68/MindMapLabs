package com.mindapp.client.patterns;

import com.mindapp.client.models.MindMap;
import com.mindapp.client.models.Node;

// [Concrete Implementor A] - Форматування у простий текст
public class TextFormat implements IExportFormat {
    @Override
    public String formatHeader(MindMap map) {
        return "=== MIND MAP: " + map.getTitle() + " ===\n";
    }

    @Override
    public String formatNode(Node node, int level) {
        // Відступи для ієрархії
        return "\t".repeat(level) + "- " + node.getText() + "\n";
    }

    @Override
    public String formatFooter(MindMap map) {
        return "\n(End of Export)";
    }

    @Override
    public String getExtension() {
        return "*.txt";
    }
}