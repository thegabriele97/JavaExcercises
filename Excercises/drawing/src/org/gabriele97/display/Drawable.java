package org.gabriele97.display;

import org.gabriele97.display.exceptions.PositionOutOfBoundsException;

public interface Drawable {

    /**
     * Method used to draw this figure in a Display starting from indicated position
     * 
     * @param d - Display where this figure will be drew
     * @param startPosition - This figure will be drew starting from startPosition
     * 
     * @throws PositionOutOfBoundsException if startPosition is out of bounds in Display d
     */
    void drawMe(Display d, Position startPosition) throws PositionOutOfBoundsException;
}