package modelo;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author afric
 */
public class DAOException extends Exception {
    public DAOException (String msj, Throwable e) {
        super (msj, e);
    }
    
    public DAOException (SQLException e) {
        super ("Error en DAO", e);
    }
    
    public DAOException (Throwable e) {
        super ("Error en DAO", e);
    }
    
    public DAOException (IOException e) {
        super ("Error en DAO", e);
    }
}