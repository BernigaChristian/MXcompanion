/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 20/04/2022, mercoledì
 **/
public class Team {
    private String name;
    private int id;

    public Team(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
