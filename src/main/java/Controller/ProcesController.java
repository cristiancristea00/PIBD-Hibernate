package Controller;

import DAOImplement.ProcesDAOImpl;
import JavaBean.Proces;
import org.jetbrains.annotations.NotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProcesController extends HttpServlet
{
    Proces proces = new Proces();
    ProcesDAOImpl procesDAO = new ProcesDAOImpl();

    @Override
    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("addProces") != null)
        {
            proces.setNUMAR(request.getParameter("NUMAR"));
            proces.setOBIECT(request.getParameter("OBIECT"));
            proces.setMATERIE_JURIDICA(request.getParameter("MATERIE_JURIDICA"));
            proces.setSTADIU_PROCESUAL(request.getParameter("STADIU_PROCESUAL"));
            proces.setRECLAMANT(request.getParameter("RECLAMANT"));
            proces.setPARAT(request.getParameter("PARAT"));

            procesDAO.addProces(proces);
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProces.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("displayProcese") != null)
        {
            List<Proces> procese = procesDAO.displayProcese();
            request.setAttribute("proceseList", procese);
            RequestDispatcher dispatcher = request.getRequestDispatcher("displayProcese.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("deleteProces") != null)
        {
            Long ID_PROCES = Long.parseLong(request.getParameter("ID_PROCES"));
            proces.setID_PROCES(ID_PROCES);
            procesDAO.deleteProces(proces);
            RequestDispatcher dispatcher = request.getRequestDispatcher("deleteProces.jsp");
            dispatcher.forward(request, response);
        }
        if (request.getParameter("updateProces") != null)
        {
            Long ID_PROCES = Long.parseLong(request.getParameter("ID_PROCES"));
            String NUMAR = request.getParameter("NUMAR");
            String OBIECT = request.getParameter("OBIECT");
            String MATERIE_JURIDICA = request.getParameter("MATERIE_JURIDICA");
            String STADIU_PROCESUAL = request.getParameter("STADIU_PROCESUAL");
            String RECLAMANT = request.getParameter("RECLAMANT");
            String PARAT = request.getParameter("PARAT");

            procesDAO.updateProces(ID_PROCES, NUMAR, OBIECT, MATERIE_JURIDICA, STADIU_PROCESUAL, RECLAMANT, PARAT);
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProces.jsp");
            dispatcher.forward(request, response);
        }
    }
}
