package builder;

/**
 * @author JUANJUAN
 * @version 2017年7月21日下午8:11:07
 */
public class VegBurger extends Burger {
	@Override
	public float price() {
		return 25.0f;
	}

	@Override
	public String name() {
		return "Veg Burger";
	}
}
