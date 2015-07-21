/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.bugs;

import com.autonomy.aci.client.annotations.IdolBuilder;
import com.autonomy.aci.client.annotations.IdolBuilderBuild;
import com.autonomy.aci.client.annotations.IdolDocument;
import com.autonomy.aci.client.annotations.IdolField;

@IdolDocument("responsedata")
public class FullLogFile {

    private final String name;
    private final String logFileName;
    private final long startOffset;
    private final long endOffset;
    private final long dataSize;
    private final long fileSize;
    private final String searchHitCsv;
    private final String regularExpression;
    private final String data;

    private FullLogFile(final String name,
                        final String logFileName,
                        final long startOffset,
                        final long endOffset,
                        final long dataSize,
                        final long fileSize,
                        final String searchHitCsv,
                        final String regularExpression,
                        final String data
    ) {
        this.name = name;
        this.logFileName = logFileName;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.dataSize = dataSize;
        this.fileSize = fileSize;
        this.searchHitCsv = searchHitCsv;
        this.regularExpression = regularExpression;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public long getDataSize() {
        return dataSize;
    }

    public long getEndOffset() {
        return endOffset;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public String getName() {
        return name;
    }

    public String getRegularExpression() {
        return regularExpression;
    }

    public String getSearchHitCsv() {
        return searchHitCsv;
    }

    public long getStartOffset() {
        return startOffset;
    }

    @IdolBuilder
    @IdolDocument("responsedata")
    public static class Builder {
        private String name;
        private String logFileName;
        private long startOffset;
        private long endOffset;
        private long dataSize;
        private long fileSize;
        private String searchHitCsv;
        private String regularExpression;
        private String data;

        @IdolField("data")
        public void setData(final String data) {
            this.data = data;
        }

        @IdolField("dataSize")
        public void setDataSize(final long dataSize) {
            this.dataSize = dataSize;
        }

        @IdolField("endOffset")
        public void setEndOffset(final long endOffset) {
            this.endOffset = endOffset;
        }

        @IdolField("fileSize")
        public void setFileSize(final long fileSize) {
            this.fileSize = fileSize;
        }


        @IdolField("logFileName")
        public void setLogFileName(final String logFileName) {
            this.logFileName = logFileName;
        }

        @IdolField("name")
        public void setName(final String name) {
            this.name = name;
        }

        @IdolField("regularExpression")
        public void setRegularExpression(final String regularExpression) {
            this.regularExpression = regularExpression;
        }

        @IdolField("searchHitCSV")
        public void setSearchHitCsv(final String searchHitCsv) {
            this.searchHitCsv = searchHitCsv;
        }

        @IdolField("startOffset")
        public void setStartOffset(final long startOffset) {
            this.startOffset = startOffset;
        }

        @IdolBuilderBuild
        public FullLogFile build() {
            return new FullLogFile(
                    name,
                    logFileName,
                    startOffset,
                    endOffset,
                    dataSize,
                    fileSize,
                    searchHitCsv,
                    regularExpression,
                    data
            );
        }
    }
}
