package com.mindapp.client.patterns;

import javafx.scene.paint.Color;

public class LightThemeFactory implements ThemeFactory {
    @Override
    public NodeRenderer createNodeRenderer() {
        return new SimpleRectangleRenderer(); 
    }

    @Override
    public LineStrategy createLineStrategy() {
        return new StraightLineStrategy(); 
    }

    @Override
    public Color getBackgroundColor() {
        return Color.WHITE;
    }
}
