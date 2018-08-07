package com.example.samupc.appreperibilita.data;

public class Impianto {
    private String idZona;
    private String via;
    private String citta;
    private Tipo tipo;

    public enum Tipo{
        PRINCIPALE,
        SATELLITE
    }

    public Impianto(String idZona, String via, String citta, Tipo tipo){
        setIdZona(idZona);
        setVia(via);
        setCitta(citta);
        setTipo(tipo);
    }

    public String getIdZona() {
        return idZona;
    }

    public void setIdZona(String idZona) {
        this.idZona = idZona;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }


}
