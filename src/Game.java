import java.util.*;

public class Game {
        private GameHelper helper = new GameHelper();
        private ArrayList<Ship> shipsList = new ArrayList<Ship>();
        private GameField gameField = new GameField();
        private int numOfGuess = 0;

        private void setUpGame(){
            //создаем корабли и называем их
            Ship one = new Ship("Линкор");
            Ship two = new Ship("Крейсер");
            Ship three = new Ship("Авианосец");
            shipsList.add(one);
            shipsList.add(two);
            shipsList.add(three);

            //Выводим инструкции для пользователя
            System.out.println("Ваша цель потопить три корабля.");
            System.out.println("Попытайтесь потопить их за минимальное количество ходов.");
            System.out.println("Пока они не разрушили вашу базу.");
            System.out.println("В качестве ходов нужно использовать сочетания букв \"A, B, C, D, E, F, G\" " +
                    "и цифр от 1 до 7");

            //Используя вспомогательный класс, задаем размещение кораблям
            for(Ship shipToSet : shipsList){
                ArrayList<String> newLocation = helper.placeShip(3);
                shipToSet.setLocationCells(newLocation);
            }
        }
        //Принимаем ход от пользователя, пока все корабли не будут потоплены
        private void startPlaying(){
            while(!shipsList.isEmpty()){
                String userGuess = helper.getUserInput("Сделайте ход");
                checkUserGuess(userGuess);
            }
            finishGame();
        }
        //Опрашиваем каждый корабль на наличие попадания.
        private void checkUserGuess(String userGuess){
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
            gameField.printGameField(userGuess, result);
        }
        //Выводим результат
        private void finishGame(){
            System.out.println("УРА!!! Все корабли потоплены.");
            if(numOfGuess<=24){
                System.out.println("Это заняло у Вас всего "+numOfGuess+" попыток.");
                System.out.println("Вы успели затопить корабли, до того как они разрушили вашу базу. =D");
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
