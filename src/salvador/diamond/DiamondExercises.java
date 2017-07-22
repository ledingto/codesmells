package salvador.diamond;

/*
 Code Smell #1: Duplicate Code (Dispensable)
 Solution: helper method printCharacters(..) and printTriangle(..)

 Code Smell #2: Comments
 Solution: delete the comments and change variable/method names to explain purpose/function
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

        int startingNumOfSpaces = n-1;
        int startingNumAsterisks = 1;
        printTriangle(n, startingNumOfSpaces, startingNumAsterisks, false);
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
        int startingNumOfSpaces = 1;
        int startingNumAsterisks = (n*2)-3;

        printTriangle(n, startingNumOfSpaces, startingNumAsterisks, true);
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
        int numAsterisksAtBase = (n * 2)-1;
        int numAsterisksInRow = 1;
        
        for (int i = 1; i < n; i++, numAsterisksInRow +=2){
            int currPadding = (numAsterisksAtBase - numAsterisksInRow)/2;

            printCharacters(currPadding, " ");
            printCharacters(numAsterisksInRow, "*");
            printCharacters(currPadding, " ");

            System.out.println();
        }

        System.out.println("Salvador");

        numAsterisksInRow -= 2;

        for (int i = 1; i < n; i++, numAsterisksInRow -=2){
            int currPadding = (numAsterisksAtBase - numAsterisksInRow)/2;

            printCharacters(currPadding, " ");
            printCharacters(numAsterisksInRow, "*");
            printCharacters(currPadding, " ");

            System.out.println();
        }
    }


    private static void printCharacters(int numCharacters, String character) {
        for (int j = 0; j < numCharacters; j++) {
            System.out.print(character);
        }
    }

    private static void printTriangle(int n, int numPadding, int start, boolean reverse) {
        for (int i = 1; i <= n; i++){
            printCharacters(numPadding, " ");
            printCharacters(start, "*");
            printCharacters(numPadding, " ");

            System.out.println();
            if (reverse==true) {
                numPadding++;
                start-=2;
            }
            else {
                numPadding--;
                start+=2;
            }
        }
    }
}