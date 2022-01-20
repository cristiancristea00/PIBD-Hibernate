package DAO;

import JavaBean.Judecator;

import java.util.List;

public interface JudecatorDAO
{
    void addJudecator(Judecator judecator);

    void deleteJudecator(Judecator judecator);

    void updateJudecator(Judecator judecator);

    Judecator getJudecator(long ID_JUDECATOR);

    List<Judecator> getJudecatori();
}
