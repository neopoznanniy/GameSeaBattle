import java.util.*;

public class Game {
    public static void main(String[] args){
        private GameHelper helper = new GameHelper();
        private ArrayList<Ship> shipsList = new ArrayList<Ship>();
        private int numOfGuess = 0;

        private void setUpGame(){
            //создаем корабли и называем их
            Ship one = new Ship();
            one.setName("Линкор");
            Ship two = new Ship();
            two.setName("Крейсер");
            Ship three = new Ship();
            three.setName("Авианосец");
            shipsList.add(one);
            shipsList.add(two);
            shipsList.add(three);

            //Выводим инструкции для пользователя
            System.out.println("Ваша цель потопить три корабля.");
            System.out.println("Попытайтесь потопить их за минимальное количество ходов.");
            System.out.println("А не то они потопят вас.");

            //Используя вспомогательный класс, задаем размещение кораблям
            for(Ship shipToSet : shipsList){
                ArrayList<String> newLocation = helper.placeDotCom(3); //Изменить название метода
                shipToSet.setLocationCells(newLocation);
            }
        }
        private void startPlaying(){
            while(!shipsList.isEmpty()){
                String userGuess = helper.getUserInput("Сделайте ход");
                checkUserGuess(userGuess);
            }
            finishGame();
        }

    }
}
