import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 20/04/2022, mercoledì
 **/
public class ListPane extends JPanel {
    private JList ridersList;
    private JTextArea riderSpecs;
    private ArrayList<Integer> ridersIds;
    private int championshipId;
    private int categoryId;

    public ListPane(int championshipId,int categoryId){
        this.championshipId = championshipId;
        this.categoryId = categoryId;
        setGUI();
    }

    private void setGUI(){
        this.ridersIds = new ArrayList<>();
        ArrayList<String> riders = new ArrayList<>();
        for(Rider r : Main.riders)
            if(r.getChampionshipId() == this.championshipId && r.getCategoryId() == this.categoryId){
                ridersIds.add(r.getId());
                riders.add(r.getName());
            }
        ridersList = new JList(riders.toArray());
        riderSpecs = new JTextArea("\t");

        ridersList.addListSelectionListener(e -> {
            try{
                riderSpecs.setText(Main.getRiderById(ridersIds.get(ridersList.getSelectedIndex())).riderToString());
            }catch (NotFoundException ex){
                System.out.println("ERROR DETECTED IN LISTPANE");
            }
        });

        GridBagLayout  gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gridBagLayout);
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(ridersList,gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(riderSpecs,gbc);
    }

    public int getCategoryId() {
        return categoryId;
    }
}
