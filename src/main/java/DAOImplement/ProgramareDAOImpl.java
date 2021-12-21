package DAOImplement;

import JavaBean.*;
import org.hibernate.*;
import DAO.ProgramareDAO;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.sql.Time;
import java.time.*;
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
        programare.setDATA(Date.valueOf(DATA));
        programare.setORA(Time.valueOf(ORA));
        session.update(programare);
        transaction.commit();
        session.close();
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