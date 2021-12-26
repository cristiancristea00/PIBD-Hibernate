package JavaBean;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Programare implements Serializable
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
        ID_PROGRAMARE = 0L;
        JUDECATOR = new Judecator();
        PROCES = new Proces();
        ORAS = "";
        LOCATIE = "";
        SALA = "";
        DATA = LocalDate.now();
        ORA = LocalTime.now();
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

    public void setDATA(LocalDate DATA)
    {
        this.DATA = DATA;
    }

    public LocalTime getORA()
    {
        return ORA;
    }

    public void setORA(LocalTime ORA)
    {
        this.ORA = ORA;
    }
}
