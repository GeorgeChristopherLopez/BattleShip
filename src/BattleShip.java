    import java.lang.reflect.Array;
    import java.util.Scanner;
    import  java.util.ArrayList;

    public class BattleShip {

        public static void main (String [] args) {
            // DECLARE an int variable to hold the number of user guesses, named numOfGuesses
            int numOfGuesses = 0;
            GameHelper helper = new GameHelper();

            //COMPUTE a random number between 0 and 4 that will be the starting location
            // cell position
            int start =(int) Math.floor(Math.random()*(5));

            Ship ship1 = new Ship();
            ArrayList<String> locations = new ArrayList<String>();
            // add start position to location arrayList
            for (int x =0; x < 3; x++){

                String loc = Integer.toString(start + x);
                locations.add(loc);
            }
            ship1.setLocationCells(locations);
            System.out.println(locations);
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
            private ArrayList<String> locationCells;

            public void setLocationCells(ArrayList<String> loc){
                locationCells = loc;
            }


            String checkYourself(String stringGuess){
                String result = "miss";
                int index =locationCells.indexOf(stringGuess);
                if(index >=0) {
                    locationCells.remove(index);
                    if(locationCells.isEmpty()) {
                        result = "kill";
                    } else {
                        result = "hit";
                    }
                }
                System.out.println(result);

                return result;
            }





        }

    }





