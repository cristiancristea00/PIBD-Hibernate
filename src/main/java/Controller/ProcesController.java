package Controller;

import DAOImplement.ProcesDAOImpl;
import JavaBean.Proces;
import org.jetbrains.annotations.NotNull;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ProcesController extends HttpServlet
{
    Proces proces = new Proces();
    ProcesDAOImpl procesDAO = new ProcesDAOImpl();

    @Override
    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("displayProcese") != null)
        {
            List<Proces> procese = procesDAO.displayProcese();
            request.setAttribute("procesList", procese);
            RequestDispatcher dispatcher = request.getRequestDispatcher("displayProcese.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if (request.getParameter("addProces") != null)
        {
            proces.setNUMAR(request.getParameter("Numar_add"));
            proces.setOBIECT(request.getParameter("Obiect_add"));
            proces.setMATERIE_JURIDICA(request.getParameter("Materie_juridica_add"));
            proces.setSTADIU_PROCESUAL(request.getParameter("Stadiu_procesual_add"));
            proces.setRECLAMANT(request.getParameter("Reclamant_add"));
            proces.setPARAT(request.getParameter("Parat_add"));

            procesDAO.addProces(proces);
            response.sendRedirect("/");
        }
        else if (request.getParameter("updateProces") != null)
        {
            Long ID_PROCES = Long.parseLong(request.getParameter("Select_proces_Update"));
            proces = procesDAO.getProces(ID_PROCES);

            String NUMAR = request.getParameter("Numar_update");
            NUMAR = NUMAR.length() == 0 ? proces.getNUMAR() : NUMAR;
            String OBIECT = request.getParameter("Obiect_update");
            OBIECT = OBIECT.length() == 0 ? proces.getOBIECT() : OBIECT;
            String MATERIE_JURIDICA = request.getParameter("Majerie_juridica_update");
            MATERIE_JURIDICA = MATERIE_JURIDICA.length() == 0 ? proces.getMATERIE_JURIDICA() : MATERIE_JURIDICA;
            String STADIU_PROCESUAL = request.getParameter("Satdiu_procesual_update");
            STADIU_PROCESUAL = STADIU_PROCESUAL.length() == 0 ? proces.getSTADIU_PROCESUAL() : STADIU_PROCESUAL;
            String RECLAMANT = request.getParameter("Reclamant_update");
            RECLAMANT = RECLAMANT.length() == 0 ? proces.getRECLAMANT() : RECLAMANT;
            String PARAT = request.getParameter("Parat_update");
            PARAT = PARAT.length() == 0 ? proces.getPARAT() : PARAT;

            procesDAO.updateProces(ID_PROCES, NUMAR, OBIECT, MATERIE_JURIDICA, STADIU_PROCESUAL, RECLAMANT, PARAT);
            response.sendRedirect("Procese?displayProcese=Tabelul+cu+procese");
        }
        else if (request.getParameter("deleteProces") != null)
        {
            Long ID_PROCES = Long.parseLong(request.getParameter("Select_proces_Delete"));
            proces.setID_PROCES(ID_PROCES);
            procesDAO.deleteProces(proces);
            response.sendRedirect("Procese?displayProcese=Tabelul+cu+procese");
        }
    }

    @Override
    public String getServletInfo()
    {
        return "Controller for Procese Servlet";
    }
}
