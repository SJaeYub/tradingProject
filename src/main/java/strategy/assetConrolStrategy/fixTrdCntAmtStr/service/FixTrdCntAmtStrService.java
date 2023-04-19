package strategy.assetConrolStrategy.fixTrdCntAmtStr.service;

import strategy.assetConrolStrategy.common.AssetVar;
import strategy.assetConrolStrategy.fixTrdCntAmtStr.bean.Calculate_FTCAS;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FixTrdCntAmtStrService {

    public int getTrdCtrCnt(AssetVar assVar) {
        int result;

//        매매 계약 수 = 금액 리스크/매매별 리스크
        Calculate_FTCAS calculate = new Calculate_FTCAS();
        BigDecimal tradeRiskAmount = calculate.calculateRiskPerTrd(assVar.getAccountAmt(), assVar.getFixCntOfPosTrd());
        BigDecimal tradeRiskPerCtr = calculate.calculateRisk(assVar.getEntryPrice(), assVar.getStopPrice(), assVar.getFee());

        result = tradeRiskAmount.divide(tradeRiskPerCtr, RoundingMode.DOWN).intValue();

        return result;
    }
}
