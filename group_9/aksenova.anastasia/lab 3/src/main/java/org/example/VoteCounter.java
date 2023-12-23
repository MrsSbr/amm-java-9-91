package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VoteCounter {

    public static List<Integer> countVotes(List<Integer> votes) {
        // Создаем список из 12 элементов, заполненных нулями
        List<Integer> candidateVotes = IntStream.range(0, 12)
                .mapToObj(i -> 0)
                .collect(Collectors.toCollection(ArrayList::new));

        // Используем стрим для увеличения счетчика голосов для каждого кандидата
        votes.forEach(vote -> candidateVotes.set(vote - 1, candidateVotes.get(vote - 1) + 1));

        return candidateVotes;
    }
}
