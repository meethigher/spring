package top.meethigher.demo12.proxy;

/**
 * Producer
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/3/23
 */
public class ProducerImpl implements Producer {
    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱："+money);
    }
    public void afterService(float money){
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
