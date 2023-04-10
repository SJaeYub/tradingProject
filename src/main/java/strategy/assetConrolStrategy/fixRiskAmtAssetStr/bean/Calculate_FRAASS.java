package strategy.assetConrolStrategy.fixRiskAmtAssetStr.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Calculate_FRAASS {

    public BigDecimal calculateFixedRiskAmt(BigDecimal accountAmt, int posTradingContractCnt) {
        BigDecimal result = new BigDecimal(BigInteger.ZERO);

        BigDecimal trcontractCntToBig = new BigDecimal(posTradingContractCnt);

        result = accountAmt.divide(trcontractCntToBig, RoundingMode.DOWN);

        return result;
    }

    public int calculatePosTradingContractCnt(BigDecimal fixedRiskAmt, BigDecimal tradeRiskAmount) {

        int result = 0;

        result = fixedRiskAmt.divide(tradeRiskAmount, RoundingMode.DOWN).intValue();

        return result;
    }
}
