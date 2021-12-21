package Controller;

import DAOImplement.JudecatorDAOImpl;
import JavaBean.Judecator;
import org.jetbrains.annotations.NotNull;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class JudecatorController extends HttpServlet
{
    Judecator judecator = new Judecator();
    JudecatorDAOImpl judecatorDAO = new JudecatorDAOImpl();

    @Override
    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("addJudecator") != null)
        {
            judecator.setCNP(request.getParameter("CNP"));
            judecator.setNUME(request.getParameter("NUME"));
            judecator.setPRENUME(request.getParameter("PRENUME"));
            judecator.setSPECIALIZARE(request.getParameter("SPECIALIZARE"));

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            judecator.setDATA_NASTERII(Date.valueOf(LocalDate.parse(request.getParameter("DATA_NASTERII"), dateFormat)));
            judecator.setPRELUARE_MANDAT(Date.valueOf(LocalDate.parse(request.getParameter("PRELUARE_MANDAT"), dateFormat)));
            judecator.setEXPIRARE_MANDAT(Date.valueOf(LocalDate.parse(request.getParameter("EXPIRARE_MANDAT"), dateFormat)));

            judecatorDAO.addJudecator(judecator);
            RequestDispatcher dispatcher = request.getRequestDispatcher("addJudecator.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("displayJudecatori") != null)
        {
            List<Judecator> judecatorList = judecatorDAO.displayJudecatori();
            request.setAttribute("judecatorList", judecatorList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("displayJudecatori.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("deleteJudecator") != null)
        {
            Long ID_JUDECATOR = Long.parseLong(request.getParameter("ID_JUDECATOR"));
            judecator.setID_JUDECATOR(ID_JUDECATOR);
            judecatorDAO.deleteJudecator(judecator);
            RequestDispatcher dispatcher = request.getRequestDispatcher("deleteJudecator.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("updateJudecator") != null)
        {
            Long ID_JUDECATOR = Long.parseLong(request.getParameter("ID_JUDECATOR"));
            String CNP = request.getParameter("CNP");
            String NUME = request.getParameter("NUME");
            String PRENUME = request.getParameter("PRENUME");
            String SPECIALIZARE = request.getParameter("SPECIALIZARE");

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate DATA_NASTERII = LocalDate.parse(request.getParameter("DATA_NASTERII"), dateFormat);
            LocalDate PRELUARE_MANDAT = LocalDate.parse(request.getParameter("PRELUARE_MANDAT"), dateFormat);
            LocalDate EXPIRARE_MANDAT = LocalDate.parse(request.getParameter("EXPIRARE_MANDAT"), dateFormat);

            judecatorDAO.updateJudecator(ID_JUDECATOR, CNP, NUME, PRENUME, DATA_NASTERII, SPECIALIZARE, PRELUARE_MANDAT, EXPIRARE_MANDAT);
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateJudecator.jsp");
            dispatcher.forward(request, response);
        }
    }
}
