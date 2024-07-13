package com.itheima._02设计模式Design_Patterns._a创建型模式Creational_Patterns._24建造者设计模式Builder之拓展案例实现;


/**
 * @version v1.0
 * @ClassName: Phone
 * @Description: 手机类
 * @Author: 黑马程序员
 */
public class Phone {

    private String cpu;
    private String screen;
    private String memory;
    private String mainboard;

    //私有构造方法
    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainboard = builder.mainboard;
    }
    // 定义一个静态的方法，用户获取内部类的对象
    public static Builder builder(){
        return new Phone.Builder();
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                '}';
    }
    // TODO：定义一个静态的内部类
    public static final class Builder {
        // 重新定义一遍外部类的成员变量
        private String cpu;
        private String screen;
        private String memory;
        private String mainboard;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setScreen(String screen) {
            this.screen = screen;
            return this;
        }
        public Builder setMemory(String memory) {
            this.memory = memory;
            return this;
        }
        public Builder setMainboard(String mainboard) {
            this.mainboard = mainboard;
            return this;
        }

        //使用构建者创建Phone对象
        public Phone build() {
            return new Phone(this);
        }
    }
}
