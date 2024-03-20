package com.example.entity;

import javax.persistence.*;

@Table(name = "playground")
public class PlayGround {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "money")
    private Long money;

    @Column(name = "mouth")
    private Long mouth;

    @Column(name = "day")
    private Long day;

    @Column(name = "initTime")
    private Long initTime;

    @Column(name = "destroyTime")
    private Long destroyTime;

    @Column(name = "reservation")
    private Long reservation;

    @Column(name = "state")
    private String state;

    @Transient
    private String reservationName;

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getReservation() {
        return reservation;
    }

    public void setReservation(Long reservation) {
        this.reservation = reservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getMouth() {
        return mouth;
    }

    public void setMouth(Long mouth) {
        this.mouth = mouth;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public Long getInitTime() {
        return initTime;
    }

    public void setInitTime(Long initTime) {
        this.initTime = initTime;
    }

    public Long getDestroyTime() {
        return destroyTime;
    }

    public void setDestroyTime(Long destroyTime) {
        this.destroyTime = destroyTime;
    }
}
