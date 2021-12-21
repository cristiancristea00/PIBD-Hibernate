package DAO;

import JavaBean.*;
import org.jetbrains.annotations.NotNull;

import java.time.*;
import java.util.List;

public interface ProgramareDAO
{
    void addProgramare(Programare programare);

    void deleteProgramare(Programare programare);

    void updateProgramare(Long ID_PROGRAMARE, Judecator JUDECATOR, Proces PROCES, String ORAS, String LOCATIE, String SALA, @NotNull LocalDate DATA,
                          @NotNull LocalTime ORA);

    List<Programare> displayProgramari();
}
