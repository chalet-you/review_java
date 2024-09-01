package com.itheima._07正则表达式的演示;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
    目标：正则的分组

    输入11位手机号，把中间手机4位数字加密，密文如：138****5830
 */
public class _10RegexDemo {
    public static void main(String[] args) {

        System.out.println(process("   18721055830   "));
        System.out.println(process("13517045620 "));

    }


    /**
     * process方法 实现加密的业务逻辑
     *
     * @param phoNum 入参：未加密手机号
     * @return 返回：加密后的手机号字符串
     */
    public static String process(String phoNum) {
        String processPhoNum = null;
        // 手机号不为空 并且为11位
        if (phoNum != null && phoNum.trim().length() == 11) {
            // 判断数据是否满足中国大陆手机号码规范
            String regex = "^(1[3-9]\\d{9}$)";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phoNum.trim());

            if (m.matches()) {//进入这里都是符合手机号规则的
                //使用正则替换 返回加密后数据
                processPhoNum = phoNum.trim().replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
            } else {
                processPhoNum = phoNum; //不符合手机号规则 数据直接原封不动返回
            }
        } else {
            //不符合11位 数据直接原封不动返回
            processPhoNum = phoNum;
        }
        return processPhoNum;
    }
}
