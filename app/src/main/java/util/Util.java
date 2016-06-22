package util;

import org.reflections.Reflections;

import java.util.Set;

import belief.Belief;

/**
 * Created by SStrombe on 6/13/16.
 */
public class Util {
    public static int generateRandomIntInRange(int min, int max) {
        return (int) generateRandomFloatInRange(min, max);
    }

    public static float generateRandomFloatInRange(float min, float max) {
        double random = Math.random() * max;

        if(random < min) {
            random = min;
        }

        return (float) random;
    }
}
