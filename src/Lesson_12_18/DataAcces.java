package Lesson_12_18;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface DataAcces <T> {

    default Connection getConnection(){
        return Connect.connect("jdbc:sqlite:C:\\Users\\Mogromir\\Downloads\\chinook\\chinook.db");
    }
    T create (T entity);
    User update (T entity);
    boolean delete (int id);
    List<T> findById (int id);
    List<T> getAll ();
    boolean deleteAll ();
}

class DaoUser implements DataAcces<User>{

    @Override
    public User create(User entity) {
        PreparedStatement pst;
        try {
            String insert="INSERT INTO User (ID, Name) VALUES (?, ?)";
            pst=getConnection().prepareStatement(insert);
            pst.setString(2,entity.name);
            pst.executeUpdate();

            int index=0;
            ResultSet rs=pst.getGeneratedKeys();
            index=rs.getInt(1);
            entity.id=index;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return entity;
    }

    @Override
    public List<User> findById(int id) {
        List<User> result = new ArrayList<>();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT ID,Name FROM User WHERE ID="+id);
            while (rs.next()==true){
                int index=rs.getInt(1);
                User tempUser=new User(rs.getString(2));
                tempUser.id=index;
                result.add(tempUser);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT ID,Name FROM User");
            while (rs.next()==true){
                int index=rs.getInt(1);
                User tempUser=new User(rs.getString(2));
                tempUser.id=index;
                result.add(tempUser);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public User update(User entity) {
        PreparedStatement pst;
        User result = entity;
        String update = "UPDATE User SET Name = ? WHERE ID="+entity.id;
        try {
            pst=getConnection().prepareStatement(update);
            pst.setString(1, entity.name);
            int temp = pst.executeUpdate();
            if (temp>0) {
                result.name = entity.name;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        PreparedStatement pst;
        String delete = "DELETE FROM User WHERE ID="+id;
        try {
            pst=getConnection().prepareStatement(delete);
            if (pst.executeUpdate()>0){
                result=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteAll() {
        boolean result = false;
        PreparedStatement pst;
        String delete = "DELETE FROM User";
        try {
            pst=getConnection().prepareStatement(delete);
            if (pst.executeUpdate()>0){
                result=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }



    public static void main(String[] args) {
        User user1=new User("Ivan");
        User user2=new User("Vasya");
        User user3=new User("Dima");
        DaoUser daoUser = new DaoUser();
        System.out.println(daoUser.create(user1));
        System.out.println(daoUser.create(user2));
        System.out.println(daoUser.create(user3));
        System.out.println("**********************************");
        System.out.println(daoUser.findById(48));
        System.out.println("**********************************");
        System.out.println(daoUser.getAll());
        System.out.println("**********************************");
        System.out.println(daoUser.update(user1));
        System.out.println("**********************************");
        System.out.println(daoUser.delete(50));
        System.out.println("**********************************");
        System.out.println(daoUser.deleteAll());
    }
}
