package cmn.parsing;

import cmn.dataGrid.TicksData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TicksDataParser {

    public static List<TicksData> parse(String json) {
        List<TicksData> trades = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            TicksData trade = new TicksData(
                    jsonObj.getString("market"),
                    jsonObj.getString("trade_date_utc"),
                    jsonObj.getString("trade_time_utc"),
                    jsonObj.getLong("timestamp"),
                    jsonObj.getBigDecimal("trade_price"),
                    jsonObj.getBigDecimal("trade_volume"),
                    jsonObj.getBigDecimal("prev_closing_price"),
                    jsonObj.getBigDecimal("change_price"),
                    jsonObj.getString("ask_bid"),
                    jsonObj.getLong("sequential_id")
            );
            trades.add(trade);
        }
        return trades;
    }
}
