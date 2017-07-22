package salvador.diamond;

/*
 Code Smell #1: Duplicate Code (Dispensable)
 Solution: helper method printCharacters(..)

 Code Smell #2: Comments (Dispensable)
 Solution: delete the comments and change variable/method names to explain purpose/function

 Code Smell #3: Long Method (Bloater)
 Solution: extract logic (loops, conditionals, etc.) into helper method [drawBottomPartDiamond(..)]

 Code Smell #4: (Bloater)
 Solution:

 Code Smell #5: Private vs Public (OO Abuser..?)
 Solution: Keep helper methods as private, but change access modifier to public for drawing-methods that may
 be used by other classes (hypothetically)
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
    public static void drawAnIsoscelesTriangle(int n) {
        int startingNumOfSpaces = n-1;
        int startingNumAsterisks = 1;

        for (int i = 1; i <= n; i++, startingNumOfSpaces--, startingNumAsterisks+=2){
            printCharacters(startingNumOfSpaces, " ");
            printCharacters(startingNumAsterisks, "*");
            printCharacters(startingNumOfSpaces, " ");
            System.out.println();
        }
    }


    //    Diamond
//    Given a number n, print a centered diamond. Example for n=3:
//              *
//             ***
//            *****
//             ***
//              *
    public static void drawADiamond(int n) {
        drawAnIsoscelesTriangle(n);
        drawBottomPartDiamond(n);
    }


    //    Diamond with Name
//    Given a number n, print a centered diamond with your name in place of the middle line. Example for n=3:
//             *
//            ***
//           Bill
//            ***
//             *
    public static void drawADiamondWithYourName(int n) {
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

        drawBottomPartDiamond(n);
    }


    private static void printCharacters(int numCharacters, String character) {
        for (int j = 0; j < numCharacters; j++) {
            System.out.print(character);
        }
    }

    private static void drawBottomPartDiamond(int n) {
        int startingNumOfSpaces = 1;
        int startingNumAsterisks = (n*2)-3;
        for (int i = 1; i <= n; i++, startingNumOfSpaces++, startingNumAsterisks-=2){
            printCharacters(startingNumOfSpaces, " ");
            printCharacters(startingNumAsterisks, "*");
            printCharacters(startingNumOfSpaces, " ");
            System.out.println();
        }
    }
}