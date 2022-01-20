package DAOImplement;

import DAO.JudecatorDAO;
import JavaBean.Judecator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class JudecatorDAOImpl implements JudecatorDAO
{
    @Override
    public void addJudecator(Judecator judecator)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(judecator);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteJudecator(Judecator judecator)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(judecator);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateJudecator(Judecator judecator)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(judecator);
        transaction.commit();
        session.close();
    }

    @Override
    public Judecator getJudecator(long ID_JUDECATOR)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Judecator judecator = session.load(Judecator.class, ID_JUDECATOR);
        session.close();
        return judecator;
    }

    @Override
    public List<Judecator> getJudecatori()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Judecator> judecatorList = session.createQuery("from Judecator").list();
        session.close();
        return judecatorList;
    }
}
