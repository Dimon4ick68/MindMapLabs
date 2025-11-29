package com.mindapp.client.patterns;

// [Component]
public interface MapItem {
    void print(String indent); // Операція: вивести структуру
    int getSize();             // Операція: отримати "вагу" (наприклад, к-сть символів або файлів)
}
