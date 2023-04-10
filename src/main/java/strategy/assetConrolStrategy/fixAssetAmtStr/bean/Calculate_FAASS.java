package strategy.assetConrolStrategy.fixAssetAmtStr.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculate_FAASS {

    public int calculatePosTradingContract(BigDecimal assAmt, BigDecimal fixAssetUnitPerContract) {
        int result = 0;

        result = assAmt.divide(fixAssetUnitPerContract, RoundingMode.DOWN).intValue();

        //매매 가능 계약 수가 1 이하인 경우 매매 유지를 위해 1로 고정
        if (result < 1) {
            result = 1;
        }

        return result;
    }

    public BigDecimal calculateFixAssetUnit(BigDecimal maxCumulativeLoss, BigDecimal acceptableLossRatio) {
        BigDecimal result = new BigDecimal(0);

        result = maxCumulativeLoss.divide(acceptableLossRatio, RoundingMode.HALF_UP);

        return result;
    }
}
