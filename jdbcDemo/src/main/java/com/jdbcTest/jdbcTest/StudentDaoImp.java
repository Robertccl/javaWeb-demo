package com.jdbcTest.jdbcTest;

import java.util.List;  

import javax.sql.DataSource;  
  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowCallbackHandler;  
  
  
public class StudentDaoImp implements StudentDao{  
  
    private DataSource datasource;  
    private JdbcTemplate jdbcTemplateObject;  
      
      
    public void setdatasource(DataSource ds) {  
        this.datasource = ds;  
        this.jdbcTemplateObject = new JdbcTemplate(datasource);       
    }  
  
    public void addstudent(Student student) {  
        String sql = "INSERT INTO student(ID,name,age,FM)VALUES(?,?,?,?)";  
          
        jdbcTemplateObject.update(sql, student.getID(),  
                student.getname(),student.getage(),student.getFM());  
        return ;  
    }  
  
    public void delstudentbyID(String ID) {  
        String sql = "DELETE FROM student WHERE ID=?";  
        jdbcTemplateObject.update(sql,ID);  
        return ;  
    }  
  
    public void delstudentbyname(String name) {  
        String sql = "DELETE FROM student WHERE name=?";  
        jdbcTemplateObject.update(sql,name);  
        return ;          
    }  
  
    public void delallstudent() {  
        String sql = "DELETE FROM student";  
        jdbcTemplateObject.update(sql);  
        return ;      
    }  
  
    public void updstudent(Student student) {  
        String sql = "UPDATE student set name=?,age=?,FM=? WHERE ID=?";  
        jdbcTemplateObject.update(sql,student.getname(),  
                student.getage(),student.getFM(),student.getID());  
        return ;  
    }  
  
    public List<Student> allstudent() {  
        List<Student> students = null;  
        String sql = "SELECT * FROM student";  
        students = jdbcTemplateObject.query(sql, new StudentMapper());  
        return students;  
    }  
  
    public List<Student> querystudentbyID(String ID) {  
        List<Student> students = null;  
        String sql = "SELECT * FROM student WHERE ID=?";  
        students = jdbcTemplateObject.query(sql, new Object[]{ID}, new StudentMapper());  
        return students;  
    }  
  
    public List<Student> querystudentbyname(String name) {  
        List<Student> students = null;  
        String sql = "SELECT * FROM student WHERE name=?";  
        students = jdbcTemplateObject.query(sql, new Object[]{name}, new StudentMapper());  
        return students;  
    }  
  
    public List<Student> querystudentbyage(int age) {  
        List<Student> students = null;  
        String sql = "SELECT * FROM student WHERE age=?";  
        students = jdbcTemplateObject.query(sql, new Object[]{age}, new StudentMapper());  
        return students;  
    }  
      
    public void displayall(){  
        List<Student> students = allstudent();  
        for(Student s : students){  
            s.display();  
        }  
    }  
      
      
}  