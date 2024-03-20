package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "teacher_info")
public class TeacherInfo extends Account{

    @Column(name = "mailbox")
    private String mailbox;

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }
}
