package com.mindapp.client.patterns;

import com.mindapp.client.models.Node;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

// [Concrete Strategy B]
public class CurvedLineStrategy implements LineStrategy {
    @Override
    public void drawLine(GraphicsContext gc, Node parent, Node child, NodeRenderer renderer) {
        // Координати центрів вузлів
        double startX = parent.getX() + renderer.getWidth(parent) / 2;
        double startY = parent.getY() + renderer.getHeight(parent) / 2;
        
        double endX = child.getX() + renderer.getWidth(child) / 2;
        double endY = child.getY() + renderer.getHeight(child) / 2;

        gc.setStroke(Color.DARKGRAY);
        gc.setLineWidth(2);

        // Малюємо криву Безьє
        gc.beginPath();
        gc.moveTo(startX, startY);
        
        // Контрольні точки для вигину (створюємо ефект "дерева")
        // Вигин залежить від відстані по Y
        double controlY = startY + (endY - startY) / 2;
        
        // curveTo(controlX1, controlY1, controlX2, controlY2, endX, endY)
        gc.bezierCurveTo(startX, controlY, endX, controlY, endX, endY);
        
        gc.stroke();
        gc.closePath();
    }
}