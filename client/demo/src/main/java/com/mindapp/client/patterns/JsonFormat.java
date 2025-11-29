package com.mindapp.client.patterns;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mindapp.client.models.MindMap;
import com.mindapp.client.models.Node;

// [Concrete Implementor B] - Форматування у JSON (спрощено)
public class JsonFormat implements IExportFormat {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String formatHeader(MindMap map) {
        return "{ \"title\": \"" + map.getTitle() + "\", \"nodes\": [\n";
    }

    @Override
    public String formatNode(Node node, int level) {
        try {
            // Створюємо простий JSON об'єкт для вузла
            ObjectNode jsonNode = mapper.createObjectNode();
            jsonNode.put("text", node.getText());
            jsonNode.put("level", level);
            return mapper.writeValueAsString(jsonNode) + ",\n";
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

    @Override
    public String formatFooter(MindMap map) {
        return "] }"; // Закриваємо масив і об'єкт
    }

    @Override
    public String getExtension() {
        return "*.json";
    }
}
