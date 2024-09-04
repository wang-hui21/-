package com.IO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class IO_BufferedReader {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            //  读一行数据
            String[] firstLine = reader.readLine().split(" ");

            int M = Integer.parseInt(firstLine[0]);
            int N = Integer.parseInt(firstLine[1]);

            System.out.println("M= "+M+" N= "+N);

            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i=0;i<M;i++){
                String line = reader.readLine();
                String[] parts = line.split(" ");
                int first=Integer.parseInt(parts[0]);
                int second=Integer.parseInt(parts[1]);
                map.putIfAbsent(first, new ArrayList<>());
                map.putIfAbsent(second,new ArrayList<>());
                map.get(first).add(second);
                map.get(second).add(first);

            }
            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                int key = entry.getKey();
                List<Integer> values = entry.getValue();
                System.out.printf("键%d关联的值为",key);
                for(int value:values){
                    System.out.print(value+" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
