package ShakedShpirkoAndNoaSchwarz;

import java.util.Comparator;

public class CompareByCommitteePapers implements Comparator<Committee> {

    @Override
    public int compare(Committee o1, Committee o2) {
        int totalPapersO1 = 0;
        int totalPapersO2 = 0;
        if(o1.getMembers() != null){
            for (Lecturer member : o1.getMembers()) {
                if (member instanceof Doctor) {
                    totalPapersO1 += ((Doctor) member).getNumOfPapers();
                }
            }
        }
        if(o2.getMembers() != null){
            for (Lecturer member : o2.getMembers()) {
                if (member instanceof Doctor) {
                    totalPapersO2 += ((Doctor) member).getNumOfPapers();
                }
            }
        }
        return Integer.compare(totalPapersO1, totalPapersO2);
    }

}
