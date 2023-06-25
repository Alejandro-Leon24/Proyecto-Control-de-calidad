package com.mycompany.proyecto;

public class Samsung extends Producto {
    //Realizamos herencia de nuestro producto base para clasificarlo y guardarlo aqui
    //Adicionalmente al hacer herencia herede los atributos anteriores y agregue nuevos que seran unicos para esta clase
    private String estado;
    private int garantia;
    private String marca;
    
    //Creamos constructores agregando los que teniamos en la herencia usando super y agregando los nuevos que tenemos aqui
    public Samsung(String estado, int garantia, String marca, String modelo, int unidades, double peso, int anio, int mes, int dia) {
        super(modelo, unidades, peso, anio, mes, dia);
        this.estado = estado;
        this.garantia = garantia;
        this.marca = marca;
    }
    public Samsung(String estado, int garantia, String modelo, int unidades, double peso, int anio, int mes, int dia) {
        super(modelo, unidades, peso, anio, mes, dia);
        this.estado = estado;
        this.garantia = garantia;
    }
    //Metodos setters y getters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    
    //Realizamos polimorfimos con el metodo para sobreEscribirlo y agregar nuevos mensaje usando el mismo nombre del metodos
    //Override es para indicar a java que este metodo existe en mi clase padre y aqui lo modificare para esta clase
    @Override
    public void MostrarDatos(){
        System.out.println("La marca del producto es: "+getMarca());
        System.out.println("La garantia del producto es: "+getGarantia());
        System.out.println("El estado del producto es: "+getEstado());
        System.out.println("El modelo de tu producto es: "+ getModelo());
        System.out.println("Las unidades disponibles son: "+ getUnidades());
        System.out.println("El peso del producto es: "+ getPeso());
        System.out.println("Su fecha de Ingreso es: ("+getDia()+"/"+getMes()+"/"+getAnio()+")");
    }
}
