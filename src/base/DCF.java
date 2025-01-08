package base;

/**
 * 现金流量折现法(Discounted Cash Flow Technique，简称DCF）是通过预测公司将来的现金流量并按照一定的贴现率计算公司的现值，从而确定股价的方法。
 * 参考 https://zhuanlan.zhihu.com/p/645828685
 */
public class DCF {
    // r代表自由现金流的折现率 取值范围8%～12%
    private static float r = 0.08f;
    // price 代表某一企业、资产或工程的现值（当前价值）
    private static float price = 0f;
    //g  表示预测期的自由现金流增长率 也就是平均净利润增长率，可以以近5年的净利润平均增长率
    private static float g = 0.15f;
    // y 永续增长率（3% ~ 5%）
    private static float y = 0.03f;
    // f 表示今年的自由现金流或者净利润
    private static float f = 300f;

    public static void main(String[] args) {
        float temp = f;

        for (int i = 1; i < 11; i++) {
            temp = (float) (f * Math.pow((1 + g), i) /Math.pow((1 + r), i));
            System.out.println("temp = " + i + " = " + temp);
            price += temp;
        }

        temp = (float) (f * Math.pow((1 + g), 10) * (1 + y) / ((r - y) * Math.pow((1 + r), 11)));


        price += temp;
        System.out.println("price = " + price);

        System.out.println("PE = " + price / f);
    }
}

/**
 * 记一些结论，如果股票按照10%增长，折现率12%，永续增长3%，则对应的PE为17.6
 *           如果股票按照10%增长，折现率8%，永续增长3%，则对应的PE为33.99
 *           这么来看的话，彼得林奇的PEG = 1就不太符合了，实际上很少能找到PEG = 1的股票，即使是在大熊市，茅台也不会跌到PE=15
 *
 *
 *           如果股票按照15%增长，折现率12%，永续增长3%，则对应的PE为24
 *           如果股票按照15%增长，折现率8%，永续增长3%，则对应的PE为50.1
 *           也就是说，如果能找到评论增长15%的股票，股票给出24的PE就属于便宜了，24～50.1都可以，折中也是37
 *           所以这个范围很大，但是37的PE也太高了吧，一般也很少出现这样的机会，所以需要耐心等待机会的出现，
 *           我认为药明康德属于这样的好机会，记录于2025.01.08
 */

