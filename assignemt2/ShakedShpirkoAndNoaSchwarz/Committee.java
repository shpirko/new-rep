package ShakedShpirkoAndNoaSchwarz;

public class Committee {
    private String name; 
    private Lecturer[] members; // Array of Lecturer objects
    private int numOfMembers; // Number of members in the committee
    private Lecturer chair; // Chair of the committee

    public Committee(String name, Lecturer chair) {
        this.chair = chair;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getChairName() {
        return chair.getName();
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
