package org.tradingstr.reverseMomStr.outSideDayWithDownClose;

import cmn.MarketData;
import cmn.callAPI.GetMinCandle;
import cmn.parsing.JsonArrayParser;
import cmn.parsing.MarketDataParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import personnelPack.PersonnelKey;

import java.math.BigDecimal;
import java.util.List;

public class OutSideDayStr {

    PersonnelKey key = new PersonnelKey();
    String accKey = key.getAccKey();
    String secKey = key.getSecKey();

    public void outSideDatStrPlay() {

        GetMinCandle minCandle = new GetMinCandle(accKey, secKey);
//        JsonArrayParser jsonArrayParser = new JsonArrayParser();
//        open, high, low, trade    curr, prev
        BigDecimal[][] priceArray = new BigDecimal[2][4];
        boolean tradeSignal = false;
        boolean sellingSignal = false;

        while (true) {

            if (sellingSignal) {
//          sell
                System.out.println("sell");

                sellingSignal = false;
            }

            String minCandle_BTC = minCandle.getMinCandle("KRW-BTC", null, "2", "5");
            System.out.println(minCandle_BTC);

            MarketDataParser marketDataParser = new MarketDataParser();
            List<MarketData> marketDataList = marketDataParser.parse(minCandle_BTC);

            int cnt = 0;
            for (MarketData marketData : marketDataList) {
                String candleDateTimeKst = marketData.getCandle_date_time_kst();
                BigDecimal openingPrice = marketData.getOpening_price();
                BigDecimal highPrice = marketData.getHigh_price();
                BigDecimal lowPrice = marketData.getLow_price();
                BigDecimal tradePrice = marketData.getTrade_price();

                System.out.println("timestamp : " + candleDateTimeKst + " open : " + openingPrice + " high : " + highPrice + " low : " + lowPrice + " trade : " + tradePrice);

                priceArray[cnt][0] = openingPrice;
                priceArray[cnt][1] = highPrice;
                priceArray[cnt][2] = lowPrice;
                priceArray[cnt][3] = tradePrice;

                cnt++;
            }

            if (tradeSignal) {
                BigDecimal curr_openPrice = priceArray[0][0];
                BigDecimal prev_tradePrice = priceArray[1][3];

                if (curr_openPrice.compareTo(prev_tradePrice) == -1) {
                    System.out.println("buy");
//                    trade
                    sellingSignal = true;
                    tradeSignal = false;
                }
            }

            boolean checkOutsideDay = checkOutSideDay(priceArray[0][1], priceArray[1][1], priceArray[0][2], priceArray[0][3]);

            if (checkOutsideDayWithDownClose(checkOutsideDay, priceArray[0][3], priceArray[1][2])) {
                System.out.println("signal on");
                tradeSignal = true;
            }

            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private boolean checkOutSideDay(BigDecimal curr_highP, BigDecimal prev_highP, BigDecimal curr_lowP, BigDecimal prev_lowP) {

        if (curr_highP.compareTo(prev_highP) == 1) {

            if (curr_lowP.compareTo(prev_lowP) == -1) {
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    private boolean checkOutsideDayWithDownClose(boolean chkOSD, BigDecimal curr_tradeP, BigDecimal prev_lowP) {
        if (chkOSD) {
            if (curr_tradeP.compareTo(prev_lowP) == -1) {
                return true;
            }
        }

        return false;
    }

}
