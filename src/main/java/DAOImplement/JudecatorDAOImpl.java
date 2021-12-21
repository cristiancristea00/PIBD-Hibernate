package DAOImplement;

import DAO.JudecatorDAO;
import JavaBean.Judecator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
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
    public void updateJudecator(Long ID_JUDECATOR, String CNP, String NUME, String PRENUME, LocalDate DATA_NASTERII, String SPECIALIZARE,
                                LocalDate PRELUARE_MANDAT, LocalDate EXPIRARE_MANDAT)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Judecator judecator = session.load(Judecator.class, ID_JUDECATOR);
        judecator.setCNP(CNP);
        judecator.setNUME(NUME);
        judecator.setPRENUME(PRENUME);
        judecator.setDATA_NASTERII(Date.valueOf(DATA_NASTERII));
        judecator.setSPECIALIZARE(SPECIALIZARE);
        judecator.setPRELUARE_MANDAT(Date.valueOf(PRELUARE_MANDAT));
        judecator.setEXPIRARE_MANDAT(Date.valueOf(EXPIRARE_MANDAT));
        session.update(judecator);
        transaction.commit();
        session.close();
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
