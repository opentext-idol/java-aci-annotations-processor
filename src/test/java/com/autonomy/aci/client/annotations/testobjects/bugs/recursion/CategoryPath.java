/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.autonomy.aci.client.annotations.testobjects.bugs.recursion;

import com.autonomy.aci.client.annotations.IdolDocument;

import java.util.LinkedList;
import java.util.List;

@IdolDocument("autn:category")
public class CategoryPath extends CategoryName {

    public List<CategoryName> getActualPath() {
        final List<CategoryName> result = new LinkedList<>();
        CategoryName temp = getChild();

        while (temp != null) {
            result.add(temp);
            temp = temp.getChild();
        }

        result.add(this);
        return result;
    }

}