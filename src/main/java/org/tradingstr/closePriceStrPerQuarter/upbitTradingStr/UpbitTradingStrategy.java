//package org.tradingstr.closePriceStrPerQuarter.upbitTradingStr;
//
//import com.upbit.api.Upbit;
//import com.upbit.api.UpbitException;
//import com.upbit.api.dto.*;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.List;
//
//public class UpbitTradingStrategy {
//    private final String MARKET_CODE = "KRW-BTC"; // 시장 코드
//    private final int MINUTES_UNIT = 30; // 분봉 단위 (30분)
//    private final int MAX_TICKS_COUNT = 1000; // 최대 체결 건수
//
//    private Upbit upbit; // Upbit API 클라이언트
//
//    public UpbitTradingStrategy(String accessKey, String secretKey) {
//        upbit = new Upbit(accessKey, secretKey);
//    }
//
//    // 매매 전략 실행
//    public void run() throws IOException, UpbitException, InterruptedException {
//        // 초기화
//        BigDecimal currentClosePrice = null;
//        BigDecimal prevClosePrice = null;
//        boolean isHolding = false;
//
//        // 매매 루프
//        while (true) {
//            // 현재가 조회
//            Ticker ticker = upbit.getTicker(MARKET_CODE);
//            currentClosePrice = ticker.getTradePrice();
//
//            // 분봉 데이터 조회
//            List<CandleMinutes> candleMinutesList = upbit.getCandlesMinutes(MARKET_CODE, MINUTES_UNIT, 1);
//            if (candleMinutesList.size() == 0) {
//                continue;
//            }
//            CandleMinutes currentCandle = candleMinutesList.get(0);
//            if (currentCandle.getMarket().equals(MARKET_CODE) == false) {
//                continue;
//            }
//
//            // 전 분봉 데이터 조회
//            candleMinutesList = upbit.getCandlesMinutes(MARKET_CODE, MINUTES_UNIT, 2);
//            if (candleMinutesList.size() < 2) {
//                continue;
//            }
//            CandleMinutes prevCandle = candleMinutesList.get(1);
//            if (prevCandle.getMarket().equals(MARKET_CODE) == false) {
//                continue;
//            }
//            prevClosePrice = prevCandle.getTradePrice();
//
//            // 매매 시그널 계산
//            boolean isBuySignal = (currentClosePrice.compareTo(prevClosePrice) > 0);
//            boolean isSellSignal = (currentClosePrice.compareTo(prevClosePrice) < 0);
//
//            // 매수
//            if (isBuySignal && !isHolding) {
//                Market market = upbit.getMarket(MARKET_CODE);
//                Orderbook orderbook = upbit.getOrderbook(market.getMarket());
//                OrderbookUnit orderbookUnit = orderbook.getOrderbookUnits().get(0);
//                BigDecimal bidPrice = orderbookUnit.getBidPrice(); // 매수 호가
//                BigDecimal bidSize = orderbookUnit.getBidSize(); // 매수 잔량
//                BigDecimal buyPrice = bidPrice.multiply(BigDecimal.valueOf(1.01)); // 1% 가격 상승으로 매수 진행
//                BigDecimal buySize = bidSize.multiply(BigDecimal.valueOf(0.5)); // 매수 잔량의 50%만 매수 진행
//                upbit.placeOrder(MARKET_CODE, "bid", buyPrice, buySize, null, null);
//                // 현재 보유중인 코인의 잔액 조회
//                Wallet wallet = upbit.getWallet(MARKET_CODE.replace("KRW-", ""));
//                BigDecimal coinBalance = wallet.getBalance();
//
//                // 매수 후 보유중인 코인 잔액 계산
//                BigDecimal buyAmount = buyPrice.multiply(buySize);
//                BigDecimal newCoinBalance = coinBalance.add(buySize).subtract(buyAmount);
//
//                // 매수 완료 후 매수 신호 상태 변경
//                isHolding = true;
//                System.out.println("Buy signal detected. Buy order placed at " + buyPrice + ". Coin balance: " + newCoinBalance);
//
//            }
//
//            // 손절 매도
//            if (isSellSignal && isHolding) {
//                // 매도 주문
//                BigDecimal sellPrice = currentClosePrice.multiply(BigDecimal.valueOf(0.99)); // 1% 가격 하락으로 매도 진행
//                upbit.placeOrder(MARKET_CODE, "ask", sellPrice, null, null, null);
//
//                // 매도 후 보유중인 코인 잔액 계산
//                Wallet wallet = upbit.getWallet(MARKET_CODE.replace("KRW-", ""));
//                BigDecimal coinBalance = wallet.getBalance();
//                BigDecimal sellAmount = coinBalance; // 전량 매도
//                BigDecimal newCoinBalance = coinBalance.subtract(sellAmount);
//
//                // 매도 완료 후 매수 신호 상태 변경
//                isHolding = false;
//                System.out.println("Sell signal detected. Sell order placed at " + sellPrice + ". Coin balance: " + newCoinBalance);
//            }
//
//            // 30분 간격으로 매매 신호 체크
//            Thread.sleep(30 * 60 * 1000);
//        }
//    }
//}