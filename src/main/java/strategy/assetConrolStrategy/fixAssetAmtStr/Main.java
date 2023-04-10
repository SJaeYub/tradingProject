package strategy.assetConrolStrategy.fixAssetAmtStr;

import assetConrolStrategy.common.AssetVar;
import assetConrolStrategy.fixAssetAmtStr.service.FixAssetAmtStrService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                AssetVar asset = new AssetVar();
                asset.setAccountAmt(new BigDecimal(8000));
                asset.setMaxCumulativeLoss(new BigDecimal(14000));
                asset.setAcceptableLossRatio(new BigDecimal(0.2));
                FixAssetAmtStrService service = new FixAssetAmtStrService();
                int contractCnt = service.getPosTrdCnt(asset);
//                System.out.println("[자산 고정 자금 관리 - 계좌자산 : 8000] :  매매 가능 계약 수 " + contractCnt);
            }
            if (i == 1) {
                AssetVar asset = new AssetVar();
                asset.setAccountAmt(new BigDecimal(29000));
                asset.setMaxCumulativeLoss(new BigDecimal(14000));
                asset.setAcceptableLossRatio(new BigDecimal(0.3));
                FixAssetAmtStrService service = new FixAssetAmtStrService();
                int contractCnt = service.getPosTrdCnt(asset);
//                System.out.println("[자산 고정 자금 관리 - 계좌자산 : 8000] :  매매 가능 계약 수 " + contractCnt);
            }
            if (i == 2) {
                AssetVar asset = new AssetVar();
                asset.setAccountAmt(new BigDecimal(32000));
                asset.setMaxCumulativeLoss(new BigDecimal(14000));
                asset.setAcceptableLossRatio(new BigDecimal(0.4));
                FixAssetAmtStrService service = new FixAssetAmtStrService();
                int contractCnt = service.getPosTrdCnt(asset);
//                System.out.println("[자산 고정 자금 관리 - 계좌자산 : 8000] :  매매 가능 계약 수 " + contractCnt);
            }
            if (i == 3) {
                AssetVar asset = new AssetVar();
                asset.setAccountAmt(new BigDecimal(48000));
                asset.setMaxCumulativeLoss(new BigDecimal(14000));
                asset.setAcceptableLossRatio(new BigDecimal(0.5));
                FixAssetAmtStrService service = new FixAssetAmtStrService();
                int contractCnt = service.getPosTrdCnt(asset);
//                System.out.println("[자산 고정 자금 관리 - 계좌자산 : 8000] :  매매 가능 계약 수 " + contractCnt);
            }
            if (i == 4) {
                AssetVar asset = new AssetVar();
                asset.setAccountAmt(new BigDecimal(51000));
                asset.setMaxCumulativeLoss(new BigDecimal(14000));
                asset.setAcceptableLossRatio(new BigDecimal(0.933));
                FixAssetAmtStrService service = new FixAssetAmtStrService();
                int contractCnt = service.getPosTrdCnt(asset);
//                System.out.println("[자산 고정 자금 관리 - 계좌자산 : 8000] :  매매 가능 계약 수 " + contractCnt);
            }

        }


    }
}
