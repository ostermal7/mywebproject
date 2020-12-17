package database;

import entity.Discipline;
import entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            ResultSet rs= stmt.executeQuery("SELECT * FROM student where status='1'");
            ArrayList<Student> arr=new ArrayList<Student>();
            while (rs.next()){
                Student student=new Student();
                student.setId(rs.getInt("id"));
                student.setGroup(rs.getString("group"));
                student.setName(rs.getString("name"));
                student.setDate(rs.getDate("dateofadmission"));
                student.setSername(rs.getString("sername"));
                arr.add(student);
            }
            for (Student s:arr) {
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void createNewDiscipline(String disc){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            stmt.execute("INSERT INTO `discipline` (`disciplines`) VALUES ('"+disc+"');");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteDiscipline(String id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            stmt.execute("UPDATE `discipline` SET `status` = '0' WHERE (`id` ="+id+");");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void modifyDiscipline(String id,String discipline){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            stmt.execute("UPDATE `discipline` SET `disciplines` = '"+discipline+"' WHERE (`id` = '"+id+"');");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Discipline> getAllActiveDisciplines(){
        ArrayList<Discipline> arr=new ArrayList<Discipline>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM discipline where status='1';");
            while (rs.next()){
                Discipline discipline=new Discipline();
                discipline.setDiscId(rs.getInt("id"));
                discipline.setDiscName(rs.getString("disciplines"));
                arr.add(discipline);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }
    public static Discipline getDisciplineById(String id){
        Discipline discipline=new Discipline();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM discipline where status='1' and id="+id+";");
            while (rs.next()){
                discipline.setDiscId(rs.getInt("id"));
                discipline.setDiscName(rs.getString("disciplines"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return discipline;
    }
    public static ArrayList<Student> getAllActiveStudents(){
        ArrayList<Student> studentArr=new ArrayList<Student>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM student where status='1';");
            while (rs.next()){
                Student student=new Student();
                student.setId(rs.getInt("id"));
                student.setSername(rs.getString("sername"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("dateofadmission"));
                studentArr.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentArr;
    }
    public static void createNewStudent(String sername, String name, String group, Date date){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            stmt.execute("INSERT INTO `student` (`sername`, `name`, `group`, `dateofadmission`) VALUES ('"+sername+"', '"+name+"', '"+group+"', '"+date+"');");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteStudent(String id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = "+id+");");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static Student getStudentById(String id){
        Student student=new Student();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM student where status='1' and id="+id+";");
            while (rs.next()){
                student.setId(rs.getInt("id"));
                student.setSername(rs.getString("sername"));
                student.setName(rs.getString("name"));
                student.setGroup(rs.getString("group"));
                student.setDate(rs.getDate("dateofadmission"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }
    public static void modifyStudent(String id,String sername,String name,String group,Date date){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/students_15?user=root&password=elizaveta&useUnicode=true&serverTimezone=UTC&useSSL=false");
            Statement stmt=conn.createStatement();
            stmt.execute("UPDATE `student` SET `sername` = '"+sername+"', `name` = '"+name+"', `group` = '"+group+"', `dateofadmission` = '"+date+"' WHERE (`id` = '"+id+"');");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
