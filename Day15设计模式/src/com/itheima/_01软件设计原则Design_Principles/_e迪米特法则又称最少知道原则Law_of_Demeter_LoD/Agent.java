package com.itheima._01软件设计原则Design_Principles._e迪米特法则又称最少知道原则Law_of_Demeter_LoD;

/**
 * @version v1.0
 * @ClassName: Agent
 * @Description: 经纪人类
 * @Author: 黑马程序员
 */
public class Agent {

    private Star star;
    private Fans fans;
    private Company company;

    public void setStar(Star star) {
        this.star = star;
    }

    public void setFans(Fans fans) {
        this.fans = fans;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    //和粉丝见面的方法
    public void meeting() {
        System.out.println(star.getName() + "和粉丝" + fans.getName() + "见面");
    }

    //和媒体公司洽谈的方法
    public void business() {
        System.out.println(star.getName() + "和" + company.getName() + "洽谈");
    }
}
