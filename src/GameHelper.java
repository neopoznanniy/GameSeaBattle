import java.io.*;
import java.util.*;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 47;
    private int[] grid = new int[gridSize];
    private int comCount = 0;
    //принимаем пользовательский ввод
    public String getUserInput(String promt){
        String inputLine = null;
        System.out.println(promt+" ");
        try{
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if(inputLine.length()==0)return null;
        }catch (IOException e){
            System.out.println("IOException: "+e);
        }
        return inputLine.toLowerCase();
    }
    //Устанавливаем координаты кораблям
    public ArrayList<String> placeShip(int shipSize){
        ArrayList<String> alphaCells = new ArrayList<String>();
        String temp = null;
        int[] coords = new int[shipSize];
        int attemts = 0;
        boolean success = false;
        int location = 0;

        comCount++;
        int incr =1;
        if((comCount%2)==1){
            incr=gridLength;
        }

        while(!success & attemts++<200){
            location = (int)(Math.random()*gridSize);
//            System.out.println("пробуем " + location);
            int x = 0;
            success = true;
            while(success && x<shipSize){
                if(grid[location]==0){
                    coords[x++] = location;
                    location += incr;
                    if(location>=gridSize){
                        success=false;
                    }
                }else{
//                    System.out.println("используется " +location);
                    success = false;
                }
            }
        }

        int x = 0;
        int row =0;
        int column = 0;
//        System.out.println("\n");
        while(x<shipSize){
            grid[coords[x]]=1;
            row = (int)(coords[x]/gridLength);
            column = coords[x]%gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(row+1)));
            x++;
//          System.out.println(" coord"+x+" = "+alphaCells.get(x-1));
        }
        System.out.println("\n");
        return alphaCells;
    }
}
