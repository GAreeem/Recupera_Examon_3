package testEnvios;

import org.example.models.Envio;
import org.example.models.Mercancia;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEnvios {

    @Test
    public void ValidarDistancia(){
        Envio envio =  new Envio();
        envio.AgregarMercancia(23,0,"terrestre",1,"17-12-2023");
        assertEquals(0,envio.getMercancias().size());
    }

    @Test
    public void ValidarPeso(){
        Envio envio =  new Envio();
        envio.AgregarMercancia(0,1000,"terrestre",1,"17-12-2023");
        assertEquals(0,envio.getMercancias().size());
    }
    @Test
    public void ValidarTransporte(){
        Envio envio =  new Envio();
        envio.AgregarMercancia(10,1000,"Helicoptero Apache",1,"17-12-2023");
        assertEquals(0,envio.getMercancias().size());
    }

    @Test
    public void TestPesoMenorCienTerrestre(){
        Envio envio =  new Envio();
        envio.AgregarMercancia(10,1000,"terrestre",1,"17-12-2023");
        envio.CalcularMercancia();
        assertEquals(1,envio.getMercancias().size());
    }

    @Test
    public void TestPesoMayorCienTerrestre(){
        Envio envio =  new Envio();
        envio.AgregarMercancia(101,1000,"terrestre",1,"17-12-2023");
        envio.CalcularMercancia();
        assertEquals(1,envio.getMercancias().size());
    }

    @Test
    public void TestPesoMenorCincoMaritimo(){
        Envio envio =  new Envio();
        envio.AgregarMercancia(200,1000,"maritimo",1,"17-12-2023");
        envio.CalcularMercancia();
        assertEquals(1,envio.getMercancias().size());
    }

    @Test
    public void TestPesoMayorCincoMaritimo(){
        Envio envio =  new Envio();
        envio.AgregarMercancia(501,1000,"maritimo",1,"17-12-2023");
        envio.CalcularMercancia();
        assertEquals(1,envio.getMercancias().size());
    }

    @Test
    public void TestTransporteAereo(){
        Envio envio =  new Envio();
        envio.AgregarMercancia(2,1000,"aereo",1,"17-12-2023");
        envio.CalcularMercancia();
        assertEquals(1,envio.getMercancias().size());
    }

    @Test
    public void TestMercanciasEnviadas(){
        Envio envio =  new Envio();
        envio.AgregarMercancia(2,1000,"aereo",1,"17-12-2023");
        envio.AgregarMercancia(501,1000,"maritimo",2,"18-12-2023");
        envio.AgregarMercancia(103,1000,"terrestre",3,"20-12-2023");
        envio.CalcularMercancia();
        assertEquals(3,envio.getMercancias().size());
    }
}
