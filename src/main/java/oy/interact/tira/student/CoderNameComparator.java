package oy.interact.tira.student;

import java.util.Comparator;
import oy.interact.tira.model.Coder;

public class CoderNameComparator implements Comparator<Coder> {

    public CoderNameComparator() {}

    @Override
    public int compare(Coder c1, Coder c2) {
        return c1.getCoderName().compareTo(c2.getCoderName());
    }
}
