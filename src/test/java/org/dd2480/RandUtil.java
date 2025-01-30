package org.dd2480;

import java.awt.geom.Point2D;
import java.util.function.Supplier;

public class RandUtil {

    public static boolean generateBoolean() {
        return Math.random() < 0.5;
    }

    public static int generateInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static double generateDouble(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    public static Point2D generatePoint2D(double min, double max) {
        return new Point2D.Double(generateDouble(min, max), generateDouble(min, max));
    }

    public static <T extends Enum<T>> T generateEnum(Class<T> clazz) {
        T[] values = clazz.getEnumConstants();
        return values[generateInt(0, values.length - 1)];
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] generateVector(int n, Supplier<T> supplier) {
        Class<?> clazz = supplier.get().getClass();
        T[] vector = (T[]) java.lang.reflect.Array.newInstance(clazz, n);
        for (int i = 0; i < n; i++) {
            vector[i] = supplier.get();
        }
        return vector;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[][] generateMatrix(int n, int m, Supplier<T> supplier) {
        Class<?> clazz = supplier.get().getClass();
        T[][] matrix = (T[][]) java.lang.reflect.Array.newInstance(clazz, n, m);
        for (int i = 0; i < n; i++) {
            matrix[i] = generateVector(m, supplier);
        }
        return matrix;
    }

}
