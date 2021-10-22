import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CTCIEightQueens {
    public static void main(String[] args) {
        try {
            CTCIEightQueens obj = new CTCIEightQueens();
            obj.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String[] args) {
        //Print out all the combinations of 8 queens

        //CheckIfPossible method
        //Place in all possible positions
        //Save if done
        //Recursively call if possible
        //print out all saved combos
        ArrayList<int[][]> allPossibleQueenArrangements = new ArrayList<int[][]>();
        saveQueenCombos(0,new HashSet<Integer>(),new int[8][8],allPossibleQueenArrangements);
        System.out.println("Number of combos found:" + allPossibleQueenArrangements.size());
        for(int x=0;x<allPossibleQueenArrangements.size();x++){
            int[][] currentArrayToPrint = allPossibleQueenArrangements.get(x);
            for(int y=0;y<8;y++){
                System.out.println(Arrays.toString(currentArrayToPrint[y]));
            }
            System.out.println();
        }
    }
    public void saveQueenCombos(int currentY,HashSet<Integer> usedColumns,int[][] currentBoard,ArrayList<int[][]> holdFinishedCombos){
        for(int x=0;x<8;x++){
            if((!usedColumns.contains(x)) && isPossibleCombo(currentY,x,currentBoard)){
                currentBoard[currentY][x] = 1;
                usedColumns.add(x);
                if(currentY == 7){
                    //System.out.println("Here");
                    int[][] tempArray = new int[8][8];
                    for(int yPos=0;yPos<8;yPos++){
                        for(int xPos=0;xPos<8;xPos++){
                            tempArray[yPos][xPos] = currentBoard[yPos][xPos];
                        }
                    }
                    holdFinishedCombos.add(tempArray);
                }else{
                    saveQueenCombos(currentY+1,usedColumns,currentBoard,holdFinishedCombos);
                }
                currentBoard[currentY][x] = 0;
                usedColumns.remove(x);
            }
        }
    }
    public boolean isPossibleCombo(int y,int x,int[][] currentBoard){
        int tempY = y;
        int tempX = x;
        while(tempY>0 && tempX > 0 ){
            tempX--;
            tempY--;
            if(currentBoard[tempY][tempX] == 1){
                return false;
            }
        }
        tempY = y;
        tempX = x;
        while(tempY>0 && tempX < 7 ){
            tempX++;
            tempY--;
            if(currentBoard[tempY][tempX] == 1){
                return false;
            }
        }
        tempY = y;
        tempX = x;
        while(tempY<7&& tempX > 0 ){
            tempX--;
            tempY++;
            if(currentBoard[tempY][tempX] == 1){
                return false;
            }
        }
        tempY = y;
        tempX = x;
        while(tempY<7 && tempX <7 ){
            tempX++;
            tempY++;
            if(currentBoard[tempY][tempX] == 1){
                return false;
            }
        }
        return true;
    }
}