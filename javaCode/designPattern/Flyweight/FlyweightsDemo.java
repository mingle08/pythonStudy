package designPattern.Flyweight;

public class FlyweightsDemo {

	public static void main(String[] args) {
		WebSiteFactory factory = new WebSiteFactory();
		WebSite fx = factory.getWebSiteCategory("产品展示");
		fx.use(new User("小菜"));
		
		WebSite fy = factory.getWebSiteCategory("产品展示");
		fy.use(new User("大鸟"));
		
		WebSite fz = factory.getWebSiteCategory("产品展示");
		fz.use(new User("娇娇"));
		
		WebSite fl = factory.getWebSiteCategory("博客");
		fx.use(new User("老顽童"));
		
		WebSite fm = factory.getWebSiteCategory("博客");
		fy.use(new User("桃谷六仙"));
		
		WebSite fn = factory.getWebSiteCategory("博客");
		fz.use(new User("南海鳄神"));

		System.out.println("得到网站分类总数为：" + factory.getWebSiteCount());
	}

}
