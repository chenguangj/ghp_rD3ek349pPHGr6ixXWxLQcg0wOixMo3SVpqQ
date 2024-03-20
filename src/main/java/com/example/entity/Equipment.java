package com.example.entity;

import javax.persistence.*;

@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "money")
    private Long money;


    @Column(name = "capacity")
    private Long capacity;

    @Column(name = "studentId")
    private String studentId;

    @Column(name = "destroyNum")
    private Long destroyNum;

    public Long getDestroyNum() {
        return destroyNum;
    }

    public void setDestroyNum(Long destroyNum) {
        this.destroyNum = destroyNum;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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


    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }


}
