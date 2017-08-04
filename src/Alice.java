
public class Alice {

    private Puzzle [] puzzlesArray;

    private AVLTree ansTree=new AVLTree();

    public Alice(){
    }

    public Puzzle[] getPuzzlesCopy(){
        Puzzle[] puzzlesCopy = new Puzzle[puzzlesArray.length];
        for(int i = 0; i < puzzlesArray.length; i++){
            puzzlesCopy[i] = new Puzzle(puzzlesArray[i]);
        }
        return puzzlesCopy;
    }
    //returns a random value for a riddle array's cell with index i
    private int randValue(int i,int n){
        return (int)((Math.random()*Math.pow(n,3))+i*(Math.pow(n,3)));
    }
    //returns a random index between i and n-1
    private int randIndex(int i,int n){
        return (int)(Math.random()*(n-i))+i;
    }
    //swaps between two cells i and j in an array of ints
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    //shuffles the array randomly
    private void RandomShuffle(int[] arr){
        for (int i = 0; i < arr.length; i++)
            swap(arr,i,randIndex(i,arr.length));
    }
    //creates an array of puzzles with k puzzles, each puzzle holds two arrays of n random shuffled ints
    public void createPuzzles(int n, int k){
        puzzlesArray=new Puzzle[k];
        int[] privateKey=new int[n];
        int[] riddle=new int[n];
        String indexKey="";
        for (int j=0; j<k; j++) {
            //creates the puzzle still not shuffled
            for (int i = 0; i < n; i++) {
                privateKey[i] = randValue(i, n);
                riddle[i] = randValue(i, n);
            }
            //solves the riddle of the index
            indexKey = PuzzleOps.puzzleSolver(riddle);
            //checks if this index is not already in one of the created puzzles index
            if(!ansTree.search(indexKey)) {
                //insert the index and the sorted secretkey array to the AVL
                ansTree.insert(new NodeData(indexKey,privateKey.clone()));
                //suffles the puzzel's arrays and add them to the puzzles array
                RandomShuffle(privateKey);
                RandomShuffle(riddle);
                puzzlesArray[j] = new Puzzle(privateKey.clone(), riddle.clone());
            }
            else //this index was already created so we make a different puzzle
                j--;
        }
    }
    //returns the secret key of a riddle and the number of comparisons done to find it
    public Pair<String, Integer> findKey(String sIndex){
        Pair keyFound=ansTree.getPrivateKey(sIndex);

        return new Pair(PuzzleOps.puzzleSolver((int[])keyFound.getKey()),(Integer)keyFound.getValue());
    }




}
