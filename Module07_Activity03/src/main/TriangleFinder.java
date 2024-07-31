package main;
/*
 * This is a very basic program to tell what type of triangle you have.
 */

public class TriangleFinder {
    private String side1, side2, side3;

    public String determineTriangleType() throws IFeelException {
        int s1 = -1, s2 = -1, s3 = -1;
        try {
            s1 = Integer.parseInt(side1);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Side 1 is not a number!");
        }
        try {
            s2 = Integer.parseInt(side2);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Side 2 is not a number!");
        }
        try {
            s3 = Integer.parseInt(side3);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Side 3 is not a number!");
        }

        // Check that nothing is negative or zero
        if (s1 <= 0 || s2 <= 0 || s3 <= 0) {
            throw new IllegalArgumentException("At least one length is less than or equal to 0!");
        }

        // Check for side length
        if ((s1 + s2 <= s3) || (s1 + s3 <= s2) || (s2 + s3 <= s1)) {
            throw new IllegalArgumentException("The lengths of the triangles do not form a valid triangle!");
        }

        if (s1 + s2 + s3 > 1000000) {
            throw new IFeelException("I feel your triangle is too big!");
        }

        String type = "";
        if ((s1 == s2) && (s2 == s3)) {
            type = "Equilateral";
        } else if ((s1 == s2) || (s2 == s3) || (s1 == s3)) {
            type = "Isosceles";
        } else {
            type = "Scalene";
        }
        return type;
    }

    public void setSide1(String s) {
        side1 = s;
    }

    public void setSide2(String s) {
        side2 = s;
    }

    public void setSide3(String s) {
        side3 = s;
    }

   
}