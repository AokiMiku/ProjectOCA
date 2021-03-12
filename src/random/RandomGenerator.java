package random;

import java.util.Random;

public class RandomGenerator 
{
	public static int getRandomNumber(int min, int max)
	{
		if (min > max) 
		{
            throw new IllegalArgumentException("max must be at least equals to min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
	}
}
