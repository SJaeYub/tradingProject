package org.tradingstr.reverseMomentumTwoCandle;

import cmn.callAPI.GetMinCandle;
import personnelPack.PersonnelKey;

public class ReverseMomentumTwoCandlesStr {

    private static PersonnelKey key = new PersonnelKey();
    private static String accKey = key.getAccKey();
    private static String secKey = key.getSecKey();
    private static final String MARKET = "KRW-BTC";

    public void reverseMomTwoCanStrPlay(String market) {
        GetMinCandle minCandle = new GetMinCandle(accKey, secKey);


        while (true) {
            String minCandle30Min = minCandle.getMinCandle("KRW-BTC", null, "1", "30");
            
        }
    }
}
