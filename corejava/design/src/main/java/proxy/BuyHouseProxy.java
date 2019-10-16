package proxy;

/**创建代理类
 * @Auther:JHLY
 * @Date:2019/10/7
 * @Description:proxy
 * @Version:1.0
 */
public class BuyHouseProxy implements BuyHouse {

    private BuyHouse buyHouse;

    public BuyHouseProxy(final BuyHouse buyHouse){
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("买房前准备");
        buyHouse.buyHouse();
        System.out.println("买房后装修");
    }
}
