package org.example.service;

import  org.example.model.MilkRecord;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class TaskExecutor {

  public static void execute(MilkRecordService service, Collection<MilkRecord> collection) {
    createRunnableTasks(service, collection).forEach(Runnable::run);
  }

  private static Stream<Runnable> createRunnableTasks(
          MilkRecordService service,
          Collection<MilkRecord> collection
  ) {
    return Stream.of(
            createSingleTask("averageWeeklyMilkCount", service::averageWeeklyMilkCount, collection),
            createSingleTask("bestMonthForFeedCountToMilkCount", service::bestMonthForFeedCountToMilkCount, collection),
            createSingleTask("eatenFeedCountSum", service::eatenFeedCountSum, collection));
  }

  private static Runnable createSingleTask(String methodName, Consumer<Collection<MilkRecord>> consumer, Collection<MilkRecord> collection) {
    return () -> {
      final long start = System.currentTimeMillis();
      System.out.println("TASK: " + collection.getClass() + ", METHOD: " + methodName);
      System.out.println("Start execute task --------------------->");
      consumer.accept(collection);
      System.out.println("Task finished <---------------------------");
      final long finish = System.currentTimeMillis();
      System.out.println("Task execution time: " + (finish - start) + "ms");
      System.out.println();
    };
  }
}
