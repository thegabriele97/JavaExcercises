# Drawing

Design and implement a program that allows you to view geometric figures on a screen composed of a _r_ x c array of characters to display on the standard output (where _r_ is the number of lines and _c_ is the number of columns that will form the screen).

The screen allows you to add figures (using the draw () method) that will be printed on screen only when invoking a specific method (view ()). Multiple screen instances can be defined.

The figures exist independently of the screen on which they will be displayed. When they are to be drawn on a screen, the figures are associated with a starting point on the screen.

The part of the screen where there are no printed figures (background) should be represented with the character '.' (point). Each figure must know how to display itself (ie the points of which it is composed) on the screens to which it is assigned using the method made available to the screen (print \ _point ()). Each figure will be associated with a character (which must be different from '.') Which will be printed in the area of ​​the screen occupied by the figure. The order in which they are drawn is also the one with which they will be printed on screen. For example, in case of overlap the last figure will be printed above the previous ones.
## Step 1

Design a system that implements the previous requirements and implement it in Java. Initially, the project must support the printing of points and rectangles.

For example, given a 10 x 30 screen on which the points are drawn:

- p1 in position (6.24)
- p2 in position (7.7)

and the rectangles:

- r1 of dimensions 3x3 in position (3,8) ed
- r2 of 3x2 dimensions in position (0,0) ed
- r3 of 4x4 dimensions in position (1,1).

## Step 2

Add support for printing Triangles Rectangles and Squares.

## Step 3

Add support for defining groups of figures. A group of figures makes it possible to represent an ordered set of figures and their relative positions (using the add () method).