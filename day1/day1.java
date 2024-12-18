import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.lang.Math;

public class day1 {
    public static void main(String[] args) {
        ArrayList <Integer> list1 = new ArrayList<>();
        ArrayList <Integer> list2 = new ArrayList<>();
        File input;
        Scanner s = null;
        try {
            input = new File("day1/input_1_1.txt");          
            s = new Scanner(input);           

        } catch (Exception FileNotFoundException) {
            System.out.println("File not found");
        }
               
       
        while (s.hasNextLine()){
            String[] line = s.nextLine().split("   ");
            list1.add (Integer.parseInt(line[0]));
            list2.add (Integer.parseInt(line[1]));
        }
        s.close();

        Collections.sort(list1);
        Collections.sort(list2);

        int total = 0;

        for(int i = 0; i < list1.size(); i++){
            total += Math.abs(list1.get(i) - list2.get(i));
        }


        System.out.println("~~~~~~~");       
        System.out.println("The total distance between points in the lists is: ");
        System.out.println(total);
        System.out.println("~~~~~~~");


        // Part 2

        int similar = 0;

        HashSet <Integer> set = new HashSet<>();
        HashMap <Integer, Integer> map = new HashMap<>();

        for(int i : list1){
            set.add(i);
        }

        for(int i: list2){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i : set){
            if (map.containsKey(i)){
                similar = similar + (i * map.get(i));
            }
        }
        
        System.out.println("~~~~~~~");
        System.out.println("Total Similarity is:");
        System.out.println(similar);
        System.out.println("~~~~~~~");


    }
}
