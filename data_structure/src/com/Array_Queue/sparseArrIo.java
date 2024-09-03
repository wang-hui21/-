/**
 * 稀疏数组：
 * 1. 二维数组转稀疏数组
 * 2. 稀疏数组转二维数组
 */

package com.Array_Queue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class sparseArrIo {
    public static void main(String[] args) {
        // 创建二维数组
        // 0：没有棋子，1：黑棋，2：白棋
        // 棋盘大小 11*11
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        // 预览棋盘上棋子的位置
        System.out.println("预览原始数组");
        printChessArray(chessArr);

        //二维数组转稀疏数组
        int[][] sparseArr = chessToSpaser(chessArr);
        System.out.println("二维数组转稀疏数组");
        printChessArray(sparseArr);

        // 稀疏数组转二维数组
        // 从文件中读取稀疏数组


        int[][] chessArr2 = sparseToChess(sparseArr);
        System.out.println("稀疏数组转二维矩阵");
        printChessArray(chessArr2);
    }


    /**
     * 系数矩阵转二维数组
     * @param sparseArr
     * @return
     */
    private static int[][] sparseToChess(int[][] sparseArr) {


        // 1. 创建二维数组
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2. 恢复有效数据到二维数组
        for(int i=1; i<sparseArr.length;i++){
            int[] rows=sparseArr[i];
            chessArr[rows[0]][rows[1]]=rows[2];
        }
        return chessArr;
    }

    /**
     * 二维数组转稀疏矩阵
     * @param chessArr
     * @return
     */
    private static int[][] chessToSpaser(int[][] chessArr) {
        // 1. 表里数组得到有效棋子个数
        int sum = 0;
        for (int[] row : chessArr) {
            for (int chess : row) {
                if (chess != 0) {
                    sum++;
                }
            }
        }
        // 2. 创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        // 3. 将二维数据的有效数据存入到稀疏数组中
        int chessRow = chessArr.length;  // 行：棋盘大小
        int chessCol = 0; // 列：棋盘大小
        int cout = 0; //记录当前是第几个非0的数据
        for(int i=0;i<chessArr.length;i++){
            int[] rows = chessArr[i];
            if(chessCol==0){
                chessCol=rows.length;
            }
            for(int j=0;j<rows.length;j++){
                int chess=rows[j];
                if(chess==0){
                    continue;
                }
                cout++;   //第一行是棋盘信息，多以要先自增
                sparseArr[cout][0]=i;
                sparseArr[cout][1]=j;
                sparseArr[cout][2]=chess;
            }
        }
        // 4. 补全第一行的棋盘大小和有效数据
        sparseArr[0][0]=chessRow;
        sparseArr[0][1]=chessCol;
        sparseArr[0][2]=sum;

        // 5.存储稀疏数组
        saveSparse(sparseArr);

        return sparseArr;

    }

    private static void saveSparse(int[][] sparseArr) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("data_structure/src/com/Array_Queue/data"))){
            for(int[] rows : sparseArr){
                for(int row:rows){
                    writer.write(row + " ");
                }
                writer.newLine();  //换行
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 打印数组
     *
     * @param chessArr
     */
    private static void printChessArray(int[][] chessArr) {
        for (int[] row : chessArr) {
            for (int data : row) {
                //左对齐，使用两个空格补齐2位数
                System.out.printf("%-2d\t", data);
            }
            System.out.println("");
        }
    }

}
