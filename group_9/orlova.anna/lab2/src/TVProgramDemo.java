import java.util.ArrayList;
import java.util.List;
import media.*;
import exceptions.*;

public class TVProgramDemo {
    public static void main(String[] args) {

        TVProgram program = new TVProgram();

        List<MediaProduction> list = new ArrayList<>();

        list.add(new Movie("Pride and Prejustice", 2005,"Joe Wright", 127,
                Genre.ROMANCE,"Sparks fly when spirited Elizabeth Bennet meets single, rich, and " +
                "proud Mr. Darcy. But Mr. Darcy reluctantly finds himself falling in love with a woman beneath his " +
                "class. Can each overcome their own pride and prejudice?"));
        list.add(new Advertisement("Luxury Car Ad", 2022, 1));
        list.add(new Movie("Oppenheimer", 2023, "Christopher Nolan", 189, Genre.DOCUMENTARY,
                "The story of American scientist, J. Robert Oppenheimer, and his role in the development" +
                        " of the atomic bomb."));
        list.add(new Advertisement("Smartphone Promo", 2023, 2));
        list.add(new Movie("Barbie", 2023, "Greta Gerwig", 110, Genre.ADVENTURE,
                "Barbie suffers a crisis that leads her to question her world and her existence."));

        list.add(new TVSeries("One Piece", 2023, 60, "Netflix", 1,
                Genre.ADVENTURE,"In a seafaring world, a young pirate captain sets out with his crew to " +
                "attain the title of Pirate King, and to discover the mythical treasure known as 'One Piece.'"));
        list.add(new Advertisement("Blockbuster Movie Teaser", 2023, 5));
        list.add(new Advertisement("Summer Getaway Deal", 2023, 2));
        list.add(new TVSeries("Breaking Bad", 2008, 49, "HBO", 3, Genre.CRIME,
                "A chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and " +
                        "selling methamphetamine with a former student in order to secure his family's future."));

        for (MediaProduction product : list) {
            try {
                program.add(product);
            } catch (NotMediaProductException e) {
                System.out.println("Not Media Product Exception: " + e.getMessage() + "\n");
            } catch (ProgramFullException e) {
                System.out.println("Program is Full Exception: " + e.getMessage() + "\n");
            } catch (TooManyAdsException e) {
                System.out.println("Too Many Ads Exception: " + e.getMessage() + "\n");
            }
        }

        program.play();

    }
}