package com.IO;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class IO_Scanner {
    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("请输入一行文字");
//        String input = reader.readLine();
//        System.out.println("你输入的文字是："+input);
//        reader.close();

        Scanner scanner = new Scanner(System.in);
        //  读取第一行数据
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        System.out.println("M= " + M+"N= "+ N);
        Map<Integer, List<Integer>> map = new HashMap<>();

        //  读取后续的数据对
        for(int i=0;i<M;i++){
            int first = scanner.nextInt();
            int second = scanner.nextInt();

            //  如果键不存在，创建新的键
            map.putIfAbsent(first, new ArrayList());
            map.putIfAbsent(second, new ArrayList<>());

            map.get(first).add(second);
            map.get(second).add(first);
        }
        //  打印存储的数据
        System.out.println("存储的数据：");
        int s=1;
        for (Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            int key = entry.getKey();
            List<Integer> values = entry.getValue();
            System.out.println("键"+key+"关联的值：");
            if(values.contains(s)){
                System.out.printf("键中包含%d\n", s);
            }
            for(int value: values){
                System.out.print(value+" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
