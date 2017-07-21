package builder;
/**
 * @author JUANJUAN
 * @version 2017年7月21日下午8:10:15
*/
public abstract class ColdDrink implements Item{

	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return new Bottle();
	}

	@Override
	public abstract float price();

}
