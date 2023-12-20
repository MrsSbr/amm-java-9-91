package org.example;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;

public class BicycleRaceTask {
    private static final int NOW_YEAR = LocalDate.now().getYear();

    // Участники гонок, которые занимали призовые места за последние 3 года
    public Set<Integer> findAthletesWithPrizesInThreeYears(Collection<BicycleRace> BicycleRaces) {
        int threeYearsAgo = NOW_YEAR - 3;
        Set<Integer> winnersThisYear = new HashSet<>();
        BicycleRaces.stream()
                .filter(x -> x.getDateRace().getYear() <= NOW_YEAR &&
                        x.getDateRace().getYear() > threeYearsAgo)
                .forEach(x -> {
                    winnersThisYear.add(x.getFinalList().get(1));
                    winnersThisYear.add(x.getFinalList().get(2));
                    winnersThisYear.add(x.getFinalList().get(3));
                });
        return winnersThisYear;
    }

    //Посчитать количество спортсменов, которые выигрывали гонку
    public int countWinner(Collection<BicycleRace> BicycleRaces) {
        Set<Integer> winners = new HashSet<>();
        BicycleRaces
                .forEach(x -> winners.add(x.getFinalList().get(1)));
        return winners.size();
    }

    //Найти всех спортсменов, которые занимали места за последний год, при чем до этого 5 лет участвовали в гонках,
    //но не занимали мест
    public Set<Integer> findAthletesByCondition(Collection<BicycleRace> BicycleRaces) {
        int fiveYearsAgo = NOW_YEAR - 5;
        Set<Integer> winnersThisYear = new HashSet<>();
        Set<Integer> notWinFiveYears = new HashSet<>();
        BicycleRaces.stream()
                .filter(x -> x.getDateRace().getYear() >= fiveYearsAgo)
                .forEach(x -> {
                    if (x.getDateRace().getYear() == NOW_YEAR) {
                        winnersThisYear.add(x.getFinalList().get(1));
                        winnersThisYear.add(x.getFinalList().get(2));
                        winnersThisYear.add(x.getFinalList().get(3));
                    } else {
                        for (int i = 1; i <= x.getNumbersParticipant().size(); i++) {
                            if (i < 4) {
                                winnersThisYear.remove(x.getFinalList().get(i)); //т. к. в notWin может добавится повторно позже при прохождении условия
                            } else {
                                notWinFiveYears.add(x.getFinalList().get(i));
                            }
                        }
                    }
                });
        Set<Integer> res = new HashSet<>();
        winnersThisYear.stream()
                .filter(notWinFiveYears::contains)
                .forEach(res::add);
        return res;
    }

    /* public Set<Integer> findAthletesByCondition(Collection<BicycleRace> BicycleRaces) {
        int fiveYearsAgo = NOW_YEAR - 5;
        Set<Integer> winnersThisYear = new HashSet<>();
        List<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        BicycleRaces.stream()
                .filter(x -> x.getDateRace().get(Calendar.YEAR) >= fiveYearsAgo)
                .forEach(x -> {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    if (x.getDateRace().get(Calendar.YEAR) == NOW_YEAR) {
                        for (int i = 1; i < 4; i++) {
                            if (!changingColumnWin(matrix, x.getFinalList().get(i), x.getDateRace().get(Calendar.YEAR), 1)) {
                                addMatrixRow(matrix, x.getFinalList().get(i), 1);
                            }
                        }
                    } else {
                        for (int i = 1; i <= x.getNumbersParticipant().size(); i++) {
                            if (i > 3) {
                                if (!changingColumnWin(matrix, x.getFinalList().get(i), x.getDateRace().get(Calendar.YEAR), 1)) {
                                    addMatrixRow(matrix, x.getFinalList().get(i), 0);
                                    int index = NOW_YEAR - x.getDateRace().get(Calendar.YEAR) + 1;
                                    matrix.get(matrix.size() - 1).set(index, 1);
                                }
                            } else { //призовые
                                //value так как в каком-то из 5 годов ранее выиграл
                                changingColumnWin(matrix, x.getFinalList().get(i), x.getDateRace().get(Calendar.YEAR), -12427);
                            }
                        }
                    }
                });
        matrix.stream()
                .filter(x -> x.get(1) > 0 && x.get(2) > 0 && x.get(3) > 0 && x.get(4) > 0 && x.get(5) > 0 && x.get(6) > 0)
                .forEach(x -> winnersThisYear.add(x.get(0)));
        return winnersThisYear;
    }

    private void addMatrixRow(List<ArrayList<Integer>> matrix, int first, int second) {
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(first);
        tmp.add(second);
        for (int i = 0; i < 5; i++) {
            tmp.add(0);
        }
        matrix.add(tmp);
    }

    private boolean changingColumnWin(List<ArrayList<Integer>> matrix, int number, int year, int value) {
        for (ArrayList<Integer> integers : matrix) {
            if (Objects.equals(integers.get(0), number)) {
                int index = NOW_YEAR - year + 1;
                value = integers.get(index) + value;
                integers.set(index, value);
                return true;
            }
        }
        return false;
    }
     */
}
