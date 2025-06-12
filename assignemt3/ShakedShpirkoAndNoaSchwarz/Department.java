package ShakedShpirkoAndNoaSchwarz;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Lecturer> lecturers;

    public Department(String name) {
        this.name = name;
        this.lecturers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(ArrayList<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public int getNumOfLecturers() {
        return lecturers.size();
    }

    public void addLecturer(Lecturer lecturer) {
        if (!lecturers.contains(lecturer)) {
            lecturers.add(lecturer);
        }
    }

    public void removeLecturer(Lecturer lecturer) {
        lecturers.remove(lecturer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append(name).append("\n");
        sb.append("numOfLecturers: ").append(getNumOfLecturers()).append("\n");
        sb.append("lecturers: ");
        if (lecturers != null && !lecturers.isEmpty()) {
            for (int i = 0; i < lecturers.size(); i++) {
                sb.append(lecturers.get(i).getName());
                if (i < lecturers.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        } else {
            sb.append("null\n");
        }
        sb.append("--------------------------------------------------");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Department that = (Department) obj;
        return name.equals(that.name) && lecturers.equals(that.lecturers);
    }
}
