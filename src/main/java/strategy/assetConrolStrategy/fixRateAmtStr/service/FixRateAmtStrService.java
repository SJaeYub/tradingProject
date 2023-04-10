package strategy.assetConrolStrategy.fixRateAmtStr.service;

import assetConrolStrategy.common.AssetVar;
import assetConrolStrategy.fixRateAmtStr.bean.Calculate_FixRate;

import java.math.BigDecimal;

public class FixRateAmtStrService {

    public int getPosTrdCnt(AssetVar assVar, BigDecimal nextAccAmtLevel) {
        int result = assVar.getCurrTradingCtrCnt();

        if (nextAccAmtLevel.compareTo(assVar.getCurrAccAmtLevel()) >= 0) {
            result++;
        }

        return result;
    }

    public BigDecimal getNextAccAmtLevel(AssetVar assVar) {
        Calculate_FixRate calculate = new Calculate_FixRate();
        BigDecimal delta = calculate.calculateDelta(assVar.getMaxCumulativeLoss(), assVar.getInitialMargin());
        BigDecimal nextAccAmtLevel = calculate.calculateNextAccAmtLevel(assVar.getCurrAccAmtLevel(), delta, assVar.getCurrTradingCtrCnt());

        return nextAccAmtLevel;
    }
}
