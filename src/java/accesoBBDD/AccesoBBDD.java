package accesoBBDD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DAOException;
import modelo.Empleado;

/**
 *
 * @author afric
 */
public class AccesoBBDD {
    private static final String URL = "jdbc:mariaDB://localhost:3306/empresa";
    private static final String USER = "root";
    private static final String PWD = "alumno";
    
    // Método alta, baja, etc
    public static Empleado showEmpleado(int empno) throws DAOException{
        String query = "SELECT * FROM emp WHERE empno = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
                PreparedStatement stmt = conn.prepareStatement(query);) {
            stmt.setInt(1, empno);
            ResultSet rs = stmt.executeQuery(query);
            
            /* while (rs.next()) { */
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String job = rs.getString(3); // out.print(rs.getString("Job" + " "));
                Integer mgr = Integer.parseInt(rs.getString(4));
                Date hireDate = rs.getDate(5);
                int sal = rs.getInt(6);
                Integer comm = rs.getInt(7);
                int deptno = rs.getInt(8);
            rs.close();
            return new Empleado(id, name, job, mgr, hireDate, sal, comm, deptno);
        } catch (SQLException se) {
            throw new DAOException(se);
        }
    }
    
    public static String addEmpleado (int empno, String ename, String job, Integer mgr, Date hireDate, int sal, Integer comm, int deptno) throws DAOException {
        String valores = empno + ", " + ename + ", " + job + ", " + mgr + ", " +  hireDate + ", " + sal + ", " + comm + ", " + deptno;
        String query = "INSERT INTO emp VALUES (?)"; // (empno, ename, job, mgr, hiredate, sal, comm, deptno)
        String msj;
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, valores);
            int resultado = ps.executeUpdate();
            
            if (resultado > 0) {
                msj = "¡Actualizado con éxito!";
            } else {
                msj = "No se ha actualizado correctamente.";
            }
        return msj;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public static List<Empleado> showAllEmpleados() throws DAOException{
        String query = "SELECT * FROM emp";
        try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery(query);) {
            List<Empleado> emps = new ArrayList<>();
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String job = rs.getString(3); // out.print(rs.getString("Job" + " "));
                Integer mgr = Integer.parseInt(rs.getString(4));
                Date hireDate = rs.getDate(5);
                int sal = rs.getInt(6);
                Integer comm = rs.getInt(7);
                int deptno = rs.getInt(8);
                emps.add(new Empleado(id, name, job, mgr, hireDate, sal, comm, deptno));
            }
            return emps;
        } catch (SQLException se) {
            throw new DAOException(se);
        }
    }
    
    public static void deleteEmpleado(int empno) throws DAOException{
        String query = "DELETE FROM emp WHERE empno = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
                PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setInt(1, empno);
            
            int ñ = ps.executeUpdate();
            
            /* if (ñ > 0)
                Eliminado correctamente
            else
                No eliminado o algo salió mal
            */
                
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    public static int modifyEmpleado(int empnoACambiar, String newEname, String newJob, Integer newMgr, Date newHireDate, double newSal, Integer newComm, int newDeptno) throws DAOException {
        String query = "UPDATE emp SET ? WHERE ?";
        String values = empnoACambiar + ", " + newEname + ", " + newJob + ", " + newMgr + ", " +  newHireDate + ", " + newSal + ", " + newComm + ", " + newDeptno;
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
                PreparedStatement ps = conn.prepareStatement(query);) {
            ps.setString(1, values);
            ps.setInt(2, empnoACambiar);
            
            int numCambios = ps.executeUpdate();
            return numCambios;
            
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        
    }
}
