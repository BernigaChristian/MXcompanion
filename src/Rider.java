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

    public void setName(String name) {
        this.name = name;
    }

    public int getMotoId() {
        return motoId;
    }

    public void setMotoId(int motoId) {
        this.motoId = motoId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getChampionshipId() {
        return championshipId;
    }

    public void setChampionshipId(int championshipId) {
        this.championshipId = championshipId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String riderToString()    throws NotFoundException{
        return "\tNAME: " + name + "\n\tMOTO: " + Main.getBrandById(motoId).getName() + "\n\tTEAM: " + Main.getTeamById(teamId).getName();
    }
}
