package com.solfastory.testapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemModel implements Serializable {
    public List<Integer> getPictList() {
        return pictList;
    }

    public void setPictList(List<Integer> pictList) {
        this.pictList = pictList;
    }

    public   List<Integer> pictList = new ArrayList<>();
}
