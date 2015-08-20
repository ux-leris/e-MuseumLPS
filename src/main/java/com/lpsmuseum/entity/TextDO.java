/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Luis Eduardo
 */
@Entity
@SuppressWarnings("serial")
public class TextDO extends MuseologicalObjectDO {
    @Column(name="text")
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
