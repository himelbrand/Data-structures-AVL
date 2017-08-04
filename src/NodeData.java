/**
 * Created by omri on 5/4/16.
 */
public class NodeData implements Comparable{
    private String index;
    private int[] privateKey;

    public NodeData(){
        index=null;
        privateKey=null;

    }

    public NodeData(String sIndex,int[] pk){
        index=sIndex;
        privateKey=pk;

    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof NodeData){
            return this.index.compareTo(((NodeData) o).index);
        }else
        throw new RuntimeException("wrong object type");
    }
    public String getIndex(){
        return index;
    }
    public int[] getPrivateKey(){
        return privateKey;
    }

}
