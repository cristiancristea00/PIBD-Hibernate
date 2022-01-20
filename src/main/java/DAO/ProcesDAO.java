package DAO;

import JavaBean.Proces;

import java.util.List;

public interface ProcesDAO
{
    void addProces(Proces proces);

    void deleteProces(Proces proces);

    void updateProces(Proces proces);

    Proces getProces(long ID_PROCES);

    List<Proces> getProcese();
}
