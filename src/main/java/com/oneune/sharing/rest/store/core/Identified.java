package com.oneune.sharing.rest.store.core;

import lombok.NonNull;

import javax.swing.*;
import java.io.Serializable;
import java.util.*;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

@FunctionalInterface
public interface Identified extends Serializable {

   Long getId();

   static <I extends Identified> Optional<I> findById(final List<I> containerForSearching,
                                                      @NonNull Long targetId) {
        return containerForSearching.stream()
                .filter(item -> !Objects.isNull(item.getId()))
                .filter(item -> item.getId().equals(targetId))
                .findFirst();
   }

    private static Comparator<? super Long> getSortingOrder(SortOrder sortOrder) {
        return switch (sortOrder) {
            case ASCENDING, UNSORTED -> naturalOrder();
            case DESCENDING -> reverseOrder();
            default -> throw new RuntimeException("Sorting types have got only two types");
        };
    }

    static <I extends Identified> List<Long> extractIds(final Collection<? extends I> identifiableItems,
                                                        SortOrder sortOrder) {
        return identifiableItems.stream()
                .map(Identified::getId)
                .sorted(getSortingOrder(sortOrder))
                .collect(toList());
    }
}
