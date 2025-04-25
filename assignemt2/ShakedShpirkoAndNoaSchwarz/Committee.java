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

    


}
