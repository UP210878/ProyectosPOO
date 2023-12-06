package presentacion;
import encapsuladores.Genero;
import encapsuladores.Libro;
import excepciones.GenericaExcepcion;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;
import negocio.LibrosNegocio;
public class Menu {
    public void ejecutarMenu() {
        BufferedReader bufferedReader = new BufferedReader(new
        InputStreamReader(System.in));
        byte opcionTecleada = 0;
        do {
            try {
                System.out.println("----------------------------GESTIÓN LIBROS ----------------------------");
                System.out.println("1.- Insertar");
                System.out.println("2.- Actualizar premiado");
                System.out.println("3.- Eliminar libro");
                System.out.println("4.- Consultar por identificador de libro");
                System.out.println("5.- Consultar todos");
                System.out.println("6.- Consultar número de libros");
                System.out.println("0.- Finalizar");
                System.out.println("------------------------------------------------------------------------");
                System.out.print("Seleccione opción : ");
                opcionTecleada =
                (byte)Integer.parseInt(bufferedReader.readLine());
                switch(opcionTecleada)
                {
                    case 1: insertar(bufferedReader);
                    break;
                    case 2: actualizarPremiado(bufferedReader);
                    break;
                    case 3: eliminar(bufferedReader);
                    break;
                    case 4: consultarPorIdLibro(bufferedReader);
                    break;
                    case 5: consultarTodos();
                    break;
                    case 6: consultarNumeroLibros();
                    break;
                }
            }
            catch (Exception exception)
            {
                gestionarExcepcion(exception);
            }
        }
            while (opcionTecleada != 0);
    }
    private void gestionarExcepcion(Exception excepcion) {
        int codigoError = 0;
        String mensajeError = "";
        if (excepcion instanceof GenericaExcepcion)
        {
            GenericaExcepcion genericaExcepcion = (GenericaExcepcion)excepcion;
            codigoError = genericaExcepcion.getCodigoError();
            switch (genericaExcepcion.getCodigoError())
            {
                case 50: mensajeError = "Se ha producido una situación de error como consecuencia de problemas con la             conexión a la BD";
                break;
                case 71: mensajeError = "No existe un libro con ese identificador";
                break;
                case 80: mensajeError = "Se ha producido una situación de error en la BD al intentar insertar libro";
                break;
                case 81: mensajeError = "Se ha producido una situación de error en la BD al intentar actualizar premiado";
                break;
                case 82: mensajeError = "Se ha producido una situación de error en la BD al intentar eliminar libro";
                break;
                case 83: mensajeError = "Se ha producido una situación de error en la BD al intentar consultar por identificador de libro";
                break;
                case 84: mensajeError = "Se ha producido una situación de error en la BD al intentar consultar todos los libros";
                break;
                case 85: mensajeError = "Se ha producido una situación de error en la BD al intentar consultar el número de libros";
                break;
                case 90: mensajeError = "Se ha producido una situación de error en la BD al intentar consultar la relación de géneros";
                break;
            }
        }
        else
        { 
            if (excepcion instanceof NumberFormatException)
            {
                mensajeError = "La totalidad de los dígitos deben ser numéricos";
            }
            else
            {
                mensajeError = excepcion.getMessage();
            }
        }
        System.out.println("Código de error: " + codigoError + " - " + mensajeError);
    }
    
    private void insertar(BufferedReader bufferedReader) throws Exception {
        System.out.println("------------- INTRODUCCIÓN DATOS DE NUEVO LIBRO ------------------");
        Libro libro = new Libro();
        System.out.print("identificador de libro : ");
        libro.setIdLibro(bufferedReader.readLine());
        System.out.print("título : ");
        libro.setTitulo(bufferedReader.readLine());
        List<Genero> listaGeneros = new
        LibrosNegocio().consultarGeneros();
        System.out.println("------------- GÉNEROS ------------------");
        for (int i=0; i<listaGeneros.size(); i++)
        {
            Genero genero = listaGeneros.get(i);
            System.out.println(genero.getCodigo()+" - "+genero.getDescripcion());
        }
        System.out.print("introduzca código de género : ");
        libro.setGenero(bufferedReader.readLine());
        System.out.print("fecha edición (aaaa-mm-dd) : ");
        libro.setFechaEdicion(java.sql.Date.valueOf(bufferedReader.readLine()));
        System.out.print("número páginas : ");
        libro.setNumeroPaginas(Integer.parseInt(bufferedReader.readLine()));
        System.out.print("premiado (0/1) : ");
        int valorPremiado = (Integer.parseInt(bufferedReader.readLine()));
        if (valorPremiado == 1)
            libro.setPremiado(true);
        else
            libro.setPremiado(false);
            new LibrosNegocio().insertar(libro);
    }
    
