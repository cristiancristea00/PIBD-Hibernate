package JavaBean;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Judecator implements java.io.Serializable
{
    private Long ID_JUDECATOR;
    private String CNP;
    private String NUME;
    private String PRENUME;
    private LocalDate DATA_NASTERII;
    private String SPECIALIZARE;
    private LocalDate PRELUARE_MANDAT;
    private LocalDate EXPIRARE_MANDAT;
    private Set<Programare> programari = new HashSet<>(0);

    public Judecator()
    {
    }

    public Judecator(Long ID_JUDECATOR, String CNP, String NUME, String PRENUME, LocalDate DATA_NASTERII, String SPECIALIZARE,
                     LocalDate PRELUARE_MANDAT, LocalDate EXPIRARE_MANDAT, Set<Programare> programari)
    {
        this.ID_JUDECATOR = ID_JUDECATOR;
        this.CNP = CNP;
        this.NUME = NUME;
        this.PRENUME = PRENUME;
        this.DATA_NASTERII = DATA_NASTERII;
        this.SPECIALIZARE = SPECIALIZARE;
        this.PRELUARE_MANDAT = PRELUARE_MANDAT;
        this.EXPIRARE_MANDAT = EXPIRARE_MANDAT;
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
        this.PRELUARE_MANDAT = judecator.getPRELUARE_MANDAT();
        this.EXPIRARE_MANDAT = judecator.getEXPIRARE_MANDAT();
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

    public LocalDate getDATA_NASTERII()
    {
        return DATA_NASTERII;
    }

    public void setDATA_NASTERII(LocalDate DATA_NASTERII)
    {
        this.DATA_NASTERII = DATA_NASTERII;
    }

    public String getSPECIALIZARE()
    {
        return SPECIALIZARE;
    }

    public void setSPECIALIZARE(String SPECIALIZARE)
    {
        this.SPECIALIZARE = SPECIALIZARE;
    }

    public LocalDate getPRELUARE_MANDAT()
    {
        return PRELUARE_MANDAT;
    }

    public void setPRELUARE_MANDAT(LocalDate PRELUARE_MANDAT)
    {
        this.PRELUARE_MANDAT = PRELUARE_MANDAT;
    }

    public LocalDate getEXPIRARE_MANDAT()
    {
        return EXPIRARE_MANDAT;
    }

    public void setEXPIRARE_MANDAT(LocalDate EXPIRARE_MANDAT)
    {
        this.EXPIRARE_MANDAT = EXPIRARE_MANDAT;
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
