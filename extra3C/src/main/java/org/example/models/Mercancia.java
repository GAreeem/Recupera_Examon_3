package org.example.models;

public class Mercancia {
    private Integer peso;
    private Integer distancia;
    private String transporte;
    private double costo;
    private int idenvio;
    private String fecha;

    public Mercancia(Integer peso, Integer distancia, String transporte, double costo, int idenvio, String fecha) {
        this.peso = peso;
        this.distancia = distancia;
        this.transporte = transporte;
        this.costo = costo;
        this.idenvio = idenvio;
        this.fecha = fecha;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getIdenvio() {
        return idenvio;
    }

    public void setIdenvio(int idenvio) {
        this.idenvio = idenvio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
