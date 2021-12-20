package DAO;

import JavaBean.*;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public interface JudecatorDAO
{
    void addJudecator(Judecator judecator);

    void deleteJudecator(Judecator judecator);

    void updateJudecator(Long ID_JUDECATOR, String CNP, String NUME, String PRENUME, Date DATA_NASTERII, String SPECIALIZARE,
                         @NotNull Date PRELUARE_MANDAT, @NotNull Date EXPIRARE_MANDAT);

    List<Judecator> displayJudecatori();
}
