package Pres;



import Dao.IDao;
import Metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main( String[] args ) throws  Exception{

        //injection des dependances dynamiques
        Scanner scanner=new Scanner(new File("config.txt"));
        //DaoImpl p=new DaoImpl();
        String daoClassName=scanner.nextLine();//la lecture du premiere ligne du fichier
        Class cdao=Class.forName(daoClassName);
        IDao d = (IDao) cdao.getConstructor().newInstance();

        String MetierClassName=scanner.nextLine();
        Class cmetier=Class.forName(MetierClassName);//charger la classe en memoire
        IMetier metier=(IMetier) cmetier.getConstructor(IDao.class).newInstance(d);

        //instanciation dynamique par la methode setDao
        Method setDao=cmetier.getDeclaredMethod("setDao",IDao.class);
        setDao.invoke(metier,d);//execution du methode sur objet Metier en transmettatnt en para objet IDao


        

        System.out.println(metier.calcul());
    }
}
