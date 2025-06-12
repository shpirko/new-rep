package ShakedShpirkoAndNoaSchwarz;

import java.util.ArrayList;

public class Committee implements Cloneable {
    private String name;
    private Lecturer chair;
    private ArrayList<Lecturer> members;

    public Committee(String name, Lecturer chair) {
        this.name = name;
        this.chair = chair;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecturer getChair() {
        return chair;
    }

    public void setChair(Lecturer chair) {
        this.chair = chair;
    }

    public ArrayList<Lecturer> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Lecturer> members) {
        this.members = members;
    }

    public int getNumOfMembers() {
        return members.size();
    }

    public void addMember(Lecturer lecturer) {
        if (!members.contains(lecturer)) {
            members.add(lecturer);
        }
    }

    public void removeMember(Lecturer lecturer) {
        members.remove(lecturer);
    }

    

    @Override
    public Committee clone() throws CloneNotSupportedException {
        Committee cloned = (Committee) super.clone();
        cloned.members = new ArrayList<>(this.members);
        cloned.chair = this.chair;
        return cloned;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ").append(name).append("\n");
        sb.append("chair: ").append(chair != null ? chair.getName() : "null").append("\n");
        sb.append("numOfMembers: ").append(getNumOfMembers()).append("\n");
        sb.append("members: ");
        if (members != null && !members.isEmpty()) {
            for (int i = 0; i < members.size(); i++) {
                sb.append(members.get(i).getName());
                if (i < members.size() - 1) {
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
        Committee committee = (Committee) obj;
        return name.equals(committee.name) &&
               chair.equals(committee.chair) &&
               members.equals(committee.members);
    }
}
