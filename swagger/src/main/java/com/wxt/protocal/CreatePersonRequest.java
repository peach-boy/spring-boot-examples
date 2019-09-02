package com.wxt.protocal;

/**
 * @Description: TODO
 * @Auther: ThomasWu
 * @Date: 2019/9/2 21:41
 * @Email:1414924381@qq.com
 */
public class CreatePersonRequest {
    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
