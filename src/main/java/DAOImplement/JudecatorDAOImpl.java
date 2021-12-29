package DAOImplement;

import DAO.JudecatorDAO;
import JavaBean.Judecator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
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
    public void updateJudecator(long ID_JUDECATOR, String CNP, String NUME, String PRENUME, String SPECIALIZARE, String TELEFON, String EMAIL,
                                LocalDate PRELUARE_MANDAT, LocalDate EXPIRARE_MANDAT)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Judecator judecator = session.load(Judecator.class, ID_JUDECATOR);
        judecator.setCNP(CNP);
        judecator.setNUME(NUME);
        judecator.setPRENUME(PRENUME);
        judecator.setTELEFON(TELEFON);
        judecator.setEMAIL(EMAIL);
        judecator.setSPECIALIZARE(SPECIALIZARE);
        judecator.setPRELUARE_MANDAT(PRELUARE_MANDAT);
        judecator.setEXPIRARE_MANDAT(EXPIRARE_MANDAT);
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
    public List<Judecator> displayJudecatori()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Judecator> judecatorList = session.createQuery("from Judecator").list();
        session.close();
        return judecatorList;
    }
}
