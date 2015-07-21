/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.bugs.subclass;

import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;
import com.autonomy.aci.client.annotations.IdolProcessorField;

import java.util.LinkedList;
import java.util.List;

@IdolDocument("autn:cluster")
public class NewsResultCluster {
    private String title;
    private String category;
    private float score;
    private final List<String> terms = new LinkedList<>();
    private final List<NewsResultDocument> documents = new LinkedList<>();

    public String getCategory() {
        return category;
    }

    public List<NewsResultDocument> getDocuments() {
        return documents;
    }

    public float getScore() {
        return score;
    }

    public List<String> getTerms() {
        return terms;
    }

    public String getTitle() {
        return title;
    }

    @IdolField("autn:title")
    public NewsResultCluster setTitle(final String value) {
        this.title = value;
        return this;
    }

    public NewsResultCluster setCategory(final String value) {
        this.category = value;
        return this;
    }

    @IdolField("autn:score")
    public NewsResultCluster setScore(final float value) {
        this.score = value;
        return this;
    }

    @IdolField("autn:term")
    public NewsResultCluster addTerm(final String value) {
        this.terms.add(value);
        return this;
    }

    @IdolProcessorField("autn:doc")
    public NewsResultCluster addDocument(final NewsResultDocument value) {
        this.documents.add(value);
        return this;
    }
}

