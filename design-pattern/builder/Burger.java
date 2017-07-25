package builder;
/**
 * @author JUANJUAN
 * @version 2017年7月21日下午8:07:22
*/
public abstract class Burger implements Item{

	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return new Wrapper();
	}

	@Override
	public abstract float price();

}
