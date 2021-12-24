package DAO;

import JavaBean.Judecator;

import java.time.LocalDate;
import java.util.List;

public interface JudecatorDAO
{
    void addJudecator(Judecator judecator);

    void deleteJudecator(Judecator judecator);

    void updateJudecator(Long ID_JUDECATOR, String CNP, String NUME, String PRENUME, String TELEFON, String EMAIL, String SPECIALIZARE,
                         LocalDate PRELUARE_MANDAT, LocalDate EXPIRARE_MANDAT);

    Judecator getJudecator(Long ID_JUDECATOR);

    List<Judecator> displayJudecatori();
}
