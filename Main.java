package YanghuiTrangle;
import java.io.IOException;
import java.util.Scanner;

public class YanghuiTrangle {
    //计算n的阶乘，这里是使用递归来实现阶乘操作的；
    //递归的两个重要特点：1，结束条件(这里是n==1的时候）;2,调用自身,这里是factorial(n - 1);
    static private int factorial(int n){
        return n == 1?1:n*factorial(n - 1);
    }

    //取得杨辉三角中元素的最大宽度，原理：最后一行的中间一个元素就是最大元素，该元素的宽度就是最大的元素宽度
    static private int getElementWidth(int n){
        return String.format("%d",factorial(n)/(factorial(n/2)*factorial(n - n/2))).length();
    }
    static private String repeat(String str,int n){
        String strRes = "";
        for(int i = 0;i < n; i++)
            strRes += str;
        return strRes;
    }

    public static void main(String[] args){
        //输入杨辉三角的高度（行）
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        //计算杨辉三角的宽度，空元素也要算
        int width = 2 * n - 1;

        //计算每个元素的最大宽度,原理：最后一行的中间一个元素就是最大元素，该元素的宽度就是最大的元素宽度
        int elementWidth = getElementWidth(n);

        String strFormat = "%" + elementWidth + "d";
        //使用循环逐行的输出数据
        for(int row=0;row < n;++row)
        {
            //输出每行前边的空格
            System.out.print(" ".repeat((elementWidth) * ((width - (2 * row + 1))/2)));
            int ratio = 1;
            //输出每行的第一个数，固定为1
            System.out.print(String.format(strFormat,ratio));
            //作循环，输出当前行中的所有数据
            for(int i = 0;i < row;++i)
            {
                //计算当前行中第i个元素
                ratio = ratio * (row - i)/(i + 1);
                //输出一个空的元素，注意其宽度为3，即该空元素有3个空格
                System.out.print(" ".repeat(elementWidth));
                //输出新的元素
                System.out.print(String.format(strFormat,ratio));
            }
            //换行
            System.out.println();
        }
    }
}
