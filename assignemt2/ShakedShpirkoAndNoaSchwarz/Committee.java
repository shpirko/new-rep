package ShakedShpirkoAndNoaSchwarz;

public class Committee {
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Committee: ").append(name).append(", Chair: ").append(chair.getName()).append(", Number of Members: ").append(numOfMembers).append(", Members: ");
        if (numOfMembers != 0) {
            for (int i = 0; i < numOfMembers; i++) {
                sb.append(members[i].getName());
                if (i < numOfMembers - 1) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append("null");
            
        }
        return sb.toString();
    }
    
    public void tostring() {
        System.out.println("name: " + name);
        System.out.println("chair: " + chair.getName());
        System.out.println("numOfMembers: " + numOfMembers);
        if (members != null) {
            System.out.println("members: ");
            for (int i = 0; i < numOfMembers; i++) {
                System.out.println(members[i].getName());
            }
        } else {
            System.out.println("members: null");
        }
        System.out.println("--------------------------------------------------"); 
    }
}
