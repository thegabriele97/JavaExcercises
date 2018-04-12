package org.gabriele97.display;

public class Position {
    private int r;
    private int c;

    public Position(int r, int c) {
        this.c = c;
        this.r = r;
    }

    public Position add(Position pos) {
        return new Position(r + pos.r, c + pos.c);
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}