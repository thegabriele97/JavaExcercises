package org.gabriele97.display;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.gabriele97.display.exceptions.*;;

public class Display {
    public static final char BACKGROUND_CHAR = '.';

    private char[][] display;
    private int maxRow;
    private int maxColumn;

    private Queue<DrawInfo> drawingQueue;

    public Display(int r, int c) {

        drawingQueue = new LinkedList<>();

        display = new char[r][c];
        maxRow = r;
        maxColumn = c;

        for (char[] row : display) {
            Arrays.fill(row, BACKGROUND_CHAR);
        }
    }

    public void draw(Drawable drawing, Position startPoint) throws PositionOutOfBoundsException {

        if (isPositionOutOfBounds(startPoint)) {
            throw new PositionOutOfBoundsException();
        }

        if (drawing == null) {
            throw new NullPointerException();
        }

        drawingQueue.add(new DrawInfo(drawing, startPoint));
    }

    public void drawPoint(char characterToDraw, Position positionToDraw) throws PositionOutOfBoundsException {

        if (isPositionOutOfBounds(positionToDraw)) {
            throw new PositionOutOfBoundsException();
        }

        display[positionToDraw.getR()][positionToDraw.getC()] = characterToDraw;
    }

    public void display() throws PositionOutOfBoundsException {
        
        //drawing all queued drawings
        while (drawingQueue.size() > 0) {
            DrawInfo drawing = drawingQueue.poll();

            drawing.getDrawing().drawMe(this, drawing.getPos());
        }

        //push display to stdout
        getAndPrintDisplayMatrix();
    }

    protected boolean isPositionOutOfBounds(Position pos) {

        Boolean b1 = pos.getC()>= 0 && pos.getR() >= 0;
        Boolean b2 = pos.getC() < maxColumn && pos.getR() < maxRow;
        
        return (!b1 || !b2);
    }

    protected char[][] getAndPrintDisplayMatrix() {

        for (char[] row : display) {
            for (char ch : row) {
                System.out.print(ch);
            }

            System.out.println();
        }

        return display;
    }

    private class DrawInfo {
        private Drawable drawing;
        private Position pos;

        private DrawInfo(Drawable drawing, Position pos) {
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