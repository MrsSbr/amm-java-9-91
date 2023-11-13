package media;
import java.util.List;
import java.util.ArrayList;
import exceptions.*;
public class TVProgram {
    private final List<MediaProduction> program;
    private int duration;

    public TVProgram() {
        program = new ArrayList<>();
        duration = 0;
    }

    public void add(MediaProduction mediaProduct)
            throws NotMediaProductException, ProgramFullException, TooManyAdsException {
        if (mediaProduct instanceof Overview) {
            if (duration + mediaProduct.getDuration() < 1440) {
                program.add(mediaProduct);
                duration += mediaProduct.getDuration();
            }
            else {
                throw new ProgramFullException("You are trying to add media product to already full program");
            }
        }
        else {
            if (mediaProduct instanceof Advertisement ) {
                // нельзя добавить в программу две рекламы подряд
                if (program.get(program.size() - 1) instanceof Advertisement) {
                    throw new TooManyAdsException("You are trying to add too many advertisements");
                }
                else {
                    if (duration + mediaProduct.getDuration() < 1440) {
                        program.add(mediaProduct);
                        duration += mediaProduct.getDuration();
                    }
                    else {
                        throw new ProgramFullException("You are trying to add media product to already full program");
                    }
                }
            }
            else {
                throw new NotMediaProductException("You are trying to add non-media product");
            }
        }
    }

    public void play() {
        for (MediaProduction mediaProduct : program) {
            System.out.println(mediaProduct.play());
            System.out.println("Info: " + mediaProduct + "\n");
        }
    }

}
