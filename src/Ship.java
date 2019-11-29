import  java.util.ArrayList;
public class Ship {
    public String name;
    public ArrayList<String> locationCells;


    public void setLocationCells(ArrayList<String> loc){
        locationCells = loc;
    }
    public void setName(String n){
        name = n;
    }
    String checkYourself(String stringGuess){
        String result = "miss";
        int index =locationCells.indexOf(stringGuess);
        if(index >=0) {
            locationCells.remove(index);
            if(locationCells.isEmpty()) {
                result = "kill";
                System.out.println("Ouch! You sunk " + name + " : ( ");
            } else {
                result = "hit";
            }
        }
        System.out.println(result);

        return result;
    }


}