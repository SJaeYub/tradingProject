package org.tradingstr.reverseMomStr.outSideDayWithDownClose;

import cmn.callAPI.GetTicker;
import cmn.callAPI.GetTradeTicks;
import cmn.dataGrid.MarketData;
import cmn.callAPI.GetMinCandle;
import cmn.dataGrid.TickerData;
import cmn.dataGrid.TicksData;
import cmn.parsing.MarketDataParser;
import cmn.parsing.TickerDataParser;
import cmn.parsing.TicksDataParser;
import org.json.JSONArray;
import org.json.JSONObject;
import personnelPack.PersonnelKey;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class OutSideDayStr {

    private static PersonnelKey key = new PersonnelKey();
    private static String accKey = key.getAccKey();
    private static String secKey = key.getSecKey();
    private static final String MARKET = "KRW-BTC";

    public void outSideDatStrPlay() throws Exception {

        GetMinCandle minCandle = new GetMinCandle(accKey, secKey);
//        open, high, low, trade    curr, prev
        BigDecimal[][] priceArray = new BigDecimal[2][4];
        boolean tradeSignal = false;
        boolean sellingSignal = false;
        BigDecimal initPrice = new BigDecimal(0);

        while (true) {


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

            if (sellingSignal) {

                GetTicker ticker = new GetTicker(accKey, secKey);
                ticker.init();
                String tickerData = ticker.getTicker(MARKET);

                TickerDataParser tickerDataParser = new TickerDataParser();
                List<TickerData> tickerDataList = tickerDataParser.parse(tickerData);

                TickerData tickerData1 = tickerDataList.get(0);
                BigDecimal openingPrice = tickerData1.getOpeningPrice();
                BigDecimal tradePrice = tickerData1.getTradePrice();

                if (initPrice.compareTo(openingPrice) == -1) {
                    int ask = executeTrade("ask", tradePrice, 0.01);
                    if (ask == -1) {
                        sellingSignal = true;
                    } else {
                        sellingSignal = false;
                    }
                }
            }

            boolean checkOutsideDay = checkOutSideDay(priceArray[0][1], priceArray[1][1], priceArray[0][2], priceArray[0][3]);

            if (checkOutsideDayWithDownClose(checkOutsideDay, priceArray[0][3], priceArray[1][2])) {
                System.out.println("signal on");
                tradeSignal = true;
            }

            if (tradeSignal) {
                //buy
                GetTicker ticker = new GetTicker(accKey, secKey);
                ticker.init();
                String tickerData = ticker.getTicker(MARKET);

                TickerDataParser tickerDataParser = new TickerDataParser();
                List<TickerData> tickerDataList = tickerDataParser.parse(tickerData);

                TickerData tickerData1 = tickerDataList.get(0);
                BigDecimal openingPrice = tickerData1.getOpeningPrice();
                BigDecimal prevClosingPrice = tickerData1.getPrevClosingPrice();
                BigDecimal tradePrice = tickerData1.getTradePrice();

                if (openingPrice.compareTo(prevClosingPrice) == -1) {
                    int bidResult = executeTrade("bid", tradePrice, 0.01);
                    if (bidResult == -1) {
                        //
                        tradeSignal = false;
                    } else {
                        initPrice = tradePrice;
                        sellingSignal = true;
                        tradeSignal = false;
                    }
                }

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

    // Get the current bid price
    private static double getBidPrice() throws Exception {
        String apiUrl = "https://api.upbit.com/v1/orderbook?markets=" + MARKET;
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONArray jsonArray = new JSONArray(response.toString());
        JSONObject data = jsonArray.getJSONObject(0);

        JSONArray bids = data.getJSONArray("orderbook_units");
        JSONObject highestBid = bids.getJSONObject(0);

        return highestBid.getDouble("bid_price");
    }

    private static double getAskPrice() throws Exception {
        String apiUrl = "https://api.upbit.com/v1/orderbook?markets=" + MARKET;
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONArray jsonArray = new JSONArray(response.toString());
        JSONObject data = jsonArray.getJSONObject(0);

        JSONArray asks = data.getJSONArray("orderbook_units");
        JSONObject lowestAsk = asks.getJSONObject(asks.length() - 1);

        return lowestAsk.getDouble("ask_price");
    }

    private static void placeOrder(String side, BigDecimal price, double volume) throws Exception {
        String apiUrl = "https://api.upbit.com/v1/orders";
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer " + accKey);

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes("{\"market\":\"" + MARKET + "\",\"side\":\"" + side + "\",\"price\":\"" + price + "\",\"volume\":\"" + volume + "\",\"ord_type\":\"limit\"}");
        wr.flush();
        wr.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        String uuid = jsonResponse.getString("uuid");
        System.out.println("Order placed successfully with UUID: " + uuid);
    }

    private static int executeTrade(String side, BigDecimal price, double volume) throws Exception {
        BigDecimal currentBidPrice = BigDecimal.valueOf(getBidPrice());
        BigDecimal currentAskPrice = BigDecimal.valueOf(getAskPrice());

        if (side.equals("bid")) {
            if (price.compareTo(currentAskPrice) >= 0) {
                System.out.println("Error: Bid price is higher than or equal to current ask price.");
                return -1;
            }
        } else if (side.equals("ask")) {
            if (price.compareTo(currentBidPrice) <= 0) {
                System.out.println("Error: Ask price is lower than or equal to current bid price.");
                return -1;
            }
        }

        placeOrder(side, price, volume);
        return 1;
    }
}
