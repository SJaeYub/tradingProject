package strategy.assetConrolStrategy.fixRiskAmtAssetStr.service;

import assetConrolStrategy.common.AssetVar;
import assetConrolStrategy.fixRiskAmtAssetStr.bean.Calculate_FRAASS;

import java.math.BigDecimal;

public class FixRiskAmtAssetStrService {

    public int getPosTrdCnt(BigDecimal accAsset, int posTradContrCnt, BigDecimal tradeRiskAmt) {
        AssetVar assetVar = new AssetVar();
        assetVar.setAccountAmt(accAsset);
        assetVar.setPosTradingContractCnt(posTradContrCnt);

        Calculate_FRAASS calculate = new Calculate_FRAASS();
        BigDecimal fixedRiskAmt = calculate.calculateFixedRiskAmt(assetVar.getAccountAmt(), assetVar.getPosTradingContractCnt());

        System.out.println("[리스크 금액 고정 자금 관리] :  고정된 리스크 금액 " + fixedRiskAmt);

        assetVar.setFixedRiskAmt(fixedRiskAmt);

        int result = calculate.calculatePosTradingContractCnt(fixedRiskAmt, tradeRiskAmt);

        return result;
    }
}
