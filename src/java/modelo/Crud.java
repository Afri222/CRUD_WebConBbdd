package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Crud {
    private static final String URL = "jdbc:mariadb://localhost:3306/empresa";
    private static final String USER = "root";
    private static final String PASSWORD = "profesor";

    public static String darAlta(int numEmpleado, String nombre, String trabajo, int manager,
            Date fechaContrato, int salario, int comision, int numDepartamento) {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Recarga el Driver
        } catch (ClassNotFoundException ex) {
            return "No se encuentra el driver!";
        }
        String sql = "INSERT INTO emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection insertarConexion = DriverManager.getConnection(URL, USER, PASSWORD);
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

    //----------------------------------------------------------------------------------------------------------------------------------------
    
    public static String darBaja(int numEmpleado) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            return "No se encuentra el driver!";
        }
        
        String sql = "DELETE FROM emp WHERE  empno=?";
        
        try (Connection insertarConexion = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparadoStmt = insertarConexion.prepareStatement(sql)) {
            preparadoStmt.setInt(1, numEmpleado);

            int filasAfectadas = preparadoStmt.executeUpdate();

            if (filasAfectadas == 1) {
                return "¡El registro se ha eliminado correctamente!";
            }
            return "No se ha podido eliminar el registro o algo ha salido mal.";
        } catch (SQLException e) {
            return "Error al intentar eliminar el registro: " + e.getMessage();
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------------------
    public static String actualizarRegistro(int numEmpleado, String nombre, String trabajo, int manager,
            Date fechaContrato, int salario, int comision, int numDepartamento) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            return "No se encuentra el driver!";
        }
        String sql = "UPDATE emp SET  ename= ?,job= ?,mgr= ?,hiredate= ?,sal= ?,comm= ?,deptno= ? WHERE empno=?  ";

        try (Connection insertarConexion = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparadoStmt = insertarConexion.prepareStatement(sql)) {
            preparadoStmt.setString(1, nombre);
            preparadoStmt.setString(2, trabajo);
            preparadoStmt.setInt(3, manager);
            preparadoStmt.setDate(4, fechaContrato);
            preparadoStmt.setInt(5, salario);
            preparadoStmt.setInt(6, comision);
            preparadoStmt.setInt(7, numDepartamento);
            preparadoStmt.setInt(8, numEmpleado);

            int filasAfectadas = preparadoStmt.executeUpdate();

            if (filasAfectadas > 0) {
                return "¡El registro se ha actualizado correctamente!";
            }
        } catch (SQLException e) {
            return "Error al actualizar el registro: " + e.getMessage();
        }
        return "No se ha podido actualizar el registro.";
    }

    //----------------------------------------------------------------------------------------------------------------------------------------
    
    public static Empleado consultaRegistro(int numEmpleado) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            return null;
        }
        String sql = "SELECT * FROM emp WHERE empno=?";

        try (Connection insertarConexion = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparadoStmt = insertarConexion.prepareStatement(sql)) {
            preparadoStmt.setInt(1, numEmpleado);
            try (ResultSet rs = preparadoStmt.executeQuery()) {
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                Integer mgr = Integer.parseInt(rs.getString("mgr"));
                Date hireDate = rs.getDate("hireDate");
                int sal = rs.getInt("sal");
                Integer comm = Integer.parseInt(rs.getString("comm"));
                int deptno = rs.getInt("deptno");
                return new Empleado(numEmpleado, ename, job, mgr, hireDate, sal, comm, deptno);
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    //----------------------------------------------------------------------------------------------------------------------------------------
    
    public static ArrayList<Empleado> mostrarListado() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            return null;
        }
        String sql = "SELECT * FROM emp";

        try (Connection insertarConexion = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement preparadoStmt = insertarConexion.prepareStatement(sql)) {
            ArrayList<Empleado> emps = new ArrayList<>();
            int empno;
                String ename;
                String job;
                Integer mgr;
                Date hireDate;
                int sal;
                Integer comm;
                int deptno;

            try (ResultSet rs = preparadoStmt.executeQuery()) {
                while (rs.next()) {
                    empno = rs.getInt("empno");
                    ename = rs.getString("ename");
                    job = rs.getString("job");
                    mgr = Integer.parseInt(rs.getString("mgr"));
                    hireDate = rs.getDate("hireDate");
                    sal = rs.getInt("sal");
                    comm = Integer.parseInt(rs.getString("comm"));
                    deptno = rs.getInt("deptno");
                    emps.add(new Empleado(empno, ename, job, mgr, hireDate, sal, comm, deptno));
                }
            }
            return emps;
        } catch (SQLException e) {
            return null;
        }
    }
}

// (int empno, String ename, String job, Integer mgr, Date hireDate, int sal, Integer comm, int deptno)