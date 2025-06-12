package ShakedShpirkoAndNoaSchwarz;

import java.util.Comparator;

public class CompareByCommitteeMembers implements Comparator<Committee>{

    @Override
    public int compare(Committee o1, Committee o2) {
        return Integer.compare(o1.getNumOfMembers(), o2.getNumOfMembers());
    }

}
