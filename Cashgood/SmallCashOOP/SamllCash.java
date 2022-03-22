package Cashgood.SmallCashOOP;


//该类完成零钱通各项功能
//把每一个功能封装成一个方法

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/***
 * 1.主菜单
 * 2.明细
 * 3.入账
 * 4.消费
 * 5.退出
 */
public class SamllCash {

    boolean loop = true;//是否还要循环显示,默认为true
    Scanner scanner = new Scanner(System.in);//创建Scanner对象接受输入
    String key="";//创建字符串接受选择

    String details = "================零钱通明细===============";

    double money = 0;
    double balance = 0;
    Date date = null;//调用util包  data是Data类型 表示类型
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//格式化输出日期

    //4.完成消费功能
    //定义消费需要的变量
    String note;


    //1.显示主菜单
    public void mainMenu(){
        do{
            System.out.println("\n================零钱通菜单===============");
            System.out.println("\t\t\t1. 零钱通明细");
            System.out.println("\t\t\t2. 收益入账");
            System.out.println("\t\t\t3. 消费");
            System.out.println("\t\t\t4. 退出系统");

            System.out.println("请选择1-4");
            key=scanner.next();//将scanner.next()接受值传入key保存

            //使用分支控制
            switch(key){
                case "1":
                    this.detail();
                    break;
                case "2" :
                    this.income();
                    break;
                case "3" :
                    this.pay();
                    break;
                case "4" :
                  this.exit();
                    break;
                default:
                    System.out.println("输入有误,请重新选择");
            }
        }while(loop);
    }

    //2.明细
    public void detail(){
        System.out.println(details);
    }

    //3.入账
    public void income(){
        System.out.println("入账金额:");
        money = scanner.nextDouble();

        if(money <= 0){
            System.out.println("收入金额应为正数");
            return;//退出方法 替代break
        }//列出不正确信息,马上打道回府

        balance += money;//将收入归余额
        date = new Date();//获取当前时间信息
        details =details +"\n收入:\t+"+money+"\t"+sdf.format(date)+"\t"+balance;
    }

    //4.消费
    public void pay(){
        System.out.println("消费金额:");
        money = scanner.nextDouble();

        if(money <= 0 ){
            System.out.println("消费金额应为 0--"+balance);
            return;
        }

        if(money > balance){
            System.out.println("消费金额应为 0--"+balance);
            return;
        }

        System.out.println("消费说明:");
        note = scanner.next();
        balance -= money;
        //拼接一条新信息到datails
        date = new Date();//获取当前时间信息
        details =details +"\n"+note+":"+"\t-"+money+"\t"+sdf.format(date)+"\t"+balance;
    }

    //5.退出
    public void exit(){
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

        }
    }

