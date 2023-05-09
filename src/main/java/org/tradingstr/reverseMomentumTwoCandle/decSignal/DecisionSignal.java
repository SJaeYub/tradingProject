package org.tradingstr.reverseMomentumTwoCandle.decSignal;

import cmn.calculateMethod.CalculateBean;
import cmn.dataGrid.MarketData;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DecisionSignal {

    private static MarketData pre1Candle;
    private static MarketData pre2Candle;
    private static MarketData preCandle;

    public DecisionSignal(MarketData pre1Candle, MarketData pre2Candle, MarketData preCandle) {
        this.pre1Candle = pre1Candle;
        this.pre2Candle = pre2Candle;
        this.preCandle = preCandle;
    }

    /**
     * 매수 시그널 발생
     *
     * @return 2연속 양봉 후 음봉 시 매수 시그널 발생
     */
    public boolean getPreBuySignal() {
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
     * 양봉인지 음봉인지 판단
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

    /**
     * 매수 예비 시그널 발생 후 직전 양봉 고점 돌파 판단 시 매수 시그널 발생
     *
     * @return 5개 봉 동안 고점 돌파시 true, 미돌파시 false
     */
    public boolean decisionTradeSignal(BigDecimal stanHighPrice, MarketData currCandle) {
        boolean result = false;

        if (stanHighPrice.compareTo(currCandle.getHigh_price()) == -1) {
            result = true;
        }

        return result;
    }

    /**
     * 직전 캔들을 통해 전일 기준 -1.0% 이상 종가 하락 시 매도 시그널 발생
     *
     * @param standardPrice 매도 기준 가격
     * @param currCandle    전일 캔들
     * @return
     */
    public boolean decisionSellSignal(BigDecimal standardPrice, MarketData currCandle, BigDecimal standardNum) {
        boolean result = false;

        CalculateBean calculateBean = new CalculateBean();
        BigDecimal rate = calculateBean.calculateRate(standardPrice, currCandle.getTrade_price());

        if (rate.compareTo(new BigDecimal(String.valueOf(standardNum))) <= 0) {
            result = true;
        }

        return result;
    }


}
