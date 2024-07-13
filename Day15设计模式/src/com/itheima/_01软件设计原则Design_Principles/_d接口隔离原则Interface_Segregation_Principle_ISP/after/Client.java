package com.itheima._01软件设计原则Design_Principles._d接口隔离原则Interface_Segregation_Principle_ISP.after;



/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        //创建黑马安全门对象
        HeiMaSafetyDoor door = new HeiMaSafetyDoor();
        //调用功能
        door.antiTheft();
        door.fireproof();
        door.waterproof();

        System.out.println("============");
        //创建传智安全门对象
        ItcastSafetyDoor door1 = new ItcastSafetyDoor();
        //调用功能
        door1.antiTheft();
        door1.fireproof();
    }
}
