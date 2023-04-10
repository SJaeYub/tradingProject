package strategy.assetConrolStrategy.fixRiskAmtAssetStr;

import assetConrolStrategy.fixRiskAmtAssetStr.service.FixRiskAmtAssetStrService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        BigDecimal originAsset = new BigDecimal(20000);

        for (int i = 0; i <= 3; i++) {
            if (i == 0) {
                FixRiskAmtAssetStrService fixRiskAmtAssetStrService = new FixRiskAmtAssetStrService();
                int contractCnt = fixRiskAmtAssetStrService.getPosTrdCnt(originAsset, 40, new BigDecimal(650));
                System.out.println("[리스크 금액 고정 자금 관리 650] :  매매 가능 계약 수 " + contractCnt);
            }
            if (i == 1) {
                FixRiskAmtAssetStrService fixRiskAmtAssetStrService = new FixRiskAmtAssetStrService();
                int contractCnt = fixRiskAmtAssetStrService.getPosTrdCnt(originAsset, 40, new BigDecimal(350));
                System.out.println("[리스크 금액 고정 자금 관리 350] :  매매 가능 계약 수 " + contractCnt);
            }
            if (i == 2) {
                FixRiskAmtAssetStrService fixRiskAmtAssetStrService = new FixRiskAmtAssetStrService();
                int contractCnt = fixRiskAmtAssetStrService.getPosTrdCnt(originAsset, 40, new BigDecimal(265));
                System.out.println("[리스크 금액 고정 자금 관리 265] :  매매 가능 계약 수 " + contractCnt);
            }
            if (i == 3) {
                FixRiskAmtAssetStrService fixRiskAmtAssetStrService = new FixRiskAmtAssetStrService();
                int contractCnt = fixRiskAmtAssetStrService.getPosTrdCnt(originAsset, 40, new BigDecimal(200));
                System.out.println("[리스크 금액 고정 자금 관리 200] :  매매 가능 계약 수 " + contractCnt);
            }

        }




    }
}
