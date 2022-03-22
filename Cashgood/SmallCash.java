package Cashgood;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallCash {
    //化繁为简
    //1,完成功能为显示菜单并且可以保存输入
    //菜单最好用do  while 因为菜单必须显示一次
    public static void main(String[] args) {
        //定义变量

        boolean loop = true;//是否还要循环显示,默认为true
        Scanner scanner = new Scanner(System.in);//创建Scanner对象接受输入
        String key="";//创建字符串接受选择

        //完成零钱通明细 用字符串拼接形式 以后每次将记录拼接到文末
        String details = "================零钱通明细===============";

        //3.完成收入入账
        double money = 0;
        double balance = 0;
        Date date = null;//调用util包  data是Data类型 表示类型
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//格式化输出日期

        //4.完成消费功能
        //定义消费需要的变量
        String note;
        do{
            System.out.println("\n================零钱通菜单===============");
            System.out.println("\t\t\t1. 零钱通明细");
            System.out.println("\t\t\t2. 收益入账");
            System.out.println("\t\t\t3. 消费");
            System.out.println("\t\t\t4. 退出系统");

            System.out.print("请选择1-4");
            key=scanner.next();//将scanner.next()接受值传入key保存

            //使用分支控制
            switch(key){
                case "1":
                    System.out.println(details);
                    break;
                case "2" :
                    System.out.println("入账金额:");
                    money = scanner.nextDouble();
                    //这里应该有一个收入金额的校验
                    if(money <= 0){
                        System.out.println("收入金额应为正数");
                        break;
                    }//列出不正确信息,马上打道回府
                    balance += money;//将收入归余额
                    date = new Date();//获取当前时间信息
                    details =details +"\n收入:\t+"+money+"\t"+sdf.format(date)+"\t"+balance;
                    break;
                case "3" :
                    System.out.println("消费金额:");
                    money = scanner.nextDouble();
                    //这里也应该有一个消费金额的校验
                    if(money <= 0 && money >balance){
                        System.out.println("消费金额应为 0--"+money);
                        break;
                    }
                    System.out.println("消费说明:");
                    note = scanner.next();
                    balance -= money;
                    //拼接一条新信息到datails
                    date = new Date();//获取当前时间信息
                    details =details +"\n"+note+":"+"\t-"+money+"\t"+sdf.format(date)+"\t"+balance;
                    break;
                case "4" :
                    //用户输入4时候需要询问用户是否确认退出
                    System.out.println("4. 退出程序");
                    //需要用户再次确认,否则就一直问
                    String choice = "";
                    while (true){
                        System.out.println("确定退出吗");
                        choice = scanner.next();
                        if("y".equals(choice) || "n".equals(choice)){
                            break;
                        }//退出循环后再判断是退出与否
                    }

                    if(choice.equals("y")){
                        loop = false;
                    }
                    //输入4后loop变为false 循环退出
                    break;
                default:
                    System.out.println("输入有误,请重新选择");
            }
        }while(loop);

        System.out.println("========退出了 零钱通项目=============");
    }


}
