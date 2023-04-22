package cmn.dataGrid;

import java.math.BigDecimal;

public class TickerData {
    private String market;
    private String tradeDate;
    private String tradeTime;
    private String tradeDateKst;
    private String tradeTimeKst;
    private long tradeTimestamp;
    private BigDecimal openingPrice;
    private BigDecimal highPrice;
    private BigDecimal lowPrice;
    private BigDecimal tradePrice;
    private BigDecimal prevClosingPrice;
    private String change;
    private BigDecimal changePrice;
    private BigDecimal changeRate;
    private BigDecimal signedChangePrice;
    private BigDecimal signedChangeRate;
    private BigDecimal tradeVolume;
    private BigDecimal accTradePrice;
    private BigDecimal accTradePrice24h;
    private BigDecimal accTradeVolume;
    private BigDecimal accTradeVolume24h;
    private BigDecimal highest52WeekPrice;
    private String highest52WeekDate;
    private BigDecimal lowest52WeekPrice;
    private String lowest52WeekDate;
    private long timestamp;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTradeDateKst() {
        return tradeDateKst;
    }

    public void setTradeDateKst(String tradeDateKst) {
        this.tradeDateKst = tradeDateKst;
    }

    public String getTradeTimeKst() {
        return tradeTimeKst;
    }

    public void setTradeTimeKst(String tradeTimeKst) {
        this.tradeTimeKst = tradeTimeKst;
    }

    public long getTradeTimestamp() {
        return tradeTimestamp;
    }

    public void setTradeTimestamp(long tradeTimestamp) {
        this.tradeTimestamp = tradeTimestamp;
    }

    public BigDecimal getOpeningPrice() {
        return openingPrice;
    }

    public void setOpeningPrice(BigDecimal openingPrice) {
        this.openingPrice = openingPrice;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public BigDecimal getPrevClosingPrice() {
        return prevClosingPrice;
    }

    public void setPrevClosingPrice(BigDecimal prevClosingPrice) {
        this.prevClosingPrice = prevClosingPrice;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public BigDecimal getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(BigDecimal changePrice) {
        this.changePrice = changePrice;
    }

    public BigDecimal getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(BigDecimal changeRate) {
        this.changeRate = changeRate;
    }

    public BigDecimal getSignedChangePrice() {
        return signedChangePrice;
    }

    public void setSignedChangePrice(BigDecimal signedChangePrice) {
        this.signedChangePrice = signedChangePrice;
    }

    public BigDecimal getSignedChangeRate() {
        return signedChangeRate;
    }

    public void setSignedChangeRate(BigDecimal signedChangeRate) {
        this.signedChangeRate = signedChangeRate;
    }

    public BigDecimal getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(BigDecimal tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public BigDecimal getAccTradePrice() {
        return accTradePrice;
    }

    public void setAccTradePrice(BigDecimal accTradePrice) {
        this.accTradePrice = accTradePrice;
    }

    public BigDecimal getAccTradePrice24h() {
        return accTradePrice24h;
    }

    public void setAccTradePrice24h(BigDecimal accTradePrice24h) {
        this.accTradePrice24h = accTradePrice24h;
    }

    public BigDecimal getAccTradeVolume() {
        return accTradeVolume;
    }

    public void setAccTradeVolume(BigDecimal accTradeVolume) {
        this.accTradeVolume = accTradeVolume;
    }

    public BigDecimal getAccTradeVolume24h() {
        return accTradeVolume24h;
    }

    public void setAccTradeVolume24h(BigDecimal accTradeVolume24h) {
        this.accTradeVolume24h = accTradeVolume24h;
    }

    public BigDecimal getHighest52WeekPrice() {
        return highest52WeekPrice;
    }

    public void setHighest52WeekPrice(BigDecimal highest52WeekPrice) {
        this.highest52WeekPrice = highest52WeekPrice;
    }

    public String getHighest52WeekDate() {
        return highest52WeekDate;
    }

    public void setHighest52WeekDate(String highest52WeekDate) {
        this.highest52WeekDate = highest52WeekDate;
    }

    public BigDecimal getLowest52WeekPrice() {
        return lowest52WeekPrice;
    }

    public void setLowest52WeekPrice(BigDecimal lowest52WeekPrice) {
        this.lowest52WeekPrice = lowest52WeekPrice;
    }

    public String getLowest52WeekDate() {
        return lowest52WeekDate;
    }

    public void setLowest52WeekDate(String lowest52WeekDate) {
        this.lowest52WeekDate = lowest52WeekDate;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public TickerData(String market, String tradeDate, String tradeTime, String tradeDateKst, String tradeTimeKst, long tradeTimestamp,
                      BigDecimal openingPrice, BigDecimal highPrice, BigDecimal lowPrice, BigDecimal tradePrice, BigDecimal prevClosingPrice, String change, BigDecimal changePrice, BigDecimal changeRate, BigDecimal signedChangePrice, BigDecimal signedChangeRate, BigDecimal tradeVolume, BigDecimal accTradePrice, BigDecimal accTradePrice24h, BigDecimal accTradeVolume, BigDecimal accTradeVolume24h,
                      BigDecimal highest52WeekPrice, String highest52WeekDate, BigDecimal lowest52WeekPrice, String lowest52WeekDate, long timestamp) {
        this.market = market;
        this.tradeDate = tradeDate;
        this.tradeTime = tradeTime;
        this.tradeDateKst = tradeDateKst;
        this.tradeTimeKst = tradeTimeKst;
        this.tradeTimestamp = tradeTimestamp;
        this.openingPrice = openingPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.tradePrice = tradePrice;
        this.prevClosingPrice = prevClosingPrice;
        this.change = change;
        this.changePrice = changePrice;
        this.changeRate = changeRate;
        this.signedChangePrice = signedChangePrice;
        this.signedChangeRate = signedChangeRate;
        this.tradeVolume = tradeVolume;
        this.accTradePrice = accTradePrice;
        this.accTradePrice24h = accTradePrice24h;
        this.accTradeVolume = accTradeVolume;
        this.accTradeVolume24h = accTradeVolume24h;
        this.highest52WeekPrice = highest52WeekPrice;
        this.highest52WeekDate = highest52WeekDate;
        this.lowest52WeekPrice = lowest52WeekPrice;
        this.lowest52WeekDate = lowest52WeekDate;
        this.timestamp = timestamp;
    }

    // Getter & Setter 생략
}

