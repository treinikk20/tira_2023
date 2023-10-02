package oy.interact.tira.student;

import java.util.Comparator;
import oy.interact.tira.model.Coder;

public class CoderFullNameComparator implements Comparator<Coder> {

    public CoderFullNameComparator() {}

    @Override
    public int compare(Coder c1, Coder c2) {
        return c1.compareTo(c2);
    }
}
