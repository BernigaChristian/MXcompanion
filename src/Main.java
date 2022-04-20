import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 20/04/2022, mercoledì
 **/

class NotFoundException extends Exception{
    String type;
    public NotFoundException(String s){
        type = s;
    }
    public String toString(){
        return type + " NOT FOUND!!";
    }
}

public class Main {
    static ArrayList<Rider> riders;
    static ArrayList<Team> teams;
    static ArrayList<MotoBrand> motoBrands;
    static ArrayList<Championship> championships;
    static ArrayList<Category> categories;
    static ArrayList<ChampionshipTabbedPane> championshipTabbedPanes;

    static Rider getRiderById(int id)   throws NotFoundException{
        for(Rider r : riders)
            if(r.getId() == id) return r;
        throw new NotFoundException("RIDER");
    }
    static Team getTeamById(int id)   throws NotFoundException{
        for(Team t : teams)
            if(t.getId() == id) return t;
        throw new NotFoundException("TEAM");
    }
    static MotoBrand getBrandById(int id)   throws NotFoundException{
        for(MotoBrand m : motoBrands)
            if(m.getId() == id) return m;
        throw new NotFoundException("MOTO BRAND");
    }
    static Championship getChampionshipById(int id)   throws NotFoundException{
        for(Championship c : championships)
            if(c.getId() == id) return c;
        throw new NotFoundException("CHAMPIONSHIP");
    }
    static Category getCategoryById(int id)   throws NotFoundException{
        for(Category c : categories)
            if(c.getId() == id) return c;
        throw new NotFoundException("CATEGORY");
    }

    static void setBody(){
        championshipTabbedPanes = new ArrayList<>();
        for (int i = 0; i < championships.size(); i++) {
            championshipTabbedPanes.add(new ChampionshipTabbedPane(championships.get(i).getId()));
            for (int j = 0; j < categories.size(); j++)
                if(categories.get(j).getChampionshipId() == championships.get(i).getId())
                    championshipTabbedPanes.get(i).addTab(new ListPane(championships.get(i).getId(),categories.get(j).getId()));
        }
    }

    public static void main(String[] args) {
        InputHandler reader = new InputHandler("riders.txt","teams.txt","motos.txt","championships.txt","categories.txt");
        //INPUT
        riders = reader.getRiders();
        teams = reader.getTeams();
        motoBrands = reader.getBrands();
        championships = reader.getChampionships();
        categories = reader.getCategories();
        System.out.println("INPUT CORRECTLY RUN");
        //GUI
        JFrame mainFrame = new JFrame("MX COMPANION");
        mainFrame.setSize(500,450);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            //menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("SELECT THE CHAMPIONSHIP");
        ArrayList<JMenuItem> menuItems = new ArrayList<>();
        ActionListener switchMenu = e -> {
            String championship = ((JMenuItem)e.getSource()).getText();
            int index = 0;
            for(int i = 0; i < championships.size(); i++)
                if(championships.get(i).getName().equalsIgnoreCase(championship))   index =i;
            for(int i = 0; i < championshipTabbedPanes.size(); i++){
                if(index == i)  championshipTabbedPanes.get(i).setVisible(true);
                else    championshipTabbedPanes.get(i).setVisible(false);
            }
        };
        for(Championship c : championships)
            menuItems.add(new JMenuItem(c.getName()));
        for(JMenuItem j : menuItems){
            menu.add(j);
            j.addActionListener(switchMenu);
        }
        menuBar.add(menu);
        mainFrame.setJMenuBar(menuBar);
            //body
        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body,BoxLayout.Y_AXIS));
        setBody();
        for(ChampionshipTabbedPane t : championshipTabbedPanes){
            body.add(t);
            t.setVisible(false);
        }
        championshipTabbedPanes.get(1).setVisible(true);
        mainFrame.getContentPane().add(BorderLayout.CENTER,body);
    }
}
