import java.util.*;
import java.util.ArrayList;

public class Ship {
    private ArrayList<String> locationCells;

    String checkYourSelf(String stringGuess){

        String result = "Мимо";
        int index = locationCells.indexOf(userInput);

        if(index>=0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result="Потопил";
            }else{
                result="Попал";
            }
        }
        return result;
    }

    public void setLocationCells(ArrayList<String> loc){
        this.locationCells = loc;
    }
}
