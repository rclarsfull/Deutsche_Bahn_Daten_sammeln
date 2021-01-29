import java.io.File;
import java.util.ArrayList;

public class BahnhofsNetzwerk {
    ArrayList<Bahnhof> alleBahnhoefe=new ArrayList<Bahnhof>();
    File xmlDatei=new File("DB-Netz_INSPIRE_20200217.txt");

    BahnhofsNetzwerk(String filename){
        xmlDatei=new File("DB-Netz_INSPIRE_20200217.txt");
        XMLFileReader reader=new XMLFileReader(new File("DB-Netz_INSPIRE_20200217.txt"));
        ArrayList<String> liste=reader.getAsArraylist("<RailwayStationNode","</RailwayStationNode>");

        for (String s:liste) {
            alleBahnhoefe.add(new Bahnhof(s));
        }
    }

    BahnhofsNetzwerk(File xmlDatei){
        this.xmlDatei=xmlDatei;
        XMLFileReader reader=new XMLFileReader(new File(xmlDatei.getName()));

        ArrayList<String> liste=reader.getAsArraylist("<RailwayStationNode","</RailwayStationNode>");

        for (String s:liste) {
            alleBahnhoefe.add(new Bahnhof(s));
        }
    }

    public int getAnzahlBahnhoefe(){
        return alleBahnhoefe.size();
    }






















    public ArrayList<Bahnhof> getAlleBahnhoefe() {
        return alleBahnhoefe;
    }
}
