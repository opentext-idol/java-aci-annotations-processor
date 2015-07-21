/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.primitive;

import com.autonomy.aci.client.annotations.IdolField;

public class PrimitiveHolder {

    private char myChar;
    private boolean myBoolean;
    private byte myByte;
    private short myShort;
    private int myInt;
    private long myLong;
    private float myFloat;
    private double myDouble;

    private Character myCharObj;
    private Boolean myBooleanObj;
    private Byte myByteObj;
    private Short myShortObj;
    private Integer myIntObj;
    private Long myLongObj;
    private Float myFloatObj;
    private Double myDoubleObj;

    public boolean isMyBoolean() {
        return myBoolean;
    }

    @IdolField("BOOL")
    public void setMyBoolean(final boolean myBoolean) {
        this.myBoolean = myBoolean;
    }

    public Boolean getMyBooleanObj() {
        return myBooleanObj;
    }

    @IdolField("BOOLEAN")
    public void setMyBooleanObj(final Boolean myBooleanObj) {
        this.myBooleanObj = myBooleanObj;
    }

    public byte getMyByte() {
        return myByte;
    }

    @IdolField("BYTE")
    public void setMyByte(final byte myByte) {
        this.myByte = myByte;
    }

    public Byte getMyByteObj() {
        return myByteObj;
    }

    @IdolField("BYTEO")
    public void setMyByteObj(final Byte myByteObj) {
        this.myByteObj = myByteObj;
    }

    public char getMyChar() {
        return myChar;
    }

    @IdolField("CHAR")
    public void setMyChar(final char myChar) {
        this.myChar = myChar;
    }

    public Character getMyCharObj() {
        return myCharObj;
    }

    @IdolField("CHARACTER")
    public void setMyCharObj(final Character myCharObj) {
        this.myCharObj = myCharObj;
    }

    public double getMyDouble() {
        return myDouble;
    }

    @IdolField("DOUBLE")
    public void setMyDouble(final double myDouble) {
        this.myDouble = myDouble;
    }

    public Double getMyDoubleObj() {
        return myDoubleObj;
    }

    @IdolField("DOUBLEO")
    public void setMyDoubleObj(final Double myDoubleObj) {
        this.myDoubleObj = myDoubleObj;
    }

    public float getMyFloat() {
        return myFloat;
    }

    @IdolField("FLOAT")
    public void setMyFloat(final float myFloat) {
        this.myFloat = myFloat;
    }

    public Float getMyFloatObj() {
        return myFloatObj;
    }

    @IdolField("FLOATO")
    public void setMyFloatObj(final Float myFloatObj) {
        this.myFloatObj = myFloatObj;
    }

    public int getMyInt() {
        return myInt;
    }

    @IdolField("INT")
    public void setMyInt(final int myInt) {
        this.myInt = myInt;
    }

    public Integer getMyIntObj() {
        return myIntObj;
    }

    @IdolField("INTEGER")
    public void setMyIntObj(final Integer myIntObj) {
        this.myIntObj = myIntObj;
    }

    public long getMyLong() {
        return myLong;
    }

    @IdolField("LONG")
    public void setMyLong(final long myLong) {
        this.myLong = myLong;
    }

    public Long getMyLongObj() {
        return myLongObj;
    }

    @IdolField("LONGO")
    public void setMyLongObj(final Long myLongObj) {
        this.myLongObj = myLongObj;
    }

    public short getMyShort() {
        return myShort;
    }

    @IdolField("SHORT")
    public void setMyShort(final short myShort) {
        this.myShort = myShort;
    }

    public Short getMyShortObj() {
        return myShortObj;
    }

    @IdolField("SHORTO")
    public void setMyShortObj(final Short myShortObj) {
        this.myShortObj = myShortObj;
    }

}
