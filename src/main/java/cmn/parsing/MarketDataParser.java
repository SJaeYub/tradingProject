package cmn.parsing;

import java.util.ArrayList;
import java.util.List;

import cmn.dataGrid.MarketData;
import org.json.JSONArray;
import org.json.JSONObject;

public class MarketDataParser {
    public static List<MarketData> parse(String jsonString) {
        List<MarketData> marketDataList = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(jsonString);

        for(int i=0; i<jsonArray.length(); i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            MarketData marketData = new MarketData();

            marketData.setMarket(jsonObj.getString("market"));
            marketData.setCandle_date_time_utc(jsonObj.getString("candle_date_time_utc"));
            marketData.setCandle_date_time_kst(jsonObj.getString("candle_date_time_kst"));
            marketData.setOpening_price(jsonObj.getBigDecimal("opening_price"));
            marketData.setHigh_price(jsonObj.getBigDecimal("high_price"));
            marketData.setLow_price(jsonObj.getBigDecimal("low_price"));
            marketData.setTrade_price(jsonObj.getBigDecimal("trade_price"));
            marketData.setTimestamp(jsonObj.getLong("timestamp"));
            marketData.setCandle_acc_trade_price(jsonObj.getBigDecimal("candle_acc_trade_price"));
            marketData.setCandle_acc_trade_volume(jsonObj.getDouble("candle_acc_trade_volume"));
            marketData.setUnit(jsonObj.getInt("unit"));

            marketDataList.add(marketData);
        }

        return marketDataList;
    }
}