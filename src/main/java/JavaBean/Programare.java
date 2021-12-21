package JavaBean;

import org.jetbrains.annotations.NotNull;

import java.time.*;

public class Programare implements java.io.Serializable
{
    private Long ID_PROGRAMARE;
    private Judecator JUDECATOR;
    private Proces PROCES;
    private String ORAS;
    private String LOCATIE;
    private String SALA;
    private LocalDate DATA;
    private LocalTime ORA;

    public Programare()
    {
    }

    public Programare(Long ID_PROGRAMARE, Judecator JUDECATOR, Proces PROCES, String ORAS, String LOCATIE, String SALA, @NotNull LocalDate DATA,
                      @NotNull LocalTime ORA)
    {
        this.ID_PROGRAMARE = ID_PROGRAMARE;
        this.JUDECATOR = new Judecator(JUDECATOR);
        this.PROCES = new Proces(PROCES);
        this.ORAS = ORAS;
        this.LOCATIE = LOCATIE;
        this.SALA = SALA;
        this.DATA = DATA;
        this.ORA = ORA;
    }

    public Long getID_PROGRAMARE()
    {
        return ID_PROGRAMARE;
    }

    public void setID_PROGRAMARE(Long ID_PROGRAMARE)
    {
        this.ID_PROGRAMARE = ID_PROGRAMARE;
    }

    public Judecator getJUDECATOR()
    {
        return new Judecator(JUDECATOR);
    }

    public void setJUDECATOR(Judecator JUDECATOR)
    {
        this.JUDECATOR = new Judecator(JUDECATOR);
    }

    public Proces getPROCES()
    {
        return new Proces(PROCES);
    }

    public void setPROCES(Proces PROCES)
    {
        this.PROCES = new Proces(PROCES);
    }

    public String getORAS()
    {
        return ORAS;
    }

    public void setORAS(String ORAS)
    {
        this.ORAS = ORAS;
    }

    public String getLOCATIE()
    {
        return LOCATIE;
    }

    public void setLOCATIE(String LOCATIE)
    {
        this.LOCATIE = LOCATIE;
    }

    public String getSALA()
    {
        return SALA;
    }

    public void setSALA(String SALA)
    {
        this.SALA = SALA;
    }

    public LocalDate getDATA()
    {
        return DATA;
    }

    public void setDATA(@NotNull LocalDate DATA)
    {
        this.DATA = DATA;
    }

    public LocalTime getORA()
    {
        return ORA;
    }

    public void setORA(@NotNull LocalTime ORA)
    {
        this.ORA = ORA;
    }
}
