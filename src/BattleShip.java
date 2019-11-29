    import java.util.ArrayList;

    public class BattleShip {

        public static void main (String [] args) {
            BattleShipGame game = new BattleShipGame();

            //DECLARE a setUpGame() method to create and initialize the DotCom objects with names
            //and locations. Display brief instructions to the user.
            game.setUpGame();
            //DECLARE a startPlaying() method that asks the player for guesses and calls the
            //checkUserGuess() method until all the DotCom objects are removed from play.
            game.startPlaying();


        }

        static class BattleShipGame{
            // DECLARE and instantiate the GameHelper instance variable, named helper.
             private GameHelper helper = new GameHelper();
            // DECLARE and instantiate an ArrayList to hold the list of DotComs (initially three) Call is dotComsList.
            private ArrayList<Ship> shipList = new ArrayList<Ship>();
            // DECLARE an int variable to hold the number of user guesses (so that we can give the user a
            // score at the end of the game). Name it numOfGuesses and set it to 0.
            private int numOfGuesses = 0;




            // make 3 ships and name them
            private void setUpGame(){
                //CREATE three DotCom objects.
                Ship ship1 = new Ship();
                Ship ship2 = new Ship();
                Ship ship3 = new Ship();
                //SET a name for each DotCom.
                ship1.name = "jenny";
                ship2.name = "jenny2";
                ship3.name = "jenny3";
                //ADD the DotComs to the dotComsList ( the ArrayList).
                shipList.add(ship1);
                shipList.add(ship2);
                shipList.add(ship3);




                //REPEAT with each of the DotCom objects in the dotComsList array
                //CALL the placeDotCom() method on the helper object, to get a randomly-selected
                //location for this DotCom (three cells, vertically or horizontally aligned, on a 7 X 7 grid).
                //SET the location for each DotCom based on the result of the placeDotCom() call.
                for (Ship ship : shipList ){
                  ArrayList<String> newLocation = helper.placeShip(3);
                  ship.setLocationCells(newLocation);
                //END REPEAT
                }
                //END METHOD
            }

            void startPlaying(){


                //DECLARE a checkUserGuess() method that loops through all remaining DotCom objects and
                //calls each DotCom object’s checkYourself() method.

                while(!shipList.isEmpty()){
                    String userGuess = helper.getUserInput("enter a number ");
                    checkUserGuess(userGuess);
                }

                //DECLARE a finishGame() method that prints a message about the user’s performance, based
                //on how many guesses it took to sink all of the DotCom objects.
                finishGame();
            }

            void checkUserGuess(String userGuess){
                String result = "miss";
                numOfGuesses++;
                for(int x = 0; x < shipList.size();x++){
                    result = shipList.get(x).checkYourself(userGuess);
                    if(result == "hit"){
                        break;

                    }
                    if(result == "kill"){
                        shipList.remove(x);
                        break;
                    }

                }

                System.out.println(result);
            }

            void finishGame(){
                System.out.println("All ships are dead! Your are victorious!");
                if(numOfGuesses<=18){
                    System.out.println("It only took you "+numOfGuesses+ " guesses.");
                    System.out.println(" You got out before your options sank.");

                } else {
                    System.out.println("Took you long enough. "+ numOfGuesses + " guesses.");
                    System.out.println("Fish are dancing with you shrapnel");
                }
            }

        }

    }





