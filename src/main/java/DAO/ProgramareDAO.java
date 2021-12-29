package DAO;

import JavaBean.Judecator;
import JavaBean.Proces;
import JavaBean.Programare;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ProgramareDAO
{
    void addProgramare(Programare programare);

    void deleteProgramare(Programare programare);

    void updateProgramare(long ID_PROGRAMARE, Judecator JUDECATOR, Proces PROCES, String ORAS, String LOCATIE, String SALA, @NotNull LocalDate DATA,
                          @NotNull LocalTime ORA);

    Programare getProgramare(long ID_PROGRAMARE);

    List<Programare> displayProgramari();
}
