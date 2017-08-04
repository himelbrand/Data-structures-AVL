

/**
 * Created by omri on 5/3/16.
 */
public class PuzzleOps {

    //sorts a shuffled riddle
    public static int[] sortPuzzle(int[] arr){
        int[] ans=new int[arr.length];
        int d=(int)Math.pow(arr.length,3);
        for (int i = 0; i <arr.length ; i++)
            ans[arr[i]/d]=arr[i];
        return ans;
    }

    //counts the number of ones in the binary form of num, if even return 0 else return 1
    public static char xorNum(int num){
        int count=0;

        while (num>0){
            if(num % 2==1)
                count++;
            num=num/2;
        }
        return count%2==0?'0':'1';
    }


    //returns the solution of a riddle
    public static String puzzleSolver(int[] puzzle) {
        String ans = "";
        //every number is sent to xorNum and the ans is appended to the solution string
        for (int i = 0; i < puzzle.length; i++) {
            ans += xorNum(puzzle[i]);
        }
        return ans;
    }
    //returns a pair of a puzzle solution, both riddle and privatekey
    public static Pair<String, String> solveFullPuzzle(Puzzle puz){
        String secretKey="";
        String indexKey="";
        int[] sortedPrivateKey=PuzzleOps.sortPuzzle(puz.getPrivateKey());
        int[] sortedRiddle=PuzzleOps.sortPuzzle(puz.getRiddle());
        indexKey = PuzzleOps.puzzleSolver(sortedRiddle);
        secretKey = PuzzleOps.puzzleSolver(sortedPrivateKey);
        return new Pair(indexKey,secretKey);
    }
}
