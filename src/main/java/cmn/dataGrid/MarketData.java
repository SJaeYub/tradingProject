package cmn.dataGrid;

import java.math.BigDecimal;

public class MarketData {
    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getCandle_date_time_utc() {
        return candle_date_time_utc;
    }

    public void setCandle_date_time_utc(String candle_date_time_utc) {
        this.candle_date_time_utc = candle_date_time_utc;
    }

    public String getCandle_date_time_kst() {
        return candle_date_time_kst;
    }

    public void setCandle_date_time_kst(String candle_date_time_kst) {
        this.candle_date_time_kst = candle_date_time_kst;
    }

    public BigDecimal getOpening_price() {
        return opening_price;
    }

    public void setOpening_price(BigDecimal opening_price) {
        this.opening_price = opening_price;
    }

    public BigDecimal getHigh_price() {
        return high_price;
    }

    public void setHigh_price(BigDecimal high_price) {
        this.high_price = high_price;
    }

    public BigDecimal getLow_price() {
        return low_price;
    }

    public void setLow_price(BigDecimal low_price) {
        this.low_price = low_price;
    }

    public BigDecimal getTrade_price() {
        return trade_price;
    }

    public void setTrade_price(BigDecimal trade_price) {
        this.trade_price = trade_price;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getCandle_acc_trade_price() {
        return candle_acc_trade_price;
    }

    public void setCandle_acc_trade_price(BigDecimal candle_acc_trade_price) {
        this.candle_acc_trade_price = candle_acc_trade_price;
    }

    public Double getCandle_acc_trade_volume() {
        return candle_acc_trade_volume;
    }

    public void setCandle_acc_trade_volume(Double candle_acc_trade_volume) {
        this.candle_acc_trade_volume = candle_acc_trade_volume;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    private String market;
    private String candle_date_time_utc;
    private String candle_date_time_kst;
    private BigDecimal opening_price;
    private BigDecimal high_price;
    private BigDecimal low_price;
    private BigDecimal trade_price;
    private Long timestamp;
    private BigDecimal candle_acc_trade_price;
    private Double candle_acc_trade_volume;
    private Integer unit;


}