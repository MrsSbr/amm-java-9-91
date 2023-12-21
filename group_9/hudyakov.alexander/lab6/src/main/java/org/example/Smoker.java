package org.example;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Smoker extends Thread {
    private final Semaphore componentSemaphore;
    private final Semaphore smokerSemaphore;
    private final String componentName;
    private final Random random;
    private boolean shouldWork;

    public Smoker(Semaphore componentSemaphore, String componentName, Random random) {
        this.componentSemaphore = componentSemaphore;
        this.componentName = componentName;
        this.random = random;
        smokerSemaphore = new Semaphore(1);
        shouldWork = true;
    }

    public Semaphore getSmokerSemaphore() {
        return smokerSemaphore;
    }

    public String getComponentName() {
        return componentName;
    }

    @Override
    public void run() {
        while (shouldWork) {
            try {
                componentSemaphore.acquire();
                smokerSemaphore.acquire();
                System.out.printf("Курильщик %s начал курить!\n", componentName);
                sleep(random.nextInt(3000, 15000));
                System.out.printf("Курильщик %s докурил!\n", componentName);
                smokerSemaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopSmoking() {
        shouldWork = false;
        smokerSemaphore.release();
    }
}
