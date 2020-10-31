package com.cloud.platform.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
// 用于标记持久化类， Spring Boot 项目加载后会自动根据持久化类建表
@Table(name="tb_traffic_info")
public class TrafficInfo implements Serializable {
    /*
     使用@Id指定主键。指定主键的生成策略，MySQL默认为自增长
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //地点名
    private String locationName;
    //实时人数
    private int peopleNum;
    //当前时间
    private String currentSj;

    public TrafficInfo() {
    }

    public TrafficInfo(int id, String locationName, int peopleNum, String currentSj) {
        this.id = id;
        this.locationName = locationName;
        this.peopleNum = peopleNum;
        this.currentSj = currentSj;
    }

    public String getLocationName() {
        return locationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public String getCurrentSj() {
        return currentSj;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public void setCurrentSj(String currentSj) {
        this.currentSj= currentSj;
    }
}
