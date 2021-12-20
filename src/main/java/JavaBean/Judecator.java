package JavaBean;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Judecator implements java.io.Serializable
{
    private Long ID_JUDECATOR;
    private String CNP;
    private String NUME;
    private String PRENUME;
    private Date DATA_NASTERII;
    private String SPECIALIZARE;
    private Date PRELUARE_MANDAT;
    private Date EXPIRARE_MANDAT;
    private Set<Programare> programari = new HashSet<>(0);

    public Judecator()
    {
    }

    public Judecator(Long ID_JUDECATOR, String CNP, String NUME, String PRENUME, Date DATA_NASTERII, String SPECIALIZARE,
                     @NotNull Date PRELUARE_MANDAT, @NotNull Date EXPIRARE_MANDAT, Set<Programare> programari)
    {
        this.ID_JUDECATOR = ID_JUDECATOR;
        this.CNP = CNP;
        this.NUME = NUME;
        this.PRENUME = PRENUME;
        this.DATA_NASTERII = new Date(DATA_NASTERII.getTime());
        this.SPECIALIZARE = SPECIALIZARE;
        this.PRELUARE_MANDAT = new Date(PRELUARE_MANDAT.getTime());
        this.EXPIRARE_MANDAT = new Date(EXPIRARE_MANDAT.getTime());
        this.programari = new HashSet<>(programari);
    }

    public Judecator(@NotNull Judecator judecator)
    {
        this.ID_JUDECATOR = judecator.getID_JUDECATOR();
        this.CNP = judecator.getCNP();
        this.NUME = judecator.getNUME();
        this.PRENUME = judecator.getPRENUME();
        this.DATA_NASTERII = judecator.getDATA_NASTERII();
        this.SPECIALIZARE = judecator.getSPECIALIZARE();
        this.PRELUARE_MANDAT = new Date(judecator.getPRELUARE_MANDAT().getTime());
        this.EXPIRARE_MANDAT = new Date(judecator.getEXPIRARE_MANDAT().getTime());
        this.programari = new HashSet<>(judecator.getProgramari());
    }

    public Long getID_JUDECATOR()
    {
        return ID_JUDECATOR;
    }

    public void setID_JUDECATOR(Long ID_JUDECATOR)
    {
        this.ID_JUDECATOR = ID_JUDECATOR;
    }

    public String getCNP()
    {
        return CNP;
    }

    public void setCNP(String CNP)
    {
        this.CNP = CNP;
    }

    public String getNUME()
    {
        return NUME;
    }

    public void setNUME(String NUME)
    {
        this.NUME = NUME;
    }

    public String getPRENUME()
    {
        return PRENUME;
    }

    public void setPRENUME(String PRENUME)
    {
        this.PRENUME = PRENUME;
    }

    public Date getDATA_NASTERII()
    {
        return new Date(DATA_NASTERII.getTime());
    }

    public void setDATA_NASTERII(@NotNull Date DATA_NASTERII)
    {
        this.DATA_NASTERII = new Date(DATA_NASTERII.getTime());
    }

    public String getSPECIALIZARE()
    {
        return SPECIALIZARE;
    }

    public void setSPECIALIZARE(String SPECIALIZARE)
    {
        this.SPECIALIZARE = SPECIALIZARE;
    }

    public Date getPRELUARE_MANDAT()
    {
        return new Date(PRELUARE_MANDAT.getTime());
    }

    public void setPRELUARE_MANDAT(@NotNull Date PRELUARE_MANDAT)
    {
        this.PRELUARE_MANDAT = new Date(PRELUARE_MANDAT.getTime());
    }

    public Date getEXPIRARE_MANDAT()
    {
        return new Date(EXPIRARE_MANDAT.getTime());
    }

    public void setEXPIRARE_MANDAT(@NotNull Date EXPIRARE_MANDAT)
    {
        this.EXPIRARE_MANDAT = new Date(EXPIRARE_MANDAT.getTime());
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
