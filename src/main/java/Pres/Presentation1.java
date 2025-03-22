package Pres;

import Dao.DaoImpl;
import Metier.MetierImpl;

public class Presentation1 {
    public static void main( String[] args ){
        //injection des dependances statiques <=>new
        DaoImpl d=new DaoImpl();
        MetierImpl m=new MetierImpl(d);
        System.out.println("res =" + m.calcul());
    }
}
