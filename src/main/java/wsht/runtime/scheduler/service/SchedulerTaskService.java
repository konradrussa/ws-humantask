package wsht.runtime.scheduler.service;

import java.util.Date;
import java.util.Map;

import wsht.runtime.exceptions.WSHTSystemSchedulerException;
import wsht.runtime.scheduler.enums.TaskParameterTypeEnum;

/**
 * Realizuje funkcjonalność schedulera. Zarządza zadaniami.
 * Pozwalada na usuniecie, zdefiniowanie nowego zadania.
 * Wywołuje zdefiniowane zadania w określonym czasie.
 */
public interface SchedulerTaskService {

    /**
     * Dodaje nowe zadanie do schedulera
     * @param taskID Unikalny identyfikator zadania(someID, taskID)
     * @param runTime Czas wywołania zadania
     * @param parameters Parametry wejściowe (kontekst) "joba"
     * @param taskClass Klasa "joba", typ zadania
     * @throws WSHTSystemSchedulerException Wyjatek schedulera
     */
    public void addTask(Long taskID, Date runTime, Map<TaskParameterTypeEnum, Object> parameters,
            Class<?> jobClass) throws WSHTSystemSchedulerException;


    /**
     * Usuwa określone zadanie z schedulera
     * @param aTaskID Unikalny identyfikator zadania(someID, taskID)
     * @param taskClass Klasa "joba", typ zadania
     * @return Czy usunięto zadanie
     * @throws WSHTSystemSchedulerException Wyjatek schedulera
     */
    public boolean deleteTask(Long aTaskID, Class<?> jobClass) throws WSHTSystemSchedulerException;
}
