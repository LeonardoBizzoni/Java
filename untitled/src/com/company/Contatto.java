package com.company;

class Contatto{
    private String nome;
    private String cognome;
    private String numeroTelefono;

    public Contatto(String nome, String cognome, String tel){
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = tel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String toString(){
        return "Nome: " + nome + "\nCognome: " + cognome + "\nTelefono: " + numeroTelefono;
    }
}
