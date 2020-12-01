class Contatto{
    private String nome;
    private String cognome;
    private String numeroTelefono;

    public Contatto(String nome, String cognome, String tel){
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = tel;
    }

    public String setNome(String nome){
        this.nome = nome;
    }
    public String setCognome(String cognome){
        this.cognome = cognome;
    }
    public String setNumeroDiTelefono(String tel){
        this.numeroDiTelefono = tel;
    }

    public void getNome(String nome){
        return nome;
    }
    public void getNome(String nome){
        return cognome;
    }
    public void getNumeroDiTelefono(String tel){
        return numeroDiTelefono;
    }

    public String toString(){
        return "Nome: " + nome + "\nCognome: " + cognome + "\nTelefono: " + numeroDiTelefono;
    }
}
