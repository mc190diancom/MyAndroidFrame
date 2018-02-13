package com.miu360.annwalk.model.bean;

import java.io.Serializable;

/**
 * Created by Murphy on 2018/2/1.
 *
 */

public class User implements Serializable {
    private long id;// '用车人id',
    private String mobile;// '登陆手机号码',
    private String name;// '名字',
    private int checked;// 是否需要完善信息
    private int score;
    private int sex;
    private String pop_code;// 我的推荐码
    private String login_token;// 登录token
    private int haspwd;// 登录token
    private String head;// 头像
    private String birth;// 出生日期
    private String email;// 电子邮件
    private String ycer_order_mobile;//本机号码

    public String getYcer_order_mobile() {
        return ycer_order_mobile;
    }

    public void setYcer_order_mobile(String ycer_order_mobile) {
        this.ycer_order_mobile = ycer_order_mobile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPop_code() {
        return pop_code;
    }

    public void setPop_code(String pop_code) {
        this.pop_code = pop_code;
    }

    public String getLogin_token() {
        return login_token;
    }

    public void setLogin_token(String login_token) {
        this.login_token = login_token;
    }

    public int getHaspwd() {
        return haspwd;
    }

    public void setHaspwd(int haspwd) {
        this.haspwd = haspwd;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", mobile=" + mobile + ", name=" + name + ", checked=" + checked + ", score=" + score
                + ", pop_code=" + pop_code + ", login_token=" + login_token + ", haspwd=" + haspwd + "]";
    }

}
