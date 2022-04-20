/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 20/04/2022, mercoledì
 **/
public class Rider {
    private static int riders = 0;
    private int id;
    private String name;
    private int motoId;
    private int teamId;
    private int championshipId;
    private int categoryId;

    public Rider(String name, int motoId, int teamId, int championshipId, int categoryId) {
        this.id = ++riders;
        this.name = name;
        this.motoId = motoId;
        this.teamId = teamId;
        this.championshipId = championshipId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getChampionshipId() {
        return championshipId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String riderToString()    throws NotFoundException{
        return "\tNAME: " + name + "\n\tMOTO: " + Main.getBrandById(motoId).getName() + "\n\tTEAM: " + Main.getTeamById(teamId).getName();
    }
}
