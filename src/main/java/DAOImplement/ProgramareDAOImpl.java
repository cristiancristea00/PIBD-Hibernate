package DAOImplement;

import DAO.ProgramareDAO;
import JavaBean.Programare;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProgramareDAOImpl implements ProgramareDAO
{
    @Override
    public void addProgramare(Programare programare)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(programare);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteProgramare(Programare programare)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(programare);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateProgramare(Programare programare)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(programare);
        transaction.commit();
        session.close();
    }

    @Override
    public Programare getProgramare(long ID_PROGRAMARE)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Programare programare = session.load(Programare.class, ID_PROGRAMARE);
        session.close();
        return programare;
    }

    @Override
    public List<Programare> getProgramari()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Programare> programareList = session.createQuery("from Programare").list();
        session.close();
        return programareList;
    }
}