package strategy.assetConrolStrategy.fixTrdCntAmtStr.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculate_FTCAS {

    public BigDecimal calculateRiskPerTrd(BigDecimal assAmt, int fixCntOfPosTrd) {
        BigDecimal result;

        result = assAmt.divide(new BigDecimal(fixCntOfPosTrd), RoundingMode.DOWN);

        return result;
    }

    public BigDecimal calculateRisk(BigDecimal entryPrice, BigDecimal stopPrice, BigDecimal fee) {
        BigDecimal result;

        result = entryPrice.subtract(stopPrice).add(fee);

        return result;
    }
}
