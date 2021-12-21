package DAO;

import JavaBean.Judecator;

import java.time.LocalDate;
import java.util.List;

public interface JudecatorDAO
{
    void addJudecator(Judecator judecator);

    void deleteJudecator(Judecator judecator);

    void updateJudecator(Long ID_JUDECATOR, String CNP, String NUME, String PRENUME, LocalDate DATA_NASTERII, String SPECIALIZARE,
                         LocalDate PRELUARE_MANDAT, LocalDate EXPIRARE_MANDAT);

    List<Judecator> displayJudecatori();
}
