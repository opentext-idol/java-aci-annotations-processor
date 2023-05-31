/*
 * Copyright 2015 Open Text.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Open Text and its affiliates
 * and licensors ("Open Text") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Open Text shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.autonomy.aci.client.annotations.testobjects.bugs.subclass;

import com.autonomy.aci.client.annotations.IdolField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultDocument implements Comparable<ResultDocument> {

    private final List<String> companies = new ArrayList<>();
    private final List<String> people = new ArrayList<>();
    private final List<String> places = new ArrayList<>();
    private String database = "";
    private String language = "";
    private String reference = "";
    private String source = "";
    private String summary = "";
    private String title = "";
    private float score = 0;
    private float weight = 0;
    private long date = 0;

    public List<String> getCompanies() {
        return companies;
    }

    public String getDatabase() {
        return database;
    }

    public long getDate() {
        return date;
    }

    public String getLanguage() {
        return language;
    }

    public List<String> getPeople() {
        return people;
    }

    public List<String> getPlaces() {
        return places;
    }

    public String getReference() {
        return reference;
    }

    public float getScore() {
        return score;
    }

    public String getSource() {
        return source;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }

    public float getWeight() {
        return weight;
    }

    @IdolField("COMPANY")
    public ResultDocument addAgentBoolCompany(final String value) {
        companies.add(value);
        return this;
    }

    @IdolField("PERSON")
    public ResultDocument addAgentBoolPerson(final String value) {
        people.add(value);
        return this;
    }

    @IdolField("PLACE")
    public ResultDocument addAgentBoolPlace(final String value) {
        places.add(value);
        return this;
    }

    @IdolField("autn:database")
    public ResultDocument setDatabase(final String value) {
        this.database = value;
        return this;
    }

    @IdolField("autn:language")
    public ResultDocument setLanguage(final String value) {
        this.language = value;
        return this;
    }

    @IdolField("autn:reference")
    public ResultDocument setReference(final String value) {
        this.reference = value.replaceAll("&", "&amp;");
        return this;
    }

    @IdolField("autn:ref")
    public ResultDocument setRef(final String value) {
        return setReference(value);
    }

    @IdolField("SOURCE")
    public ResultDocument setNewsSource(final String value) {
        this.source = value;
        return this;
    }

    @IdolField("autn:summary")
    public ResultDocument setSummary(final String value) {
        this.summary = value;
        return this;
    }

    @IdolField("autn:title")
    public ResultDocument setTitle(final String value) {
        this.title = value;
        return this;
    }

    @IdolField("autn:score")
    public ResultDocument setScore(final float value) {
        this.score = value;
        return this;
    }

    @IdolField("autn:weight")
    public ResultDocument setWeight(final float value) {
        this.weight = value;
        return this;
    }

    @IdolField("autn:date")
    public ResultDocument setDate(final long value) {
        this.date = value;
        return this;
    }


    public List<String> getTerms() {
        final List<String> bool = getTitleAsTerms();
        bool.addAll(getPlaces());
        bool.addAll(getPeople());
        bool.addAll(getCompanies());
        return bool;
    }

    public List<String> getTitleAsTerms() {
        final List<String> bool = new ArrayList<>();
        bool.addAll(Arrays.asList(getTitle().split("\\s*,\\s*")));
        return bool;
    }

    @Override
    public int compareTo(final ResultDocument o) {
        return (int) (o.weight * 100 - this.weight * 100);
    }

}
