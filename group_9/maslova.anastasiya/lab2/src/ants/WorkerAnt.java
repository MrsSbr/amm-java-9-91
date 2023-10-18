package ants;

import java.util.Random;

/**
 * The WorkerAnt class represents an ant type that performs general labor.
 */
public class WorkerAnt extends Ant {
    private int tasksCompleted;

    /**
     * Constructor to initialize a WorkerAnt with a name.
     *
     * @param name The name of the WorkerAnt.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public WorkerAnt(String name) {
        super(name);
        this.tasksCompleted = 0;
    }

    /**
     * Get the number of tasks completed by the worker ant.
     *
     * @return The number of tasks completed.
     */
    public int getTasksCompleted() {
        return tasksCompleted;
    }

    /**
     * Work as a worker ant and increase the number of tasks completed.
     */
    @Override
    public void work() {
        Random random = new Random();
        int randomTasks = random.nextInt(5);
        tasksCompleted = tasksCompleted + randomTasks;
        System.out.println(name + " is working hard. Tasks completed: " + tasksCompleted);
    }

    /**
     * Check if two worker ants are equal based on their names and tasks completed.
     *
     * @param obj The object to compare.
     * @return true if the ants have the same name and tasks completed, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        WorkerAnt workerAnt = (WorkerAnt) obj;
        return tasksCompleted == workerAnt.tasksCompleted;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + tasksCompleted;
    }

    @Override
    public String toString() {
        return "WorkerAnt{" +
                "name='" + name + '\'' +
                ", tasksCompleted=" + tasksCompleted +
                '}';
    }
}
