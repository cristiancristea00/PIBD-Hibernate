package DAOImplement;

import DAO.ProcesDAO;
import JavaBean.Proces;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProcesDAOImpl implements ProcesDAO
{
    @Override
    public void addProces(Proces proces)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(proces);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteProces(Proces proces)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(proces);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateProces(long ID_PROCES, String NUMAR, String OBIECT, String MATERIE_JURIDICA, String STADIU_PROCESUAL, String RECLAMANT,
                             String PARAT)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Proces proces = session.load(Proces.class, ID_PROCES);
        proces.setNUMAR(NUMAR);
        proces.setOBIECT(OBIECT);
        proces.setMATERIE_JURIDICA(MATERIE_JURIDICA);
        proces.setSTADIU_PROCESUAL(STADIU_PROCESUAL);
        proces.setRECLAMANT(RECLAMANT);
        proces.setPARAT(PARAT);
        session.update(proces);
        transaction.commit();
        session.close();
    }

    @Override
    public Proces getProces(long ID_PROCES)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Proces proces = session.load(Proces.class, ID_PROCES);
        session.close();
        return proces;
    }

    @Override
    public List<Proces> displayProcese()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Proces> procesList = session.createQuery("from Proces").list();
        session.close();
        return procesList;
    }
}