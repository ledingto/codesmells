package salvador.diamond;

/*
 Code Smell #1: Duplicate Code (Dispensable)
 Solution: helper method printCharacters(..)
 */


public class DiamondExercises {
    public static void main(String[] args) {
        drawAnIsoscelesTriangle(3);
        System.out.println();

        drawADiamond(5);
        drawADiamondWithYourName(3);
    }

    //    Isosceles Triangle
//    Given a number n, print a centered triangle. Example for n=3:
//              *
//             ***
//            *****
    private static void drawAnIsoscelesTriangle(int n) {

        /*
         *-----------------
         * The General Idea
         * ----------------
         * Draw the triangle top down calculating the length of padding based on the size of the base.
         * Since each new line is only as long as the base, we know that each line consists of n * 2 characters.
         *
         * We know that from top to bottom:
         * - Each new layer of the triangle increases by two asterisks.
         * - The remainder is all padding
         * - The left and right padding are symmetrical
         *
         * Thus:
         * At each layer we draw the left padding, the number of asterisks in a layer, and the right padding
         */

        int numPadding = n-1;
        int start = 1;

        for (int i = 1; i <= n; i++, numPadding--, start+=2){

            //left padding
            printCharacters(numPadding, " ");
            //asterisks in between
            printCharacters(start, "*");
            //right padding
            printCharacters(numPadding, " ");

            System.out.println();
        }

    }

    private static void printCharacters(int numCharacters, String character) {
        for (int j = 0; j < numCharacters; j++) {
            System.out.print(character);
        }
    }



    //    Diamond
//    Given a number n, print a centered diamond. Example for n=3:
//              *
//             ***
//            *****
//             ***
//              *
    private static void drawADiamond(int n) {
        drawAnIsoscelesTriangle(n);

        // reverse what was done in drawnIsoscelesTriangle()
        int numPadding = 1;
        int start = (n*2)-3;

        for (int i = 1; i <= n; i++, numPadding++, start-=2){

            //left padding
            printCharacters(numPadding, " ");
            //asterisks in between
            printCharacters(start, "*");
            //right padding
            printCharacters(numPadding, " ");

            System.out.println();
        }
    }

    //    Diamond with Name
//    Given a number n, print a centered diamond with your name in place of the middle line. Example for n=3:
//
//             *
//            ***
//           Bill
//            ***
//             *
    private static void drawADiamondWithYourName(int n) {
        int numBase = (n * 2)-1; //# of asterisks that the base consist of
        int start = 1;           //# of asterisks the tip of the triangle has

        //We work our way down starting from the top
        //similar to first exercise except we don't draw the base...
        // the base becomes our name
        for (int i = 1; i < n; i++, start+=2){
            int currPadding = (numBase - start)/2;

            //print left padding
            printCharacters(currPadding, " ");

            //print horizontal slice of triangle
            printCharacters(start, "*");

            //print right padding
            printCharacters(currPadding, " ");

            System.out.println();
        }

        //Write our name
        System.out.println("Salvador");

        //Work our way down
        start -= 2;

        for (int i = 1; i < n; i++, start-=2){
            int currPadding = (numBase - start)/2;

            //print left padding
            printCharacters(currPadding, " ");

            //print horizontal slice of triangle
            printCharacters(start, "*");

            //print right padding
            printCharacters(currPadding, " ");

            System.out.println();
        }
    }
}