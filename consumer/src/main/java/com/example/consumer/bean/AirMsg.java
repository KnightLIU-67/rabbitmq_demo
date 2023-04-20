package com.example.consumer.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class AirMsg implements Serializable {
    private List<Integer> results;
    private String devId;
    private Integer num;

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "AirMsg{" +
                "results=" + results +
                ", devId='" + devId + '\'' +
                ", num=" + num +
                '}';
    }
}
