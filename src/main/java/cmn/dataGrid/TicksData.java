package cmn.dataGrid;

import java.math.BigDecimal;

public class TicksData {

    private String market;
    private String tradeDateUtc;
    private String tradeTimeUtc;
    private long timestamp;
    private BigDecimal tradePrice;
    private BigDecimal tradeVolume;
    private BigDecimal prevClosingPrice;
    private BigDecimal changePrice;
    private String askBid;
    private long sequentialId;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getTradeDateUtc() {
        return tradeDateUtc;
    }

    public void setTradeDateUtc(String tradeDateUtc) {
        this.tradeDateUtc = tradeDateUtc;
    }

    public String getTradeTimeUtc() {
        return tradeTimeUtc;
    }

    public void setTradeTimeUtc(String tradeTimeUtc) {
        this.tradeTimeUtc = tradeTimeUtc;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public BigDecimal getTradeVolume() {
        return tradeVolume;
    }

    public void setTradeVolume(BigDecimal tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public BigDecimal getPrevClosingPrice() {
        return prevClosingPrice;
    }

    public void setPrevClosingPrice(BigDecimal prevClosingPrice) {
        this.prevClosingPrice = prevClosingPrice;
    }

    public BigDecimal getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(BigDecimal changePrice) {
        this.changePrice = changePrice;
    }

    public String getAskBid() {
        return askBid;
    }

    public void setAskBid(String askBid) {
        this.askBid = askBid;
    }

    public long getSequentialId() {
        return sequentialId;
    }

    public void setSequentialId(long sequentialId) {
        this.sequentialId = sequentialId;
    }

    public TicksData(String market, String tradeDateUtc, String tradeTimeUtc, long timestamp,
                     BigDecimal tradePrice, BigDecimal tradeVolume, BigDecimal prevClosingPrice,
                     BigDecimal changePrice, String askBid, long sequentialId) {
        this.market = market;
        this.tradeDateUtc = tradeDateUtc;
        this.tradeTimeUtc = tradeTimeUtc;
        this.timestamp = timestamp;
        this.tradePrice = tradePrice;
        this.tradeVolume = tradeVolume;
        this.prevClosingPrice = prevClosingPrice;
        this.changePrice = changePrice;
        this.askBid = askBid;
        this.sequentialId = sequentialId;
    }
}
