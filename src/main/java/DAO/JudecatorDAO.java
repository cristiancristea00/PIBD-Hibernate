package DAO;

import JavaBean.Judecator;

import java.time.LocalDate;
import java.util.List;

public interface JudecatorDAO
{
    void addJudecator(Judecator judecator);

    void deleteJudecator(Judecator judecator);

    void updateJudecator(long ID_JUDECATOR, String CNP, String NUME, String PRENUME, String TELEFON, String EMAIL, String SPECIALIZARE,
                         LocalDate PRELUARE_MANDAT, LocalDate EXPIRARE_MANDAT);

    Judecator getJudecator(long ID_JUDECATOR);

    List<Judecator> displayJudecatori();
}
