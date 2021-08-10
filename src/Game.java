import java.util.*;

public class Game {
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
            System.out.println("Пока они не разрушили вашу базу.");
            System.out.println("В качестве ходов нужно использовать сочетания букв \"abcdefg\" и цифр от 0 до 6");

            //Используя вспомогательный класс, задаем размещение кораблям
            for(Ship shipToSet : shipsList){
                ArrayList<String> newLocation = helper.placeShip(3);
                shipToSet.setLocationCells(newLocation);
            }
        }
        private void startPlaying(){
            //Принимаем ход от пользователя, пока все корабли не будут потоплены
            while(!shipsList.isEmpty()){
                String userGuess = helper.getUserInput("Сделайте ход");
                checkUserGuess(userGuess);
            }
            finishGame();
        }
        private void checkUserGuess(String userGuess){
            //Опрашиваем каждый корабль на наличие попадания.
            numOfGuess++;
            String result = "Мимо";
            for(Ship shipTest: shipsList){
                result = shipTest.checkYourSelf(userGuess);
                if(result.equals("Попал")) {
                    break;
                }
                if(result.equals("Потопил")){
                    shipsList.remove(shipTest);
                    break;
                }
            }
            System.out.println(result);
        }
        private void finishGame(){
            System.out.println("УРА!!! Все корабли потоплены.");
            if(numOfGuess<=24){
                System.out.println("Это заняло у Вас всего "+numOfGuess+" попыток.");
                System.out.println("Вы успели затопить корабли, до того как они разрушили вашу базу.");
            }else{
                System.out.println("Однако, это заняло у вас довольно много времени. "+numOfGuess+" попыток.");
                System.out.println("Ваша база лежит в руинах. :'(");
            }
        }
        public static void main(String[] args){
            Game game = new Game();
            game.setUpGame();
            game.startPlaying();
        }
}
