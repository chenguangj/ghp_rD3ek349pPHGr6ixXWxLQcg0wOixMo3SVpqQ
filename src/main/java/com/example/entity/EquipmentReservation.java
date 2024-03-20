package com.example.entity;

import javax.persistence.*;

@Table(name = "equipmentreservation")
public class EquipmentReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mouth")
    private Long mouth;

    @Column(name = "day")
    private Long day;

    @Column(name = "initTime")
    private Long initTime;

    @Column(name = "destroyTime")
    private Long destroyTime;

    @Column(name = "capacity")
    private Long capacity;

    public Long getMouth() {
        return mouth;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
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
}
