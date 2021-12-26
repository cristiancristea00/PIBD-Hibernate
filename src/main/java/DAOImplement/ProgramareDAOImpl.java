package DAOImplement;

import DAO.ProgramareDAO;
import JavaBean.Judecator;
import JavaBean.Proces;
import JavaBean.Programare;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
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
    public void updateProgramare(Long ID_PROGRAMARE, Judecator JUDECATOR, Proces PROCES, String ORAS, String LOCATIE, String SALA,
                                 @NotNull LocalDate DATA, @NotNull LocalTime ORA)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Programare programare = session.load(Programare.class, ID_PROGRAMARE);
        programare.setJUDECATOR(JUDECATOR);
        programare.setPROCES(PROCES);
        programare.setORAS(ORAS);
        programare.setLOCATIE(LOCATIE);
        programare.setSALA(SALA);
        programare.setDATA(DATA);
        programare.setORA(ORA);
        session.update(programare);
        transaction.commit();
        session.close();
    }

    @Override
    public Programare getProgramare(Long ID_PROGRAMARE)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Programare programare = session.load(Programare.class, ID_PROGRAMARE);
        session.close();
        return programare;
    }

    @Override
    public List<Programare> displayProgramari()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Programare> programareList = session.createQuery("from Programare").list();
        session.close();
        return programareList;
    }
}