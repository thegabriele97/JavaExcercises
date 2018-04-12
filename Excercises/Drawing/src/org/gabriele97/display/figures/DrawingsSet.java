package org.gabriele97.display.figures;

import java.util.LinkedList;
import java.util.Queue;

import org.gabriele97.display.Display;
import org.gabriele97.display.Drawable;
import org.gabriele97.display.Position;
import org.gabriele97.display.exceptions.PositionOutOfBoundsException;

public class DrawingsSet implements Drawable {
    private Queue<DrawingInfo> drawingQueue;

    public DrawingsSet() {
        drawingQueue = new LinkedList<>();
    }

    public void add(Drawable drawing, int rowOffset, int columnOffset) {

        if (drawing == null) {
            throw new NullPointerException();
        }

        drawingQueue.add(new DrawingInfo(drawing, new Position(rowOffset, columnOffset)));
    }

    @Override
    public void drawMe(Display d, Position startPosition) throws PositionOutOfBoundsException {
        
        int sizeOfQueue = drawingQueue.size();
        while (sizeOfQueue-- > 0) {
            DrawingInfo drawing = drawingQueue.poll();
            drawing.getDrawing().drawMe(d, startPosition.add(drawing.getPos()));
        }
    }

    private class DrawingInfo {
        private Drawable drawing;
        private Position pos;

        private DrawingInfo(Drawable drawing, Position pos) {
            this.drawing = drawing;
            this.pos = pos;
        }

        private Drawable getDrawing() {
            return drawing;
        }

        private Position getPos() {
            return pos;
        }
    }
}