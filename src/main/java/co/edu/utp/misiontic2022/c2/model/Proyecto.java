package co.edu.utp.misiontic2022.c2.model;

public class Proyecto {
    private Integer id;
    private String constructora;
    private Integer numeroHabitaciones;
    private String ciudad;
    
    public Proyecto(Integer id, String constructora, Integer numeroHabitaciones, String ciudad) {
        this.id = id;
        this.constructora = constructora;
        this.numeroHabitaciones = numeroHabitaciones;
        this.ciudad = ciudad;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getConstructora() {
        return constructora;
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }
    public Integer getNumeroHabitaciones() {
        return numeroHabitaciones;
    }
    public void setNumeroHabitaciones(Integer numeroHabitaciones) {
        this.numeroHabitaciones = numeroHabitaciones;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
}
