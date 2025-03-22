package Dao;

public class DaoImpl implements IDao{
    @Override
    public double getData() {
        System.out.println("version base de donnees");
        double t =23;
        return t;
    }
}
