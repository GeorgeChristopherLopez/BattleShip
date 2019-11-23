
    import java.util.Scanner;

    public class BattleShip {

        public static void main (String [] args) {
            // DECLARE an int variable to hold the number of user guesses, named numOfGuesses
            int numOfGuesses = 0;
            GameHelper helper = new GameHelper();

            //COMPUTE a random number between 0 and 4 that will be the starting location
            // cell position
            int start =(int) Math.floor(Math.random()*(5));
            Ship ship1 = new Ship();
            int[] locations = {start,start+1,start+2};
            ship1.setLocationCells(locations);
            boolean isAlive = true;


            //WHILE the dot com is still alive :
            while(isAlive){
                //GET user input from the command line
                String userGuess = helper.getUserInput("enter a number ");
                String result = ship1.checkYourself(userGuess);
                numOfGuesses++;
                if(result == "kill"){
                    isAlive = false;
                    System.out.println("You took "+numOfGuesses+" guesses");
                }
            }
        }

        static class Ship {
            //DECLARE an int array to hold the location cells. Call it locationCells.
            int[] locationCells;

            //  DECLARE an int to hold the number of hits. Call it numOfHits and SET it to 0.
            int numOfHits;

            // DECLARE a checkYourself() method that takes a String for the user’s guess (“1”, “3”, etc.),
            //checks it, and returns a result representing a “hit”, “miss”, or “kill”.
            String checkYourself(String stringGuess){
                //GET the user guess as a String parameter
                //CONVERT the user guess to an int
                int intGuess = Integer.parseInt(stringGuess);
                String result = "miss";

                //REPEAT with each of the location cells in the int array
                //// COMPARE the user guess to the location cell
                //IF the user guess matches
                //INCREMENT the number of hits
                for(int cell: locationCells){
                    if(intGuess == cell){
                        result = "hit";
                        numOfHits++;
                        break;
                    }

                }


                //// FIND OUT if it was the last location cell:
                //IF number of hits is 3, RETURN “kill” as the result
                //ELSE it was not a kill, so RETURN“hit”
                //END IF
                //ELSE the user guess did not match, so RETURN “miss”
                if(numOfHits == locationCells.length){
                    result = "kill";
                }
                //END IF
                //END REPEAT
                //END METHOD
                System.out.println(result);

                return result;
            }

            //DECLARE a setLocationCells() setter method that takes an int array (which has the three cell
            //locations as ints (2,3,4, etc.).
            public void setLocationCells(int[] loc){
                //GET the cell locations as an int array parameter
                //ASSIGN the cell locations parameter to the cell locations instance variable
                //END METHOD
                locationCells = loc;
            }




        }

    }





