package com.mindapp.client.patterns;

import com.mindapp.client.models.MindMap;
import com.mindapp.client.models.Node;

// [Implementor] - Визначає базові операції форматування
public interface IExportFormat {
    String formatHeader(MindMap map);
    String formatNode(Node node, int level);
    String formatFooter(MindMap map);
    String getExtension(); // наприклад ".txt" або ".json"
}