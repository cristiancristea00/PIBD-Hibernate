package JavaBean;

import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class Programare implements java.io.Serializable
{
    private Long ID_PROGRAMARE;
    private Judecator JUDECATOR;
    private Proces PROCES;
    private String ORAS;
    private String LOCATIE;
    private String SALA;
    private Date DATA;
    private Time ORA;

    public Programare()
    {
    }

    public Programare(Long ID_PROGRAMARE, Judecator JUDECATOR, Proces PROCES, String ORAS, String LOCATIE, String SALA, @NotNull Date DATA,
                      @NotNull Time ORA)
    {
        this.ID_PROGRAMARE = ID_PROGRAMARE;
        this.JUDECATOR = new Judecator(JUDECATOR);
        this.PROCES = new Proces(PROCES);
        this.ORAS = ORAS;
        this.LOCATIE = LOCATIE;
        this.SALA = SALA;
        this.DATA = new Date(DATA.getTime());
        this.ORA = new Time(ORA.getTime());
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

    public Date getDATA()
    {
        return new Date(DATA.getTime());
    }

    public void setDATA(@NotNull Date DATA)
    {
        this.DATA = new Date(DATA.getTime());
    }

    public Time getORA()
    {
        return new Time(ORA.getTime());
    }

    public void setORA(@NotNull Time ORA)
    {
        this.ORA = new Time(ORA.getTime());
    }
}
