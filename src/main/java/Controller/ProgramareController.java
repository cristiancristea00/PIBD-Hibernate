package Controller;

import DAOImplement.ProgramareDAOImpl;
import DAOImplement.HibernateUtil;
import JavaBean.Judecator;
import JavaBean.Proces;
import JavaBean.Programare;
import org.hibernate.Session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProgramareController extends HttpServlet
{
    Programare programare = new Programare();
    ProgramareDAOImpl programareDAO = new ProgramareDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("addProgramare") != null)
        {
            Long ID_JUDECATOR = Long.parseLong(request.getParameter("ID_JUDECATOR"));
            Long ID_PROCES = Long.parseLong(request.getParameter("ID_PROCES"));
            Session session = HibernateUtil.getSessionFactory().openSession();
            programare.setJUDECATOR(session.get(Judecator.class, ID_JUDECATOR));
            programare.setPROCES(session.get(Proces.class, ID_PROCES));
            session.close();

            programare.setORAS(request.getParameter("ORAS"));
            programare.setLOCATIE(request.getParameter("LOCATIE"));
            programare.setSALA(request.getParameter("SALA"));

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            programare.setDATA(LocalDate.parse(request.getParameter("DATA"), dateFormat));

            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
            programare.setORA(LocalTime.parse(request.getParameter("ORA"), timeFormat));

            programareDAO.addProgramare(programare);
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProgramare.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("displayProgramari") != null)
        {
            List<Programare> programareList = programareDAO.displayProgramari();
            request.setAttribute("programareList", programareList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("displayProgramari.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("deleteProgramare") != null)
        {
            Long ID_PROGRAMARE = Long.parseLong(request.getParameter("ID_PROGRAMARE"));
            programare.setID_PROGRAMARE(ID_PROGRAMARE);
            programareDAO.deleteProgramare(programare);
            RequestDispatcher dispatcher = request.getRequestDispatcher("deleteProgramare.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("updateProgramare") != null)
        {
            Long ID_PROGRAMARE = Long.parseLong(request.getParameter("ID_PROGRAMARE"));
            Session session = HibernateUtil.getSessionFactory().openSession();
            Long ID_JUDECATOR = Long.parseLong(request.getParameter("ID_JUDECATOR"));
            Long ID_PROCES = Long.parseLong(request.getParameter("ID_PROCES"));
            Judecator JUDECATOR = session.get(Judecator.class, ID_JUDECATOR);
            Proces PROCES = session.get(Proces.class, ID_PROCES);

            String ORAS = request.getParameter("ORAS");
            String LOCATIE = request.getParameter("LOCATIE");
            String SALA = request.getParameter("SALA");

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate DATA = LocalDate.parse(request.getParameter("DATA"), dateFormat);

            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime ORA = LocalTime.parse(request.getParameter("ORA"), timeFormat);

            programareDAO.updateProgramare(ID_PROGRAMARE, JUDECATOR, PROCES, ORAS, LOCATIE, SALA, DATA, ORA);
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProgramare.jsp");
            dispatcher.forward(request, response);
            session.close();
        }
    }
}
