package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "student_info")
public class StudentInfo extends Account{
    @Column(name = "code")
    private String code;

    @Column(name = "mailbox")
    private String mailbox;

    @Column(name = "playGroundRe")
    private String playGroundRe;

    @Column(name = "equipmentRe")
    private String equipmentRe;

    @Column(name = "legal")
    private Long legal;

    public Long getLegal() {
        return legal;
    }

    public void setLegal(Long legal) {
        this.legal = legal;
    }

    public String getEquipmentRe() {
        return equipmentRe;
    }

    public void setEquipmentRe(String equipmentRe) {
        this.equipmentRe = equipmentRe;
    }

    public String getPlayGroundRe() {
        return playGroundRe;
    }

    public void setPlayGroundRe(String playGroundRe) {
        this.playGroundRe = playGroundRe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }
}
