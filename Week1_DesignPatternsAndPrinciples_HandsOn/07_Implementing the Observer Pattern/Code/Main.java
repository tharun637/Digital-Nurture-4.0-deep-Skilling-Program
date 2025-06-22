public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        
        Observer mobileApp = new MobileApp("StockTracker Mobile");
        Observer webApp = new WebApp("StockWatcher Web");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("AAPL", 145.32);
        stockMarket.setStockPrice("GOOGL", 2780.65);

        stockMarket.deregisterObserver(mobileApp);

        stockMarket.setStockPrice("AMZN", 3342.88);
    }
}