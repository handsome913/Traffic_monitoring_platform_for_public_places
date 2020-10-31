package com.cloud.platform.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
// 用于标记持久化类， Spring Boot 项目加载后会自动根据持久化类建表
@Table(name="tb_user")
public class User implements Serializable {
    /*
      使用@Id指定主键。指定主键的生成策略，MySQL默认为自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;// 主键
    private String username;
    private String email;
    private String password;

    public User(){}

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

