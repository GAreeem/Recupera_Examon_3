package org.example.models;

public class Calcular {

    Mercancia mercancia;
    double costo;

    public Calcular(Mercancia mercancia, double costo) {
        this.mercancia = mercancia;
        this.costo = costo;
    }

    public Mercancia getMercancia() {
        return mercancia;
    }

    public void setMercancia(Mercancia mercancia) {
        this.mercancia = mercancia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
