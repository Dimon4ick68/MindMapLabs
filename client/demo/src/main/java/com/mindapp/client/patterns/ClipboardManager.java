package com.mindapp.client.patterns;

public class ClipboardManager {
    // Зберігаємо скопійований об'єкт
    private static IPrototype buffer = null;

    // Метод копіювання (зберігає клон, щоб відв'язатися від оригіналу)
    public static void copy(IPrototype item) {
        if (item != null) {
            buffer = item.clone();
            System.out.println("Copied to clipboard: " + item);
        }
    }

    // Метод вставки (повертає новий клон з буфера)
    public static IPrototype paste() {
        if (buffer != null) {
            return buffer.clone();
        }
        return null;
    }

    // Перевірка, чи є щось у буфері (для активації кнопки "Вставити")
    public static boolean hasContent() {
        return buffer != null;
    }
}
