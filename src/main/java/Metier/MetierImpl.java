package Metier;

import Dao.IDao;

public class MetierImpl implements IMetier{
    private IDao dao;//couplage faible

    //injection des dependances via constructeur
    public MetierImpl(IDao dao){
        this.dao=dao;
    }
    @Override
    public double calcul() {
        double t= dao.getData();
        return t*2/3;
    }

    /**
     * pour injecter dans a variable dao
     * un objet de la classe qui implemente l'interface IDao
     */

    //injection des dependances via setters

    public void setDao( IDao dao){
        this.dao=dao;
    }

}
