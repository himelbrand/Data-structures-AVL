
public class Eve {
	


    public Eve(){}
    //goes over the puzzles array until bob's puzzle is found and then solved by using the puzzleOps class
    public Pair<String, Integer> findKey(String index, Puzzle[] puzzles){
        String secretKey="";
        String indexKey;
        int compCount=0;
        int[] sortedRiddle;
        int[] sortedPrivateKey;

        for (int i = 0; i < puzzles.length; i++) {
            sortedRiddle=PuzzleOps.sortPuzzle(puzzles[i].getRiddle());
            indexKey = PuzzleOps.puzzleSolver(sortedRiddle);
            compCount++;
            if (indexKey.equals(index)) {
                sortedPrivateKey = PuzzleOps.sortPuzzle(puzzles[i].getPrivateKey());
                secretKey = PuzzleOps.puzzleSolver(sortedPrivateKey);
                break;
            }
        }
        return new Pair(secretKey,compCount);
    }
    //solves puzzle using the puzzleOps class
    public Pair<String, String> solvePuzzle(Puzzle puz){
        return PuzzleOps.solveFullPuzzle(puz);
    }

}
