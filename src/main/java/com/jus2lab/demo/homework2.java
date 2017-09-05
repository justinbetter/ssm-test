package com.jus2lab.demo;

import java.util.Scanner;

public class homework2 {

    public static void main(String[] args) {

        /*   第五题: 分析以下需求，并用代码实现
	有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13... 定义一个方法求出这个数列的前20 项之和。         */

        int fenmu = 1;
        int fenzi = 2;
        double result = 0.0D;
        for (int i = 0; i < 20; i++) {
            System.out.print(fenzi + "/" + fenmu + ",");
            double number = fenzi / fenmu;
            result += number;
            //保存本次分母
            int lastFenmu = fenmu;
            //下一个分母是本次的分子
            fenmu = fenzi;
            //下个分子是本次的分母+分子
            fenzi = lastFenmu + fenzi;
        }
        System.out.println("result: " + String.valueOf(result));






        /*       第四题: 分析以下需求，并用代码实现
	1.键盘录入10个整数存入数组中
	2.定义一个方法将奇数放在数组的左侧,偶数放在数组的右侧
	3.定义一个方法打印原数组和处理后的数组
        */
/*
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.println("输入第"+i+"个整数：");
            int number = scanner.nextInt();
            array[i] = number;
            System.out.println(number + "已输入");

        }
        System.out.println("array size:" + array.length);

        //
        int[] resultArray = new int[10];
        int index_even = 5;
        int index_odd = 0;

        for (int index = 0; index < array.length; index++) {
            int number = array[index];
            if (number % 2 == 0) {//偶数
                resultArray[index_even++] = number;
            } else {
                resultArray[index_odd] = number;
            }
        }
        System.out.println("排序后数组：");
        for (int i : resultArray) {
            System.out.print(i + ",");
        }*/

    }


}
