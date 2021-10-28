import java.util.Arrays;

public class GameField {
    private int gridLength = 7;
    private char[][] gameFieldPrint;
    private String[][] gameField;
    private final int[] GRID_X = new int[]{1, 2, 3, 4, 5, 6, 7};
    private final String[] GRID_Y = new String[]{"a", "b", "c", "d", "e", "f", "g"};

    public GameField(){
        char [][] gameFieldPrint = new char[gridLength][gridLength];
        String [][] gameField = new String[gridLength][gridLength];
        for(int i=0; i<gridLength; i++){
            for(int k=0; k<gridLength; k++){
                gameFieldPrint[k][i] = ' ';
                gameField[k][i] = GRID_Y[k] + "" + GRID_X[i];
            }
        }
        this.gameFieldPrint = gameFieldPrint;
        this.gameField = gameField;
    }
    //Выводим игровое поле
    public void printGameField(String guess, String result) {
        checkGuess(guess, result);
        System.out.print("  ");
        System.out.println(Arrays.toString(GRID_X));
        for(int i=0; i<gridLength; i++){
            System.out.print(GRID_Y[i] + " ");
            System.out.println(Arrays.toString(gameFieldPrint[i]));
        }
    }
    //Отображаем на игровом поле ход пользователя
    private void checkGuess(String guess, String result){
        char hit = 'X';
        char miss = '0';

        for(int i=0; i<gridLength; i++){
            for(int k=0; k<gridLength; k++){
                if(gameField[k][i].equals(guess)){
                    if(result.equals("Мимо")){
                        gameFieldPrint[k][i] = miss;
                    }else{
                        gameFieldPrint[k][i] = hit;
                    }
                }
            }
        }
    }
}
