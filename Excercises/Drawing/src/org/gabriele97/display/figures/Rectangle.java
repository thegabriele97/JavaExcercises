package org.gabriele97.display.figures;

import org.gabriele97.display.Display;
import org.gabriele97.display.Drawable;
import org.gabriele97.display.Position;
import org.gabriele97.display.exceptions.PositionOutOfBoundsException;

public class Rectangle implements Drawable {
    private int length;
    private int width;
    private char characterToDraw;

    public Rectangle(int length, int width, char characterToDraw) {
        this.length = length;
        this.width = width;
        this.characterToDraw = characterToDraw;
    }

    @Override
    public void drawMe(Display d, Position startPosition) throws PositionOutOfBoundsException {
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                d.drawPoint(characterToDraw, startPosition.add(new Position(i, j)));
            }
        }
    }
}