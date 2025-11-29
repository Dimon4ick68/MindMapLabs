package com.mindapp.client.patterns;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import com.mindapp.client.models.MindMap;

// [Abstraction] - Керує процесом експорту, використовуючи Implementor
public abstract class MapExporter {
    protected IExportFormat format; // Посилання на Implementor (Bridge)

    public MapExporter(IExportFormat format) {
        this.format = format;
    }

    // Метод, який використовує формат для створення файлу
    public void export(MindMap map, File file) {
        StringBuilder content = new StringBuilder();
        content.append(format.formatHeader(map));
        content.append(generateBody(map)); // Цей крок залежить від типу експортера
        content.append(format.formatFooter(map));
        
        writeToFile(file, content.toString());
    }

    // Абстрактний метод, який уточнюється в RefinedAbstraction
    protected abstract String generateBody(MindMap map);

    private void writeToFile(File file, String content) {
        try {
            Files.writeString(file.toPath(), content, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}