package goodness.exercise8;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// Exercise #8: Create a new version of Exercise #7 where you also record all of the user’s guesses and print them out
// once they guess correctly. Use an ArrayList to store the guesses. Catch the NumberFormatException and handle the case
// where the user entered a String that is not parseable.

/*
 Code Smell #1: Data Class -- Dialogue (Dispensable)
 Solution: Encapsulate fields. Don't want to migrate functionality (while loop) to Dialogue class because of
 coupling with UserInput class.
 Code Smell #2: Lazy Class -- Dialogue (Dispensable)
 Solution: Reduce overhead by using print statements in Main and deleting Dialogue. Drawback: reduce
 encapsulation and separation/control of what is said during game.
 Ultimately I choose to keep the Dialogue class because it makes it easy for programmers to find, change,
 protect, and maintain what is said during the game, despite class overhead.
 Code Smell #3: No absurdly long classes or methods, overuse of primitives, long parameter lists,
 or data clumps (Bloater)
 Code Smell #4: (Bloater)
 Code Smell #5: No abuse of switch statements, temporary fields, refused bequests, or inheritance (OO Abuser)
 */

public class Main {

    public static void main(String[] args) {

        int randomNumber = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        Scanner kb = new Scanner(System.in);
        UserInput userInput = new UserInput();
        Dialogue dialogue = new Dialogue();

        dialogue.begin();

        while (true) {
            userInput.setUserInput(kb.nextLine());

            if(userInput.isInvalid()) {
                dialogue.tryAgain();
            }
            else if (userInput.is(randomNumber)) {
                dialogue.success();
                userInput.printHistory();
                break;
            }
            else if (userInput.isGreaterThan(randomNumber)) {
                dialogue.tooHigh();
            }
            else if (userInput.isLessThan(randomNumber)) {
                dialogue.tooLow();
            }
        }
    }
}

class UserInput{
    private int userInput = 0;
    private boolean isInvalid = false;
    ArrayList<Integer> inputHistory = new ArrayList<>();

    public void setUserInput(String userInput) {
        try {
            inputHistory.add(this.userInput);
            this.userInput = Integer.parseInt(userInput);
            isInvalid = false;
        }
        catch (NumberFormatException e){
            isInvalid = true;
        }
    }

    public void printHistory(){
        System.out.print("Previous guesses: ");
        inputHistory.remove(0);
        for (Integer guess: inputHistory) {
            System.out.print(guess + ", ");

        }
    }

    public boolean is(int randomNumber){
    if(userInput == randomNumber)
        return true;
    else
        return false;
    }

    public boolean isGreaterThan(int randomNumber){
        if(userInput > randomNumber)
            return true;
        else
            return false;
    }

    public boolean isLessThan(int randomNumber){
        if(userInput < randomNumber)
            return true;
        else
            return false;
    }

    public boolean isInvalid(){
        if(isInvalid == true)
            return true;
        else return false;
    }
}

class Dialogue{
    private final static String SUCCESS = "Congratulations. You won!";
    private final static String TOO_LOW = "Sorry, this number is too low. Try again";
    private final static String TOO_HIGH = "Sorry, this number is too high. Try again";
    private final static String BEGIN = "Guess a number between 1 and 100";
    private final static String TRY_AGAIN = "It appears you entered an invalid number! \nPlease pick a number 1-100";

    public void begin(){System.out.println(BEGIN);}

    public void success(){System.out.println(SUCCESS);}

    public void tooLow(){System.out.println(TOO_LOW);}

    public void tooHigh(){System.out.println(TOO_HIGH);}

    public void tryAgain(){System.out.println(TRY_AGAIN);}
}