package org.example;

import org.example.model.MilkRecord;
import org.example.service.MilkRecordService;
import org.example.service.DataGenerator;
import org.example.service.TaskExecutor;
import java.util.*;
//Фермер ведет статистику работы своего коровника, каждый день записывая дату, количество корма, съеденного коровами,
//и количество молока
//Всего известно о 8517 таких записей (подумайте, как можно смоделировать
//        ввод с помощью случайных чисел)
//
//Необходимо найти следующую информацию:
//Найти лучший месяц по соотношению количество корма/количество молока
//Сколько, в среднем, в неделю коровы дают молока
//Суммарный объем съеденного корма
//В задаче должны использоваться коллекции (за исключением Map), необходимо сравнить производительность
//различных коллекций для этой задачи, выбрать наиболее подходящую (подходящие), аргументировать свой выбор
//
//В задаче должны использоваться элементы функционального программирования
//Задача должна быть представлена в виде maven-проекта
//Задача должна быть покрыта тестами с помощью JUnit

public class MilkFarm {
    public static void main(String[] args) {
        final int RECORDS_COUNT = 8517;

        MilkRecordService service = new MilkRecordService();

        Collection<MilkRecord> listRecords = DataGenerator.generate(RECORDS_COUNT, ArrayList::new);
        Collection<MilkRecord> linkedListRecords = DataGenerator.generate(RECORDS_COUNT, LinkedList::new);
        Collection<MilkRecord> arrayDequeRecords = DataGenerator.generate(RECORDS_COUNT, ArrayDeque::new);
        Collection<MilkRecord> hashSetRecords = DataGenerator.generate(RECORDS_COUNT, HashSet::new);
        Collection<MilkRecord> linkedHashSetRecords = DataGenerator.generate(RECORDS_COUNT, LinkedHashSet::new);
        Collection<MilkRecord> treeSetRecords = DataGenerator.generate(RECORDS_COUNT, () -> new TreeSet<>(new Comparator<MilkRecord>() {
            @Override
            public int compare(MilkRecord o1, MilkRecord o2) {
                return Integer.compare(o1.getFeedCount(), o2.getFeedCount())
                        + Integer.compare(o1.getMilkCount(), o2.getMilkCount());
            }
        }));

        TaskExecutor.execute(service, listRecords);
        TaskExecutor.execute(service, linkedListRecords);
        TaskExecutor.execute(service, arrayDequeRecords);
        TaskExecutor.execute(service, hashSetRecords);
        TaskExecutor.execute(service, linkedHashSetRecords);
        TaskExecutor.execute(service, treeSetRecords);
    }
}