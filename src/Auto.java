import java.text.DecimalFormat;

public class Auto extends Vehiculo{

    //Atributos
    private int puertas;

    //Método Constructor
    public Auto(String marca, String modelo, float precio, int puertas) {
        super(marca, modelo, precio);
        this.puertas = puertas;
    }

    public Auto() {
    }

    //Métodos Getters y Setters
    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public void mostrarDatos() {

        DecimalFormat df = new DecimalFormat("###,###.00");

        System.out.print("Marca: " + getMarca());
        System.out.print(" // ");
        System.out.print("Modelo: " + getModelo());
        System.out.print(" // ");
        System.out.print("Puertas: " + getPuertas());
        System.out.print(" // ");
        System.out.print("Precio: $" + df.format(getPrecio()));

    }
}
