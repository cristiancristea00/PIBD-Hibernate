package JavaBean;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Judecator implements Serializable
{
    private Long ID_JUDECATOR;
    private String CNP;
    private String NUME;
    private String PRENUME;
    private String TELEFON;
    private String EMAIL;
    private String SPECIALIZARE;
    private LocalDate PRELUARE_MANDAT;
    private LocalDate EXPIRARE_MANDAT;
    private Set<Programare> PROGRAMARI;

    public Judecator()
    {
        ID_JUDECATOR = 0L;
        CNP = "";
        NUME = "";
        PRENUME = "";
        TELEFON = "";
        EMAIL = "";
        SPECIALIZARE = "";
        PRELUARE_MANDAT = LocalDate.now();
        EXPIRARE_MANDAT = LocalDate.now();
        PROGRAMARI = new HashSet<>();
    }

    public Judecator(Long ID_JUDECATOR, String CNP, String NUME, String PRENUME, String TELEFON, String EMAIL, String SPECIALIZARE,
                     LocalDate PRELUARE_MANDAT, LocalDate EXPIRARE_MANDAT, Set<Programare> PROGRAMARI)
    {
        this.ID_JUDECATOR = ID_JUDECATOR;
        this.CNP = CNP;
        this.NUME = NUME;
        this.PRENUME = PRENUME;
        this.TELEFON = TELEFON;
        this.EMAIL = EMAIL;
        this.SPECIALIZARE = SPECIALIZARE;
        this.PRELUARE_MANDAT = PRELUARE_MANDAT;
        this.EXPIRARE_MANDAT = EXPIRARE_MANDAT;
        this.PROGRAMARI = new HashSet<>(PROGRAMARI);
    }

    public Judecator(@NotNull Judecator judecator)
    {
        this.ID_JUDECATOR = judecator.getID_JUDECATOR();
        this.CNP = judecator.getCNP();
        this.NUME = judecator.getNUME();
        this.PRENUME = judecator.getPRENUME();
        this.TELEFON = judecator.getTELEFON();
        this.EMAIL = judecator.getEMAIL();
        this.SPECIALIZARE = judecator.getSPECIALIZARE();
        this.PRELUARE_MANDAT = judecator.getPRELUARE_MANDAT();
        this.EXPIRARE_MANDAT = judecator.getEXPIRARE_MANDAT();
        this.PROGRAMARI = new HashSet<>(judecator.getPROGRAMARI());
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

    public String getTELEFON()
    {
        return TELEFON;
    }

    public void setTELEFON(String TELEFON)
    {
        this.TELEFON = TELEFON;
    }

    public String getEMAIL()
    {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL)
    {
        this.EMAIL = EMAIL;
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

    public Set<Programare> getPROGRAMARI()
    {
        return new HashSet<>(PROGRAMARI);
    }

    public void setPROGRAMARI(Set<Programare> PROGRAMARI)
    {
        this.PROGRAMARI = new HashSet<>(PROGRAMARI);
    }
}
