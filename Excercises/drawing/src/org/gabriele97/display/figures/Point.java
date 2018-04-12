package org.gabriele97.display.figures;

import org.gabriele97.display.Display;
import org.gabriele97.display.Drawable;
import org.gabriele97.display.Position;
import org.gabriele97.display.exceptions.PositionOutOfBoundsException;

public class Point implements Drawable {
    private char characterToDraw;

    public Point(char characterToDraw) {

        if (characterToDraw == Display.BACKGROUND_CHAR) {
            throw new IllegalArgumentException();
        }

        this.characterToDraw = characterToDraw;
    }

    @Override
    public void drawMe(Display d, Position startPosition) throws PositionOutOfBoundsException {
        d.drawPoint(characterToDraw, startPosition);
    }
}