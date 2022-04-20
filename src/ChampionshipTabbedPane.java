import javax.swing.*;
import java.util.ArrayList;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 20/04/2022, mercoledì
 **/
public class ChampionshipTabbedPane extends JTabbedPane {
    private ArrayList<ListPane> categoriesPanes;
    private int championshipId;

    public ChampionshipTabbedPane(int championshipId){
        this.categoriesPanes = new ArrayList<>();
        this.championshipId = championshipId;
    }

    public void addTab(ListPane newPane){
        categoriesPanes.add(newPane);
        try{
            super.addTab(Main.getCategoryById(newPane.getCategoryId()).getName(),newPane);
        }catch (NotFoundException e){
            System.out.println("EXCEPTION DETECTED IN CHAMPIONSHIP TABBEDPANE");
        }
    }
}
