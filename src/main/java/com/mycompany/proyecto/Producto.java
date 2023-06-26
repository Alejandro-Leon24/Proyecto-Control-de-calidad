
package com.mycompany.proyecto;

public class Producto extends Fecha{
    //Definimos atributos que tendra mi producto base y hacemos herencia con la clase fecha para tener
    //El dia, mes y año y no repetir esos atributos
    private String modelo;
    private int unidades;
    private double peso;
    
    //Definimos los constructores para llenarlos en la clase logica
    public Producto(String modelo, int unidades, double peso, int anio, int mes, int dia) {
        super(anio, mes, dia);
        this.modelo = modelo;
        this.unidades = unidades;
        this.peso = peso;
    }
    
    //Definimos los metodos setters y getters para obtener o editar informacion ya que esta encapsulada como private
    //Para que solo se use en las clases asignadas
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    //Definimos un metodo que me permita mostrar cada dato de la clase y al momento de hacer herencia realizar polimorfismo y
    //sobreEscritura de metodo
    public void MostrarDatos(){
        System.out.println("El modelo de tu producto es: "+ getModelo());
        System.out.println("Las unidades disponibles son: "+ getUnidades());
        System.out.println("El peso del producto es: "+ getPeso());
        System.out.println("Su fecha de Ingreso es: ("+getDia()+"/"+getMes()+"/"+getAnio()+")");
    }
    //Metodo para mostrar sus datos eliminados
    public void MostrarDatosEliminados(){
        System.out.println("El modelo de tu producto eliminado es: "+ getModelo());
        System.out.println("Las unidades que tenia son: "+ getUnidades());
        System.out.println("Su peso era : "+ getPeso());
        System.out.println("Su fecha de Ingreso era: ("+getDia()+"/"+getMes()+"/"+getAnio()+")");
    }
}
