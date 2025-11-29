package com.mindapp.client.models;

import java.util.ArrayList;
import java.util.List;

import com.mindapp.client.patterns.IPrototype;

public class Node implements Cloneable, IPrototype {
    private Long id;
    private String text;
    private double x;
    private double y;
    
    // Вкладення та категорії
    private String attachmentType = "NONE"; // "IMAGE", "VIDEO", "FILE"
    private String attachmentPath;
    private String category = "NORMAL";
    
    private String borderColor; 
    // ------------------------------
    
    private List<Node> children = new ArrayList<>();

    public Node() {}

    public Node(String text, double x, double y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    @Override
    public Node clone() {
        try {
            Node cloned = (Node) super.clone();
            cloned.setId(null); // Скидаємо ID, бо це новий об'єкт
            
            // Копіювання полів (String і так immutable, тому просто присвоюємо)
            cloned.setText(this.getText());
            cloned.setX(this.getX());
            cloned.setY(this.getY());
            cloned.setAttachmentType(this.getAttachmentType());
            cloned.setAttachmentPath(this.getAttachmentPath());
            cloned.setCategory(this.getCategory());
            cloned.setBorderColor(this.getBorderColor());
            
            // Глибоке копіювання дітей (щоб скопіювати всю гілку)
            List<Node> clonedChildren = new ArrayList<>();
            if (this.getChildren() != null) {
                for (Node child : this.getChildren()) {
                    clonedChildren.add(child.clone()); // Рекурсивний виклик
                }
            }
            cloned.setChildren(clonedChildren);
            
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    // Гетери та Сетери
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    
    public String getAttachmentType() { return attachmentType; }
    public void setAttachmentType(String attachmentType) { this.attachmentType = attachmentType; }
    
    public String getAttachmentPath() { return attachmentPath; }
    public void setAttachmentPath(String attachmentPath) { this.attachmentPath = attachmentPath; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    // --- ГЕТЕРИ ТА СЕТЕРИ ДЛЯ НОВОГО ПОЛЯ ---
    public String getBorderColor() { return borderColor; }
    public void setBorderColor(String borderColor) { this.borderColor = borderColor; }
    // ----------------------------------------
    
    public List<Node> getChildren() { return children; }
    public void setChildren(List<Node> children) { this.children = children; }
}