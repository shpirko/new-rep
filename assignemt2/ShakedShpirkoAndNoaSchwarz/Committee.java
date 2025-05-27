package ShakedShpirkoAndNoaSchwarz;

public class Committee implements Cloneable{
    private String name; 
    private Lecturer[] members; // Array of Lecturer objects
    private int numOfMembers; // Number of members in the committee
    private Lecturer chair; // Chair of the committee

    public Committee(String name, Lecturer chair) {
        this.name = name;
        this.chair = chair;
    }

    public String getName() {
        return name;
    }

    public Lecturer getChairman() {
        return chair;
    }

    public int getNumOfMembers() {
        return numOfMembers;
    }

    public Lecturer[] getMembers() {
        return members;
    }

    public void setChair(Lecturer chair) {
        this.chair = chair;
    }

    public void setNumOfMembers(int numOfMembers) {
        this.numOfMembers = numOfMembers;
    }

    public void setMembers(Lecturer[] members) {
        this.members = members;
    }

     public void setName(String name) {
        this.name = name;
    }

    public Lecturer getChair() {
        return chair;
    }

    public String getCommitteeMembersNames() {
        String names = "";
        for (int i = 0; i < numOfMembers; i++) {
            names += members[i].getName();
            if (i < numOfMembers - 1) {
                names += ", ";
            }
        }
        return names;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Committee committee = (Committee) obj;
        return name.equals(committee.name);
    }

    @Override
    protected Committee clone() throws CloneNotSupportedException{
        Committee cloned = (Committee) super.clone();
        cloned.chair = (Lecturer) chair.clone();
        if (members != null) {
            cloned.members = new Lecturer[members.length];
            for (int i = 0; i < members.length; i++) {
                cloned.members[i] = (Lecturer) members[i].clone();
            }
        }
        return cloned;
    }

    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("name: ").append(name).append("\n");
    sb.append("chair: ").append(chair != null ? chair.getName() : "null").append("\n");
    sb.append("numOfMembers: ").append(numOfMembers).append("\n");
    sb.append("members: ");
    if (members != null && numOfMembers > 0) {
        for (int i = 0; i < numOfMembers; i++) {
            sb.append(members[i].getName());
            if (i < numOfMembers - 1) {
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
    
   
}
