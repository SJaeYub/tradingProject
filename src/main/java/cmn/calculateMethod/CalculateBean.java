package cmn.calculateMethod;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateBean {


    public BigDecimal calculateRate(BigDecimal param1, BigDecimal param2) {
        if (param1 == null || param2 == null || param1.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return param2.subtract(param1).divide(param1, 8, RoundingMode.HALF_UP);
    }
}
