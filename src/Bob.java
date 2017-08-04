
public class Bob {

    public Bob(){

    }
    //chooses random puzzle from array and sends it to solvepuzzle
    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){

        return solvePuzzle(puzzles[(int)(Math.random()*puzzles.length)]);
    }
    //uses the puzzleOps class to return solution for puzzle
    public Pair<String, String> solvePuzzle(Puzzle puz){
        return PuzzleOps.solveFullPuzzle(puz);
    }

}
