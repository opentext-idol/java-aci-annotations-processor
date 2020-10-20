/*
 * (c) Copyright 2015 Micro Focus or one of its affiliates.
 *
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License.
 *
 * The only warranties for products and services of Micro Focus and its affiliates
 * and licensors ("Micro Focus") are as may be set forth in the express warranty
 * statements accompanying such products and services. Nothing herein should be
 * construed as constituting an additional warranty. Micro Focus shall not be
 * liable for technical or editorial errors or omissions contained herein. The
 * information contained herein is subject to change without notice.
 */

package com.autonomy.aci.client.annotations;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.LinkedList;

/**
 * Class representing a path to an IDOL field to make operations involving paths easier.
 */
class Path {

    private final LinkedList<String> pathComponents;

    /**
     * The magic token that means "any path ending in".
     */
    private static final String START_TOKEN = "//";

    Path(final String pathString) {
        this.pathComponents = new LinkedList<>();

        final String pathComponentString;

        if (pathString.startsWith(START_TOKEN)) {
            this.pathComponents.addFirst(START_TOKEN);
            pathComponentString = pathString.substring(2);
        } else {
            pathComponentString = pathString;
        }

        if (pathComponentString.contains(START_TOKEN)) {
            throw new IllegalArgumentException("Supplied path string " + pathString + " contains " + START_TOKEN + " at an index other than 0");
        }

        final String[] pathComponents = pathComponentString.split("/");

        for (final String pathComponent : pathComponents) {
            if (!pathComponent.isEmpty()) {
                this.pathComponents.add(pathComponent);
            }
        }
    }

    Path(final Path path) {
        this.pathComponents = new LinkedList<>(path.pathComponents);
    }

    Path append(final String pathComponent) {
        final Path path = new Path(this);

        if (!pathComponent.isEmpty()) {
            path.pathComponents.addLast(pathComponent);
        }

        return path;
    }

    Path removeLastComponent() {
        final Path path = new Path(this);

        if (!path.isEmpty()) {
            path.pathComponents.removeLast();
        }

        return path;
    }

    /**
     * Method for testing if two paths are <i>equivalent</i>, including and wildcards. Can't override equals because
     * then we cannot satisfy the hashCode contract.
     * @param other The path we are comparing against
     * @return True if the paths are equivalent, otherwise false
     */
    boolean isEquivalent(final Path other) {
        if (pathComponents.isEmpty() && other.pathComponents.isEmpty()) {
            return true;
        }

        if (pathComponents.isEmpty() || other.pathComponents.isEmpty()) {
            return false;
        }

        final String thisFirst = this.pathComponents.getFirst();
        final String otherFirst = other.pathComponents.getFirst();

        final int thisStartIndex;
        final int otherStartIndex;

        if ((START_TOKEN.equals(thisFirst) && START_TOKEN.equals(otherFirst))) {
            thisStartIndex = 1;
            otherStartIndex = 1;
        } else if (!START_TOKEN.equals(thisFirst) && !START_TOKEN.equals(otherFirst)) {
            thisStartIndex = 0;
            otherStartIndex = 0;
        } else if (START_TOKEN.equals(thisFirst)) {
            thisStartIndex = 1;
            otherStartIndex = other.pathComponents.indexOf(this.pathComponents.get(1));
        } else {
            thisStartIndex = this.pathComponents.indexOf(other.pathComponents.get(1));
            otherStartIndex = 1;
        }

        return !(thisStartIndex == -1 || otherStartIndex == -1)
                && this.pathComponents.subList(thisStartIndex, this.pathComponents.size()).equals(other.pathComponents.subList(otherStartIndex, other.pathComponents.size()));
    }

    String getFinalFieldName() {
        return pathComponents.getLast();
    }

    boolean isEmpty() {
        return pathComponents.isEmpty();
    }

    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return pathComponents.toString();
    }

}