    private void actualizarPremiado(BufferedReader bufferedReader) throws Exception {
        System.out.println("-------------------- ACTUALIZAR PREMIADO -------------------------");
        Libro libro = new Libro();
        System.out.print("identificador de libro : ");
        libro.setIdLibro(bufferedReader.readLine());
        System.out.print("premiado (0/1) : ");
        int valorPremiado =
        (Integer.parseInt(bufferedReader.readLine()));
        if (valorPremiado == 1)
            libro.setPremiado(true);
        else
            libro.setPremiado(false);
        new LibrosNegocio().actualizarPremiado(libro);
    }
    private void eliminar(BufferedReader bufferedReader) throws Exception {
        System.out.println("---------------------- ELIMINAR LIBRO ----------------------------");
        Libro libro = new Libro();
        System.out.print("identificador de libro : ");
        libro.setIdLibro(bufferedReader.readLine());
        new LibrosNegocio().eliminar(libro);
    }
    
    private void consultarPorIdLibro(BufferedReader bufferedReader) throws Exception
    {
        System.out.println("----------- CONSULTAR POR IDENTIFICADOR DE LIBRO -----------------");
        Libro libro = new Libro();
        System.out.print("identificador de libro a consultar : ");
        libro.setIdLibro(bufferedReader.readLine());
        Libro libroObtenido = new
        LibrosNegocio().consultarPorIdLibro(libro);
        if (libroObtenido != null)
        {
            System.out.println("SE HA ENCONTRADO EL LIBRO : ");
            System.out.println("identificador de libro : " +
            libroObtenido.getIdLibro());
            System.out.println("título : " +
            libroObtenido.getTitulo());
            System.out.println("género : " +
            libroObtenido.getGenero() + " - " +
            libroObtenido.getDescripcion());
            System.out.println("fecha edición : " + new
            SimpleDateFormat("yyyy-MMdd").
            format(libroObtenido.getFechaEdicion()));
            System.out.println("número páginas : " +
            libroObtenido.getNumeroPaginas());
            String premiado = "NO";
            if (libroObtenido.isPremiado())
            premiado = "SI";
            System.out.println("premiado : " + premiado);
        }
        else
            System.out.println("NO EXISTE UN LIBRO CON EL IDENTIFICADOR INTRODUCIDO");
    }
    
    private void consultarTodos() throws Exception {
        System.out.println("---------------------- LISTADO LIBROS ----------------------------");
        List<Libro> listaLibros = new
        LibrosNegocio().consultarTodos();
        for (int i=0; i<listaLibros.size(); i++)
        {
            Libro libro = listaLibros.get(i);
            System.out.println("identificador de libro : " +
            libro.getIdLibro());
            System.out.println("título : " + libro.getTitulo());
            System.out.println("género : " + libro.getGenero() + " - " + libro.getDescripcion());
            System.out.println("fecha edición : " + new SimpleDateFormat("yyyy-MMdd").
            format(libro.getFechaEdicion()));
            System.out.println("número páginas : " + libro.getNumeroPaginas());
            String premiado = "NO";
            if (libro.isPremiado())
                premiado = "SI";
            System.out.println("premiado : " + premiado);
            System.out.println("--------------------------------------------------");
        }
    }
    
    private void consultarNumeroLibros() throws Exception
    {
        System.out.println("---------------- CONSULTAR NÚMERO DE LIBROS ----------------------");
        int numeroLibros = new LibrosNegocio().consultarNumeroFilas();
        System.out.println("número de libros : " + numeroLibros);
    }
}