public class Test {
    public static void main(String[]args){
        BahnhofsNetzwerk netz=new BahnhofsNetzwerk("DB-Netz_INSPIRE_20200217.txt");
        BahnhofsNetzwerk netzAlt=new BahnhofsNetzwerk("DB-Netz_INSPIRE_20131128.txt");
        //for (Bahnhof b:netz.getAlleBahnhoefe()) {
       //     System.out.println(b.xmlData+"\n\n\n");
     //   }


        for (int i = 0; i < netz.getAlleBahnhoefe().size(); i++) {
            System.out.println(i+". "+netz.getAlleBahnhoefe().get(i).toString());
            System.out.println();
        }

        for (int i = 0; i < netzAlt.getAlleBahnhoefe().size(); i++) {
            System.out.println(i+". "+netzAlt.getAlleBahnhoefe().get(i).toString());
            System.out.println();
        }
// test ob sich was geändert hat
        for (int i = 0; i < netzAlt.getAlleBahnhoefe().size(); i++) {
            if (!netz.alleBahnhoefe.get(i).toString().equalsIgnoreCase(netzAlt.alleBahnhoefe.get(i).toString())){
                System.out.println(i+".(Alt) "+netzAlt.getAlleBahnhoefe().get(i).toString());
                System.out.println();
                System.out.println(i+".(Neu) "+netz.getAlleBahnhoefe().get(i).toString());
                System.out.println();
                System.out.println();
            }
        }

        System.out.println("Neu: "+netz.getAnzahlBahnhoefe()+" alt: "+netzAlt.getAnzahlBahnhoefe());

    }
}
