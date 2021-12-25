package Controller;

import DAOImplement.JudecatorDAOImpl;
import JavaBean.Judecator;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
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
            judecator.setCNP(request.getParameter("CNP_add"));
            judecator.setNUME(request.getParameter("Nume_add"));
            judecator.setPRENUME(request.getParameter("Prenume_add"));
            judecator.setTELEFON(request.getParameter("Telefon_add"));
            judecator.setEMAIL(request.getParameter("Email_add"));
            judecator.setSPECIALIZARE(request.getParameter("Specializare_add"));

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            judecator.setPRELUARE_MANDAT(LocalDate.parse(request.getParameter("Preluare_mandat_add"), dateFormat));
            judecator.setEXPIRARE_MANDAT(LocalDate.parse(request.getParameter("Expirare_mandat_add"), dateFormat));

            judecatorDAO.addJudecator(judecator);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        else if (request.getParameter("updateJudecator") != null)
        {
            Long ID_JUDECATOR = Long.parseLong(request.getParameter("Select_judecator_Update"));
            judecator = judecatorDAO.getJudecator(ID_JUDECATOR);

            String CNP = request.getParameter("CNP_update");
            CNP = CNP.length() == 0 ? judecator.getCNP() : CNP;
            String NUME = request.getParameter("Nume_update");
            NUME = NUME.length() == 0 ? judecator.getNUME() : NUME;
            String PRENUME = request.getParameter("Prenume_update");
            PRENUME = PRENUME.length() == 0 ? judecator.getPRENUME() : PRENUME;
            String TELEFON = request.getParameter("Telefon_update");
            TELEFON = TELEFON.length() == 0 ? judecator.getTELEFON() : TELEFON;
            String EMAIL = request.getParameter("Email_update");
            EMAIL = EMAIL.length() == 0 ? judecator.getEMAIL() : EMAIL;
            String SPECIALIZARE = request.getParameter("Specializare_update");
            SPECIALIZARE = SPECIALIZARE.length() == 0 ? judecator.getSPECIALIZARE() : SPECIALIZARE;

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String PRELUARE_MANDAT_STR = request.getParameter("Preluare_mandat_update");
            String EXPIRARE_MANDAT_STR = request.getParameter("Expirare_mandat_update");

            LocalDate PRELUARE_MANDAT = PRELUARE_MANDAT_STR.length() == 0 ? judecator.getPRELUARE_MANDAT() :
                    LocalDate.parse(PRELUARE_MANDAT_STR, dateFormat);
            LocalDate EXPIRARE_MANDAT = EXPIRARE_MANDAT_STR.length() == 0 ? judecator.getEXPIRARE_MANDAT() :
                    LocalDate.parse(EXPIRARE_MANDAT_STR, dateFormat);

            judecatorDAO.updateJudecator(ID_JUDECATOR, CNP, NUME, PRENUME, SPECIALIZARE, TELEFON, EMAIL, PRELUARE_MANDAT, EXPIRARE_MANDAT);
            response.sendRedirect("Judecatori?displayJudecatori=Tabelul+cu+judecători");
        }
        else if (request.getParameter("deleteJudecator") != null)
        {
            Long ID_JUDECATOR = Long.parseLong(request.getParameter("Select_judecator_Delete"));
            judecator.setID_JUDECATOR(ID_JUDECATOR);
            judecatorDAO.deleteJudecator(judecator);
            response.sendRedirect("Judecatori?displayJudecatori=Tabelul+cu+judecători");
        }
        else if (request.getParameter("displayJudecatori") != null)
        {
            List<Judecator> judecatorList = judecatorDAO.displayJudecatori();
            request.setAttribute("judecatorList", judecatorList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("displayJudecatori.jsp");
            dispatcher.forward(request, response);
        }
    }
}
