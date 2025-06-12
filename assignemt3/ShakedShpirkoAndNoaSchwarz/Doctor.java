package ShakedShpirkoAndNoaSchwarz;

import java.util.ArrayList;

public class Doctor extends Lecturer implements Comparable<Doctor> {
    private ArrayList<String> publishedPapers;

    public Doctor(String name, String id, String degreeName, DegreeLevel degreeLevel, int salary) {
        super(name, id, degreeName, degreeLevel, salary);
        this.publishedPapers = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Published Papers: ");
        if (!publishedPapers.isEmpty()) {
            for (int i = 0; i < publishedPapers.size(); i++) {
                sb.append(publishedPapers.get(i));
                if (i < publishedPapers.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        } else {
            sb.append("null\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Doctor doctor = (Doctor) obj;
        return super.equals(obj) && publishedPapers.equals(doctor.publishedPapers);
    }

    public void addPublishedPaper(String paper) {
        if (paper != null && !paper.isEmpty() && !publishedPapers.contains(paper)) {
            publishedPapers.add(paper);
        }
    }

    @Override
    public int compareTo(Doctor other) {
        return Integer.compare(this.publishedPapers.size(), other.publishedPapers.size());
    }

    public ArrayList<String> getPublishedPapers() {
        return publishedPapers;
    }

    public void setPublishedPapers(ArrayList<String> publishedPapers) {
        this.publishedPapers = publishedPapers;
    }

    public int getNumOfPapers() {
        return publishedPapers.size();
    }
}


