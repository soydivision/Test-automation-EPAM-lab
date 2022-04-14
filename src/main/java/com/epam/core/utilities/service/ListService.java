package com.epam.core.utilities.service;

import java.util.List;

public final class ListService {

    private ListService() {
    }

    public static boolean isListDoubleInDescendingOrder(final List<Double> elements, double maxValue) {
        for (double element : elements) {
            if (element <= maxValue) {
                maxValue = element;
            } else {
                return false;
            }
        }
        return true;
    }
}
