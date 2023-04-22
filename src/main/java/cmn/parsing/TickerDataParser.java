package cmn.parsing;

import cmn.dataGrid.TickerData;
import cmn.dataGrid.TicksData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TickerDataParser {

    public static List<TickerData> parse(String response) throws JSONException {
        JSONArray jsonArray = new JSONArray(response);
        List<TickerData> tickerDataList = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            TickerData tickerData = new TickerData(
                    jsonObject.getString("market"),
                    jsonObject.getString("trade_date"),
                    jsonObject.getString("trade_time"),
                    jsonObject.getString("trade_date_kst"),
                    jsonObject.getString("trade_time_kst"),
                    jsonObject.getLong("trade_timestamp"),
                    new BigDecimal(jsonObject.getString("opening_price")),
                    new BigDecimal(jsonObject.getString("high_price")),
                    new BigDecimal(jsonObject.getString("low_price")),
                    new BigDecimal(jsonObject.getString("trade_price")),
                    new BigDecimal(jsonObject.getString("prev_closing_price")),
                    jsonObject.getString("change"),
                    new BigDecimal(jsonObject.getString("change_price")),
                    new BigDecimal(jsonObject.getString("change_rate")),
                    new BigDecimal(jsonObject.getString("signed_change_price")),
                    new BigDecimal(jsonObject.getString("signed_change_rate")),
                    new BigDecimal(jsonObject.getString("trade_volume")),
                    new BigDecimal(jsonObject.getString("acc_trade_price")),
                    new BigDecimal(jsonObject.getString("acc_trade_price_24h")),
                    new BigDecimal(jsonObject.getString("acc_trade_volume")),
                    new BigDecimal(jsonObject.getString("acc_trade_volume_24h")),
                    new BigDecimal(jsonObject.getString("highest_52_week_price")),
                    jsonObject.getString("highest_52_week_date"),
                    new BigDecimal(jsonObject.getString("lowest_52_week_price")),
                    jsonObject.getString("lowest_52_week_date"),
                    jsonObject.getLong("timestamp")
            );
            tickerDataList.add(tickerData);
        }

        return tickerDataList;
    }

}
