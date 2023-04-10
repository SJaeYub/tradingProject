package strategy.assetConrolStrategy.common.bean;

import java.math.BigDecimal;

public class calculateCmn {

    public BigDecimal calculateMarginPerCtr(BigDecimal buyingAmt, BigDecimal sellingAmt,
                                            int currTradingCtrCnt) {

        BigDecimal result;

        if (sellingAmt.compareTo(buyingAmt) <= 0) {
            result = new BigDecimal(0);
        } else {
            BigDecimal gubun = sellingAmt.subtract(buyingAmt);
            result = gubun.divide(new BigDecimal(currTradingCtrCnt));
        }

        return result;
    }
}
