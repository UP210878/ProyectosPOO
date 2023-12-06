package encapsuladores;
import java.sql.Date;

public class Libro {
    private String idLibro;
    private String titulo;
    private String genero;
    private String descripcion;
    private Date fechaEdicion;
    private int numeroPaginas;
    private boolean premiado;

    public String getIdLibro() {
        return idLibro;
    }
    
    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Date getFechaEdicion() {
        return fechaEdicion;
    }
    
    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }
    
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    
    public boolean isPremiado() {
        return premiado;
    }
    
    public void setPremiado(boolean premiado) {
        this.premiado = premiado;
    }
}
