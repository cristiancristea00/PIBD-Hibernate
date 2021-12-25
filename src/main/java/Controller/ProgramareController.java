package Controller;

import DAOImplement.HibernateUtil;
import DAOImplement.ProgramareDAOImpl;
import JavaBean.Judecator;
import JavaBean.Proces;
import JavaBean.Programare;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ProgramareController extends HttpServlet
{
    Programare programare = new Programare();
    ProgramareDAOImpl programareDAO = new ProgramareDAOImpl();

    @Override
    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("addProgramare") != null)
        {
            Long ID_JUDECATOR = Long.parseLong(request.getParameter("ID_Judecator_add"));
            Long ID_PROCES = Long.parseLong(request.getParameter("ID_Proces_add"));
            Session session = HibernateUtil.getSessionFactory().openSession();
            programare.setJUDECATOR(session.get(Judecator.class, ID_JUDECATOR));
            programare.setPROCES(session.get(Proces.class, ID_PROCES));
            session.close();

            programare.setORAS(request.getParameter("Oras_add"));
            programare.setLOCATIE(request.getParameter("Locatie_add"));
            programare.setSALA(request.getParameter("Sala_add"));

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            programare.setDATA(LocalDate.parse(request.getParameter("Data_add"), dateFormat));

            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
            programare.setORA(LocalTime.parse(request.getParameter("Ora_add"), timeFormat));

            programareDAO.addProgramare(programare);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        else if (request.getParameter("updateProgramare") != null)
        {
            Long ID_PROGRAMARE = Long.parseLong(request.getParameter("Select_programare_Update"));
            programare = programareDAO.getProgramare(ID_PROGRAMARE);

            Judecator JUDECATOR = programare.getJUDECATOR();
            Proces PROCES = programare.getPROCES();

            String ORAS = request.getParameter("Oras_update");
            ORAS = ORAS.length() == 0 ? programare.getORAS() : ORAS;
            String LOCATIE = request.getParameter("Locatie_update");
            LOCATIE = LOCATIE.length() == 0 ? programare.getLOCATIE() : LOCATIE;
            String SALA = request.getParameter("Sala_update");
            SALA = SALA.length() == 0 ? programare.getSALA() : SALA;

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String DATA_STR = request.getParameter("Data_update");
            LocalDate DATA = DATA_STR.length() == 0 ? programare.getDATA() : LocalDate.parse(DATA_STR, dateFormat);

            DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
            String ORA_STR = request.getParameter("Ora_update");
            LocalTime ORA = ORA_STR.length() == 0 ? programare.getORA() : LocalTime.parse(ORA_STR, timeFormat);

            programareDAO.updateProgramare(ID_PROGRAMARE, JUDECATOR, PROCES, ORAS, LOCATIE, SALA, DATA, ORA);
            response.sendRedirect("Programari?displayProgramari=Tabelul+cu+programări");
        }
        else if (request.getParameter("deleteProgramare") != null)
        {
            Long ID_PROGRAMARE = Long.parseLong(request.getParameter("Select_programare_Delete"));
            programare = programareDAO.getProgramare(ID_PROGRAMARE);
            programareDAO.deleteProgramare(programare);
            response.sendRedirect("Programari?displayProgramari=Tabelul+cu+programări");
        }
        else if (request.getParameter("displayProgramari") != null)
        {
            List<Programare> programareList = programareDAO.displayProgramari();
            request.setAttribute("programareList", programareList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("displayProgramari.jsp");
            dispatcher.forward(request, response);
        }
    }
}
