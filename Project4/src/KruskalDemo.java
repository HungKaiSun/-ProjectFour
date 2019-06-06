import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Hung-Kai Sun
 *
 * This program will do a greedy, Kruskal algorithm to find the global optimal
 */

public class KruskalDemo {
    public static void main(String[] args){

        String line;
        String[] element;
        int row = 0;
        int[][] edge = new int[0][0];

        try{
            //read the input file
            Scanner input = new Scanner(new File("input.txt"));
            while(input.hasNextLine()){
                line = input.nextLine();
                element = line.split("  ");

                if(row == 0){
                    edge = new int[element.length][element.length];
                }
                for(int i = 0; i < element.length; i++){
                    if(element[i].equals("N")){
                        edge[row][i] = -1;
                    }
                    else {
                        edge[row][i] = Integer.parseInt(element[i]);
                    }
                }
                row++;
            }
            input.close();
        }
        catch(FileNotFoundException e){
            System.out.println("file not found");
        }

        Kruskals graph = new Kruskals();

        try{
            //to write the output
            int[][] global = graph.run(edge);
            File outputFile = new File("output.txt");
            PrintWriter output = new PrintWriter(outputFile);
            output.println("Kruskal graph result: ");

            for(int i = 0; i < global.length; i++){
                for(int j = 0; j < global.length; j++){
                    if(global[i][j] == -1){
                        output.print("N");
                    }
                    else {
                        output.print(global[i][j]);
                    }
                    if(j < global.length -1){
                        output.print("\t\t");
                    }
                }
                output.println();
            }
            output.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}
