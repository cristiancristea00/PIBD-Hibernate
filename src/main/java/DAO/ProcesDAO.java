package DAO;

import JavaBean.Proces;

import java.util.List;

public interface ProcesDAO
{
    void addProces(Proces proces);

    void deleteProces(Proces proces);

    void updateProces(Long ID_PROCES, String NUMAR, String OBIECT, String MATERIE_JURIDICA, String STADIU_PROCESUAL, String RECLAMANT, String PARAT);

    Proces getProces(Long ID_PROCES);

    List<Proces> displayProcese();
}
