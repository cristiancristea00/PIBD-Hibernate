package JavaBean;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class Proces implements java.io.Serializable
{
    private Long ID_PROCES;
    private String NUMAR;
    private String OBIECT;
    private String MATERIE_JURIDICA;
    private String STADIU_PROCESUAL;
    private String RECLAMANT;
    private String PARAT;
    private Set<Programare> programari = new HashSet<>(0);

    public Proces() {
    }

    public Proces(Long ID_PROCES, String NUMAR, String OBIECT, String MATERIE_JURIDICA, String STADIU_PROCESUAL, String RECLAMANT, String PARAT,
                  Set<Programare> programari)
    {
        this.ID_PROCES = ID_PROCES;
        this.NUMAR = NUMAR;
        this.OBIECT = OBIECT;
        this.MATERIE_JURIDICA = MATERIE_JURIDICA;
        this.STADIU_PROCESUAL = STADIU_PROCESUAL;
        this.RECLAMANT = RECLAMANT;
        this.PARAT = PARAT;
        this.programari = new HashSet<>(programari);
    }

    public Proces(@NotNull Proces proces)
    {
        this.ID_PROCES = proces.ID_PROCES;
        this.NUMAR = proces.NUMAR;
        this.OBIECT = proces.OBIECT;
        this.MATERIE_JURIDICA = proces.MATERIE_JURIDICA;
        this.STADIU_PROCESUAL = proces.STADIU_PROCESUAL;
        this.RECLAMANT = proces.RECLAMANT;
        this.PARAT = proces.PARAT;
        this.programari = new HashSet<>(proces.programari);
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

    public Set<Programare> getProgramari()
    {
        return new HashSet<>(programari);
    }

    public void setProgramari(Set<Programare> programari)
    {
        this.programari = new HashSet<>(programari);
    }
}
