import java.util.*;
import java.util.ArrayList;

public class Ship {
    private ArrayList<String> locationCells;
    private String name;

    public Ship(String name){ this.name = name; }

    public void setLocationCells(ArrayList<String> loc){ this.locationCells = loc; }
    //проверяем ход пользователя на попадание
    public String checkYourSelf(String userInput){
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
        if(index>=0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result="Потопил";
                System.out.println(name+" затоплен!");
            }else{
                result="Попал";
            }
        }
        return result;
    }
}
