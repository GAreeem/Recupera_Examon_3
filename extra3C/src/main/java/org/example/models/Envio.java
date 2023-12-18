package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Envio {

    List<Mercancia> mercancias;
    List<Calcular> calcula;

    public Envio(){
        mercancias= new ArrayList<>();
        calcula=new ArrayList<>();
    }

    public List<Mercancia> getMercancias() {
        return mercancias;
    }

    public List<Calcular> getCalcula() {
        return calcula;
    }

    public void AgregarMercancia(Integer peso, Integer distancia, String transporte,int id,String fecha ){
        if(peso<=0){
            System.out.println("Peso invalido");
        }else if(distancia<=0){
            System.out.println("Distancia invalida");
        }else if (transporte.equals("terrestre")||transporte.equals("maritimo")||transporte.equals("aereo")){
            Mercancia mercancia = new Mercancia(peso, distancia, transporte, 0, id, fecha);
            mercancias.add(mercancia);
        }else {
            System.out.println("transporte invalido");
        }
    }

    public void CalcularMercancia(){
        double precio;
        for (Mercancia mercancia: mercancias){
            if (mercancia.getTransporte().equals("terrestre")){
                if (mercancia.getPeso()<=100){
                    precio = mercancia.getPeso()*50;
                    mercancia.setCosto(precio);
                    System.out.println();
                    System.out.println("id del envio: "+ mercancia.getIdenvio());
                    System.out.println("fecha: "+ mercancia.getFecha());
                    System.out.println("transprote: "+ mercancia.getTransporte());
                    System.out.println("peso: "+ mercancia.getPeso());
                    System.out.println("distancia: "+ mercancia.getDistancia());
                    System.out.println("costo :"+ mercancia.getCosto());
                    System.out.println();
                }else if (mercancia.getPeso()>=100){
                    precio = mercancia.getPeso()*40;
                    mercancia.setCosto(precio);
                    System.out.println();
                    System.out.println("id del envio: "+ mercancia.getIdenvio());
                    System.out.println("fecha: "+ mercancia.getFecha());
                    System.out.println("transprote: "+ mercancia.getTransporte());
                    System.out.println("peso: "+ mercancia.getPeso());
                    System.out.println("distancia: "+ mercancia.getDistancia());
                    System.out.println("costo :"+ mercancia.getCosto());
                    System.out.println();
                }
            }else if (mercancia.getTransporte().equals("maritimo")){
                if (mercancia.getPeso()<=500){
                    precio=mercancia.getPeso()*100;
                    mercancia.setCosto(precio);
                    System.out.println();
                    System.out.println("id del envio: "+ mercancia.getIdenvio());
                    System.out.println("fecha: "+ mercancia.getFecha());
                    System.out.println("transprote: "+ mercancia.getTransporte());
                    System.out.println("peso: "+ mercancia.getPeso());
                    System.out.println("distancia: "+ mercancia.getDistancia());
                    System.out.println("costo :"+ mercancia.getCosto());
                    System.out.println();
                }else if (mercancia.getPeso()>=500){
                    precio=mercancia.getPeso()*80;
                    mercancia.setCosto(precio);
                    System.out.println();
                    System.out.println("id del envio: "+ mercancia.getIdenvio());
                    System.out.println("fecha: "+ mercancia.getFecha());
                    System.out.println("transprote: "+ mercancia.getTransporte());
                    System.out.println("peso: "+ mercancia.getPeso());
                    System.out.println("distancia: "+ mercancia.getDistancia());
                    System.out.println("costo :"+ mercancia.getCosto());
                    System.out.println();
                }
            }else if (mercancia.getTransporte().equals("aereo")){
                    precio=mercancia.getPeso()*200;
                    mercancia.setCosto(precio);
                System.out.println();
                System.out.println("id del envio: "+ mercancia.getIdenvio());
                System.out.println("fecha: "+ mercancia.getFecha());
                System.out.println("transprote: "+ mercancia.getTransporte());
                System.out.println("peso: "+ mercancia.getPeso());
                System.out.println("distancia: "+ mercancia.getDistancia());
                System.out.println("costo :"+ mercancia.getCosto());
                System.out.println();
            }
        }
    }
}
