import java.util.HashSet;
import java.util.Set;

public class Kruskals {

    public Kruskals(){}

    public static int[][] run(int[][] edge){
        Set<String> hash = new HashSet<>();

        //to find the global optimal
        int[][] global = new int[edge.length][edge.length];

        //when the size is less than the matrix, size -1
        while(hash.size() < edge.length -1){
            int[] xy = min(edge);
            String key = xy[0] + " " + xy[1];

            if(hash.contains(key)){
                continue;
            }
            else{
                hash.add(key);
            }

            //save the smallest
            global[xy[0]][xy[1]] = edge[xy[0]][xy[1]];
            global[xy[1]][xy[0]] = edge[xy[0]][xy[1]];

            edge[xy[0]][xy[1]] = -1;
            edge[xy[1]][xy[0]] = -1;

        }
        return global;
    }

    //find the minimum values every time
    public static int[] min(int[][] edge){
        int[] xy = new int[2];
        int tempNum = Integer.MAX_VALUE;

        for(int i = 0; i < edge.length; i++){
            for(int j = 0; j < edge.length; j++){

                if (tempNum > edge[i][j] && edge[i][j] > -1){
                    tempNum = edge[i][j];

                    xy[0] = i;
                    xy[1] = j;
                }
            }
        }
        return xy;
    }
}
