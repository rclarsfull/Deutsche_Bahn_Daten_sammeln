import java.io.*;
import java.util.ArrayList;

public class XMLFileReader {
    File datei;
    String dateiName;
    BufferedReader br;

    XMLFileReader(File datei){
        this.datei=datei;
        this.dateiName=datei.getName();
        try {
            br=new BufferedReader(new FileReader(datei));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    XMLFileReader(String dateiName){
        this.dateiName=dateiName;
        try {
            this.datei=new File(dateiName);
        }catch (Exception e){
            System.out.println("Fehler beim laden der XML Datei");
        }
        try {
            br=new BufferedReader(new FileReader(dateiName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getAsString(){
        String ausgabe="";
        String zeile=null;
        try {
            while ((zeile = br.readLine())!=null){
                ausgabe+= zeile+"\n";
            }
        }catch (Exception e){
            System.out.println("Fehler beim String bauen");
        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ausgabe;
    }

    public ArrayList<String> getAsArraylist(String anfangszeichen,String endzeichen){
        ArrayList<String> ausgabe=new ArrayList<String>();
        String zeile=null;
        String temp;
        try {
            while ((zeile = br.readLine())!=null){
                if (zeile.contains(anfangszeichen) && zeile.contains(endzeichen)){
                    zeile=zeile.split(anfangszeichen)[1];
                    zeile=zeile.split(endzeichen)[0];
                    ausgabe.add(zeile);
                }else if (zeile.contains(anfangszeichen)){
                    temp=zeile+"\n";
                    while (((zeile = br.readLine())!=null) && !zeile.contains(endzeichen)){
                        temp+=zeile+"\n";
                    }
                    temp=temp.split(anfangszeichen)[1];
                    temp=temp.split(endzeichen)[0];
                    ausgabe.add(temp);
                }

            }
        }catch (Exception e){
            System.out.println("Fehler beim Liste(String) bauen");
        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return ausgabe;
    }



}
