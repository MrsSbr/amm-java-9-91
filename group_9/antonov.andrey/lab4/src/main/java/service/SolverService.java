package service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import entity.Country;
import entity.Sport;

public interface SolverService {

    /**
     * @return Нахождение Tоп-3 страны медального зачета
     */
    List<Country> getTop3BestCountries();

    /**
     * @return Нахождение для каждого вида спорта списка спортсменов, занявших места
     */
    Map<Sport, List<String>> getAthletesBySport();

    /**
     * @return Нахождение спортсмена, набравшего больше всего медалей
     */
    Optional<String> getBestAthlete();
}
