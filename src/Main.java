import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static List<Vehiculo> ListaVehiculos = new ArrayList<Vehiculo>();

    public static void main(String[] args) {

        crearObjetos();
        mostrarLista();

        System.out.println("=============================");

        buscarVehiculoMasCaro();
        buscarVehiculoMasBarato();
        buscarModeloConLetraY();

        System.out.println("=============================");

        ordenarVehiculosPorPrecio();

        //ListaVehiculos.sort(Vehiculo::compareTo);

        //Collections.sort(ListaVehiculos);

        imprimirVehiculosOrdenadosPorPrecio();
    }

    public static void crearObjetos(){
        Vehiculo auto1 = new Auto("Peugeot","206", 200000,4);
        Vehiculo moto1 = new Moto("Honda","Titan", 60000,125);
        Vehiculo auto2 = new Auto("Peugeot","208", 250000,5);
        Vehiculo moto2 = new Moto("Yamaha","YBR", 80500.50f,160);

        ListaVehiculos.add(auto1);
        ListaVehiculos.add(moto1);
        ListaVehiculos.add(auto2);
        ListaVehiculos.add(moto2);
    }

    public static void mostrarLista(){

        for (Vehiculo item : ListaVehiculos){

            item.mostrarDatos();

            System.out.println();
        }
    }

    public static void buscarVehiculoMasCaro(){

        float precioMayor = Float.MIN_VALUE;
        String marcaMasCara = null;
        String modeloMasCaro = null;

        for (Vehiculo item : ListaVehiculos){

            if(item.getPrecio() > precioMayor){

                precioMayor = item.getPrecio();
                marcaMasCara = item.getMarca();
                modeloMasCaro = item.getModelo();

            }
        }

        System.out.println("Vehículo más caro: " + marcaMasCara + " " + modeloMasCaro);
    }

    public static void buscarVehiculoMasBarato(){

        float precioMenor = Float.MAX_VALUE;
        String marcaMasBarata = null;
        String modeloMasBarato = null;

        for (Vehiculo item : ListaVehiculos){

            if(item.getPrecio() < precioMenor){

                precioMenor = item.getPrecio();
                marcaMasBarata = item.getMarca();
                modeloMasBarato = item.getModelo();

            }
        }

        System.out.println("Vehículo más barato: " + marcaMasBarata + " " + modeloMasBarato);
    }

    public static void buscarModeloConLetraY(){

        String marcaConLetraY = null;
        String modeloConLetraY = null;
        float precioConLetraY = 0;

        for (Vehiculo item : ListaVehiculos){

            if( item.getModelo().matches(".*[Y].*") ){

                marcaConLetraY = item.getMarca();
                modeloConLetraY = item.getModelo();
                precioConLetraY = item.getPrecio();

            }

        }

        DecimalFormat df = new DecimalFormat("###,###.00");

        System.out.println("Vehículo que contiene en el modelo la letra ‘Y’: " + marcaConLetraY + " " + modeloConLetraY + " $" + df.format(precioConLetraY));

    }

    public static void ordenarVehiculosPorPrecio(){

        int pos;

        for (int i=0; i < ListaVehiculos.size(); i++){

            pos = i;
            Vehiculo vehiculo = ListaVehiculos.get(i);

            while( (pos > 0) && ( ListaVehiculos.get(pos-1).getPrecio() > vehiculo.getPrecio() ) ){

                ListaVehiculos.set(pos, ListaVehiculos.get(pos-1));
                pos--;
            }

            ListaVehiculos.set(pos, vehiculo);
        }
    }

    public static void imprimirVehiculosOrdenadosPorPrecio(){
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        System.out.println();
        for( int i= (ListaVehiculos.size() - 1); i >= 0; i-- ){

            System.out.print(ListaVehiculos.get(i).getMarca() + " " + ListaVehiculos.get(i).getModelo());

            System.out.println();
        }
    }
}
