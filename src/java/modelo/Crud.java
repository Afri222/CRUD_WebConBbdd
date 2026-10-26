package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;

public class Crud {

    private static final String URL = "jdbc:mariadb://localhost:3306/empresa";
    private static final String USER = "root";
    private static final String PWD = "profesor";

    public static String darAlta(int numEmpleado, String nombre, String trabajo, int manager,
            Date fechaContrato, int salario, int comision, int numDepartamento) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
            return "No se encuentra el driver!";
        }
        String sql = "INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection insertarConexion = DriverManager.getConnection(URL, USER, PWD); 
             PreparedStatement preparadoStmt = insertarConexion.prepareStatement(sql)) {

            preparadoStmt.setInt(1, numEmpleado);
            preparadoStmt.setString(2, nombre);
            preparadoStmt.setString(3, trabajo);
            preparadoStmt.setInt(4, manager);
            preparadoStmt.setDate(5, fechaContrato);
            preparadoStmt.setInt(6, salario);
            preparadoStmt.setInt(7, comision);
            preparadoStmt.setInt(8, numDepartamento);

            int filasAfectadas = preparadoStmt.executeUpdate();

            if (filasAfectadas > 0) {
                return "¡El registro se ha dado de alta correctamente!";
            }

        } catch (SQLException e) {
            return "Error al intentar insertar el registro: " + e.getMessage();
        }
        return "No se ha podido dar de alta el registro.";
    }
    /*
    public static void main(String[] args){
    LocalDate localDate = LocalDate.of(2026, 10, 24);
    Date fecha = Date.valueOf(localDate);
    Crud.darAlta(9, "Ernesto", "DA2D1A", 123, fecha, 1234, 1230, 1);
    }*/

    public static String darBaja(int numEmpleado) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            return "No se encuentra el driver!";
        }
        
        String query = "DELETE FROM emp WHERE empno = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, numEmpleado);
            ps.executeUpdate();
            
            return "¡Empleado dado de baja con éxito!";
        } catch (SQLException e) {
            return "Error al intentar borrar el registro: " + e.getMessage();
        }
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static String actualizar(int empno, String newEname, String newJob, int newMgr, Date newHireDate, int newSal, int newComm, int newDeptno) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            return "No se encuentra el driver!";
        }
        
        String query = "UPDATE emp WHERE empno=? SET ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, empno);
            ps.setString(2, newEname);
            ps.setString(3, newJob);
            ps.setInt(4, newMgr);
            ps.setDate(5, newHireDate);
            ps.setInt(6, newSal);
            ps.setInt(7, newComm);
            ps.setInt(8, newDeptno);
            
            ps.executeUpdate();
            return "¡Empleado actualizado con éxito!";
            
        } catch (SQLException e) {
            return "Error al actualizar el registro: " + e.getMessage();
        }
        
    }
    
    public static String mostrarEmpleado(int empno) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            return "No se encuentra el driver!";
        }
        
        String query = "SELECT * FROM emp WHERE empno = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PWD);
                PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setInt(1, empno);
            try (ResultSet rs = ps.executeQuery();) {
                
                
                
                return "¡Empleado mostrado con éxito!";
            }
        } catch (SQLException e) {
            return "Error al mostrar registro: " + e.getMessage();
        }
    }
    
    
    
}