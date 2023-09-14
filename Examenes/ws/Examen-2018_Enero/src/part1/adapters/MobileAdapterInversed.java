package part1.adapters;

import part1.model.Mobile;
import part1.view.Media;

public class MobileAdapterInversed implements Media {

	private Mobile mobile;
	
	public MobileAdapterInversed(Mobile mobile) {
		this.mobile = mobile;
	}

	@Override
	public String getCad1() {
		return this.mobile.getModel();
	}

	@Override
	public String getCad2() {		
		return this.mobile.getBrand();
	}

}
