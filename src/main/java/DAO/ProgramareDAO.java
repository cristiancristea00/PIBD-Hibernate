package DAO;

import JavaBean.Programare;

import java.util.List;

public interface ProgramareDAO
{
    void addProgramare(Programare programare);

    void deleteProgramare(Programare programare);

    void updateProgramare(Programare programare);

    Programare getProgramare(long ID_PROGRAMARE);

    List<Programare> getProgramari();
}
