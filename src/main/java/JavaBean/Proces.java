package JavaBean;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Proces implements Serializable
{
    private Long ID_PROCES;
    private String NUMAR;
    private String OBIECT;
    private String MATERIE_JURIDICA;
    private String STADIU_PROCESUAL;
    private String RECLAMANT;
    private String PARAT;
    private Set<Programare> PROGRAMARI = new HashSet<>();

    public Proces()
    {
    }

    public Proces(Long ID_PROCES, String NUMAR, String OBIECT, String MATERIE_JURIDICA, String STADIU_PROCESUAL, String RECLAMANT, String PARAT,
                  Set<Programare> PROGRAMARI)
    {
        this.ID_PROCES = ID_PROCES;
        this.NUMAR = NUMAR;
        this.OBIECT = OBIECT;
        this.MATERIE_JURIDICA = MATERIE_JURIDICA;
        this.STADIU_PROCESUAL = STADIU_PROCESUAL;
        this.RECLAMANT = RECLAMANT;
        this.PARAT = PARAT;
        this.PROGRAMARI = new HashSet<>(PROGRAMARI);
    }

    public Proces(@NotNull Proces proces)
    {
        this.ID_PROCES = proces.getID_PROCES();
        this.NUMAR = proces.getNUMAR();
        this.OBIECT = proces.getOBIECT();
        this.MATERIE_JURIDICA = proces.getMATERIE_JURIDICA();
        this.STADIU_PROCESUAL = proces.getSTADIU_PROCESUAL();
        this.RECLAMANT = proces.getRECLAMANT();
        this.PARAT = proces.getPARAT();
        this.PROGRAMARI = new HashSet<>(proces.getPROGRAMARI());
    }

    public Long getID_PROCES()
    {
        return ID_PROCES;
    }

    public void setID_PROCES(Long ID_PROCES)
    {
        this.ID_PROCES = ID_PROCES;
    }

    public String getNUMAR()
    {
        return NUMAR;
    }

    public void setNUMAR(String NUMAR)
    {
        this.NUMAR = NUMAR;
    }

    public String getOBIECT()
    {
        return OBIECT;
    }

    public void setOBIECT(String OBIECT)
    {
        this.OBIECT = OBIECT;
    }

    public String getMATERIE_JURIDICA()
    {
        return MATERIE_JURIDICA;
    }

    public void setMATERIE_JURIDICA(String MATERIE_JURIDICA)
    {
        this.MATERIE_JURIDICA = MATERIE_JURIDICA;
    }

    public String getSTADIU_PROCESUAL()
    {
        return STADIU_PROCESUAL;
    }

    public void setSTADIU_PROCESUAL(String STADIU_PROCESUAL)
    {
        this.STADIU_PROCESUAL = STADIU_PROCESUAL;
    }

    public String getRECLAMANT()
    {
        return RECLAMANT;
    }

    public void setRECLAMANT(String RECLAMANT)
    {
        this.RECLAMANT = RECLAMANT;
    }

    public String getPARAT()
    {
        return PARAT;
    }

    public void setPARAT(String PARAT)
    {
        this.PARAT = PARAT;
    }

    public Set<Programare> getPROGRAMARI()
    {
        return new HashSet<>(PROGRAMARI);
    }

    public void setPROGRAMARI(Set<Programare> PROGRAMARI)
    {
        this.PROGRAMARI = new HashSet<>(PROGRAMARI);
    }
}
