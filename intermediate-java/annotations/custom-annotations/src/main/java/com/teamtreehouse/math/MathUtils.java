package com.teamtreehouse.math;

import java.awt.geom.Point2D;

import com.teamtreehouse.docgen.Doc;

@Doc(
        desc = "Utility class for commonly used math functions"
)
public class MathUtils {
    private static final Double EPSILON = 0.0001;


    @Doc(
            desc = "Calculates the are of the triangle",
            params = {"Coordinates of the first vertex", "Second vertex", "Third vertex"},
            returnVal = "Calculated are of the triangle"
    )
    public static Double triangleArea(Point2D.Double a, Point2D.Double b, Point2D.Double c) {
        return 0.0;
    }

    /**
     * Calculates distance between two points
     * @param a - point one
     * @param b - point two
     * @return distance
     */
    @Doc(
            desc = "Calculates the distance between the given points",
            params = {"Coordinate of one point", "Coordinate of another point"},
            returnVal = "Distance between two points"
    )
    public static Double distance(Point2D.Double a, Point2D.Double b) {
        return 0.0;
    }

    @Doc(
            desc = "Calculates quadratic root for three numbers",
            params = {"First number", "Second number", "Third number"},
            returnVal = "An array"
    )
    public static Double[] quadraticRoots(int a, int b, int c) {
        return new Double[]{};
    }

    @Doc(
            desc = "Displays the value of epsilon"
    )
    public static void epsilon() {

    }

    private static boolean arePointsClose(Point2D.Double a, Point2D.Double b) {
        return false;
    }
}