package com.Model;

import java.io.Serializable;

/**
 * @author guanzhiding
 * @date 2020/12/24 11:19
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String passWord;

    public User() {
    }

    public User(String name, String passWord) {
        this.name = name;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
