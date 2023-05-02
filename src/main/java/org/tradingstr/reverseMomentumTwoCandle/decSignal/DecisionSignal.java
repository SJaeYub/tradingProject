package org.tradingstr.reverseMomentumTwoCandle.decSignal;

import cmn.dataGrid.MarketData;

import java.math.BigDecimal;

public class DecisionSignal {

    private static MarketData pre1Candle;
    private static MarketData pre2Candle;
    private static MarketData preCandle;

    public DecisionSignal(MarketData pre1Candle, MarketData pre2Candle, MarketData preCandle) {
        this.pre1Candle = pre1Candle;
        this.pre2Candle = pre2Candle;
        this.preCandle = preCandle;
    }

    public boolean getSignal() {
        boolean result = false;

        BigDecimal openingPrice_preFirst = this.pre1Candle.getOpening_price();
        BigDecimal tradePrice_preFirst = this.pre1Candle.getTrade_price();

        BigDecimal openingPrice_preSecond = this.pre2Candle.getOpening_price();
        BigDecimal tradePrice_preSecond = this.pre2Candle.getTrade_price();

        BigDecimal openingPrice_pre = this.preCandle.getOpening_price();
        BigDecimal tradePrice_pre = this.preCandle.getTrade_price();

        boolean upDownFlag_preFirst = decisionUpDown(openingPrice_preFirst, tradePrice_preFirst);
        boolean upDownFlag_preSecond = decisionUpDown(openingPrice_preSecond, tradePrice_preSecond);
        boolean upDownFlag_pre = decisionUpDown(openingPrice_pre, tradePrice_pre);

        //연속 상승봉 이후 직전봉이 하강봉인경우 시그널 발생
        if (upDownFlag_preFirst && upDownFlag_preSecond && !upDownFlag_pre) {
            result = true;
        }

        return result;
    }

    /**
     * 상승봉인지 하강봉인지 판단
     * openingPrice < tradePrice 상승     true
     * openingPrice >= tradePrice 하강    false
     *
     * @param openingPrice
     * @param tradePrice
     * @return
     */
    private boolean decisionUpDown(BigDecimal openingPrice, BigDecimal tradePrice) {

        if (openingPrice.compareTo(tradePrice) == 1) {
            return true;
        }

        return false;
    }
}
