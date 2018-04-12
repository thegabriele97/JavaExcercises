package org.gabriele97.display.figures;

import org.gabriele97.display.Display;
import org.gabriele97.display.Drawable;
import org.gabriele97.display.Position;
import org.gabriele97.display.exceptions.PositionOutOfBoundsException;

public class Triangle implements Drawable{
    private int heigth;
    private int base;
    private char characterToDraw;

    public Triangle(int heigth, int base, char characterToDraw) {
        this.heigth = heigth;
        this.base = base;
        this.characterToDraw = characterToDraw;
    }

    @Override
    public void drawMe(Display d, Position startPosition) throws PositionOutOfBoundsException {
        
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j <= i; j++) {
                d.drawPoint(characterToDraw, startPosition.add(new Position(i, j)));
            }
        }
    }
}