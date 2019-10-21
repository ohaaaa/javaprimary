package test1;
import java.util.Scanner;
import java.lang.Math;

public class test01 {

    void menu(){
        System.out.println("          ************上机1测试*************\n");
        System.out.println("          *输入字符q：  退出程序           *\n");
        System.out.println("          *输入字符m：  打开主菜单         *\n");
        System.out.println("          *输入整数01： 求圆的周长和面积   *\n");
        System.out.println("          *输入整数02： 按序输出三个整数   *\n");
        System.out.println("          *输入整数03： 计算运输费用       *\n");
        System.out.println("          *输入整数04： 解一元二次方程     *\n");
        System.out.println("          *输入整数05： 判断不小于4的个数  *\n");
        System.out.println("          **********************************\n");
    }// 输出主菜单

    void cal_area(){
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        double i = 0;
        System.out.print("输入圆的半径：");
        i = scan.nextDouble();
        // 接收半径
        System.out.println("圆周长：" + i*2*Math.PI);
        System.out.println("圆面积：" + i*i*Math.PI);
        //scan.close();
    }//求圆的周长和面积

    void sort(){
        System.out.println("请输入三个整数：");
        Scanner in = new Scanner(System.in);
        int[] b=new int[3];
        for(int i=0;i<b.length;i++){
            b[i]=in.nextInt();
        }//输入
        int temp=0;
        for(int i=0;i<b.length;i++){
            for(int j=i+1;j<b.length;j++){
                if(b[i]>b[j]){
                    temp=b[i];
                    b[i]=b[j];
                    b[j]=temp;
                }
            }
        }//冒泡排序
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
            //System.out.println(b[i]+’ ’); //b[i]自动转换为char型
            //System.out.println(" "+b[i]);  //字符串时不改变b[i]类型
        }//输出
    }//冒泡排序

    void transport_cost(){
        System.out.print("输入运输路程/km：");
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        double s = 0;
        if (scan.hasNextDouble()){
            s = scan.nextDouble();
        }
        while(s<=0){
            System.out.println("输入错误！请重新输入！\n");
            s = scan.nextDouble();
        }
        if (s<250) System.out.println("没有折扣！\n");
        else if(s<500) System.out.println("2%折扣！\n");
        else if(s<1000) System.out.println("5%折扣！\n");
        else if(s<2000) System.out.println("8%折扣！\n");
        else if(s<3000) System.out.println("10%折扣！\n");
        else System.out.println("15%折扣！\n");
    }//多重循环计算运输费用

    void solve(){
        System.out.println("请依次输入一元二次方程三个系数：");
        Scanner in = new Scanner(System.in);
        int[] b=new int[3];
        for(int i=0;i<b.length;i++){
            b[i]=in.nextInt();
        }
        double jge=b[1]^2-4*b[0]*b[2];
        if (jge>0){
            double sol1=(-b[1]+Math.sqrt(jge))/(2*b[0]);
            double sol2=(-b[1]-Math.sqrt(jge))/(2*b[0]);
            System.out.println("此方程有两个实根："+sol1+','+sol2);
        }
        else if(jge==0){
            double sol1=(-b[1]+Math.sqrt(jge))/(2*b[0]);
            System.out.println("此方程有两个相等的实根："+sol1);
        }
        else {
            System.out.println("此方程无实根：");
        }
    }//计算方程的根

    void count_judge(){
        System.out.print("输入一个长整数：");
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        long s = 0;
        if (scan.hasNextInt()){
            s = scan.nextInt();
        }
        else{
            System.out.println("输入错误！请重新输入！\n");
            s = scan.nextInt();
        }
        s = Math.abs(s);
        int i=0;
        for(;s>=4;){
            long temp=s%10;  //挨个取每位上的数
            if(temp>=4){
                ++i;
            }
            s=s/10;
        }
        System.out.println("该数字序列中不小于4的数字个数为： "+ i );
    }//计算长整数中不小于4的数字个数

    public static void main(String args[]){
        System.out.println("hello,world!");

        test01 demo=new test01();  //实例化test01类，并取名为demo
        demo.menu();//不实例化此类，报错，非静态方法无法上下文使用

        while(true){
            Scanner scan = new Scanner(System.in);
            // 从键盘接收问题序号
            char i = 0;
            System.out.print("请输入问题的序号：");
            i = scan.next().charAt(0);
            if (i=='q'){
                break;
            }// 输入字符 q 退出程序
            //scan.close();
            //？为什么用close报错？

            switch(i){
                case 'm':  demo.menu(); break;
                case '1':  demo.cal_area(); break;
                case '2':  demo.sort(); break;
                case '3':  demo.transport_cost(); break;
                case '4':  demo.solve(); break;
                case '5':  demo.count_judge(); break;
                default: System.out.println("输入命令不存在，请重新输入！\n"); break;
            }
        }

    }
}
