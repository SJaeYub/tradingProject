package strategy.assetConrolStrategy.fixAssetAmtStr.service;

import strategy.assetConrolStrategy.common.AssetVar;
import strategy.assetConrolStrategy.fixAssetAmtStr.bean.Calculate_FAASS;

import java.math.BigDecimal;

public class FixAssetAmtStrService {


    public int getPosTrdCnt(AssetVar assVar) {
        int result = 0;

        Calculate_FAASS calculate = new Calculate_FAASS();
        BigDecimal fixAssetUnit = calculate.calculateFixAssetUnit(assVar.getMaxCumulativeLoss(), assVar.getAcceptableLossRatio());
        System.out.println("[자산 고정 자금 관리 - 계좌자산 : " + assVar.getAccountAmt() + "] : 고정 자산 금액 " + fixAssetUnit);

        result = calculate.calculatePosTradingContract(assVar.getAccountAmt(), fixAssetUnit);
        System.out.println("[자산 고정 자금 관리 - 계좌자산 : " + assVar.getAccountAmt() + "] :  매매 가능 계약 수 " + result);
        return result;
    }
}
