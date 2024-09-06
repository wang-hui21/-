package com.integer;

public class Integer_sum {
    public static void main(String[] args){
        //  将字符串转换为'int'
        int num1 = Integer.parseInt("123");

        //  将字符串按指定进制转化为int
        int num2 = Integer.parseInt("101",2);

        //  将int转换为String
        String str = Integer.toString(123);

        //  将字符串转换为 Integer 对象，类似 parseInt()，但返回的是 Integer 对象而不是原始类型 int。
        Integer num3 = Integer.valueOf("123");

        //  将int类型转换为Integer对象
        Integer num4 = Integer.valueOf(123);

        //  比较两个int值
        int result = Integer.compare(5,10);  // 输出-1

        //  比较两个 Integer 对象的大小，类似于 compare()，但作用于 Integer 对象
        Integer a = 5;
        Integer b = 10;
        int result2 = a.compareTo(b);  // 输出 -1

        //  判断当前 Integer 对象与另一个对象是否相等
        Integer a1 = 100;
        Integer b1 = 100;
        boolean isEqual = a1.equals(b1);  // 输出 true

        //  int 类型能表示的最大值（2^31 - 1），即 2147483647
        int max = Integer.MAX_VALUE;  // 输出 2147483647

        //  int 类型能表示的最小值（-2^31），即 -2147483648。
        int min = Integer.MIN_VALUE;  // 输出 -2147483648

        //  颠倒整数的二进制位
        int reversed = Integer.reverse(5);  // 5 的二进制为 101，颠倒后为 10100000000000000000000000000000

        // 将指定的二进制位向左旋转指定距离
        int result3 = Integer.rotateLeft(5,2);  // 输出20（10100）

        //  向右旋转指定的位置
        int result4= Integer.rotateRight(5, 2);  // 输出 1073741821

        //  将整数转换为二进制字符串
        String binary = Integer.toBinaryString(5);  // 输出 "101"

        //  将整数转化位16进制字符串
        String hex = Integer.toHexString(255);  // 输出 "ff"

        // 将整数转化为八进制字符串
        String octal = Integer.toOctalString(64);  // 输出 "100"

        //  返回两个整数的和
        int sum = Integer.sum(5,10);

        //  返回Integer的哈希码值
        Integer c=100;
        int hash = c.hashCode();

    }
}
