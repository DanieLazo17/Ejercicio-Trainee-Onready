import java.util.ArrayList;

public abstract class Vehiculo implements Comparable<Vehiculo> {

    //Atributos
    protected String marca;
    protected String modelo;
    protected float precio;

    //Método Constructor
    public Vehiculo(String marca, String modelo, float precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    //Métodos Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public abstract void mostrarDatos();

    @Override
    public int compareTo(Vehiculo o) {

        if (o.getPrecio() > this.precio){
            return -1;
        } else if (o.getPrecio() == this.precio){
            return 0;
        } else {
            return 1;
        }

    }
}
