package org.dd2480;

import java.awt.geom.Point2D;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class DecideTest {

    @Test
    void shouldThrowIllegalArgumentException_whenMoreThan100Points() {
        Point2D[] points = new Point2D[101];
        assertThrows(IllegalArgumentException.class, () -> Main.decide(points, null, null, null),
                "points count should not exceed 100");
    }

    @Test
    void shouldPassWithValidParameters() {

        boolean hasTrue = false;
        boolean hasFalse = false;

        for (int i = 0; i < 100000; i++) {
            Point2D[] points = RandUtil.generateVector(100, () -> RandUtil.generatePoint2D(-100.0, 100.0));
            Main.Op[][] lcm = RandUtil.generateMatrix(15, 15, () -> RandUtil.generateEnum(Main.Op.class));
            Boolean[] puv = RandUtil.generateVector(15, () -> RandUtil.generateBoolean());

            Parameters params = new Parameters(
                    RandUtil.generateDouble(0.001, 0.7),
                    RandUtil.generateDouble(1.0, 10.0),
                    RandUtil.generateDouble(1.0, 10.0),
                    RandUtil.generateDouble(1.0, 10.0),
                    RandUtil.generateDouble(1.0, 10.0),
                    RandUtil.generateDouble(1.0, 10.0),
                    RandUtil.generateDouble(1.0, 10.0),
                    RandUtil.generateInt(1, 10),
                    RandUtil.generateInt(1, 10),
                    RandUtil.generateInt(1, 10),
                    RandUtil.generateInt(1, 10),
                    RandUtil.generateInt(1, 10),
                    RandUtil.generateInt(1, 10),
                    RandUtil.generateInt(1, 10),
                    RandUtil.generateInt(1, 10),
                    RandUtil.generateInt(3, 50),
                    RandUtil.generateInt(2, 50),
                    RandUtil.generateInt(1, 3),
                    RandUtil.generateDouble(1.0, 10.0)
            );

            boolean[] puvPrimitive = new boolean[puv.length];
            for (int j = 0; j < puv.length; j++) {
                puvPrimitive[j] = puv[j];
            }

            boolean result = Main.decide(points, params, lcm, puvPrimitive);
            if (result) {
                hasTrue = true;
            } else {
                hasFalse = true;
            }
        }

        assert hasTrue && hasFalse;
    }

}
