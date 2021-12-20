package Controller;

import DAOImplement.JudecatorDAOImpl;
import JavaBean.Judecator;

import java.text.*;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JudecatorController extends HttpServlet
{
    Judecator judecator = new Judecator();
    JudecatorDAOImpl judecatorDAO = new JudecatorDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("addJudecator") != null)
        {
            judecator.setCNP(request.getParameter("CNP"));
            judecator.setNUME(request.getParameter("NUME"));
            judecator.setPRENUME(request.getParameter("PRENUME"));
            judecator.setSPECIALIZARE(request.getParameter("SPECIALIZARE"));

            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            try
            {
                judecator.setDATA_NASTERII(dateFormat.parse(request.getParameter("DATA_NASTERII")));
                judecator.setPRELUARE_MANDAT(dateFormat.parse(request.getParameter("PRELUARE_MANDAT")));
                judecator.setEXPIRARE_MANDAT(dateFormat.parse(request.getParameter("EXPIRARE_MANDAT")));
            }
            catch (ParseException exception)
            {
                exception.printStackTrace();
            }

            judecatorDAO.addJudecator(judecator);
            RequestDispatcher dispatcher = request.getRequestDispatcher("addJudecator.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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

            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date DATA_NASTERII = null;
            Date PRELUARE_MANDAT = null;
            Date EXPIRARE_MANDAT = null;
            try
            {
                DATA_NASTERII = dateFormat.parse(request.getParameter("DATA_NASTERII"));
                PRELUARE_MANDAT = dateFormat.parse(request.getParameter("PRELUARE_MANDAT"));
                EXPIRARE_MANDAT = dateFormat.parse(request.getParameter("EXPIRARE_MANDAT"));
            }
            catch (ParseException exception)
            {
                exception.printStackTrace();
            }

            assert DATA_NASTERII != null;
            assert PRELUARE_MANDAT != null;
            assert EXPIRARE_MANDAT != null;
            judecatorDAO.updateJudecator(ID_JUDECATOR, CNP, NUME, PRENUME, DATA_NASTERII, SPECIALIZARE, PRELUARE_MANDAT, EXPIRARE_MANDAT);
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateJudecator.jsp");
            dispatcher.forward(request, response);
        }
    }
}
