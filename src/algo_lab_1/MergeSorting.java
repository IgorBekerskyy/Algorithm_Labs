package algo_lab_1;

import java.util.ArrayList;
import java.util.List;

public class MergeSorting {

    protected static void mergeSortingByPassengers(List<Plane> planeList) {
        System.out.println("Merge-sort");

        List<Plane> sortedPlaneList = sorted(planeList);
        
        for (Plane plane : sortedPlaneList) {
            System.out.println(plane.toString());
        }
    }

    private static List<Plane> sorted(List<Plane> list) {
        if (list.size() < 2) {
            return list;
        }
        int mid = list.size() / 2;
        return merged(
                sorted(list.subList(0, mid)),
                sorted(list.subList(mid, list.size())));
    }

    private static List<Plane> merged(List<Plane> left, List<Plane> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        List<Plane> merged = new ArrayList<>();
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).getPassengers() < right.get(rightIndex).getPassengers()) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));
        return merged;
    }
}