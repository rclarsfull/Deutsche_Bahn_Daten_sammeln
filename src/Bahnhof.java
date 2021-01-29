import java.io.File;

public class Bahnhof {
    String xmlData;
    String name;
    String id;
    double cordsN;
    double cordsO;

    Bahnhof (String xmlData){
        this.xmlData=xmlData;
        String temp;

        temp=xmlData.split("<gml:pos>")[1];
        temp=temp.split("</gml:pos>")[0];
        this.cordsN=Double.parseDouble(temp.split(" ")[0]);
        this.cordsO=Double.parseDouble(temp.split(" ")[1]);

        temp=xmlData.split("<base:localId>")[1];
        this.id=temp.split("</base:localId>")[0];

        temp=xmlData.split("<gn:text>")[1];
        temp=temp.split("</gn:text>")[0];
        this.name=temp.strip();
    }


    @Override
    public String toString() {
        return "Bahnhof{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", cordsN=" + cordsN +
                ", cordsO=" + cordsO +
                '}';
    }
}
