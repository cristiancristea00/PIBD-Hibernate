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
    public void updateProces(Proces proces)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
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
    public List<Proces> getProcese()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Proces> procesList = session.createQuery("from Proces").list();
        session.close();
        return procesList;
    }
}