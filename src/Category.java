/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 20/04/2022, mercoledì
 **/
public class Category {
    private String name;
    private int id;
    private int championshipId;

    public Category(String name, int id,int championshipId) {
        this.name = name;
        this.id = id;
        this.championshipId = championshipId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getChampionshipId() {
        return championshipId;
    }

}
