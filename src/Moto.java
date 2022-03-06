import java.text.DecimalFormat;

public class Moto extends Vehiculo{

    //Atributos
    private int cilindrada;

    //Método Constructor
    public Moto(String marca, String modelo, float precio, int cilindrada) {
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    public Moto() {
    }

    //Métodos Getters y Setters

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public void mostrarDatos() {

        DecimalFormat df = new DecimalFormat("###,###.00");

        System.out.print("Marca: " + getMarca());
        System.out.print(" // ");
        System.out.print("Modelo: " + getModelo());
        System.out.print(" // ");
        System.out.print("Cilindrada: " + getCilindrada() + "cc");
        System.out.print(" // ");
        System.out.print("Precio: $" + df.format(getPrecio()));
    }
}
