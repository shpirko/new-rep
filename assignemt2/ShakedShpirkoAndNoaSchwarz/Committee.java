package ShakedShpirkoAndNoaSchwarz;

public class Committee {
    private String name; 
    private Lecturer[] members; // Array of Lecturer objects
    private int numOfMembers; // Number of members in the committee
    private Lecturer chair; // Chair of the committee

    public Committee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    


}
