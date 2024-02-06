import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Videojuegos {
    String nombre;
    String tipo;
    double precio;
    int id;
    String genero;

    public Videojuegos(String nombre, String tipo, double precio, int id, String genero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.id = id;
        this.genero = genero;
    }

    public Videojuegos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void ingresar(String nombre,String genero,double precio,String tipo){
        try(Connection connection= DriverManager.getConnection("jdbc:mysql//localhost:3306","root","")) {
            String sql="INSERT INTO juegos(Nombre,Genero,Precio,Tipo)values(?,?,?,?)";
            try(PreparedStatement preparedStatement=connection.prepareStatement(sql)) {
                //preparedStatement.setInt(1,id);
                preparedStatement.setString(1,nombre);
                preparedStatement.setString(2,genero);
                preparedStatement.setDouble(3,precio);
                preparedStatement.setString(4,tipo);
                int filasAfectadas= preparedStatement.executeUpdate();
                if(filasAfectadas>0){
                    System.out.println("inserccion existosa");
                }else{
                    System.out.println("inserccion fallida");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
