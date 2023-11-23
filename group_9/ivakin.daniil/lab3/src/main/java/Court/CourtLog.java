package Court;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourtLog {
    private Collection<Lawsuit> lawsuits;

    public CourtLog(Supplier<Collection<Lawsuit>> collectionSupplier,
                    Collection<Lawsuit> collection) {
        this.lawsuits = collectionSupplier.get();
        this.lawsuits.addAll(collection);
    }

    public Collection<Lawsuit> getLawsuits() {
        return lawsuits;
    }

    public long getUnsuitedPeopleCount() {
        Collection<String> suitedPeople = lawsuits.stream()
                .filter(Lawsuit::isSuited)
                .map(Lawsuit::getDefendantName)
                .distinct()
                .toList();

        Collection<String> allPeople = lawsuits.stream()
                .flatMap(lawsuit -> Stream.of(lawsuit.getSuiterName(), lawsuit.getDefendantName()))
                .distinct()
                .toList();

        return allPeople.stream()
                .filter(name -> !suitedPeople.contains(name))
                .count();
    }

    public Collection<String> getPeopleWithSeveralClausesInTenYears() {
        class HelperNameClause {
            private final String name;
            private final int clause;

            public HelperNameClause(String name, int clause) {
                this.name = name;
                this.clause = clause;
            }

            public String getName() {
                return name;
            }

            public int getClause() {
                return clause;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                HelperNameClause that = (HelperNameClause) o;
                return clause == that.clause && Objects.equals(name, that.name);
            }

            @Override
            public int hashCode() {
                return Objects.hash(name, clause);
            }
        }

        return lawsuits.stream()
                .filter(lawsuit -> ChronoUnit.YEARS.between(lawsuit.getDate(), LocalDate.now()) <= 10)
                .flatMap(lawsuit -> Stream.of(new HelperNameClause(lawsuit.getSuiterName(), lawsuit.getClause()),
                        new HelperNameClause(lawsuit.getDefendantName(), lawsuit.getClause())))
                .distinct()
                .collect(Collectors.groupingBy(HelperNameClause::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Collection<String> getPeopleWithSeveralSuitsInThreeYears() {
        return lawsuits.stream()
                .filter(lawsuit -> ChronoUnit.YEARS.between(lawsuit.getDate(), LocalDate.now()) <= 3)
                .map(Lawsuit::getSuiterName)
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }
}
