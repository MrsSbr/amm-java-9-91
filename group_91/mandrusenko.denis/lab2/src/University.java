import University.UniversityMember;
import University.Student;
import University.Professor;

public class University {
    public static void main(String[] args) {
        UniversityMember[] members = new UniversityMember[]{
                new Student("Мандрусенко Денис", 20, 3),
                new Professor("Иванов Иван", 45, "Компьютерные науки"),
        };

        for (UniversityMember member : members) {
            if (member instanceof Student student) {
                System.out.println(member.toString());
            } else if (member instanceof Professor professor)
                System.out.println(member.toString());
            member.work();
            System.out.println();
        }
    }
}