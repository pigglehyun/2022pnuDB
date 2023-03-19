package com.javadb.gradle;
import java.sql.*;
import java.util.Scanner;


public class jabaDBTest01 {
    public  static void main(String[] args){
        final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        PreparedStatement pstmt =null;
        String SQL = "select distant s.sname from s where not exists( select * from P" +
                            " where not exists(select * from sp where sp.sno = s.sno and sp.pno = p.pno and p.city = '";
        Scanner scan = new Scanner(System.in);
        String str;
        str = scan.nextLine();
        SQL = SQL+str+"'));";

        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/warehouse?validationQuery=select 1&useSSL=false&serverTimezone=Asia/Seoul",
                    "root", "0818"
            );
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
               String supplierName = rs.getString("sname");
               System.out.println(supplierName);
            }

        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
        }
    }
}
