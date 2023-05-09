package org.tradingstr.closePriceStrPerQuarter.kiwoomTradingStr;

//package org.tradingstr.closePriceStrPerQuarter;
//
//import com.kiwoom.demo.common.Constants;
//import com.kiwoom.demo.common.utils.DateUtils;
//import com.kiwoom.demo.domain.TickerData;
//
//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StockStrategy {
//    private List<TickerData> tickerDataList;
//
//    public StockStrategy() throws ParseException {
//        this.tickerDataList = loadTickerDataList();
//    }
//
//    private List<TickerData> loadTickerDataList() throws ParseException {
//        List<TickerData> tickerDataList = new ArrayList<>();
//
//        // TODO: 데이터베이스에서 분기별 종가 데이터를 조회하여 tickerDataList에 추가하는 코드 작성
//
//        return tickerDataList;
//    }
//
//    private boolean isBuySignal(TickerData tickerData) {
//        int currentQuarter = DateUtils.getQuarter(tickerData.getTradeDate());
//        int prevQuarter = currentQuarter - 1;
//        BigDecimal currentClosePrice = tickerData.getTradePrice();
//        BigDecimal prevClosePrice = findQuarterClosePrice(tickerData.getMarket(), prevQuarter);
//
//        if (prevClosePrice == null) {
//            return false;
//        }
//
//        return currentClosePrice.compareTo(prevClosePrice) > 0;
//    }
//
//    private boolean isSellSignal(TickerData tickerData) {
//        int currentQuarter = DateUtils.getQuarter(tickerData.getTradeDate());
//        int prevQuarter = currentQuarter - 1;
//        BigDecimal currentClosePrice = tickerData.getTradePrice();
//        BigDecimal prevClosePrice = findQuarterClosePrice(tickerData.getMarket(), prevQuarter);
//
//        if (prevClosePrice == null) {
//            return false;
//        }
//
//        return currentClosePrice.compareTo(prevClosePrice) < 0;
//    }
//
//    private BigDecimal findQuarterClosePrice(String market, int quarter) {
//        BigDecimal closePrice = null;
//
//        // 분기 시작일과 끝일 조회
//        String quarterStartDate = DateUtils.getQuarterStartDate(quarter);
//        String quarterEndDate = DateUtils.getQuarterEndDate(quarter);
//
//        // TODO: market, quarterStartDate, quarterEndDate를 이용하여 데이터베이스에서 분기 종가 조회
//        // 조회된 분기 종가를 closePrice 변수에 할당
//
//        return closePrice;
//    }
//
//    public void run() throws Exception {
//        // 매수할 종목 코드 조회
//        List<String> buyList = findBuyList();
//
//        // 매수 진행
//        for (String code : buyList) {
//            int quantity = Constants.DEFAULT_BUY_QUANTITY;
//            String orderNo = KiwoomApiService.getInstance().sendOrder(Constants.BUY, code, quantity);
//            System.out.println("매수주문번호 : " + orderNo);
//        }
//
//        // 매도할 종목 코드 조회
//        List<String> sellList = findSellList();
//
//        // 매도 진행
//        for (String code : sellList) {
//            int quantity = Constants.DEFAULT_SELL_QUANTITY;
//            String orderNo = KiwoomApiService.getInstance().sendOrder(Constants.SELL, code, quantity);
//            System.out.println("매도주문번호 : " + orderNo);
//        }
//    }
//
//    private List<String> findBuyList() {
//        List<String> buyList = new ArrayList<>();
//
//        for (TickerData tickerData : tickerDataList) {
//            if (isBuySignal(tickerData)) {
//                String code = tickerData.getCode();
//                buyList.add(code);
//            }
//        }
//
//        return buyList;
//    }
//
//    private List<String> findSellList() {
//        List<String> sellList = new ArrayList<>();
//
//        for (TickerData tickerData : tickerDataList) {
//            if (isSellSignal(tickerData)) {
//                String code = tickerData.getCode();
//                sellList.add(code);
//            }
//        }
//
//        return sellList;
//    }
//}
//
