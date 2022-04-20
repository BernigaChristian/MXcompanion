import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 20/04/2022, mercoledì
 **/
public class InputHandler {
    private Scanner rScanner;
    private Scanner tScanner;
    private Scanner mScanner;
    private Scanner cScanner;
    private Scanner catScanner;

    public InputHandler(String rFile,String tFile,String mFile,String cFile,String catFile) {
        try {
            this.rScanner = new Scanner(new File(rFile));
            this.tScanner = new Scanner(new File(tFile));
            this.mScanner = new Scanner(new File(mFile));
            this.cScanner = new Scanner(new File(cFile));
            this.catScanner = new Scanner(new File(catFile));
        }catch (IOException e){System.out.println("input failed");}
    }

    public ArrayList<Rider> getRiders(){
        ArrayList<Rider> riders = new ArrayList<>();
        while(rScanner.hasNextLine()){
            String[] data = rScanner.nextLine().split(";");
            riders.add(new Rider(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4])));
        }
        return riders;
    }

    public ArrayList<Team> getTeams(){
        ArrayList<Team> teams = new ArrayList<>();
        while(tScanner.hasNextLine()){
            String[] data = tScanner.nextLine().split(";");
            teams.add(new Team(data[0],Integer.parseInt(data[1])));
        }
        return teams;
    }

    public ArrayList<MotoBrand> getBrands(){
        ArrayList<MotoBrand> motoBrands = new ArrayList<>();
        while(mScanner.hasNextLine()){
            String[] data = mScanner.nextLine().split(";");
            motoBrands.add(new MotoBrand(data[0],Integer.parseInt(data[1])));
        }
        return motoBrands;
    }

    public ArrayList<Championship> getChampionships(){
        ArrayList<Championship> championships = new ArrayList<>();
        while(cScanner.hasNextLine()){
            String[] data = cScanner.nextLine().split(";");
            championships.add(new Championship(data[0],Integer.parseInt(data[1])));
        }
        return championships;
    }

    public ArrayList<Category> getCategories(){
        ArrayList<Category> categories = new ArrayList<>();
        while(catScanner.hasNextLine()){
            String[] data = catScanner.nextLine().split(";");
            categories.add(new Category(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2])));
        }
        return categories;
    }
}
