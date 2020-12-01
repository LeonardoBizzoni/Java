import java.util.List;
import java.util.ArrayList;

class Rubrica{
    private List<Contatto> contatti = new ArrayList<Contatto>();

    void aggiungiContatto(String nome, String cognome, String tel){
        contatti.add(new Contatto(nome, cognome, tel));
    }

    void rimuoviContatto(String nome, String cognome){
        Contatto con;

        for(int i=0;i<contatti.size();i++){
            con = contatti.get(i);
            if(con.getNome.compareTo(nome) == 0 && con.getCognome().compareTo(cognome) == 0){
                contatti.remove(con);
            }
        }
    }

    String cerca(String nome, String cognome){
        Contatto con;

        for(int i=0;i<contatti.size();i++){
            con = contatti.get(i);
            if(con.getNome.compareTo(nome) == 0 && con.getCognome().compareTo(cognome) == 0){
                return con.getNumeroDiTelefono();
            }
        }

        return null;
    }

    public String toString(){
        String boh = null;
        for(int i=0;i<contatti.size();i++){
            boh += contatti.get(i).toString();
        }

        return boh;
    }
}
