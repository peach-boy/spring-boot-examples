package com.wxt.common;

import java.util.Objects;

/**
 * @Description: TODO
 * @Auther: xiantao.wu
 * @Date: 2020/4/28 22:05
 * @Email:1414924381@qq.com
 */
public class FatherClass implements Cloneable {
    private String name;
    private int age;
    private ChildClass child;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        FatherClass fatherClass = (FatherClass) super.clone();
        fatherClass.child = (ChildClass) this.child.clone();
        return super.clone();
    }

    public static class ChildClass implements Cloneable {
        private String name;
        private int age;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
