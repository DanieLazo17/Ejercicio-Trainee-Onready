import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static ArrayList<Vehiculo> ListaVehiculos = new ArrayList<Vehiculo>();

    public static void main(String[] args) {

        crearObjetos();
        mostrarLista();

        System.out.println("=============================");

        buscarVehiculoMasCaro();
        buscarVehiculoMasBarato();
        buscarModeloConLetraY();

        System.out.println("=============================");

        //ordenarVehiculos();

        Collections.sort(ListaVehiculos);
        /*
        for(Vehiculo item:ListaVehiculos){

            System.out.println(item.getMarca() + " " + item.getModelo());

        }
        */
        for(int i=ListaVehiculos.size()-1; i >= 0; i--){

            System.out.println(ListaVehiculos.get(i).getMarca() + " " + ListaVehiculos.get(i).getModelo());

        }

    }

    public static void crearObjetos(){
        Auto auto1 = new Auto("Peugeot","206", 200000,4);
        Moto moto1 = new Moto("Honda","Titan", 60000,125);
        Auto auto2 = new Auto("Peugeot","208", 250000,5);
        Moto moto2 = new Moto("Yamaha","YBR", 80500.50f,160);

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

    public static void ordenarVehiculos(){

        int pos;

        for (int i=0; i < ListaVehiculos.size(); i++){

            pos = i;
            String marcaAux = ListaVehiculos.get(i).getMarca();
            String modeloAux = ListaVehiculos.get(i).getModelo();
            float precioAux = ListaVehiculos.get(i).getPrecio();
            int puertasAux = 0;
            int cilindradaAux = 0;

            if (ListaVehiculos.get(i) instanceof Auto) {
                Auto aAux = (Auto) ListaVehiculos.get(i);
                puertasAux = aAux.getPuertas();
            }

            if (ListaVehiculos.get(i) instanceof Moto) {
                Moto mAux = (Moto) ListaVehiculos.get(i);
                cilindradaAux = mAux.getCilindrada();
            }

            while( (pos > 0) && ( ListaVehiculos.get(pos-1).getPrecio() > precioAux ) ){

                int puertasAnt = 0;
                int cilindradaAnt = 0;

                //Vehiculo anterior
                if (ListaVehiculos.get(pos-1) instanceof Auto) {
                    Auto autoAnt = (Auto) ListaVehiculos.get(pos-1);
                    puertasAnt = autoAnt.getPuertas();
                }

                if (ListaVehiculos.get(pos-1) instanceof Moto) {
                    Moto motoAnt= (Moto) ListaVehiculos.get(pos-1);
                    cilindradaAnt = motoAnt.getCilindrada();
                }

                if (ListaVehiculos.get(pos) instanceof Auto) {
                    Auto a = new Auto(ListaVehiculos.get(pos-1).getMarca(), ListaVehiculos.get(pos-1).getModelo(), ListaVehiculos.get(pos-1).getPrecio(), puertasAnt);

                    ListaVehiculos.set(pos, a);
                }

                if (ListaVehiculos.get(pos) instanceof Moto) {
                    Moto m = new Moto(ListaVehiculos.get(pos-1).getMarca(), ListaVehiculos.get(pos-1).getModelo(), ListaVehiculos.get(pos-1).getPrecio(), cilindradaAnt);

                    ListaVehiculos.set(pos, m);
                }

                pos--;
            }

            if (ListaVehiculos.get(pos) instanceof Auto) {
                Auto auto = new Auto(marcaAux, modeloAux, precioAux, puertasAux);

                ListaVehiculos.set(pos, auto);
            }

            if (ListaVehiculos.get(pos) instanceof Moto) {
                Moto moto = new Moto(marcaAux, modeloAux, precioAux, cilindradaAux);

                ListaVehiculos.set(pos, moto);
            }
        }

        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        for( int i= (ListaVehiculos.size() - 1); i >= 0; i-- ){

            System.out.print(ListaVehiculos.get(i).getMarca() + " " + ListaVehiculos.get(i).getModelo());

            System.out.println();
        }
    }
}
