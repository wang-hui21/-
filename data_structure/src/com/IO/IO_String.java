package com.IO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class IO_String {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String[] read = reader.readLine().split(" ");
            for(int i=0;i<read.length;i++){
                System.out.print(read[i]+" ");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
